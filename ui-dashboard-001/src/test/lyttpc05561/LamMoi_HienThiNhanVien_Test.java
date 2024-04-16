package test.lyttpc05561;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.awt.Component;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.table.DefaultTableModel;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dao.nhanVienDao;
import com.form.DangNhap;
import com.form.Form_Home;
import com.form.QuanLyNhanVien1;
import com.main.Main;
import com.model.NhanVien;
import com.model.SanPham;
import com.untils.JOptionPane;
import com.untils.XDialog;
import com.untils.getJOptionePane;

import bsh.ParseException;

public class LamMoi_HienThiNhanVien_Test {
	JOptionPane jOptionPane;
	XDialog xDialog;
	Form_Home home;
	QuanLyNhanVien1 QLNV;
	Main main;
	nhanVienDao nvDao = new nhanVienDao();
	List<NhanVien> list;
	int row = -1;

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
	
	//HIỂN THỊ DANH SÁCH 

	// Hiển thị danh sách nhân viên với tài khoản quản lý
	@Test
	public void TC_QLCF_QLNhanVien_01() throws InterruptedException, ParseException {
		main.setForm(QLNV);
		main.setForm(main.form6);
		main.setVisible(true);
		boolean isFormOpened = QLNV.isVisible();
		assertTrue(isFormOpened);
		TimeUnit.SECONDS.sleep(5);
		jOptionPane.closeDialog();
	}

	// Hiển thị thông tin nhân viên lên form khi chọn một nhân viên bất kỳ
	@Test
	public void TC_QLCF_QLNhanVien_02() throws InterruptedException, ParseException {
		// Thiết lập form Quản lý Nhân viên và form khác (ví dụ: form6)
		main.setForm(QLNV);
		main.setVisible(true);
		// Chọn hàng thứ 1 từ bảng nhân viên
		int selectedRow = 1;
		QLNV.tblNhanVien.setRowSelectionInterval(selectedRow, selectedRow);
		// Lấy giá trị mã nhân viên từ bảng
		String manv = (String) QLNV.tblNhanVien.getValueAt(selectedRow, 0);
		// Sử dụng mã nhân viên để lấy thông tin nhân viên từ CSDL hoặc nguồn dữ liệu
		// tương ứng
		NhanVien nv = nvDao.selectById(manv);
		// Cập nhật form với thông tin nhân viên
		QLNV.setForm(nv);
		//assertEquals(false, false);
		assertNotNull(QLNV.getForm()); // Kiểm tra xem form đã được cập nhật thành công hay không
		TimeUnit.SECONDS.sleep(5);
		jOptionPane.closeDialog();
	}

//Hiển thị danh sách nhân viên với vai trò quản lý
	@Test
	public void testTC_QLCF_QLNhanVien_03() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên và form khác (ví dụ: form6)
	    main.setForm(QLNV);
	    main.setVisible(true);
	    
	    // Thiết lập các giá trị lọc
	    QLNV.cboFindVaiTro.setSelectedItem("Quản Lý");
	    TimeUnit.SECONDS.sleep(5);
	   
