package test.VuDay_PC05484;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertEquals;

import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.form.DangNhap;
import com.form.QuenMK;
import com.form.ThongKe1;
import com.form.TrangChu;
import com.main.Main;
import com.model.NhanVien;

public class LoginTest {
    private DangNhap login;
    private Main main;
    private TrangChu home;

    @BeforeMethod
    public void setUp() {
        login = new DangNhap(null, false);
        login.setVisible(true);
    }

    @AfterMethod
    public void tearDown() {
        // Khởi chạy một luồng mới để đóng hộp thoại
        new Thread(() -> closeDialog()).start();
    }

    public void sleep(int s) {
        try {
            Thread.sleep(s * 1000); // Chuyển đổi sang millisecond
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void closeDialog() {
        // Sử dụng SwingUtilities để đóng hộp thoại trên EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.getRootFrame().dispose();
            }
        });
    }

    @Test(priority = 1)
    public void LoginTestNull() {
        new Thread(() -> {
            login.getTxtTenTK().setText("");
            login.getTxtPassword().setText("");
            login.login();
        }).start();
        sleep(3); // Chờ 5 giây cho hộp thoại hiển thị và xử lý
        assertEquals(login.message,"Vui lòng nhập đầy đủ thông tin");
    }

    @Test(priority = 2)
    public void LoginTestNullTenTK() {
        new Thread(() -> {
            login.getTxtTenTK().setText("");
            login.getTxtPassword().setText("matkhau123");
            login.login();
        }).start();
        sleep(3);
        assertEquals(login.message,"Không được để trống tên đăng nhập.");
    }

    @Test(priority = 3)
    public void LoginTestNullPassword() {
        new Thread(() -> {
            login.getTxtTenTK().setText("NV000");
            login.getTxtPassword().setText("");
            login.login();
        }).start();
        sleep(3);
        assertEquals(login.message,"Không được để trống mật khẩu.");
    }

    @Test(priority = 4)
    public void LoginTestFailTenTK() {
        new Thread(() -> {
            login.getTxtTenTK().setText("NV0");
            login.getTxtPassword().setText("1234");
            login.login();
        }).start();
        sleep(3);
        assertEquals(login.message,"Sai tên đăng nhập");
    }

    @Test(priority = 5)
    public void LoginTestFailPassword() {
        new Thread(() -> {
            login.getTxtTenTK().setText("NV000");
            login.getTxtPassword().setText("12345");
            login.login();
        }).start();
        sleep(3);
        assertEquals(login.message,"Sai mật khẩu");
    }
    @Test(priority = 6)
    public void LoginTest() {
    	 new QuenMK(null, true).setVisible(true);
    }
    @Test(priority = 7)
	public void TestLoginPass() {
		main = new Main();
		home = new TrangChu();
		login = new DangNhap(null, false);
		login.setVisible(true);
		login.getTxtTenTK().setText("NV000");
		login.getTxtPassword().setText("1234");
		login.login();
		sleep(3);
		main.setVisible(true);
		main.setForm(home);
	}
}