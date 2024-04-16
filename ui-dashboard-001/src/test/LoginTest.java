package test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.form.DangNhap;
import com.untils.JOptionPane;
import com.untils.getJOptionePane;

public class LoginTest {
	DangNhap dangNhap;
	JOptionPane jOptionPane;

	@BeforeMethod
	public void beforeMethod() {
		jOptionPane = new JOptionPane();
		dangNhap = new DangNhap(null, false);
		dangNhap.setVisible(true);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@Test
	public void f() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		dangNhap.txtTenTK.setText("NV000");
		TimeUnit.SECONDS.sleep(2);
		dangNhap.txtPassword.setText("1234");
		TimeUnit.SECONDS.sleep(2);
		dangNhap.btnXacNhan.doClick();
		TimeUnit.SECONDS.sleep(6);
		jOptionPane.dispose();

	}

}
