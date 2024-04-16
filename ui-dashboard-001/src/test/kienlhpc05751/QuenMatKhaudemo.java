package test.kienlhpc05751;

import static org.testng.Assert.assertEquals;

import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.form.DangNhap;
import com.form.KhuyenMai1;
import com.form.MatKhauMoi;
import com.form.QuenMK;
import com.main.Main;

@Test
public class QuenMatKhaudemo {
    private QuenMK quen =new QuenMK(null, true);
	private Main main;
	public DangNhap login = new DangNhap(main, false);
//	private QuenMK  quen = new  
//	private QuanLyNhanVien1 quanLyNhanVien;
	public KhuyenMai1 km = new KhuyenMai1();
//    @BeforeMethod
//    public void setUp() throws InterruptedException {
//        quen = new QuenMK(null, true);
//        TimeUnit.SECONDS.sleep(2);
//        
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        quen = null;
//    }
    @BeforeMethod
	public void setUp() {
//		DangNhap login = new DangNhap(null, false);
//    	jLabel5MouseClicked
    	
		login.setVisible(true);
//		login.jLabel5MouseClicked(MouseEvent.MOUSE_CLICKED);
//		login.jLabel5.action(MouseEvent.MOUSE_CLICKED, quen);
//		login.getTxtTenTK().setText("NV000");
//		login.getTxtPassword().setText("1234");
		
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


    public void TC_QLF_QuenMK1() throws InterruptedException {
        quen.txtTK.setText("NV40");
        quen.txtEmail.setText("kienl8595@gmail.com");
        quen.btnLayMa.doClick();
        TimeUnit.SECONDS.sleep(1);
        quen.btnLayMaActionPerformed(null);
        String expectedMessage = "Tài khoản không tồn tại trên hệ thống.";
        String actualMessage = quen.message;
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    public void TS_ThemVoucher_02() throws InterruptedException {		
    	
//		setText("a@@", 11);  
//		km.btnMoi1.doClick(1);
//		    vh.createVoucher();
//		    vh.txtGia.setText(String.valueOf("1"));
//		    vh.txtGia.setText("40");	    
//		   String giaTri = Integer.parseInt(vh.txtGia.getText());
//		    vh.spnSoLuong.setValue(11);
//		TimeUnit.SECONDS.sleep(2);	
//		vh.btnTao.doClick(1);
		TimeUnit.SECONDS.sleep(2);
//		closeJOptionPane();
//		assertEquals(vh.message, "Giá trị chưa đúng");
		assertEquals(.message, "Vui lòng nhập giá trị voucher");
	
	}

//    @Test(priority = 1)
//    public void TC_QLF_QuenMK2() {
//        quen.txtTK.setText("NV000");
//        quen.txtEmail.setText("mismatched@example.com");
//        quen.btnLayMa.doClick();
//        quen.btnLayMaActionPerformed(null);
//        String expectedMessage = "Email không tương thích với tài khoản đã nhập.";
//        String actualMessage = quen.message;
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }
//    @Test(priority = 2)
//    public void TC_QLF_QuenMK3() {
//        quen.txtTK.setText("NV001");
//        quen.txtEmail.setText("");
//        quen.btnLayMa.doClick(1);
//        quen.btnLayMaActionPerformed(null);
//        String expectedMessage = "Vui lòng nhập đầy đủ tên tài khoản và email.";
//        String actualMessage = quen.message;
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }
//    
//    @Test(priority = 3)
//    public void TC_QLF_QuenMK4() {
//        quen.txtTK.setText("NV001");
//        quen.txtEmail.setText("exampleexamplecom");
////        quen.txtMaXT.setText(quen.maXT);
//        quen.btnLayMa.doClick(1);
//        quen.btnLayMaActionPerformed(null);
//        
//        String expectedMessage = "Email không đúng định dạng.";
//        String actualMessage = quen.message;
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }
//     
//    
//    
//    @Test(priority = 4)
//    public void TC_QLF_QuenMK5() {
//        quen.txtTK.setText("NV40");
//        quen.txtEmail.setText("kienl8595@gmail.com");
//        quen.btnLayMa.doClick(1);
//        quen.txtMaXT.setText(quen.maXT);
//        quen.btnLayMaActionPerformed(null);
//        quen.btnLayMa.doClick();
//       
//        String expectedMessage = "Mã đã được gửi!";
//        String actualMessage = quen.message;
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }
//    //
//
//    @Test(priority = 5)
//    public void test_GuiMailThatBai() {
//        quen.txtTK.setText("NV40");
//        quen.txtEmail.setText("kienl8595@gmail.com");
//        quen.btnLayMaActionPerformed(null);
//        String expectedMessage = "Lỗi khi gửi email. Vui lòng thử lại sau.";
//        String actualMessage = quen.message;
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }
//
//    @Test(priority = 6)
//    public void TC_QLF_QuenMK6() {
//        quen.txtTK.setText("tenTaiKhoan");
//        quen.txtEmail.setText("example@example.com");
//        quen.maXT = "123456";
//        quen.txtMaXT.setText("123456");
//        quen.btnXacNhanActionPerformed(null);
//        Assert.assertEquals(quen.maXT, "123456");
//    }
//
//    @Test(priority = 7)
//    public void TC_QLF_QuenMK7() {
//        quen.txtTK.setText("tenTaiKhoan");
//        quen.txtEmail.setText("example@example.com");
//        quen.maXT = "123456";
//        quen.txtMaXT.setText("abcdef");
//        quen.btnXacNhanActionPerformed(null);
//        String expectedMessage = "Sai mã xác thực!";
//        String actualMessage = quen.message;
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }
//
//
//    @Test(priority = 8)
//    public void TC_QLF_QuenMK8() {
//        quen.txtTK.setText("NV001");
//        quen.txtEmail.setText("example@example.com");
//        quen.txtMaXT.setText("");
//        quen.btnLayMa.doClick();
//        quen.btnXacNhan.doClick(1);
//        String expectedMessage = "Vui lòng nhập mã xác thực!";
//        String actualMessage = quen.message;
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }
//
//
//    @Test(priority = 9)
//    public void TC_QLF_QuenMK9() {
//        quen.txtTK.setText("NV001");
//        quen.txtEmail.setText("example@example.com");
////        quen.maXT = "123456";
//        quen.txtMaXT.setText(quen.maXT);
//        quen.btnXacNhanActionPerformed(null);
//        quen.btnXacNhan.doClick();
//        // Giả sử quen.ma là dialog đổi mật khẩu được mở
//        Assert.assertNotNull(quen.maXT);
//    }

    
//    @Test(priority = 11)
//    public void TC_QLF_QuenMK11() {
//        quen.txtTK.setText("tenTaiKhoan");
//        quen.txtEmail.setText("example@example.com");
//        quen.maXT = "123456";
//        quen.txtMaXT.setText("abcdef");
//        quen.btnXacNhanActionPerformed(null);
//        quen.txtMaXT.setText("123456");
//        quen.btnXacNhan.doClick(1);
//        String expectedMessage = "Sai mã xác thực!";
//        String actualMessage = quen.message;
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }

