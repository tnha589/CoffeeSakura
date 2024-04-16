package test.tuyennhkpc05660;

import org.testng.annotations.Test;

import com.Dao.ChiTieuDao;
import com.form.ChiTieu1;
import com.form.DangNhap;
import com.main.Main;
import com.model.ChiTieu;
import com.untils.JOptionPane;
import com.untils.XAuth;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.awt.Window;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JDialog;

import org.testng.annotations.AfterClass;

public class ChiTieu_Test {
	DangNhap login;
	Main main;
	ChiTieu1 form_CT;
	JOptionPane jOptionPane;

	@BeforeClass
	public void beforeClass() {
		login = new DangNhap(null, false);
		login.setVisible(true);
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");
		login.login();
		main = new Main();
		main.setForm(main.form7);
		main.setVisible(true);
		form_CT = new ChiTieu1();
	}

	@BeforeMethod
	public void beformethod() {
		jOptionPane = new JOptionPane();
	}

	@Test(priority = 1)
	public void Click() throws InterruptedException {
		ChiTieuDao dao = new ChiTieuDao();
		ChiTieu entity = dao.selectById(1);

		form_CT.tblChiTieu.setRowSelectionInterval(0, 0);
		form_CT.tblChiTieuMouseClicked(null);

		assertEquals(form_CT.txtTenNV.getText(), entity.getTenNV());
		assertEquals(form_CT.txtTien.getText(), entity.getTien() + "");
		assertEquals(formatDate(form_CT.txtNgayLay.getDate()), entity.getThoiGian() + "");
		assertEquals(form_CT.txtGhiChu.getText(), entity.getGhiChu());
	}

	@Test(priority = 2)
	public void checkAccount() {
		form_CT = new ChiTieu1();
		assertEquals(form_CT.txtTenNV.getText(), XAuth.user.getTenNV());
	}

//
	@Test(priority = 3)
	public void Huy() {
		form_CT = new ChiTieu1();

		form_CT.tblChiTieu.setRowSelectionInterval(0, 0);
		form_CT.tblChiTieuMouseClicked(null);
		form_CT.btnHuy.doClick();

		ChiTieu entityForm = form_CT.getForm();
		ChiTieu entity = new ChiTieu();
		entity.setTenNV(XAuth.user.getTenNV());
		assertEquals(entityForm, entity);
	}