	    // Áp dụng bộ lọc
	    QLNV.Loc();
	    TimeUnit.SECONDS.sleep(5);
	    // Lấy danh sách nhân viên từ CSDL hoặc nguồn dữ liệu tương ứng
	    List<NhanVien> expectedList = nvDao.selectBy2Keyword(true, "Tất Cả");
	    TimeUnit.SECONDS.sleep(5);
	    // So sánh danh sách nhân viên trả về từ form với danh sách nhân viên kỳ vọng
	    assertEquals(QLNV.listSP, expectedList);
	}
	
	// Hiển thị danh sách nhân viên với vai trò thu ngân
		@Test
		public void testTC_QLCF_QLNhanVien_04() throws InterruptedException, ParseException {
		    // Thiết lập form Quản lý Nhân viên và form khác (ví dụ: form6)
		    main.setForm(QLNV);
		    main.setVisible(true);
		    // Thiết lập các giá trị lọc
		    QLNV.cboFindVaiTro.setSelectedItem("Thu Ngân");
		    TimeUnit.SECONDS.sleep(5);
		    // Áp dụng bộ lọc
		    QLNV.Loc();
		    TimeUnit.SECONDS.sleep(5);
		    // Lấy danh sách nhân viên từ CSDL hoặc nguồn dữ liệu tương ứng
		    List<NhanVien> expectedList = nvDao.selectBy2Keyword(true, "Tất Cả");
		    TimeUnit.SECONDS.sleep(5);
		    // So sánh danh sách nhân viên trả về từ form với danh sách nhân viên kỳ vọng
		    assertEquals(QLNV.listSP, expectedList);
		}

	// Hiển thị danh sách nhân viên với vai trò nhân viên
	@Test
	public void testTC_QLCF_QLNhanVien_05() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên và form khác (ví dụ: form6)
	    main.setForm(QLNV);
	    main.setVisible(true);
	    // Thiết lập các giá trị lọc
	    QLNV.cboFindVaiTro.setSelectedItem("Nhân Viên");
	    TimeUnit.SECONDS.sleep(5);
	    // Áp dụng bộ lọc
	    QLNV.Loc();
	    TimeUnit.SECONDS.sleep(5);
	    // Lấy danh sách nhân viên từ CSDL hoặc nguồn dữ liệu tương ứng
	    List<NhanVien> expectedList = nvDao.selectBy2Keyword(true, "Tất Cả");
	    TimeUnit.SECONDS.sleep(5);
	    // So sánh danh sách nhân viên trả về từ form với danh sách nhân viên kỳ vọng
	    assertEquals(QLNV.listSP, expectedList);
	}

	// Hiển thị danh sách nhân viên với trạng thái "Đang làm"
	@Test
	public void testTC_QLCF_QLNhanVien_06() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên và form khác (ví dụ: form6)
	    main.setForm(QLNV);
	    main.setVisible(true);
	    // Thiết lập các giá trị lọc
	    QLNV.cboFindTrangThai.setSelectedItem("Đang Làm");
	    TimeUnit.SECONDS.sleep(5);
	    // Áp dụng bộ lọc
	    QLNV.Loc();
	    TimeUnit.SECONDS.sleep(5);
	    // Lấy danh sách nhân viên từ CSDL hoặc nguồn dữ liệu tương ứng
	    List<NhanVien> expectedList = nvDao.selectBy2Keyword(true, "Tất Cả");
	    TimeUnit.SECONDS.sleep(5);
	    // So sánh danh sách nhân viên trả về từ form với danh sách nhân viên kỳ vọng
	    assertEquals(QLNV.listSP, expectedList);
	}
	
	// Hiển thị danh sách nhân viên với trạng thái "Nghỉ Làm"
	@Test
	public void testTC_QLCF_QLNhanVien_07() throws InterruptedException, ParseException {
		// Thiết lập form Quản lý Nhân viên và form khác (ví dụ: form6)
		main.setForm(QLNV);
		main.setVisible(true);
		// Thiết lập các giá trị lọc
		QLNV.cboFindTrangThai.setSelectedItem("Đã Nghỉ");
		TimeUnit.SECONDS.sleep(5);
		// Áp dụng bộ lọc
		QLNV.Loc();
		TimeUnit.SECONDS.sleep(5);
		// Lấy danh sách nhân viên từ CSDL hoặc nguồn dữ liệu tương ứng
		List<NhanVien> expectedList = nvDao.selectBy2Keyword(true, "Tất Cả");
		TimeUnit.SECONDS.sleep(5);
		// So sánh danh sách nhân viên trả về từ form với danh sách nhân viên kỳ vọng
		assertEquals(QLNV.listSP, expectedList);
	}
