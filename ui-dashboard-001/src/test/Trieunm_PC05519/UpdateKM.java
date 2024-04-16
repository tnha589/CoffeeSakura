package test.Trieunm_PC05519;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Dao.nhanVienDao;
import com.form.DangNhap;
import com.form.KhuyenMai1;
import com.main.Main;

public class UpdateKM {
	private Main main;
	public DangNhap login = new DangNhap(main, false);
//	private QuanLyNhanVien1 quanLyNhanVien;
	KhuyenMai1 km = new KhuyenMai1();

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
	public void updateKhuyenmai() throws InterruptedException {
		km.tblKhuyenMai.setRowSelectionInterval(0, 0);
		TimeUnit.SECONDS.sleep(3); 
		km.tblKhuyenMaiMouseClicked(null);
		
		Assert.assertNotNull(km);
		Date ngayBD = new Date(); // Tạo một đối tượng Date hiện tại cho ngày bắt đầu
		Date ngayKT = new Date(ngayBD.getTime() + TimeUnit.DAYS.toMillis(2));
		
		System.out.println("ngày kết thúc: " + ngayKT);
		setText("KM001","Thang", ngayBD, ngayKT, false, false, "10");
		TimeUnit.SECONDS.sleep(2);
//		XDialog.setOptionPane(new YesMockOptionPane());
		km.btnCapNhat.doClick(1);
		TimeUnit.SECONDS.sleep(2);
//		closeJOptionPane();
		closeJOptionPaneIfDisplayed();
//		String error;
	}
	@Test(priority = 1)
	public void updateKhuyenmai1() throws InterruptedException {
		km.tblKhuyenMai.setRowSelectionInterval(0, 0);
		TimeUnit.SECONDS.sleep(3); 
		km.tblKhuyenMaiMouseClicked(null);
		
		Assert.assertNotNull(km);
		Date ngayBD = new Date(); // Tạo một đối tượng Date hiện tại cho ngày bắt đầu
		Date ngayKT = new Date(ngayBD.getTime() + TimeUnit.DAYS.toMillis(2));
		
		System.out.println("ngày kết thúc: " + ngayKT);
		setText("KM001","Thang", ngayBD, ngayKT, false, false, "11");
		TimeUnit.SECONDS.sleep(2);
//		XDialog.setOptionPane(new YesMockOptionPane());
		km.btnCapNhat.doClick(1);
		TimeUnit.SECONDS.sleep(2);
//		closeJOptionPane();
		closeJOptionPaneIfDisplayed();
//		String error;
		Assert.assertEquals(km.message,"Giá khuyến mãi chưa phù hợp!");
		


	}

}