	@DataProvider(name = "dateInsert")
	public Object[][] dp() {
		return new Object[][] {
				// PASS - THêm thành công
				new Object[] { "1000", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				// Pass - THêm thành công
				new Object[] { "1000", "15 thg 4, 2024", "" },
				// Pass - Lỗi hàm getForm khi ép kiểu
				new Object[] { "", "", "" },
				// Pass - Lỗi hàm getForm khi ép kiểu
				new Object[] { "", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				// Fail - Do thêm thành công nhưng không nhập ngày
				new Object[] { "1000", "", "tiền nhập nguyên liệu" },
				// Pass - Lỗi hàm getForm khi ép kiểu
				new Object[] { "abc", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				// PASS - THêm thành công
				new Object[] { "1200.25", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				// Fail - Thêm thành công khi ngày lấy trước hiện tại
				new Object[] { "100", "16 thg 3, 2026", "tiền nhập nguyên liệu" },
				// Fail - Thêm thành công check clear form
				new Object[] { "100", "16 thg 1, 2024", "tiền nhập nguyên liệu" },
				//Fail - Thêm thành công
				new Object[] { "-1", "15 thg 4, 2024", "tiền nhập nguyên liệu" } };
	}

	@Test(priority = 4, dataProvider = "dateInsert")
	public void checkInsert(String sotien, String ngaylay, String ghichu) throws InterruptedException {
		form_CT.txtTenNV.setText("Nguyen Van QL");
		form_CT.txtTien.setText(sotien);

		if (formatNgay(ngaylay) != null) {
			form_CT.txtNgayLay.setDate(formatNgay(ngaylay));
		} else {
			form_CT.txtNgayLay.setDate(null);
			form_CT.txtNgayLay.setToolTipText(ngaylay);
		}

		form_CT.txtGhiChu.setText(ghichu);
		int row = form_CT.tblChiTieu.getRowCount();
		form_CT.btnXacNhan.doClick();
		TimeUnit.SECONDS.sleep(2);
		jOptionPane.dialog.dispose();

		if (sotien.isBlank() || ngaylay.isBlank() || formatNgay(ngaylay) == null || checkDouble(sotien) == null) {
			assertEquals(form_CT.tblChiTieu.getRowCount(), row);
		} else {
			if (formatNgay(ngaylay) != null && formatNgay(ngaylay).compareTo(new Date()) < 0) {
				assertEquals(form_CT.tblChiTieu.getRowCount(), (row + 1));
			} else {
				assertEquals(form_CT.tblChiTieu.getRowCount(), row);
			}
		}
	}

	@Test(priority = 5)
	public void checkClear() throws InterruptedException {
		form_CT.txtTien.setText("2000");
		form_CT.txtNgayLay.setDate(formatNgay("15 thg 4, 2024"));
		form_CT.txtGhiChu.setText("check clear form");
		form_CT.btnXacNhan.doClick();
		TimeUnit.SECONDS.sleep(2);
		jOptionPane.dialog.dispose();

		assertEquals(form_CT.txtTenNV.getText(), "Nguyen Van QL");
		assertEquals(form_CT.txtNgayLay.getDate(), null);
		assertEquals(form_CT.txtTien.getText(), null);
		assertEquals(form_CT.txtGhiChu2.getText(), null);
	}

	@DataProvider(name = "dateFill")
	public Object[][] fill() {
		return new Object[][] {
				// PASS - THêm thành công
				new Object[] { "1000", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1100", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1200", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1300", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1400", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1500", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1600", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1700", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1800", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1900", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "19900", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1090", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1000", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1050", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1000", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "10400", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1200", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1300", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1400", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1500", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1090", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1000", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1050", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1000", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "10400", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1200", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1300", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1400", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1500", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1000", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1100", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1200", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1300", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1400", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1500", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1600", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1700", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1800", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1900", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "19900", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1090", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1000", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1050", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1000", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "10400", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1200", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1300", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1400", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1500", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1090", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1000", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1050", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1000", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "10400", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1200", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1300", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1400", "15 thg 4, 2024", "tiền nhập nguyên liệu" },
				new Object[] { "1500", "15 thg 4, 2024", "tiền nhập nguyên liệu" } };
	}

	@Test(priority = 6, dataProvider = "dateFill")
	public void Fill(String sotien, String ngaylay, String ghichu) throws InterruptedException {
		main.setForm(main.form7);
		form_CT.txtTenNV.setText("Nguyen Van QL");
		form_CT.txtTien.setText(sotien);

		form_CT.txtNgayLay.setDate(null);
		form_CT.txtNgayLay.setDate(formatNgay(ngaylay));

		form_CT.txtGhiChu.setText(ghichu);
		form_CT.btnXacNhan.doClick();
		TimeUnit.SECONDS.sleep(2);
		jOptionPane.dialog.dispose();
		form_CT.fillTable();
	}

	@AfterClass
	public void afterClass() {
		form_CT.setVisible(false);
	}

	public String formatDate(Date originalDate) {
		// Định dạng lại thành chuỗi "yyyy-MM-dd"
		SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = targetFormat.format(originalDate);
		System.out.println(formattedDate);
		return formattedDate;
	}

	public static Date formatNgay(String inputString) {
		// Định dạng ngày
		SimpleDateFormat sdfInput = new SimpleDateFormat("dd 'thg' M, yyyy", new Locale("vi"));

		try {
			// Chuyển đổi chuỗi ngày thành đối tượng ngày
			Date ngay = sdfInput.parse(inputString);
			return ngay;
		} catch (ParseException e) {
			// Nếu có lỗi xảy ra trong quá trình chuyển đổi chuỗi thành ngày
			e.printStackTrace();
			return null;
		}
	}

	public Double checkDouble(String gia) {
		try {
			Double number = Double.parseDouble(gia);
			if (number < 0) {
				return null;
			}
			return number;
		} catch (Exception e) {
			return null;
		}
	}
}
