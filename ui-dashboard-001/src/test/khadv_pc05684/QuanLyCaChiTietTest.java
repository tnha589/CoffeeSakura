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
import com.form.SapCa1;
import com.form.THU;
import com.main.Main;
import com.untils.JOptionPane;
import com.untils.XAuth;

public class QuanLyCaChiTietTest {
	DangNhap dangNhap;
	THU thu;
	Main main;
	JOptionPane jOptionPane;
	SapCa1 sapCa;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		dangNhap = new DangNhap(null, false);
		jOptionPane = new JOptionPane();
		XAuth.user = new nhanVienDao().selectById("NV000");
		thu = new THU(null, false);
		main = new Main();
		sapCa = new SapCa1(main, false);
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
	public void testCase1(int day, int row, int rowNV, int rowTN, String message) throws InterruptedException {
		main.setVisible(true);
		TimeUnit.SECONDS.sleep(2);
		thu.setVisible(true);
		TimeUnit.SECONDS.sleep(2);
		thu.cboThu.setSelectedIndex(day);
		TimeUnit.SECONDS.sleep(2);
		sapCa.getThu(thu.cboThu.getItemAt(day));
		sapCa.getCa(thu.tblCaLam.getValueAt(row, 1).toString());
		sapCa.setVisible(true);
		TimeUnit.SECONDS.sleep(3);
//		if (rowNV < sapCa.tblPhucVu.getRowCount()) {
		sapCa.listNV.add(new Object[] { sapCa.tblPhucVu.getValueAt(rowNV, 0), sapCa.tblPhucVu.getValueAt(rowNV, 1) });
		sapCa.FillPhucVu();
//		}

//		if (rowTN < sapCa.tblThuNgan.getRowCount()) {
		sapCa.listTN.add(new Object[] { sapCa.tblThuNgan.getValueAt(rowTN, 0), sapCa.tblThuNgan.getValueAt(rowTN, 1) });
		sapCa.txtThuNgan.setText(sapCa.tblThuNgan.getValueAt(rowTN, 1).toString());
//		}

		TimeUnit.SECONDS.sleep(3);
		sapCa.btnXacNhan.doClick();
		assertEquals(jOptionPane.mess, message);
		TimeUnit.SECONDS.sleep(2);
	}

	@DataProvider(name = "data")
	public Object[][] data() {
		return new Object[][] {
				{ 2, 0, 2000, 20000, "Vui lòng thêm nhân viên phục vụ" },
				{ 3, 1, 2, 200, "Vui lòng chọn nhân viên thu ngân" }, { 4, 3, 10000, 2, "Vui thêm nhân viên phục vụ" },
				{ 2, 3, 1, 0, "Thêm Thành Công!" } };
	}

//	"Thêm Thành Công!"

	@AfterMethod
	public void afterMethod() {
		main.dispose();
		thu.dispose();
	}
}
