package test.khadv_pc05684;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Dao.nhanVienDao;
import com.form.Calam;
import com.form.DangNhap;
import com.form.THU;
import com.main.Main;
import com.untils.JOptionPane;
import com.untils.XAuth;

public class QuanLyCaTest {
	DangNhap dangNhap;
	THU thu;
	Main main;
	JOptionPane jOptionPane;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		dangNhap = new DangNhap(null, false);
		jOptionPane = new JOptionPane();
		XAuth.user = new nhanVienDao().selectById("NV000");
		thu = new THU(null, false);
		main = new Main();
		dangNhap.setVisible(true);
		TimeUnit.SECONDS.sleep(2);
		dangNhap.txtTenTK.setText("NV000");
		TimeUnit.SECONDS.sleep(1);
		dangNhap.txtPassword.setText("1234");
		TimeUnit.SECONDS.sleep(2);
		dangNhap.btnXacNhan.doClick();
		TimeUnit.SECONDS.sleep(2);
		jOptionPane.dialog.dispose();
		dangNhap.dispose();
	}

	@Test(dataProvider = "data")
	public void testCase1(int day, boolean xoa) throws InterruptedException {
		main.setVisible(true);
		TimeUnit.SECONDS.sleep(2);
		thu.setVisible(true);
		TimeUnit.SECONDS.sleep(2);
		thu.cboThu.setSelectedIndex(day);
		TimeUnit.SECONDS.sleep(2);
		if (xoa) {
			thu.btnXoa.doClick();
			assertTrue(thu.userConfirmed);
		} else {
			thu.btnXoaAll.doClick();
			assertTrue(thu.userConfirmed);
		}
		TimeUnit.SECONDS.sleep(3);
	}

	@DataProvider(name = "data")
	public Object[][] data() {
		return new Object[][] { { 2, true }, { 3, false } };
	}

	@AfterMethod
	public void afterMethod() {
		main.dispose();
		thu.dispose();
	}
}
