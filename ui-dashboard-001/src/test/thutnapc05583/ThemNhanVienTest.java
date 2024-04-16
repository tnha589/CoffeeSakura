package test.thutnapc05583;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import java.awt.Frame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.form.DangNhap;
import com.form.Form_Home;
import com.form.QuanLyNhanVien1;
import com.main.Main;
import com.model.NhanVien;
import com.untils.JOptionPane;
import com.untils.XAuth;
import com.untils.getJOptionePane;

public class ThemNhanVienTest {
	JOptionPane jOptionPane;

	Form_Home home;
	QuanLyNhanVien1 QLNV;
	Main main;

	@BeforeTest
	public void DangNhap() throws InterruptedException {
		DangNhap dangnhap = new DangNhap(new Frame(), true);
		dangnhap.txtTenTK.setText("NV000");
		System.out.println(dangnhap.getTxtTenTK().getText());
		dangnhap.txtPassword.setText("1234");
		TimeUnit.SECONDS.sleep(5);
		dangnhap.btnXacNhan.doClick();

		main = new Main();
		main.setVisible(true);
		main.setForm(main.form6);
		QLNV = new QuanLyNhanVien1();
		jOptionPane = new JOptionPane();
	}

//	@DataProvider(name = "checkDateException")
//	public Object[][] checkDate() {
//		return new Object[][] {
//			{""},
//			{}
//		};
//	}
	// Kiểm tra thêm nhân viên khi mã nhân viên để trống
	@Test
	public void TC_QLCF_QLNhanVien_04() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(5);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorMaNV1.getText(), "Không được trống!");
		jOptionPane.closeDialog();
	}

	// Kiểm tra thêm nhân viên khi mã nhân viên chỉ nhập dấu cách
	@Test
	public void TC_QLCF_QLNhanVien_05() throws InterruptedException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();
		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("   ");
		QLNV.txtTenNV.setText("Anh Thu");
		QLNV.cboTrangThai.setSelectedIndex(1);
		System.out.println(String.valueOf(QLNV.cboTrangThai.getSelectedItem()));
		QLNV.cboVaiTro.setSelectedIndex(1);
		System.out.println(String.valueOf(QLNV.cboVaiTro.getSelectedItem()));
		QLNV.rdoNu.setSelected(true);
		try {
			QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);

		QLNV.btnThem.doClick();
		jOptionPane.closeDialog();

		assertEquals(QLNV.ErrorMaNV1.getText(), "Không được trống!");
	}

//	Kiểm tra thêm nhân viên khi mã nhân viên gồm số và chữ	
	@Test
	public void TC_QLCF_QLNhanVien_06() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00123");
		QLNV.txtTenNV.setText("Anh Thu");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorMaNV1.getText(), "");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi mã nhân viên gồm kí tự đặc biệt	
	@Test
	public void TC_QLCF_QLNhanVien_07() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV+12");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorMaNV1.getText(), "Không nhập ký tự đặc biệt");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi mã nhân viên trùng với mã đã tồn tại
	@Test
	public void TC_QLCF_QLNhanVien_08() throws ParseException, InterruptedException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV001");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorMaNV1.getText(), "Mã nhân viên đã tồn tại!");
	}

//	Kiểm tra thêm nhân viên khi tên nhân viên khi để trống
	@Test
	public void TC_QLCF_QLNhanVien_09() throws ParseException, InterruptedException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00123");
		QLNV.txtTenNV.setText("");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorTenNV.getText(), "Không được trống!");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi tên nhân viên khi chỉ nhập chữ
	@Test
	public void TC_QLCF_QLNhanVien_10() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00150");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorTenNV.getText(), "");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi không chọn vai trò
	@Test
	public void TC_QLCF_QLNhanVien_11() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00123");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
//		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorVaiTro.getText(), "Chưa chọn!");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi chọn vai trò là quản lý
	@Test
	public void TC_QLCF_QLNhanVien_12() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00124");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorVaiTro.getText(), "");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi chọn vai trò là thu ngân
	@Test
	public void TC_QLCF_QLNhanVien_13() throws ParseException, InterruptedException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00125");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(2);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorVaiTro.getText(), "");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi chọn vai trò là nhân viên
	@Test
	public void TC_QLCF_QLNhanVien_14() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00126");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(3);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorVaiTro.getText(), "");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi chọn trạng thái nghỉ làm	
	@Test
	public void TC_QLCF_QLNhanVien_15() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00127");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(2);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorTrangThai.getText(), "");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi không chọn giới tính
	@Test
	public void TC_QLCF_QLNhanVien_16() throws ParseException, InterruptedException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00127");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
