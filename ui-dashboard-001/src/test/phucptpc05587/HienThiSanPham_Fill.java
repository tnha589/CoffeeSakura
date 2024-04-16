package test.phucptpc05587;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
import com.model.SanPham;
import com.untils.XDialog;

public class HienThiSanPham_Fill {
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
	@AfterMethod
	public void logout() {
		main.setVisible(false);
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
	public void testFIll(boolean nut, String sp) {
		
		if(sp.equals("") && nut) {
			System.out.println("Test thêm");
			assertEquals(quanLySanPham.btnThem.isEnabled(), nut);	
		}else if(sp.equals("") && nut == false){
			System.out.println("test sửa");
			assertEquals(quanLySanPham.btnSua.isEnabled(), nut);
		}
		
	quanLySanPham.tblSanPham.setRowSelectionInterval(0, 0);
	quanLySanPham.tblSanPhamMouseClicked(null);
	if(quanLySanPham.txtTenSP.getText().equals(sp)) {
		assertTrue(nut);
	}
	}
    @DataProvider(name = "dataSanPham")
    public static Object[][] testData() {
        return new Object[][] {
            {true,""},
            {false,""},
            {true,"sp01"},
        };
    }
}
