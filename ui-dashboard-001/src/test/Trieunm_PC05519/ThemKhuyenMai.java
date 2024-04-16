package test.Trieunm_PC05519;

import static org.testng.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dao.nhanVienDao;
import com.form.DangNhap;
import com.form.KhuyenMai1;
import com.main.Main;
import com.untils.XDialog;

public class ThemKhuyenMai {
	private Main main;
	public DangNhap login = new DangNhap(main, false);
//	private QuanLyNhanVien1 quanLyNhanVien;
	public KhuyenMai1 km = new KhuyenMai1();
	private nhanVienDao nvDao;
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
	
	
	public void setText(String makm, String tenkm, Date ngayBD, Date ngayKT, boolean hinhthuc, boolean Trangthai,
			String giatri) {
		km.txtMaKM.setText(makm);
		km.txtTenKM.setText(tenkm);

		km.txtNgayBD.setDate(ngayBD);
		km.txtNgayKT.setDate(ngayKT);
		if (hinhthuc) {
			km.rdoPhanTram.setSelected(true);
		} else {
			km.rdoVND.setSelected(true);
		}
		if (Trangthai) {
			km.rdoDangDienRa.setSelected(true);
		} else {
			km.rdoDaKetThuc.setSelected(true);
		}
		km.txtGiaTri.setText(giatri);
	}

	@BeforeMethod
	public void setUp() {
		DangNhap login = new DangNhap(null, false);
		login.setVisible(true);
		login.getTxtTenTK().setText("NV000");
		login.getTxtPassword().setText("1234");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		login.login();
		main = new Main();
		main.setVisible(true);
//		main.openQuanLyNhanVien();
		main.openKhuyenMai();

		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(() -> {
			km = main.getForm4();
//			quanLyNhanVien = main.getForm6();
			km.setVisible(true);
		});
	}
	
	   private void closeJOptionPane1() {
	        AWTEvent event = new AWTEvent(new JOptionPane(), 0) {};
	        EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
	        queue.postEvent(event);
	    }
	   
	   private void closeJOptionPaneIfDisplayed() {
	        Window[] windows = Window.getWindows();
	        for (Window window1 : windows) {
	            JOptionPane window = null;
				if (window instanceof JOptionPane) {
	                JOptionPane optionPane = (JOptionPane) window;
	                if (optionPane.isVisible() && optionPane.getValue() != null && optionPane.getValue().equals(JOptionPane.OK_OPTION)) {
	                    optionPane.setValue(JOptionPane.CLOSED_OPTION);
//	                    optionPane.z();
	                }
	            }
	        }
	    }

	@AfterMethod
	public void logout() {
		main.setVisible(false);
	}
	
		@Test(priority = 0)
		public void insertKhuyenmai() throws InterruptedException {
			Assert.assertNotNull(km);
			Date ngayBD = new Date(); // Tạo một đối tượng Date hiện tại cho ngày bắt đầu
			Date ngayKT = new Date(ngayBD.getTime() + TimeUnit.DAYS.toMillis(2));
			
			System.out.println("ngày kết thúc: " + ngayKT);
			setText("KM016", "Thang", ngayBD, ngayKT, false, false, "10");
			TimeUnit.SECONDS.sleep(2);
	//		XDialog.setOptionPane(new YesMockOptionPane());
			km.btnThem.doClick(1);
			TimeUnit.SECONDS.sleep(2); 
//			closeJOptionPane();
			closeJOptionPaneIfDisplayed();
	//		String error;
			Assert.assertEquals(km.message,"Mã khuyến mãi đã tồn tại!");
	
		}
		
		@Test(priority = 1)
		public void insertKhuyenmai1() throws InterruptedException {
			Assert.assertNotNull(km);
			Date ngayBD = new Date(); // Tạo một đối tượng Date hiện tại cho ngày bắt đầu
			Date ngayKT = new Date(ngayBD.getTime() + TimeUnit.DAYS.toMillis(2));
			
			System.out.println("ngày kết thúc: " + ngayKT);
			setText("", "Thangs4", ngayBD, ngayKT, false, false, "10");
			TimeUnit.SECONDS.sleep(2);
	//		XDialog.setOptionPane(new YesMockOptionPane());
			km.btnThem.doClick(1);
			TimeUnit.SECONDS.sleep(2); 
//			closeJOptionPane();
			closeJOptionPaneIfDisplayed();
	//		String error;
			Assert.assertEquals(km.message,"Hãy điền mã khuyến mãi!");
	
		}
		@Test(priority = 2)
		public void insertKhuyenmai2() throws InterruptedException {
			Assert.assertNotNull(km);
			Date ngayBD = new Date(); // Tạo một đối tượng Date hiện tại cho ngày bắt đầu
			Date ngayKT = new Date(ngayBD.getTime() + TimeUnit.DAYS.toMillis(2));
			
			System.out.println("ngày kết thúc: " + ngayKT);
			setText("KM075", "", ngayBD, ngayKT, false, false, "10");
			TimeUnit.SECONDS.sleep(2);
	//		XDialog.setOptionPane(new YesMockOptionPane());
			km.btnThem.doClick(1);
			TimeUnit.SECONDS.sleep(2); 
//			closeJOptionPane();
			closeJOptionPaneIfDisplayed();
	//		String error;
			Assert.assertEquals(km.message,"hãy nhập tên khuyến mãi!");
	
		}

		
		@Test(priority = 3)
		public void insertKhuyenmai3() throws InterruptedException {
			Assert.assertNotNull(km);
			Date ngayBD = new Date(); // Tạo một đối tượng Date hiện tại cho ngày bắt đầu
			Date ngayKT = new Date(ngayBD.getTime() + TimeUnit.DAYS.toMillis(2));		
			System.out.println("ngày kết thúc: " + ngayKT);
			setText("KM075qqqqqq", "thang4", ngayBD, ngayKT, false, false, "10");
			TimeUnit.SECONDS.sleep(2);
			km.btnThem.doClick(1);
			TimeUnit.SECONDS.sleep(2); 
			closeJOptionPaneIfDisplayed();
			Assert.assertEquals(km.message,"Mã khuyến mãi quá dài");
	
		}
		
