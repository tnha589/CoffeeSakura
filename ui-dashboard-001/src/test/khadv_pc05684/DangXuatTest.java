package test.khadv_pc05684;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Dao.nhanVienDao;
import com.form.DangNhap;
import com.form.DoiMatKhau;
import com.main.Main;
import com.untils.JOptionPane;
import com.untils.XAuth;
import com.untils.getJOptionePane;

public class DangXuatTest {
	DangNhap dangNhap;
	Main main;
	JOptionPane jOptionPane;
	getJOptionePane optionePane;
	String password = "";

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		dangNhap = new DangNhap(null, false);
		dangNhap.setVisible(true);
		main = new Main();
		jOptionPane = new JOptionPane();
		optionePane = new getJOptionePane();
		TimeUnit.SECONDS.sleep(2);
		dangNhap.txtTenTK.setText("NV000");
		TimeUnit.SECONDS.sleep(2);
		dangNhap.txtPassword.setText("1234");
		TimeUnit.SECONDS.sleep(2);
		dangNhap.btnXacNhan.doClick();
		TimeUnit.SECONDS.sleep(2);
		jOptionPane.dialog.dispose();
		dangNhap.dispose();
		main.setVisible(true);
		TimeUnit.SECONDS.sleep(2);

	}

	@Test
	public void testcase() {
		main.DangXuat();
	}

	@AfterMethod
	public void afterMethod() {
		dangNhap.dispose();
		main.dispose();
	}
}
