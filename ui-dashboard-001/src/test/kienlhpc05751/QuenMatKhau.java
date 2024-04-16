package test.kienlhpc05751;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.form.DangNhap;
import com.form.MatKhauMoi;
import com.form.QuenMK;

public class QuenMatKhau {
	private DangNhap dangnhap;
	private QuenMK quen;
	private MatKhauMoi moi;
	JOptionPane JOptionPane = new JOptionPane();

	@BeforeMethod
	public void setUp() {
		quen = new QuenMK(null, false);
        quen.setVisible(true);
	}

	@AfterMethod
	public void tearDown() {
//		quen = null;
		quen.dispose();
		
	}

	public void closeJdialog() {
		Thread loginThread = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(3);
					closeJdialog();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		loginThread.start();
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

	public void sleep(int s) {
		try {
			TimeUnit.SECONDS.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

//    @Test
//	public void LoginTestNull() {
//        new Thread(() -> {
//        	  quen.txtTK.setText("tenTaiKhoanKhongTonTai");
//              quen.txtEmail.setText("example@example.com");
//              quen.btnLayMaActionPerformed(null);
//              closeJdialog();
//              String expectedMessage = "Tài khoản không tồn tại trên hệ thống.";
//              String actualMessage = quen.message;
//              Assert.assertEquals(expectedMessage, actualMessage);
//        }).start();
//        sleep(3); // Chờ 5 giây cho hộp thoại hiển thị và xử lý
////        assertEquals(login.message,"Vui lòng nhập đầy đủ thông tin");
//    }
//    

//    @Test(priority = 0)
//    public void TC_QLF_QuenMK1() {
//        quen.txtTK.setText("tenTaiKhoanKhongTonTai");
//        quen.txtEmail.setText("example@example.com");
//        quen.btnLayMaActionPerformed(null);
//        closeJdialog();
//        String expectedMessage = "Tài khoản không tồn tại trên hệ thống.";
//        String actualMessage = quen.message;
//        Assert.assertEquals(expectedMessage, actualMessage);
//    }
	
	@Test(priority = 0)
	public void TC_QLF_QuenMK1() {
		sleep(1);
		quen.txtTK.setText("tenTaiKhoanKhongTonTai");
		quen.txtEmail.setText("example@example.com");
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
		quen.btnLayMa.doClick();
		String expectedMessage = "Tài khoản không tồn tại trên hệ thống.";
		String actualMessage = quen.message;
		Assert.assertEquals(expectedMessage, actualMessage);
	}

    @Test(priority = 1)
    public void TC_QLF_QuenMK2() {
        quen.txtTK.setText("NV000");
        quen.txtEmail.setText("mismatched@example.com");
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
        quen.btnLayMa.doClick();
        String expectedMessage = "Email không tương thích với tài khoản đã nhập.";
        String actualMessage = quen.message;
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test(priority = 2)
    public void TC_QLF_QuenMK3() {
        quen.txtTK.setText("NV001");
        quen.txtEmail.setText("");
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
        quen.btnLayMa.doClick();
//        quen.btnLayMaActionPerformed(null);
        String expectedMessage = "Vui lòng nhập đầy đủ tên tài khoản và email.";
        String actualMessage = quen.message;
        Assert.assertEquals(expectedMessage, actualMessage);
    }
//    
    @Test(priority = 3)
    public void TC_QLF_QuenMK4() {
        quen.txtTK.setText("NV001");
        quen.txtEmail.setText("exampleexamplecom");
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
//        quen.txtMaXT.setText(quen.maXT);
        quen.btnLayMa.doClick();
//        quen.btnLayMaActionPerformed(null);
        
        String expectedMessage = "Email không đúng định dạng.";
        String actualMessage = quen.message;
        Assert.assertEquals(expectedMessage, actualMessage);
    }
//     
//    
    
    @Test(priority = 4)
    public void TC_QLF_QuenMK5() {
        quen.txtTK.setText("NV40");
        quen.txtEmail.setText("kienl8595@gmail.com");
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
        quen.btnLayMa.doClick();
        quen.txtMaXT.setText(quen.maXT);
        moi.setVisible(false);
        moi.dispose();
        moi.txtMKM.setText("kien");
        moi.txtNLMK.setText("kien");
        
//        quen.btnLayMaActionPerformed(null);
//        quen.btnLayMa.doClick();
       
        String expectedMessage = "Mã đã được gửi!";
        String actualMessage = quen.message;
        Assert.assertEquals(expectedMessage, actualMessage);
    }
//    //
//
    @Test(priority = 5)
    public void test_GuiMailThatBai() {
        quen.txtTK.setText("NV40");
        quen.txtEmail.setText("kienl8595@gmail.com");
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
        quen.btnLayMa.doClick();
        quen.setVisible(false);
        moi.dispose();
        String expectedMessage = "Lỗi khi gửi email. Vui lòng thử lại sau.";
        String actualMessage = quen.message;
        Assert.assertEquals(expectedMessage, actualMessage);
    }
//
    @Test(priority = 6)
    public void TC_QLF_QuenMK6() {
        quen.txtTK.setText("tenTaiKhoan");
        quen.txtEmail.setText("example@example.com");
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
        quen.maXT = "123456";
        quen.txtMaXT.setText("123456");
        quen.btnXacNhanActionPerformed(null);
        Assert.assertEquals(quen.maXT, "123456");
    }
//
    @Test(priority = 7)
    public void TC_QLF_QuenMK7() {
        quen.txtTK.setText("tenTaiKhoan");
        quen.txtEmail.setText("example@example.com");
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
        quen.maXT = "123456";
        quen.txtMaXT.setText("abcdef");
        quen.btnXacNhanActionPerformed(null);
        String expectedMessage = "Sai mã xác thực!";
        String actualMessage = quen.message;
        Assert.assertEquals(expectedMessage, actualMessage);
    }

//
    @Test(priority = 8)
    public void TC_QLF_QuenMK8() {
        quen.txtTK.setText("NV001");
        quen.txtEmail.setText("example@example.com");
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
        quen.txtMaXT.setText("");
        quen.btnLayMa.doClick();
        quen.btnXacNhan.doClick(1);
        String expectedMessage = "Vui lòng nhập mã xác thực!";
        String actualMessage = quen.message;
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @Test(priority = 9)
    public void TC_QLF_QuenMK9() {
        quen.txtTK.setText("NV001");
        quen.txtEmail.setText("example@example.com");
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
        quen.txtMaXT.setText(quen.maXT);
        quen.btnXacNhanActionPerformed(null);
//        quen.btnXacNhan.doClick();
//         Giả sử quen.ma là dialog đổi mật khẩu được mở
        Assert.assertNotNull(quen.maXT);
    }

	// oew day

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

//    
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