//		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorGioiTinh.getText(), "Hãy chọn giới tính");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi chọn giới tính nam
	@Test
	public void TC_QLCF_QLNhanVien_17() throws ParseException, InterruptedException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00129");
		QLNV.txtTenNV.setText("Anh Lộc");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNam.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("Anhloc123*");
		QLNV.txtRePass.setText("Anhloc123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.validateForm(), true);
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi để trống ngày vào làm
	@Test
	public void TC_QLCF_QLNhanVien_18() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00130");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(""));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorNgayVaoLam.getText(), "Chưa chọn");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi chọn ngày vào làm trong tương lai
	@Test
	public void TC_QLCF_QLNhanVien_19() throws ParseException, InterruptedException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00131");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2025-04-02"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorNgayVaoLam.getText(), "Không thể chọn ngày trong tương lai!");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi nhập ngày vào làm sai kiểu định dạng (NOTE: SỬA LẠI NGÀY)
	@Test
	public void TC_QLCF_QLNhanVien_20() throws ParseException, InterruptedException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00132");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("02-2024"));
		QLNV.txtPass.setText("Anhthu123*");
		QLNV.txtRePass.setText("Anhthu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertTrue(QLNV.validateForm());
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi mật khẩu để trống
	@Test
	public void TC_QLCF_QLNhanVien_21() throws ParseException, InterruptedException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00133");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		System.out.println(String.valueOf(QLNV.cboTrangThai.getSelectedItem()));
		QLNV.cboVaiTro.setSelectedIndex(1);
		System.out.println(String.valueOf(QLNV.cboVaiTro.getSelectedItem()));
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("");
		QLNV.txtRePass.setText("");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorMatKhau.getText(), "Không được để trống!");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi mật khẩu ít hơn 8 ký tự
	@Test
	public void TC_QLCF_QLNhanVien_22() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00134");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("THU123*");
		QLNV.txtRePass.setText("THU123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorMatKhau.getText(), "Mật khẩu chứa ít nhất 8 ký tự");
		jOptionPane.dispose();
	}

//Kiểm tra thêm nhân viên khi mật khẩu xác nhận để trống
	@Test
	public void TC_QLCF_QLNhanVien_23() throws ParseException, InterruptedException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00134");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("AnhThu123*");
		QLNV.txtRePass.setText("");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorReMatKhau.getText(), "Không khớp!");
		jOptionPane.dispose();
	}

	// Kiểm tra thêm nhân viên khi mật khẩu nhập lại, khác mật khẩu
	@Test
	public void TC_QLCF_QLNhanVien_24() throws ParseException, InterruptedException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00134");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("AnhThu123*");
		QLNV.txtRePass.setText("AnhThuuuuu123*");
		QLNV.txtSDT.setText("0706688895");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorReMatKhau.getText(), "Không khớp!");
		jOptionPane.dispose();
	}

	// Kiểm tra thêm nhân viên khi số điện thoại để trống
	@Test
	public void TC_QLCF_QLNhanVien_25() throws ParseException, InterruptedException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00134");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("AnhThu123*");
		QLNV.txtRePass.setText("AnhThu123*");
		QLNV.txtSDT.setText("");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.dispose();
	}

	// Kiểm tra thêm nhân viên khi số điện thoại sai định dạng
	@Test
	public void TC_QLCF_QLNhanVien_26() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00134");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("AnhThu123*");
		QLNV.txtRePass.setText("AnhThu123*");
		QLNV.txtSDT.setText("0111114587");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi số điện thoại chỉ nhập chữ
	@Test
	public void TC_QLCF_QLNhanVien_27() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();
		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00134");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("AnhThu123*");
		QLNV.txtRePass.setText("AnhThu123*");
		QLNV.txtSDT.setText("anhthutran");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.dispose();
	}

//	Kiểm tra thêm nhân viên khi số điện thoại gồm nhập ký tự đặc biệt
	@Test
	public void TC_QLCF_QLNhanVien_28() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00134");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("AnhThu123*");
		QLNV.txtRePass.setText("AnhThu123*");
		QLNV.txtSDT.setText("070555$5846");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.dispose();
	}

//		Kiểm tra thêm nhân viên khi số điện thoại chứa khoản cách ở giữa
	@Test
	public void TC_QLCF_QLNhanVien_29() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00134");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("AnhThu123*");
		QLNV.txtRePass.setText("AnhThu123*");
		QLNV.txtSDT.setText("0705 555 8461");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.dispose();
	}

//		Kiểm tra thêm nhân viên khi số điện thoại chỉ chứa dấu cách
	@Test
	public void TC_QLCF_QLNhanVien_30() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV00134");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("AnhThu123*");
		QLNV.txtRePass.setText("AnhThu123*");
		QLNV.txtSDT.setText("          ");
		QLNV.txtGhiChu.setText("Quản lý mới");

		TimeUnit.SECONDS.sleep(2);
		QLNV.btnThem.doClick();

		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.dispose();
	}

//		Kiểm tra thêm nhân viên đã tồn tại
	@Test
	public void TC_QLCF_QLNhanVien_31() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();
		main.setForm(QLNV);
		main.setVisible(true);

		QLNV.txtMaNV.setText("NV0145");
		QLNV.txtTenNV.setText("Anh Thư");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-02"));
		QLNV.txtPass.setText("AnhThu123*");
		QLNV.txtRePass.setText("AnhThu123*");
		QLNV.txtSDT.setText("0705555846");
		QLNV.txtGhiChu.setText("");

		TimeUnit.SECONDS.sleep(2);
		NhanVien nv = QLNV.getForm();
		// kiểm tra form trước khi insert, kỳ vọng formValidate = false (nghĩa là form đầy đủ check)
		boolean formValidate = QLNV.validateForm(); 
		QLNV.btnThem.doClick();

		//kiểm tra sau khi nhấn nút insert, kỳ vọng QLNV.validateForm() = true (nghĩa là form bị clear do đã được insert)
		formValidate = (formValidate == false) && (QLNV.validateForm() == true);
		assertTrue(formValidate);
		jOptionPane.dispose();
	}
}
