package test.VinhKy_PC05475;

import org.testng.annotations.Test;

import com.Dao.ThongKeDao;
import com.form.DangNhap;
import com.form.ThongKe1;
import com.main.Main;
import com.untils.XAuth;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;

public class ThongKeSanPhamTest {
	ThongKe1 tk1;
	Main main;
	private DangNhap login;
	ThongKeDao tkDao = new ThongKeDao();
//	List<thong> list = new ArrayList<>();

	public void sleep(int s) {
		try {
			TimeUnit.SECONDS.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void openTK() throws ParseException {
		main = new Main();
		tk1 = new ThongKe1();
		login = new DangNhap(null, false);
		login.setVisible(true);
		login.getTxtTenTK().setText("NV000");
		login.getTxtPassword().setText("1234");
		sleep(2);
		login.login();

		main.setVisible(true);

		main.setForm(tk1);
		tk1.getTabs().setSelectedIndex(1);
	}

	@Test(priority = 1)
	public void Testdoanhthu1() throws SQLException {

		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(2022, Calendar.NOVEMBER, 1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(2024, Calendar.NOVEMBER, 11);
		tk1.getTxtNgayBDTK().setDate(calendar1.getTime());
		tk1.getTxtNgayKTTK().setDate(calendar2.getTime());
		sleep(3);
		tk1.LayThongTinHoaDon();

		tk1.fillTableThongKeByCard1();

		tk1.fillTableThongKeByCard2();

		tk1.fillTableThongKeByCard3();
	}

	@Test(priority = 2)
	public void TestSanPham() throws SQLException {
		new Thread(new Runnable() {
			public void run() {
				Calendar calendar1 = Calendar.getInstance();
				calendar1.set(2025, Calendar.NOVEMBER, 1);
				Calendar calendar2 = Calendar.getInstance();
				calendar2.set(2024, Calendar.NOVEMBER, 11);
				tk1.getTxtNgayBDTK().setDate(calendar1.getTime());
				tk1.getTxtNgayKTTK().setDate(calendar2.getTime());
				sleep(3);

			}
		}).start();
		tk1.LayThongTinHoaDon();
		sleep(3);
		tk1.fillTableThongKeByCard1();

		tk1.fillTableThongKeByCard2();

		tk1.fillTableThongKeByCard3();

		tk1.closeJdialog();
		sleep(3);
		assertEquals(tk1.message, "Ngày bắt đầu phải trước ngày kết thúc");
	}

	@Test(priority = 3)
	public void TestSanPham2() throws SQLException {
		new Thread(new Runnable() {
			public void run() {

				Calendar calendar2 = Calendar.getInstance();
				calendar2.set(2024, Calendar.NOVEMBER, 11);

				tk1.getTxtNgayKTTK().setDate(calendar2.getTime());
				sleep(3);
				tk1.getTxtNgayBDTK().setDate(null);
			}
		}).start();
		tk1.LayThongTinHoaDon();

		tk1.fillTableThongKeByCard1();

		tk1.fillTableThongKeByCard2();

		tk1.fillTableThongKeByCard3();

		tk1.closeJdialog();
		sleep(3);
		assertEquals(tk1.message, "Ngày bắt đầu không được để trống!");
	}

	@Test(priority = 4)
	public void TestSanPham3() throws SQLException {
		new Thread(new Runnable() {
			public void run() {
				Calendar calendar1 = Calendar.getInstance();
				calendar1.set(2025, Calendar.NOVEMBER, 1);
				tk1.getTxtNgayBDTK().setDate(calendar1.getTime());
				sleep(3);
				tk1.getTxtNgayKTTK().setDate(null);
			}
		}).start();
		tk1.LayThongTinHoaDon();

		tk1.fillTableThongKeByCard1();

		tk1.fillTableThongKeByCard2();

		tk1.fillTableThongKeByCard3();

		tk1.closeJdialog();
		sleep(3);
		assertEquals(tk1.message, "Ngày kết thúc không được để trống!");
	}

	@Test(priority = 5)
	public void testSPHomNay() throws SQLException {

		tk1.getBtnHomNay().doClick();
		sleep(3);
		tk1.LayThongTinHoaDon();

		tk1.fillTableThongKeByCard1();

		tk1.fillTableThongKeByCard2();

		tk1.fillTableThongKeByCard3();
	}

	@Test(priority = 6)
	public void testSPTuanNay() throws SQLException {

		tk1.getBtnTuanNay().doClick();

		tk1.LayThongTinHoaDon();

		tk1.fillTableThongKeByCard1();

		tk1.fillTableThongKeByCard2();
		sleep(3);
		tk1.fillTableThongKeByCard3();
	}

	@Test(priority = 7)
	public void testSPThangNay() throws SQLException {

		tk1.getBtnThangNay().doClick();

		tk1.LayThongTinHoaDon();

		tk1.fillTableThongKeByCard1();

		tk1.fillTableThongKeByCard2();
		sleep(3);
		tk1.fillTableThongKeByCard3();
	}

	@AfterMethod
	public void closeMenu() {
		XAuth.user = null;
		main.dispose();
	}

}
