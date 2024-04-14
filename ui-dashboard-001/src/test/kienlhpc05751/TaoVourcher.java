package test.kienlhpc05751;

import static org.testng.Assert.assertEquals;

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
import com.form.Voucher;
import com.main.Main;
import com.model.KhuyenMai;
import com.supportTest.YesMockOptionPane;
import com.untils.XDialog;

public class TaoVourcher {
	private Main main;
	public DangNhap login = new DangNhap(main, false);
//	private QuanLyNhanVien1 quanLyNhanVien;
	public KhuyenMai1 km = new KhuyenMai1();
	public Voucher vh = new Voucher(null, true);
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

	public void setText(Integer giatri,Integer soluong ) {
//		 int sl = (int) vh.spnSoLuong.getValue();
	    vh.txtGia.setText(String.valueOf(giatri));
	    vh.spnSoLuong.setValue(soluong);
	    
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
	public void TS_ThemVoucher_02() throws InterruptedException {
		
//		setText("a@@", 11);
	  
//		km.btnMoi1.doClick(1);
		
		    
		    vh.createVoucher();
//		    vh.txtGia.setText(String.valueOf("1"));
		    vh.txtGia.setText("40");
		    
//		   String giaTri = Integer.parseInt(vh.txtGia.getText());
		    vh.spnSoLuong.setValue(11);
//		TimeUnit.SECONDS.sleep(2);
		
//		vh.btnTao.doClick(1);
	
		TimeUnit.SECONDS.sleep(2);
//		closeJOptionPane();
//		assertEquals(vh.message, "Giá trị chưa đúng");
		assertEquals(vh.message, "Vui lòng nhập giá trị voucher");
	
	}
	
//    Voucher voucher = new Voucher(null, true);
//    voucher.setVisible(true);
}