//
//	// Hiển thị danh sách nhân viên với trạng thái "Tất Cả"
	@Test
	public void testTC_QLCF_QLNhanVien_08() throws InterruptedException, ParseException {
		// Thiết lập form Quản lý Nhân viên và form khác (ví dụ: form6)
		main.setForm(QLNV);
		main.setVisible(true);
		// Thiết lập các giá trị lọc
		QLNV.cboFindTrangThai.setSelectedItem("Tất Cả");
		TimeUnit.SECONDS.sleep(5);
		// Áp dụng bộ lọc
		QLNV.Loc();
		TimeUnit.SECONDS.sleep(5);
		// Lấy danh sách nhân viên từ CSDL hoặc nguồn dữ liệu tương ứng
		List<NhanVien> expectedList = nvDao.selectBy2Keyword(true, "Tất Cả");
		TimeUnit.SECONDS.sleep(5); 
		// So sánh danh sách nhân viên trả về từ form với danh sách nhân viên kỳ vọng
		assertEquals(QLNV.listSP, expectedList);
	}
	
	// Hiển thị danh sách nhân viên với tìm kiếm tên nhân viên có ký tự giống trong
	// cơ sở dữ liệu
	@Test
	public void testTC_QLCF_QLNhanVien_09() throws InterruptedException, ParseException {
		// Thiết lập form Quản lý Nhân viên và form khác (ví dụ: form6)
		main.setForm(QLNV);
		main.setVisible(true);
		// Thiết lập các giá trị tìm kiếm
		String findTen = "ly";
		QLNV.txtFindTen.setText(findTen);

		// Áp dụng tìm kiếm
		QLNV.search(findTen);
		TimeUnit.SECONDS.sleep(5);
		// Kiểm tra kết quả tìm kiếm
		DefaultTableModel model = (DefaultTableModel) QLNV.tblNhanVien.getModel();
		int rowCount = model.getRowCount();
		// Khẳng định
		assertTrue(rowCount > 0); // Kiểm tra xem có kết quả tìm kiếm nào không
		boolean found = false;
		for (int i = 0; i < rowCount; i++) {
			String tenKH = model.getValueAt(i, 1).toString(); // Giả sử cột tên nằm ở chỉ số 1
			if (tenKH.equals(findTen)) {
				found = true;
				break;
			}
		}
		assertFalse(found); // Kiểm tra xem kết quả tìm kiếm có chứa người tên "ly" không
	}
	
