package test.phucptpc05587;

import org.testng.annotations.Test;
import com.form.DangNhap;
import com.form.QuanLyNhanVien1;
import com.form.QuanLySanPham1;
import com.main.Main;
import com.untils.XDialog;

import static org.testng.Assert.assertEquals;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class SuaSanPhamTest {
	private Main main;
	private DangNhap login;
	private QuanLySanPham1 quanLySanPham;

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
//	@Test
//	private void testUI() {
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		assertTrue(quanLySanPham.isVisible());
//	
//	}
	
	@Test(dataProvider = "dataSanPhamSua")
	public void testCaseSuaSanPham(String maSP, String tenSP, String giaSP, String ghiChu, int trangThai, String hinh, String mM) {
		boolean test = true;
		quanLySanPham.btnSua.setEnabled(true);
		quanLySanPham.txtMaSP.setText(maSP);
		quanLySanPham.txtTenSP.setText(tenSP);
		quanLySanPham.txtGiaSP.setText(giaSP);
		quanLySanPham.txtGhiChu.setText(ghiChu);
		quanLySanPham.cboTrangThai.setSelectedIndex(trangThai);
		quanLySanPham.lblHinh.setToolTipText(hinh);
		if(!hinh.equals("")) {
			quanLySanPham.hienThiHinh(hinh);
		}
		try {
			TimeUnit.SECONDS.sleep(5);
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
		quanLySanPham.btnSua.doClick();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(quanLySanPham.ErrorMaSP.getText().equals(mM)) {
			System.out.println("Mã SP: "+mM);
			assertEquals(quanLySanPham.ErrorMaSP.getText(), mM);
			test = false;
		}
		if(quanLySanPham.ErrorTenSP.getText().equals(mM)) {
			System.out.println("Tên SP: "+mM);
			assertEquals(quanLySanPham.ErrorTenSP.getText(), mM);
			test = false;
		}
		if(quanLySanPham.ErrorGiaSP.getText().equals(mM)) {
			System.out.println("Giá SP: "+mM);
			assertEquals(quanLySanPham.ErrorGiaSP.getText(), mM);
			test = false;
		}
		if(quanLySanPham.ErrorTrangThai.getText().equals(mM)) {
			System.out.println("Trạng Thái: "+mM);
			assertEquals(quanLySanPham.ErrorTrangThai.getText(), mM);
			test = false;
		}
		if(quanLySanPham.ErrorLoaiSP.getText().equals(mM)) {
			System.out.println("Loại SP: "+mM);
			assertEquals(quanLySanPham.ErrorLoaiSP.getText(), mM);
			test = false;
		}
		if(quanLySanPham.lblHinh.getText().equals(mM)) {
			System.out.println("Hình: "+mM);
			assertEquals(quanLySanPham.lblHinh.getText(), mM);
			test = false;
		}
		if(test) {
			System.out.println("Mong đợi: "+mM+ " Thực tế: "+XDialog.getAlertMessage());
			assertEquals(XDialog.getAlertMessage(), mM);
		}
	}
    @DataProvider(name = "dataSanPhamSua")
    public static Object[][] testData() {
        return new Object[][] {
            {"","sp01","10","test",1,"sp01.png","Không được trống!"},
            {"SP1","","10","test",1,"sp01.png","Không được trống!"},
            {"SP1","sp01","","test",1,"sp01.png","Không được trống!"}, 
            {"SP1","sp01","10","test",0,"sp01.png","Chưa chọn trạng thái!"},
            {"SP1","sp01","10","test",1,"","Vui lòng chọn hình!"},
            {"SP1","sp01","10","test",1,"sp1.docx","Sai Định Dạng Hình!"},
            {"SP1","sp01","sdw","test",1,"sp01.png","Sai định dạng!"},
        	{"SP1","!@#$%^&*()","10","test",1,"sp01.png","Tên sản phẩm chứa ký tự đặc biệt!"},
        	{"SP1","sp01","0","test",1,"sp1.docx","Không được nhập giá bằng 0!"},
        	{"SP1","sp01","-99","test",1,"sp1.docx","Không được nhập giá là số âm!"},
      	  	{"SP00","sp01","10","test",1,"sp01.png","Mã sản phẩm không tồn tại!"},
        	{"SP01","sp01","10","test",1,"sp01.png","Cập nhật sản phẩm thành công!"},
        
        };
    }
}
