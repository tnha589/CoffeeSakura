package quangddpc05711;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.form.Menu1;
import com.form.TrangChu;

import quangddpc05711.SwingTestNG.DangNhapTestNG;
import quangddpc05711.SwingTestNG.HeaderTestNG;
import quangddpc05711.SwingTestNG.LienKetEmailTestNG;
import quangddpc05711.SwingTestNG.MainTestNG;

public class LienKetEmailTest {
	DangNhapTestNG login = new DangNhapTestNG();
	MainTestNG main;
	Menu1 form1 = new Menu1();
	TrangChu home = new TrangChu();
	HeaderTestNG h2 = new HeaderTestNG();
	LienKetEmailTestNG lkemail = new LienKetEmailTestNG(login, false);

	@BeforeMethod
	public void init() {
		login.setVisible(true);
	}

	@AfterMethod
	public void Close() {
//		main.dispose();
	}

	// Nhấn nút "Liên kết" khi bỏ trống tất cả
	// PASS
	@Test
	public void TC_LKEMAIL_02() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.home);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail = main.header2.lienKetGmailActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.txtEmail.setText("");
		lkemail.txtMa.setText("");

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.btnLienKetActionPerformed(null);

		String actualMessage = lkemail.getMessageReturn();

		assertEquals(actualMessage, "Vui lòng nhập email.");

	}

	// Nhấn nút "Liên kết" khi nhập email còn lại để trống
	@Test
	public void TC_LKEMAIL_03() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.home);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail = main.header2.lienKetGmailActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.txtEmail.setText("williamdang0404@gmail.com");
		lkemail.txtMa.setText("");

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.btnLienKetActionPerformed(null);

		String actualMessage = lkemail.getMessageReturn();

		assertEquals(actualMessage, "Mã xác thực không được để trống");

	}

	// Nhấn nút "Liên kết" khi nhập mã xác thực còn lại để trống
	@Test
	public void TC_LKEMAIL_04() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.home);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail = main.header2.lienKetGmailActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.txtEmail.setText("");
		lkemail.txtMa.setText("ádasda");

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.btnLienKetActionPerformed(null);

		String actualMessage = lkemail.getMessageReturn();

		assertEquals(actualMessage, "Email không được để trống");

	}

	// Nhấn nút "Lấy mã" khi không nhập email
	// PASS
	@Test
	public void TC_LKEMAIL_05() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.home);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail = main.header2.lienKetGmailActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.txtEmail.setText("");
		lkemail.txtMa.setText("");

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.btnGuiActionPerformed(null);

		String actualMessage = lkemail.getMessageReturn();

		assertEquals(actualMessage, "Vui lòng nhập Email.");

	}

	// Nhấn nút "Lấy mã" khi nhập email
	// PASS
	@Test
	public void TC_LKEMAIL_06() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.home);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail = main.header2.lienKetGmailActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.txtEmail.setText("williamdang0404@gmail.com");
		lkemail.txtMa.setText("");

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.btnGuiActionPerformed(null);

		String actualMessage = lkemail.getMessageReturn();

		assertEquals(actualMessage, "Đã gửi mã thành công!");

	}

	// Nhấn nút "Lấy mã" khi nhập email không đúng định dạng
	// PASS
	@Test
	public void TC_LKEMAIL_07() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.home);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail = main.header2.lienKetGmailActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.txtEmail.setText("williamdang0404");
		lkemail.txtMa.setText("");

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.btnGuiActionPerformed(null);

		String actualMessage = lkemail.getMessageReturn();

		assertEquals(actualMessage, "Email không đúng định dạng.");

	}
	
	// Nhấn nút "Liên kết" khi nhập email đúng, gửi mã thành công và nhập mã sai
		// PASS
		@Test
		public void TC_LKEMAIL_08() {
			login.txtTenTK.setText("NV000");
			login.txtPassword.setText("1234");

			main = new MainTestNG();

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			main = login.btnXacNhanActionPerformed(null);
			main.setForm(main.home);

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			lkemail = main.header2.lienKetGmailActionPerformed(null);

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			lkemail.txtEmail.setText("williamdang0404@gmail.com");
			lkemail.txtMa.setText("");

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			lkemail.btnGuiActionPerformed(null);
			
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//mở lại form liên kết vì gửi mã xong form tự tắt
			lkemail = main.header2.lienKetGmailActionPerformed(null);

			lkemail.txtEmail.setText("williamdang0404@gmail.com");
			lkemail.txtMa.setText("k4tWFW");
			
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			lkemail.btnLienKetActionPerformed(null);
			
			String actualMessage = lkemail.getMessageReturn();

			assertEquals(actualMessage, "Sai mã xác thực");

		}

	// Liên kết thành công với dữ liệu nhập đúng
	// PASS
	@Test
	public void TC_LKEMAIL_09() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.home);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail = main.header2.lienKetGmailActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.txtEmail.setText("williamdang0404@gmail.com");
		lkemail.txtMa.setText("");

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lkemail.btnGuiActionPerformed(null);
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//mở lại form liên kết vì gửi mã xong form tự tắt
		lkemail = main.header2.lienKetGmailActionPerformed(null);

		lkemail.txtEmail.setText("williamdang0404@gmail.com");
		//Nhập mã xác thực được gửi
		lkemail.txtMa.setText(lkemail.maXT);
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lkemail.btnLienKetActionPerformed(null);
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String actualMessage = lkemail.getMessageReturn();

		assertEquals(actualMessage, "Liên kết thành công!");

	}
	
	// Nhấn nút "Liên kết" khi nhập lại email đã liên kết, gửi mã thành công và nhập đúng mã
		// PASS
		@Test
		public void TC_LKEMAIL_10() {
			login.txtTenTK.setText("NV000");
			login.txtPassword.setText("1234");

			main = new MainTestNG();

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			main = login.btnXacNhanActionPerformed(null);
			main.setForm(main.home);

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			lkemail = main.header2.lienKetGmailActionPerformed(null);

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			lkemail.txtEmail.setText("williamdang0404@gmail.com");
			lkemail.txtMa.setText("");

			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			lkemail.btnGuiActionPerformed(null);
			
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			String actualMessage = lkemail.getMessageReturn();

			assertEquals(actualMessage, "Email đã tồn tại trong hệ thống.");

		}

}