//	 Hiển thị danh sách nhân viên với tìm kiếm tên nhân viên có ký tự không giống trong
//	 cơ sở dữ liệu
	@Test
	public void testTC_QLCF_QLNhanVien_10() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên và form khác (ví dụ: form6)
	    main.setForm(QLNV);
	    main.setVisible(true);
	    
	    // Thiết lập các giá trị tìm kiếm
	    String findTen = "hjvvhh";
	    QLNV.txtFindTen.setText(findTen);
	    
	    // Áp dụng tìm kiếm
	    QLNV.search(findTen);
	    TimeUnit.SECONDS.sleep(5);
	    
	    // Kiểm tra kết quả tìm kiếm
	    DefaultTableModel model = (DefaultTableModel) QLNV.tblNhanVien.getModel();
	    int rowCount = model.getRowCount();
	    
	    // Khẳng định
	    assertFalse(rowCount < 0); // Kiểm tra xem có kết quả tìm kiếm nào không
	    boolean found = false;
	    for (int i = 0; i < rowCount; i++) {
	        String tenNV = model.getValueAt(i, 1).toString(); // Giả sử cột tên nằm ở chỉ số 1
	        if (tenNV.equals(findTen)) {
	            found = true;
	            break;
	        }
	    }
	    assertFalse(found); // Kiểm tra xem kết quả tìm kiếm có chứa nhân viên có tên giống "hjvvhh" không
	}
	
	//CHỨC NĂNG LÀM MỚI
	//Kiểm tra nút "Làm mới" khi chọn một nhân viên từ danh sách nhân viên
	@Test
	public void TC_QLCF_QLNhanVien_15() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên và form khác (ví dụ: form6)
	    main.setForm(QLNV);
	    main.setVisible(true);
	    // Chọn hàng thứ 1 từ bảng nhân viên
	    int selectedRow = 1;
	    QLNV.tblNhanVien.setRowSelectionInterval(selectedRow, selectedRow);
	    // Lấy giá trị mã nhân viên từ bảng
	    String manv = (String) QLNV.tblNhanVien.getValueAt(selectedRow, 0);
	    // Sử dụng mã nhân viên để lấy thông tin nhân viên từ CSDL hoặc nguồn dữ liệu tương ứng
	    NhanVien nv = nvDao.selectById(manv);
	    // Cập nhật form với thông tin nhân viên
	    QLNV.setForm(nv);
	    TimeUnit.SECONDS.sleep(5);
	    QLNV.clearForm();
	    
	    TimeUnit.SECONDS.sleep(5);
	    jOptionPane.closeDialog();
	}
	
	//Kiểm tra nút "Làm mới" khi nhập mã nhân viên các trường dữ liệu còn lại bỏ trống
	@Test
	public void TC_QLCF_QLNhanVien_16() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên và form khác (ví dụ: form6)
	    main.setForm(QLNV);
	    main.setVisible(true);
	   String maNV = "NV4554455";
	    QLNV.txtMaNV.setText(maNV);
	    TimeUnit.SECONDS.sleep(5);
	    QLNV.clearForm();
	 // Kiểm tra xem trường txtMaNV đã bị xóa hay chưa
	    String maNVAfterRefresh = QLNV.txtMaNV.getText();
	    // Kiểm tra kết quả
	    assertEquals("", maNVAfterRefresh);
	    TimeUnit.SECONDS.sleep(5);
	    jOptionPane.closeDialog();
	}
	//Kiểm tra nút "Làm mới" khi nhập tên nhân viên các trường dữ liệu còn lại bỏ trống
	@Test
	public void TC_QLCF_QLNhanVien_17() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên và form khác (ví dụ: form6)
	    main.setForm(QLNV);
	    main.setVisible(true);
	   String tenNV = "NV4554455";
	    QLNV.txtTenNV.setText(tenNV);
	    TimeUnit.SECONDS.sleep(5);
	    QLNV.clearForm();
	 // Kiểm tra xem trường txtMaNV đã bị xóa hay chưa
	    String maNVAfterRefresh = QLNV.txtTenNV.getText();
	    // Kiểm tra kết quả
	    assertEquals("", maNVAfterRefresh);
	    TimeUnit.SECONDS.sleep(5);
	    jOptionPane.closeDialog();
	}
	//Kiểm tra nút "Làm mới" khi chọn vai trò nhân viên các trường dữ liệu còn lại bỏ trống
	@Test
	public void TC_QLCF_QLNhanVien_18() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên
	    main.setForm(QLNV);
	    main.setVisible(true);
	    // Chọn vai trò "Nhân Viên"
	    QLNV.cboVaiTro.setSelectedItem("Nhân Viên");
	    TimeUnit.SECONDS.sleep(5);
	    // Nhấn nút "Làm mới"
	    QLNV.clearForm();
	    TimeUnit.SECONDS.sleep(5);
	    // Kiểm tra xem trường cboVaiTro đã bị xóa hay chưa
	    Object selectedVaiTro = QLNV.cboVaiTro.getSelectedItem();
	    // Kiểm tra kết quả
	    assertEquals(selectedVaiTro, "-------------------");
	    TimeUnit.SECONDS.sleep(5);
	    jOptionPane.closeDialog();
	}
	//Kiểm tra nút "Làm mới" khi chọn trạng thái nhân viên các trường dữ liệu còn lại bỏ trống
	@Test
	public void TC_QLCF_QLNhanVien_19() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên
	    main.setForm(QLNV);
	    main.setVisible(true);
	    // Chọn vai trò "Nhân Viên"
	    QLNV.cboTrangThai.setSelectedItem("Đang Làm");
	    TimeUnit.SECONDS.sleep(5);
	    // Nhấn nút "Làm mới"
	    QLNV.clearForm();
	    TimeUnit.SECONDS.sleep(5);
	    // Kiểm tra xem trường cboTrangThai đã bị xóa hay chưa
	    Object selectedVaiTro = QLNV.cboTrangThai.getSelectedItem();
	    // Kiểm tra kết quả
	    assertEquals(selectedVaiTro, "-------------------");
	    TimeUnit.SECONDS.sleep(5);
	    jOptionPane.closeDialog();
	}
	
	//Kiểm tra nút "Làm mới" chọn giới tính nhân viên các trường dữ liệu còn lại bỏ trống
	
	@Test
	public void TC_QLCF_QLNhanVien_20() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên
	    main.setForm(QLNV);
	    main.setVisible(true);
	    // Chọn giới tính "Nam"
	    QLNV.rdoNam.setSelected(true);
	    TimeUnit.SECONDS.sleep(5);
	    // Nhấn nút "Làm mới"
	    QLNV.clearForm();
	    TimeUnit.SECONDS.sleep(5);
	    // Kiểm tra xem trường rdoNam đã bị xóa hay chưa
	    boolean isRdoNamSelected = QLNV.rdoNam.isSelected();
	    // Kiểm tra kết quả
	    assertFalse(isRdoNamSelected);
	    TimeUnit.SECONDS.sleep(5);
	    jOptionPane.closeDialog();
	}
	//Kiểm tra nút "Làm mới" khi nhập mật khẩu nhân viên các trường dữ liệu còn lại bỏ trống
