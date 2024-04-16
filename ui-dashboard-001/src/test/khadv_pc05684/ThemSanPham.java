package test.khadv_pc05684;

import org.testng.annotations.Test;

import com.Dao.sanPhamDao;
import com.form.DangNhap;
import com.form.QuanLySanPham1;
import com.main.Main;
import com.untils.JOptionPane;
import com.untils.getJOptionePane;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ThemSanPham {
	DangNhap dangNhap;
	Main main;
	QuanLySanPham1 sp;
	JOptionPane jOptionPane;
	getJOptionePane optionePane;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		dangNhap = new DangNhap(null, false);
		dangNhap.setVisible(true);
		main = new Main();
		sp = new QuanLySanPham1();
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
		optionePane.setOptionPane(new JOptionPane());
		dangNhap.dispose();
		main.setVisible(true);
		TimeUnit.SECONDS.sleep(2);
		main.setForm(sp);
		TimeUnit.SECONDS.sleep(3);
	}

//
	@Test(dataProvider = "Data")
	public void testcase(String maSP, String tenSP, String giaSP, int loai, int trangThai, String image, String ghiChu,
			String expectedMaSP, String expectedTenSP, String expectedGiaSP, String expectedImage,
			String expectedTrangThai) throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		sp.txtMaSP.setText(maSP);
		sp.txtTenSP.setText(tenSP);
		sp.txtGiaSP.setText(giaSP);
		sp.cboLoaiSP.setSelectedIndex(loai);
		sp.cboTrangThai.setSelectedIndex(trangThai);
		sp.lblHinh.setText(image);
		if (!image.isEmpty()) {
			ImageIcon imgIcon = new ImageIcon(getClass().getResource("/com/image/" + image));
			sp.lblHinh.setIcon(imgIcon);
		}

		TimeUnit.SECONDS.sleep(3);
		sp.btnThem.doClick();
		TimeUnit.SECONDS.sleep(5);
		if (maSP.isEmpty() && giaSP.isEmpty() && tenSP.isEmpty() && image.isEmpty() && trangThai == 0) {
			assertEquals(sp.ErrorMaSP.getText(), expectedMaSP);
			assertEquals(sp.ErrorTenSP.getText(), expectedTenSP);
			assertEquals(sp.ErrorGiaSP.getText(), expectedGiaSP);
			assertEquals(sp.lblHinh.getText(), expectedImage);
			assertEquals(sp.ErrorTrangThai.getText(), expectedTrangThai);
		}

		if (maSP.isEmpty()) {
			assertEquals(sp.ErrorMaSP.getText(), expectedMaSP);
		}
		if (tenSP.isEmpty()) {
			assertEquals(sp.ErrorTenSP.getText(), expectedTenSP);
		}
		if (giaSP.isEmpty()) {
			assertEquals(sp.ErrorGiaSP.getText(), expectedGiaSP);
		}
		if (trangThai == 0) {
			assertEquals(sp.ErrorTrangThai.getText(), expectedTrangThai);
		}
		if (image.isEmpty()) {
			assertEquals(sp.lblHinh.getText(), expectedImage);
		}

		List<Object[]> list = new sanPhamDao().getSanPhamFull();
		for (Object[] objects : list) {
			if (maSP.equals(objects[0])) {
				assertEquals(sp.ErrorMaSP.getText(), expectedMaSP);
			}
			if (tenSP.equalsIgnoreCase((String) objects[1])) {
				assertEquals(sp.ErrorTenSP.getText(), expectedTenSP);
			}
		}
		String checkCQ = "^[0-9]+$";
		if (!giaSP.matches(checkCQ)) {
			assertEquals(sp.ErrorGiaSP.getText(), expectedGiaSP);
		}
		TimeUnit.SECONDS.sleep(5);
	}

//	@Test
//	public void test() {
//	}

	@DataProvider(name = "Data")
	public Object[][] Data() {
		return new Object[][] {
				{ "", "", "", 0, 0, "", "Sản phẩm mới ra mắt", "Không được trống!", "Không được trống!",
						"Không được trống!", "Vui lòng chọn hình!", "Chưa chọn trạng thái!" },
				{ "", "Trà Nho", "3000", 1, 1, "hinh1.png", "Sản phẩm mới ra mắt", "Không được trống!", "", "", "",
						"" },
				{ "SP100", "", "30000", 1, 1, "hinh1.png", "Sản phẩm mới ra mắt", "", "Không được trống!", "", "", "" },
				{ "SP150", "Trà Nho RuBy", "", 0, 1, "hinh1.png", "Sản phẩm mới ra mắt", "", "", "Không được trống!",
						"", "" },
				{ "SP200", "Trà vải", "35000", 0, 1, "hinh1.png", "", "", "", "", "", "" },
				{ "SP300", "Cơm Sườn Trứng", "25000", 1, 1, "hinh1.png", "", "", "", "", "", "" },
				{ "SP210", "Trà đào cam xả", "30000", 0, 1, "", "", "", "", "", "Vui lòng chọn hình!", "" },
				{ "SP331", "Cơm sườn trứng", "25000", 1, 2, "hinh1.png", "", "", "", "", "", "" },
				{ "SP3", "Cơm sườn trứng", "25000", 1, 2, "hinh1.png", "", "Mã sản phẩm đã tồn tại", "", "", "", "" },
				{ "SP2121", "Trà chanh đào", "25000", 0, 1, "hinh1.png", "", "", "Tên sản phẩm đã tồn tại", "", "",
						"" },
				{ "SP3", "Cơm sườn kho", "-20000", 1, 2, "hinh1.png", "Sản phẩm mới ra nắt", "", "", "Sai định dạng!",
						"", "" },
				{ "SP3", "Cơm sườn kho", "hjdhf", 1, 2, "hinh1.png", "Sản phẩm mới ra nắt", "", "", "Sai định dạng!",
						"", "" },
				{ "SP3", "Cơm sườn kho", "@123", 1, 2, "hinh1.png", "Sản phẩm mới ra nắt", "", "", "Sai định dạng!", "",
						"" } };
	}

	@AfterMethod
	public void afterMethod() {
		dangNhap.dispose();
		main.dispose();
	}
}
