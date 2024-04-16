package test.khadv_pc05684;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.naming.AuthenticationException;
import javax.swing.ImageIcon;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Dao.nhanVienDao;
import com.Dao.sanPhamDao;
import com.form.DangNhap;
import com.form.DoiMatKhau;
import com.form.QuanLySanPham1;
import com.main.Main;
import com.untils.JOptionPane;
import com.untils.XAuth;
import com.untils.getJOptionePane;

public class DoiMatKhauTest {
	DangNhap dangNhap;
	Main main;
	DoiMatKhau dmk;
	JOptionPane jOptionPane;
	getJOptionePane optionePane;
	String password = "";

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		dangNhap = new DangNhap(null, false);
		dangNhap.setVisible(true);
		main = new Main();
		dmk = new DoiMatKhau(main, false);
		jOptionPane = new JOptionPane();
		optionePane = new getJOptionePane();
		TimeUnit.SECONDS.sleep(2);
		dangNhap.txtTenTK.setText("NV001");
		TimeUnit.SECONDS.sleep(2);
		dangNhap.txtPassword.setText("matkhau123");
		TimeUnit.SECONDS.sleep(2);
		dangNhap.btnXacNhan.doClick();
		TimeUnit.SECONDS.sleep(2);
		jOptionPane.dialog.dispose();
		dangNhap.dispose();
		main.setVisible(true);
		XAuth.user = new nhanVienDao().selectById("NV001");
		password = XAuth.user.getMatKhau();
		TimeUnit.SECONDS.sleep(2);

		dmk.setVisible(true);
		TimeUnit.SECONDS.sleep(3);
	}

//
	@Test(dataProvider = "Data")
	public void testcase(String passwordOld, String passwordNew, String confirm, String expectedOld, String expectedNew,
			String expectedConfirm) throws InterruptedException {

		dmk.txtTenTK.setText(XAuth.user.getMaNV());
		dmk.txtMKC.setText(passwordOld);
		dmk.txtMKM.setText(passwordNew);
		dmk.txtNLMKM.setText(confirm);

		dmk.btnCapNhat.doClick();
		TimeUnit.SECONDS.sleep(2);
		if (passwordOld.isEmpty()) {
			assertTrue(dmk.lblTBcu.getText().equalsIgnoreCase(expectedOld));
		}
		if (passwordNew.isEmpty()) {
			assertTrue(dmk.lblTBMoi.getText().equalsIgnoreCase(expectedNew));
		}
		if (confirm.isEmpty()) {
			assertTrue(dmk.lblTBnl.getText().equalsIgnoreCase(expectedConfirm));
		}
		if (!passwordNew.equals(confirm)) {
			assertEquals(dmk.lblTBnl.getText(), expectedConfirm);
		}
		if (!passwordOld.equals(password)) {
			assertTrue(dmk.lblTBcu.getText().equalsIgnoreCase(expectedOld));
		}
		System.out.println(password);
		if (passwordNew.length() < 8) {
			assertTrue(dmk.lblTBMoi.getText().equalsIgnoreCase(expectedNew));
		}
		if (passwordNew.equals(confirm) && passwordNew.length() >= 8 && passwordOld.equals(password)) {
			assertEquals(jOptionPane.mess, expectedOld);
		}
		String checkBT = "^[a-zA-Z0-9]{8,}";
		if (!passwordNew.matches(checkBT)) {
			assertEquals(dmk.lblTBMoi.getText(), expectedNew);
		}

	}

//	@Test
//	public void test() {
//	}

	@DataProvider(name = "Data")
	public Object[][] Data() {
		return new Object[][] {
				{ "", "", "", "(*)Không được để trống!", "", "" },
				{ "matkhau123", "", "", "", "(*)Không được để trống!", "" },
				{ "matkhau123", "1234", "", "", "", "(*)Không được để trống!" },
				{ "12345678", "acb45678", "acb45678", "(*)Sai mật khẩu!", "", "" },
				{ "1234", "12345", "acb45678", "", "Mật khẩu mới phải có ít nhất 8 ký tự", "" },
				{ "1234", "acb12345", "acb", "", "", "Xác nhận mật khẩu không đúng!" },
				{ "1234", "*%$#12345", "*%$#12345", "", "Mật khẩu không được chứa ký tự đặc biệt", "" },
				{ "", "acb12345", "acb12345", "(*)Không được để trống!", "", "" },
				{ "matkhau123", "", "acb12345", "", "(*)Không được để trống!", "" },
				{ "matkhau123", "acb12345", "acb12345", "Đổi mật khẩu thành công!", "", "" } };
	}
	@AfterMethod
	public void afterMethod() {
		dangNhap.dispose();
		main.dispose();
	}
}