//	@Test
	public void TC_QLCF_QLNhanVien_21() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên
	    main.setForm(QLNV);
	    main.setVisible(true);
	    // Chọn giới tính "Nam"
	    String matkhau = "NV4554455";
	    QLNV.txtPass.setText(matkhau);
	    TimeUnit.SECONDS.sleep(5);
	    // Nhấn nút "Làm mới"
	    QLNV.clearForm();
	    TimeUnit.SECONDS.sleep(5);
	    String maNVAfterRefresh = QLNV.txtPass.getText();
//	    // Kiểm tra kết quả
	    assertEquals("", maNVAfterRefresh);
	    TimeUnit.SECONDS.sleep(5);
	    jOptionPane.closeDialog();
	}
	//Kiểm tra nút "Làm mới" khi nhập xác nhận mật khẩu nhân viên các trường dữ liệu còn lại bỏ trống
	@Test
	public void TC_QLCF_QLNhanVien_22() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên
	    main.setForm(QLNV);
	    main.setVisible(true);
	    // Chọn giới tính "Nam"
	    String matkhau = "NV4554455";
	    QLNV.txtRePass.setText(matkhau);
	    TimeUnit.SECONDS.sleep(5);
	    // Nhấn nút "Làm mới"
	    QLNV.clearForm();
	    TimeUnit.SECONDS.sleep(5);
	    String maNVAfterRefresh = QLNV.txtRePass.getText();
//	    // Kiểm tra kết quả
	    assertEquals("", maNVAfterRefresh);
	    TimeUnit.SECONDS.sleep(5);
	    jOptionPane.closeDialog();
	}
	//Kiểm tra nút "Làm mới" khi nhập số điện thoại nhân viên các trường dữ liệu còn lại bỏ trống
	@Test
	public void TC_QLCF_QLNhanVien_24() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên
	    main.setForm(QLNV);
	    main.setVisible(true);
	    // Chọn giới tính "Nam"
	    String matkhau = "0784511258";
	    QLNV.txtSDT.setText(matkhau);
	    TimeUnit.SECONDS.sleep(5);
	    // Nhấn nút "Làm mới"
	    QLNV.clearForm();
	    TimeUnit.SECONDS.sleep(5);
	    String maNVAfterRefresh = QLNV.txtSDT.getText();
//	    // Kiểm tra kết quả
	    assertEquals("", maNVAfterRefresh);
	    TimeUnit.SECONDS.sleep(5);
	    jOptionPane.closeDialog();
	}
	
	//Kiểm tra nút "Làm mới" khi chọn ngày làm nhân viên các trường dữ liệu còn lại bỏ trống
	@Test
	public void TC_QLCF_QLNhanVien_23() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên
	    main.setForm(QLNV);
	    main.setVisible(true);
	    // Chọn ngày làm "21/11/2023"
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Date ngayVaoLam;
		try {
			ngayVaoLam = dateFormat.parse("21/11/2023");
			QLNV.jdcNgayVaoLam.setDate(ngayVaoLam);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    TimeUnit.SECONDS.sleep(5);
	    // Nhấn nút "Làm mới"
	    QLNV.clearForm();
	    TimeUnit.SECONDS.sleep(5);
	    // Kiểm tra xem trường jdcNgayVaoLam đã bị xóa hay chưa
	    Date ngayVaoLamAfterRefresh = QLNV.jdcNgayVaoLam.getDate();
	    // Kiểm tra kết quả
	    assertNull(ngayVaoLamAfterRefresh);
	    TimeUnit.SECONDS.sleep(5);
	    jOptionPane.closeDialog();
	}
	//Kiểm tra nút "Làm mới" khi khi nhập ghi chú làm nhân viên các trường dữ liệu còn lại bỏ trống
	@Test
	public void TC_QLCF_QLNhanVien_25() throws InterruptedException, ParseException {
	    // Thiết lập form Quản lý Nhân viên
	    main.setForm(QLNV);
	    main.setVisible(true);
	    // Chọn giới tính "Nam"
	    String matkhau = "bhhjfsdf  nfjaknfjsnjfnsdfnkdjankjvw";
	    QLNV.txtGhiChu.setText(matkhau);
	    TimeUnit.SECONDS.sleep(5);
	    // Nhấn nút "Làm mới"
	    QLNV.clearForm();
	    TimeUnit.SECONDS.sleep(5);
	    String maNVAfterRefresh = QLNV.txtGhiChu.getText();
//	    // Kiểm tra kết quả
	    assertEquals("", maNVAfterRefresh);
	    TimeUnit.SECONDS.sleep(5);
	    jOptionPane.closeDialog();
	}
}