//    @Test(priority = 13)
//    public void TC_QLF_QuenMK13() {
//        quen.txtTK.setText("NV001");
//        quen.txtEmail.setText("example@example.com");
////        quen.maXT = "123456";
//        quen.txtMaXT.setText("123456");
//        quen.btnXacNhanActionPerformed(null);
//        quen.txtMaXT.setText("abcdef");
//        quen.btnXacNhan.doClick(1);
//        String expectedMessage = "Sai mã xác thực!";
//        String actualMessage = quen.message;
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }
    
    
//    @Test(priority = 8)
//    public void TC_QLF_QuenMK81() {
//        quen.txtTK.setText("");
//        quen.txtEmail.setText("example@example.com");
//        quen.btnXacNhan.doClick(1);
//        quen.btnLayMaActionPerformed(null);
//        String expectedMessage = "Vui lòng nhập đầy đủ tên tài khoản và email.";
//        String actualMessage = quen.message;
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }
//    @Test(priority = 92)
//    public void TC_QLF_QuenMK91() {
//        quen.txtTK.setText("NV001");
//        quen.txtEmail.setText("example@example.com");
//        quen.maXT = "";
//        quen.txtMaXT.setText("");
//        quen.btnLayMaActionPerformed(null);
//        quen.btnXacNhan.doClick(1);
//        String expectedMessage = "Vui lòng nhập mã xác thực!";
//        String actualMessage = quen.message;
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }

}
