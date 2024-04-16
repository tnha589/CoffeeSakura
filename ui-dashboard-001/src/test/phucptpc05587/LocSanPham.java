package test.phucptpc05587; 

import static org.testng.Assert.assertEquals;

import java.awt.Window;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Dao.sanPhamDao;
import com.form.DangNhap;
import com.form.QuanLySanPham1;
import com.main.Main;
import com.untils.XDialog;

public class LocSanPham {
	private Main main;
	private DangNhap login;
	private QuanLySanPham1 quanLySanPham;
	private sanPhamDao spDao;

	@BeforeMethod
	public void setUp() {
		DangNhap login = new DangNhap(null, false);
		login.setVisible(true);
		login.txtTenTK.setText("NV001");
		login.txtPassword.setText("matkhau123");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
						closeJOptionPane();
					} catch (Exception e) {
					}
				}
			}).start();
		login.login();
		main = new Main();
		main.setVisible(true);
		main.openSanPham();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(() -> {
			quanLySanPham = main.getForm3();
			quanLySanPham.setVisible(true);
		});
	}

	
	public void closeJOptionPane() {
		Window[] windows = Window.getWindows();
		for (Window window : windows) {
			if (window instanceof JDialog) {
				JDialog dialog = (JDialog) window;
				if (dialog.getContentPane().getComponentCount() == 1
						&& dialog.getContentPane().getComponent(0) instanceof JOptionPane) {
					dialog.dispose();
				}
			}
		}
	}
	
	@Test(dataProvider = "dataSanPham")
	public void testCaseTimKiemSanPham(int loaiSP,String mM) {
		 new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
						closeJOptionPane();
					} catch (Exception e) {
					}
				}
			}).start();
		quanLySanPham.cboFindLoai.setSelectedIndex(loaiSP);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Mong đợi: "+mM+ " Thực tế: "+XDialog.getAlertMessage());
		assertEquals(XDialog.getAlertMessage(), mM);
	}
    @DataProvider(name = "dataSanPham")
    public static Object[][] testData() {
        return new Object[][] {
            {0,"Tìm kiếm thành công!"},
            {1,"Tìm kiếm thành công!"},
            {2,"Tìm kiếm thành công!"},
        };
    }
}
