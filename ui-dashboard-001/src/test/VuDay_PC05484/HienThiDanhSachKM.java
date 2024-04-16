package test.VuDay_PC05484;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dao.KhuyenMaiDao;
import com.form.DangNhap;
import com.form.KhuyenMai1;

import com.main.Main;
import com.model.KhuyenMai;


public class HienThiDanhSachKM {
	private DangNhap login;
	private Main main;
	private KhuyenMai1 km1;
	KhuyenMaiDao kmDao = new KhuyenMaiDao();
	List<KhuyenMai> list = new ArrayList<>();

	@BeforeMethod
	public void setUp() {
		main = new Main();
		km1 = new KhuyenMai1();
		login = new DangNhap(null, false);
		login.setVisible(true);
		login.getTxtTenTK().setText("NV000");
		login.getTxtPassword().setText("1234");
		sleep(2);
		login.login();

		main.setVisible(true);

		main.setForm(km1);
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
	public void TestKMTK1() {
		sleep(3);
		km1.getTxtTenKM1().setText("Khuyến mãi mùa hè");
		sleep(3);
		km1.TimKhuyenMai1("Khuyến mãi mùa hè");
		sleep(3);
		list = new ArrayList<KhuyenMai>();
		sleep(3);
		assertEquals(km1.listKM, list);
		sleep(3);
	}

	@Test(priority = 2)
	public void TestKMTK2() {
		sleep(3);
		km1.getTxtTenKM1().setText("");
		sleep(3);
		km1.TimKhuyenMai1("");
		sleep(3);
		list = kmDao.selectAll();
		sleep(3);
//        assertEquals(km1.listKM, list);
//		sleep(3);
	}
	@Test(priority = 3)
	public void TestKMTK3() {
		sleep(3);
		km1.getTxtTenKM1().setText("abc");
		sleep(3);
		km1.TimKhuyenMai1("abc");
		sleep(3);
		list = new ArrayList<KhuyenMai>();
		sleep(3);
		assertEquals(km1.listKM, list);
		sleep(3);
	}
	@Test(priority = 4)
	public void TestKMTK4() {
		sleep(3);
		km1.getTxtTenKM1().setText("@!");
		sleep(3);
		km1.TimKhuyenMai1("@!");
		sleep(3);
		list = new ArrayList<KhuyenMai>();
		sleep(3);
		assertEquals(km1.listKM, list);
		sleep(3);
	}
	
	@Test(priority = 5)
    public void testLocKhuyenMaiVND() {
		sleep(3);
        km1.cboKhuyenMai.setSelectedIndex(0);
        sleep(3);
        list = new ArrayList<KhuyenMai>();
        sleep(3);
		assertEquals(km1.listKM, list);
    }
	@Test(priority = 6)
    public void testLocKhuyenMaiPhanTram() {
		sleep(3);
        km1.cboKhuyenMai.setSelectedIndex(1);
        sleep(3);
        list = new ArrayList<KhuyenMai>();
        sleep(3);
		assertEquals(km1.listKM, list);
    }
	@Test(priority = 7)
    public void testLocKhuyenMaiTatCa() {
		sleep(3);
        km1.cboKhuyenMai.setSelectedIndex(2);
        sleep(3);
        list = new ArrayList<KhuyenMai>();
        sleep(3);
		assertEquals(km1.listKM, list);
    }

}
