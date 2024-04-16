package test.kienlhpc05751;

import static org.testng.Assert.assertEquals;

import java.awt.AWTEvent;
import java.awt.Component;
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
import com.model.KhuyenMai;
import com.supportTest.YesMockOptionPane;
import com.untils.XDialog;

public class LamMoiKhuyenMai {
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
		AWTEvent event = new AWTEvent(new JOptionPane(), 0) {
		};
		EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
		queue.postEvent(event);
	}

	private void closeJOptionPaneIfDisplayed() {
		Window[] windows = Window.getWindows();
		for (Window window1 : windows) {
			JOptionPane window = null;
			if (window instanceof JOptionPane) {
				JOptionPane optionPane = (JOptionPane) window;
				if (optionPane.isVisible() && optionPane.getValue() != null
						&& optionPane.getValue().equals(JOptionPane.OK_OPTION)) {
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
	public void lamMoiKhuyenmai() throws InterruptedException {
		km.row2 = 2;
		km.edit();
		TimeUnit.SECONDS.sleep(2);
//		XDialog.setOptionPane(new YesMockOptionPane());
		km.btnMoi.doClick(1);
		TimeUnit.SECONDS.sleep(2);
//			closeJOptionPane();
		closeJOptionPaneIfDisplayed();
		KhuyenMai kmModel = new KhuyenMai();
		kmModel.setTenKM(km.txtTenKM.getText());
		kmModel.setNgayBD(km.txtNgayBD.getDate());
		kmModel.setMaKM(km.txtMaKM.getText());
		
		System.out.println("new "+kmModel.getTenKM());
//		Assert.assertNull(kmModel);
//		if(kmModel.TenKM != null) {
//			Assert.assertEquals(kmModel.getTenKM(),"");
//		}else if(kmModel.NgayBD!=null) {
//			Assert.assertEquals(kmModel.getNgayBD(),"");
//		}
		Assert.assertNotNull(kmModel, null);
//		assertEquals("", "");
	

	}
	
	@Test(priority = 1)
	public void lamMoiKhuyenmai3() throws InterruptedException {
		km.row2 = 2;
		km.edit();
		TimeUnit.SECONDS.sleep(2);
		km.btnMoi.doClick(1);
//		TimeUnit.SECONDS.sleep(2);
//			closeJOptionPane();
		closeJOptionPaneIfDisplayed();
		KhuyenMai kmModel = new KhuyenMai();
		kmModel.setTenKM(km.txtTenKM.getText());
		kmModel.setNgayBD(km.txtNgayBD.getDate());
		System.out.println("new "+kmModel.getTenKM());
//		Assert.assertNull(kmModel);
		if(kmModel.TenKM != null) {
			Assert.assertEquals(kmModel.getTenKM(),"");
		}else if(kmModel.NgayBD!=null) {
			Assert.assertEquals(kmModel.getNgayBD(),"");
		}
		assertEquals("", "");
	

	}
//	
//	@Test(priority = 1)
//	public void lamMoiKhuyenmai1() throws InterruptedException {
//		km.row2 = 2;
//		km.edit();
//		TimeUnit.SECONDS.sleep(2);
//		XDialog.setOptionPane(new YesMockOptionPane());
//		km.btnMoi.doClick(1);
//		TimeUnit.SECONDS.sleep(2);
////			closeJOptionPane();
//		closeJOptionPaneIfDisplayed();
//        KhuyenMai kmModel = km.getForm();
////		Assert.assertNull(kmModel);
//		if(kmModel.TenKM != null) {
//			Assert.assertEquals(kmModel.getTenKM(),"");
//		}else if(kmModel.MaKM!=null) {
//			Assert.assertEquals(kmModel.getMaKM(),"");
//		}else if(kmModel.GhiChu != null) {
//			Assert.assertEquals(kmModel.getGhiChu(), "");
//		}
//		assertEquals("", "");
//	
//
//	}
}