		@Test(priority = 4)
		public void insertKhuyenmai4() throws InterruptedException {
			Assert.assertNotNull(km);
			Date ngayBD = new Date(); // Tạo một đối tượng Date hiện tại cho ngày bắt đầu
			Date ngayKT = new Date(ngayBD.getTime() + TimeUnit.DAYS.toMillis(2));		
			System.out.println("ngày kết thúc: " + ngayKT);
			setText("KM075", "thang4", ngayBD, ngayKT, false,false, "");
			TimeUnit.SECONDS.sleep(2);
			km.btnThem.doClick(1);
			TimeUnit.SECONDS.sleep(2); 
			closeJOptionPaneIfDisplayed();
			Assert.assertEquals(km.message,"hãy nhập giá khuyến mãi!");
	
		}
		@Test(priority = 5)
		public void insertKhuyenmai5() throws InterruptedException {
			Assert.assertNotNull(km);
			Date ngayBD = new Date(); // Tạo một đối tượng Date hiện tại cho ngày bắt đầu
			Date ngayKT = new Date(ngayBD.getTime() + TimeUnit.DAYS.toMillis(2));		
			System.out.println("ngày kết thúc: " + ngayKT);
			setText("KM075", "thang4", ngayBD, ngayKT, false, false, "400");
			TimeUnit.SECONDS.sleep(2);
			km.btnThem.doClick(1);
			TimeUnit.SECONDS.sleep(2); 
			closeJOptionPaneIfDisplayed();
			Assert.assertEquals(km.message,"Giá khuyến mãi chưa phù hợp!");
	
		}
           
		@Test(priority = 6)
		public void insertKhuyenmai6() throws InterruptedException {
			Assert.assertNotNull(km);
			Date ngayBD = new Date(); // Tạo một đối tượng Date hiện tại cho ngày bắt đầu
			Date ngayKT = new Date(ngayBD.getTime() + TimeUnit.DAYS.toMillis(2));		
			System.out.println("ngày kết thúc: " + ngayKT);
			setText("KM075", "thang4", ngayBD, ngayKT, false, false, "ádsd");
			TimeUnit.SECONDS.sleep(2);
			km.btnThem.doClick(1);
			TimeUnit.SECONDS.sleep(2); 
			closeJOptionPaneIfDisplayed();
			Assert.assertEquals(km.message,"Giá khuyến mãi chỉ nhập số!");
	
		}
		// chest trang thái
		@Test(priority = 7)
		public void insertKhuyenmai7() throws InterruptedException {
			Assert.assertNotNull(km);
			Date ngayBD = new Date(); // Tạo một đối tượng Date hiện tại cho ngày bắt đầu
			Date ngayKT = new Date(ngayBD.getTime() + TimeUnit.DAYS.toMillis(2));		
			System.out.println("ngày kết thúc: " + ngayKT);
//			setText("KM075", "thang4", ngayBD, ngayKT, false, null, "ádsd");
			km.txtGiaTri.setText("10");
			km.txtMaKM.setText("KM086");
			km.txtTenKM.setText("thang190");
			km.txtNgayBD.setDate(ngayBD);
			km.txtNgayKT.setDate(ngayKT);
		    km.rdoVND.setSelected(true);
			
			
			TimeUnit.SECONDS.sleep(2);
			km.btnThem.doClick(1);
			TimeUnit.SECONDS.sleep(2); 
			closeJOptionPaneIfDisplayed();
			Assert.assertEquals(km.message,"Vui lòng chọn trạng thái!");
	
		}
		@Test(priority = 8)
		public void insertKhuyenmai8() throws InterruptedException {
			Assert.assertNotNull(km);
			Date ngayBD = new Date(); // Tạo một đối tượng Date hiện tại cho ngày bắt đầu
			Date ngayKT = new Date(ngayBD.getTime() + TimeUnit.DAYS.toMillis(2));		
			System.out.println("ngày kết thúc: " + ngayKT);
			setText("KM075", "thang4", null, ngayKT, false, false, "9");
			TimeUnit.SECONDS.sleep(2);
			km.btnThem.doClick(1);
			TimeUnit.SECONDS.sleep(2); 
			closeJOptionPaneIfDisplayed();
			Assert.assertEquals(km.message,"Vui lòng chọn ngày khuyến mãi phù hợp");
	
		}
		@Test(priority = 9)
		public void insertKhuyenmai9() throws InterruptedException {
			Assert.assertNotNull(km);
			Date ngayBD = new Date(); // Tạo một đối tượng Date hiện tại cho ngày bắt đầu
			Date ngayKT = new Date(ngayBD.getTime() + TimeUnit.DAYS.toMillis(2));		
			System.out.println("ngày kết thúc: " + ngayKT);
			setText("KM075", "thang4", ngayBD, null, false, false, "9");
			TimeUnit.SECONDS.sleep(2);
			km.btnThem.doClick(1);
			TimeUnit.SECONDS.sleep(2); 
			closeJOptionPaneIfDisplayed();
			Assert.assertEquals(km.message,"Vui lòng chọn ngày khuyến mãi phù hợp");
	
		}

}
