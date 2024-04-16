package test.TrucLy_PC05633;

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
import org.testng.annotations.Test;

import com.form.DangNhap;
import com.form.Form_Home;
import com.form.QuanLyNhanVien1;
import com.main.Main;
import com.untils.JOptionPane;
import com.untils.XAuth;
import com.untils.getJOptionePane;

public class CapNhatNhanVien_Test {
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

	}

	@BeforeMethod
	public void BeforeMethod() {
		jOptionPane = new JOptionPane();
	}


	// Kiểm tra sửa nhân viên khi tên nhân viên để trống
	@Test
	public void TC_QLCF_QLNhanVien_01() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("Ly2004");
		QLNV.txtRePass.setText("Ly2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorTenNV.getText(), "Không được trống!");
		jOptionPane.closeDialog();
	}
	
	//2.Kiểm tra sửa nhân viên khi tên nhân viên có dấu cách ở đầu
	@Test
	public void TC_QLCF_QLNhanVien_02() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText(" Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("20102004");
		QLNV.txtRePass.setText("20102004");	
		QLNV.txtSDT.setText("0387654321");
		QLNV.txtGhiChu.setText("Mới làm");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		

		assertFalse(QLNV.validateForm());	
		jOptionPane.closeDialog();
	}
	//3.Kiểm tra sửa nhân viên khi tên nhân viên có dấu cách ở giữa
	@Test
	public void TC_QLCF_QLNhanVien_03() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText(" Trúcc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("20102004");
		QLNV.txtRePass.setText("20102004");	
		QLNV.txtSDT.setText("0387654321");
		QLNV.txtGhiChu.setText("Mới làm");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		

		assertFalse(QLNV.validateForm());	
		jOptionPane.closeDialog();
	}
	//4.Kiểm tra sửa nhân viên khi tên nhân viên nhập toàn chữ
	@Test
	public void TC_QLCF_QLNhanVien_04() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText(" Trúc Lyy");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("20102004");
		QLNV.txtRePass.setText("20102004");	
		QLNV.txtSDT.setText("0387654321");
		QLNV.txtGhiChu.setText("Mới làm");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		

		assertFalse(QLNV.validateForm());	
		jOptionPane.closeDialog();
	}
	
	//5.Kiểm tra sửa nhân viên khi tên nhân viên nhập kí tự đặc biệt
	@Test
	public void TC_QLCF_QLNhanVien_05() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("#@%@");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("Ly2004");
		QLNV.txtRePass.setText("Ly2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorMaNV1.getText(), " Tên nhân viên không hợp lệ");
		jOptionPane.closeDialog();
	}
	//6.Kiểm tra sửa nhân viên khi tên nhân viên nhập bằng dấu cách
	@Test
	public void TC_QLCF_QLNhanVien_06() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("    ");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("Ly2004");
		QLNV.txtRePass.setText("Ly2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorMaNV1.getText(), " Tên nhân viên không hợp lệ");
		jOptionPane.closeDialog();
	}
	//7.Kiểm tra sửa nhân viên khi tên nhân viên nhập có chữ và số
	@Test
	public void TC_QLCF_QLNhanVien_07() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly2004");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("Ly2004");
		QLNV.txtRePass.setText("Ly2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertFalse(QLNV.validateForm());
		jOptionPane.closeDialog();
	}
	//8.Kiểm tra sửa nhân viên khi không chọn trang thái
	@Test
	public void TC_QLCF_QLNhanVien_08() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(0);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("Ly2004");
		QLNV.txtRePass.setText("Ly2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorTrangThai.getText(), "Chưa chọn!");
		jOptionPane.closeDialog();
	}
	//9.Kiểm tra sửa nhân viên khi chọn trang thái đang làm
	@Test
	public void TC_QLCF_QLNhanVien_09() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("Ly2004");
		QLNV.txtRePass.setText("Ly2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertFalse(QLNV.validateForm());
		jOptionPane.closeDialog();
	}
	//10.Kiểm tra sửa nhân viên khi chọn trạng thái nghỉ làm
	@Test
	public void TC_QLCF_QLNhanVien_10() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(2);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("Ly2004");
		QLNV.txtRePass.setText("Ly2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertFalse(QLNV.validateForm());
		jOptionPane.closeDialog();
	}
	//11.Kiểm tra sửa nhân viên khi không nhập mật khẩu
	@Test
	public void TC_QLCF_QLNhanVien_11() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("");
		QLNV.txtRePass.setText("Ly2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorMatKhau.getText(), "Chưa nhập!");
		jOptionPane.closeDialog();
	}
	//12.Kiểm tra sửa nhân viên khi nhập mật khẩu với kí tự đặc biệt
	@Test
	public void TC_QLCF_QLNhanVien_12() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("Ly2004@");
		QLNV.txtRePass.setText("Ly2004@");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertFalse(QLNV.validateForm());
		jOptionPane.closeDialog();
	}
	//13.Kiểm tra sửa nhân viên khi nhập mật khẩu toàn chữ
	@Test
	public void TC_QLCF_QLNhanVien_13() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("TruccLyy");
		QLNV.txtRePass.setText("TruccLyy");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertFalse(QLNV.validateForm());
		jOptionPane.closeDialog();
	}
	//14.Kiểm tra sửa nhân viên khi nhập mật khẩu toàn số
	@Test
	public void TC_QLCF_QLNhanVien_14() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertFalse(QLNV.validateForm());
		jOptionPane.closeDialog();
	}
	//15.Kiểm tra sửa nhân viên khi nhập mật khẩu có dấu cách ở giữa
	@Test
	public void TC_QLCF_QLNhanVien_15() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("TrucLy 2004");
		QLNV.txtRePass.setText("TrucLy 2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorMatKhau.getText(), "Không hợp lệ!");
		jOptionPane.closeDialog();
	}
	//16.Kiểm tra sửa nhân viên khi nhập mật khẩu có dấu cách ở đầu
	@Test
	public void TC_QLCF_QLNhanVien_16() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText(" 2004");
		QLNV.txtRePass.setText(" 2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorMatKhau.getText(), "Không hợp lệ!");
		jOptionPane.closeDialog();
	}
	//17.Kiểm tra sửa nhân viên khi nhập mật khẩu có dấu cách ở cuối
	@Test
	public void TC_QLCF_QLNhanVien_17() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("2004 ");
		QLNV.txtRePass.setText("2004 ");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorMatKhau.getText(), "Không hợp lệ");
		jOptionPane.closeDialog();
	}
	//18.Kiểm tra sửa nhân viên khi bỏ trống nhập lại mật khẩu
	@Test
	public void TC_QLCF_QLNhanVien_18() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("2004 ");
		QLNV.txtRePass.setText("");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorReMatKhau.getText(), "Không được trống!");
		jOptionPane.closeDialog();
	}
	//19.Kiểm tra sửa nhân viên khi nhập nhập lại mật khẩu không khớp với mật khẩu
	@Test
	public void TC_QLCF_QLNhanVien_19() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("2004 ");
		QLNV.txtRePass.setText("Ly2004 ");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorReMatKhau.getText(), "Không khớp!");
		jOptionPane.closeDialog();
	}
	//20.Kiểm tra sửa nhân viên khi nhập mật khẩu khớp với nhập lại mật khẩu
	@Test
	public void TC_QLCF_QLNhanVien_20() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-01"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertFalse(QLNV.validateForm());
		jOptionPane.closeDialog();
	}
	
	//21.Kiểm tra sửa nhân viên khi không chọn ngày vào làm
	@Test
	public void TC_QLCF_QLNhanVien_21() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(""));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorNgayVaoLam.getText(), "Chưa chọn");
		jOptionPane.closeDialog();
	}
	//22.Kiểm tra sửa nhân viên khi chọn ngày vào làm ngay ngày hiện tại
	@Test
	public void TC_QLCF_QLNhanVien_22() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertFalse(QLNV.validateForm());
		jOptionPane.closeDialog();
	}
	//23.Kiểm tra sửa nhân viên khi chọn ngày vào làm trước ngày hiện tại
	@Test
	public void TC_QLCF_QLNhanVien_23() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-10"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertFalse(QLNV.validateForm());
		jOptionPane.closeDialog();
	}
	
	//24.Kiểm tra sửa nhân viên khi chọn ngày vào làm sau ngày hiện tại_ Sua
	@Test
	public void TC_QLCF_QLNhanVien_24() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-25"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorNgayVaoLam.getText(), "Không hợp lệ!");
		jOptionPane.closeDialog();
	}
	
	//25.Kiểm tra sửa nhân viên khi không nhập số điện thoại
	@Test
	public void TC_QLCF_QLNhanVien_25() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorSoDT.getText(), "SDT không được trống!");
		jOptionPane.closeDialog();
	}
	//26.Kiểm tra sửa nhân viên khi nhập số điện thoại có dấu cách ở giữa 
	@Test
	public void TC_QLCF_QLNhanVien_26() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("09876 54321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.closeDialog();
	}
	//27.Kiểm tra sửa nhân viên khi nhập số điện thoại có dấu cách ở đầu
	@Test
	public void TC_QLCF_QLNhanVien_27() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText(" 0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.closeDialog();
	}
	//28.Kiểm tra sửa nhân viên khi nhập số điện thoại có dấu cách ở cuối
	@Test
	public void TC_QLCF_QLNhanVien_28() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("0987654321 ");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.closeDialog();
	}
	//29.Kiểm tra sửa nhân viên khi nhập số điện thoại bằng kí tự số không hợp lệ
	@Test
	public void TC_QLCF_QLNhanVien_29() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("0123456789");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.closeDialog();
	}
	//30.Kiểm tra sửa nhân viên khi nhập số điện thoại bằng kí tự số hợp lệ
	@Test
	public void TC_QLCF_QLNhanVien_30() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertFalse(QLNV.validateForm());
		jOptionPane.closeDialog();
	}
	//31.Kiểm tra sửa nhân viên khi nhập số điện thoại lớn hơn 10 số
	@Test
	public void TC_QLCF_QLNhanVien_31() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("09876543211");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.closeDialog();
	}
	
	//32.Kiểm tra sửa nhân viên khi nhập số điện thoại nhỏ hơn 10 số
	@Test
	public void TC_QLCF_QLNhanVien_32() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("098765432");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.closeDialog();
	}
	//33.Kiểm tra sửa nhân viên khi nhập số điện thoại bằng kí tự chữ
	@Test
	public void TC_QLCF_QLNhanVien_33() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("Hello");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.closeDialog();
	}
	//34.Kiểm tra sửa nhân viên khi nhập số điện thoại nhập kí tự đặc biệt
	@Test
	public void TC_QLCF_QLNhanVien_34() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("@#$%^&");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.closeDialog();
	}
	//35.Kiểm tra sửa nhân viên khi nhập số điện với đầu số 01
	@Test
	public void TC_QLCF_QLNhanVien_35() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("0187654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertEquals(QLNV.ErrorSoDT.getText(), "Không hợp lệ!");
		jOptionPane.closeDialog();
	}
	//36.Kiểm tra sửa nhân viên khi nhập số điện thoại với đầu số 09
	@Test
	public void TC_QLCF_QLNhanVien_36() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("0987654321");
		QLNV.txtGhiChu.setText("Mới làm quản lý");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertFalse(QLNV.validateForm());
		jOptionPane.closeDialog();
	}
	//37.Kiểm tra sửa nhân viên khi không nhập ghi chú 
	@Test
	public void TC_QLCF_QLNhanVien_37() throws InterruptedException, ParseException {
		QuanLyNhanVien1 QLNV = new QuanLyNhanVien1();

		main.setForm(QLNV);
		main.setVisible(true);
		QLNV.tblNhanVien.setRowSelectionInterval(12,12);
		QLNV.btnSua.setEnabled(true);

		QLNV.txtMaNV.setText("NV0044");
		QLNV.txtTenNV.setText("Trúc Ly");
		QLNV.cboTrangThai.setSelectedIndex(1);
		QLNV.cboVaiTro.setSelectedIndex(1);
		QLNV.rdoNu.setSelected(true);
		QLNV.jdcNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-04-15"));
		QLNV.txtPass.setText("2004");
		QLNV.txtRePass.setText("2004");
		QLNV.txtSDT.setText("09876543211");
		QLNV.txtGhiChu.setText("");
		QLNV.btnSua.doClick();

		TimeUnit.SECONDS.sleep(5);
		
		assertFalse(QLNV.validateForm());
		jOptionPane.closeDialog();
	}
	
}

