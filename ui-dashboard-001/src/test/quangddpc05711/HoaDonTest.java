package test.quangddpc05711;

import org.testng.annotations.Test;

import com.form.DangNhap;
import com.form.HoaDon2;
import com.form.Menu1;
import com.main.Main;
import com.untils.XDate;

import test.quangddpc05711.SwingTestNG.CancelInputMockOptionPane;
import test.quangddpc05711.SwingTestNG.DangNhapTestNG;
import test.quangddpc05711.SwingTestNG.HoaDon2TestNG;
import test.quangddpc05711.SwingTestNG.InputMockOptionPane;
import test.quangddpc05711.SwingTestNG.MainTestNG;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.testng.annotations.AfterMethod;

public class HoaDonTest {
	DangNhapTestNG login = new DangNhapTestNG();
	MainTestNG main;
	Menu1 form1 = new Menu1();
	HoaDon2TestNG form2 = new HoaDon2TestNG();

	@BeforeMethod
	public void init() {
		login.setVisible(true);
	}

	@AfterMethod
	public void Close() {
		main.dispose();
	}

	// Kiểm tra thông tin hiển thị của bảng HÓA ĐƠN
	// PASS
	@Test
	public void TC_HOADON_02() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.form2);

		String cot1 = main.form2.tblHoaDon.getColumnName(0);
		String cot2 = main.form2.tblHoaDon.getColumnName(1);
		String cot3 = main.form2.tblHoaDon.getColumnName(2);
		String cot4 = main.form2.tblHoaDon.getColumnName(3);
		String cot5 = main.form2.tblHoaDon.getColumnName(4);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(cot1, "Mã HĐ");
		assertEquals(cot2, "Người Tạo");
		assertEquals(cot3, "Thời Gian Tạo");
		assertEquals(cot4, "Tổng Tiền");
		assertEquals(cot5, "Ghi Chú");

	}

	// Kiểm tra thông tin chi tiết của một hóa đơn có hiển thị khi click vào hóa đơn
	// đó ở bảng HÓA ĐƠN
	// PASS
	@Test
	public void TC_HOADON_03() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.form2);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Chọn một hàng chỉ định, ví dụ hàng 1
		int selectedRow = 0;

		// Tạo một sự kiện MouseEvent để mô phỏng việc click đúp liên tiếp vào hàng đã
		// chọn
		MouseEvent clickEvent = new MouseEvent(main.form2.tblHoaDon, MouseEvent.MOUSE_CLICKED,
				System.currentTimeMillis(), 0, 0, 0, 1, false);

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// LẤY RA THÔNG TIN CHI TIẾT
		String maHD = main.form2.lblMaHD.getText();
		String nguoiTao = main.form2.lblNguoiTao.getText();
		String tgTao = main.form2.lblThoiGianTao.getText();
		String tgTT = main.form2.lblThoiGianThanhToan.getText();
		String trangThai = main.form2.lblTrangThai.getText();
		String tienSP = main.form2.lblTienSP.getText();
		String phiKhac = main.form2.lblPhiKhac.getText();
		String tongTien = main.form2.lblTongTien.getText();

		// KIỂM TRA THÔNG TIN CHI TIẾT CÓ HIỂN THI KHI CLICK VÀO HÓA ĐƠN
		assertTrue(!maHD.equals(""));
		assertTrue(!nguoiTao.equals(""));
		assertTrue(!tgTao.equals(""));
		assertTrue(!tgTT.equals(""));
		assertTrue(!trangThai.equals(""));
		assertTrue(!tienSP.equals(""));
		assertTrue(!phiKhac.equals(""));
		assertTrue(!tongTien.equals(""));

	}

	// Kiểm tra thông tin hiển thị của bảng HÓA ĐƠN CHI TIẾT
	// PASS
	@Test
	public void TC_HOADON_04() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.form2);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Chọn một hàng chỉ định, ví dụ hàng 1
		int selectedRow = 0;

		// Tạo một sự kiện MouseEvent để mô phỏng việc click đúp liên tiếp vào hàng đã
		// chọn
		MouseEvent clickEvent = new MouseEvent(main.form2.tblHoaDon, MouseEvent.MOUSE_CLICKED,
				System.currentTimeMillis(), 0, 0, 0, 1, false);

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// LẤY RA THÔNG TIN CÁC CỘT CỦA BẢNG HÓA ĐƠN CHI TIẾT
		String cot1 = main.form2.tblHoaDonCT.getColumnName(0);
		String cot2 = main.form2.tblHoaDonCT.getColumnName(1);
		String cot3 = main.form2.tblHoaDonCT.getColumnName(2);
		String cot4 = main.form2.tblHoaDonCT.getColumnName(3);
		String cot5 = main.form2.tblHoaDonCT.getColumnName(4);

		// KIỂM TRA SỐ HÀNG CỦA BẢNG HÓA ĐƠN CHI TIẾT HIỂN THỊ PHẢI LỚN HƠN 0
		int rowCount = main.form2.tblHoaDonCT.getRowCount();

		// KIỂM TRA HÓA ĐƠN CHI TIẾT CÓ HIỂN THI ĐÚNG KHI CLICK VÀO HÓA ĐƠN
		assertEquals(cot1, "Tên SP");
		assertEquals(cot2, "Đơn Giá");
		assertEquals(cot3, "Số Lượng");
		assertEquals(cot4, "Thành Tiền");
		assertEquals(cot5, "Ghi Chú");
		// KIỂM TRA SỐ ROW PHẢI LỚN HƠN 0
		assertTrue(rowCount > 0);

	}

	// Kiểm tra hành động của nút Cancel khi Hủy đơn hàng
	// PASS
	@Test
	public void TC_HOADON_05() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.form2);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Chọn một hàng chỉ định, ví dụ hàng 1
		int selectedRow = 0;

		// Tạo một sự kiện MouseEvent để mô phỏng việc click đúp liên tiếp vào hàng đã
		// chọn
		MouseEvent clickEvent = new MouseEvent(main.form2.tblHoaDon, MouseEvent.MOUSE_CLICKED,
				System.currentTimeMillis(), 0, 0, 0, 1, false);

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Gọi phương thức để xác nhận
		main.form2.setOptionPane(new CancelInputMockOptionPane());

		main.form2.jButton2ActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String trangThai = main.form2.lblTrangThai.getText();

		assertEquals(trangThai, "Đang xử lý");

	}

	// Kiểm tra hành động của nút OK khi Hủy đơn hàng và không nhập gì vào lý do hủy
	// PASS
	@Test
	public void TC_HOADON_06() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.form2);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Chọn một hàng chỉ định, ví dụ hàng 1
		int selectedRow = 0;

		// Tạo một sự kiện MouseEvent để mô phỏng việc click đúp liên tiếp vào hàng đã
		// chọn
		MouseEvent clickEvent = new MouseEvent(main.form2.tblHoaDon, MouseEvent.MOUSE_CLICKED,
				System.currentTimeMillis(), 0, 0, 0, 1, false);

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Gọi phương thức để xác nhận
		main.form2.setOptionPane(new InputMockOptionPane(""));

		main.form2.jButton2ActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String trangThai = main.form2.lblTrangThai.getText();
		String lyDo = main.form2.lblNoiDungHuy.getText();

		assertEquals(trangThai, "Yêu cầu hủy");
		assertEquals(lyDo, "");

	}

	// Kiểm tra hành động của nút OK khi được yêu cầu nhập Lý do Hủy và có nhập lý
	// do
	// PASS
	@Test
	public void TC_HOADON_07() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.form2);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Chọn một hàng chỉ định, ví dụ hàng 1
		int selectedRow = 0;

		// Tạo một sự kiện MouseEvent để mô phỏng việc click đúp liên tiếp vào hàng đã
		// chọn
		MouseEvent clickEvent = new MouseEvent(main.form2.tblHoaDon, MouseEvent.MOUSE_CLICKED,
				System.currentTimeMillis(), 0, 0, 0, 1, false);

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Gọi phương thức để xác nhận
		main.form2.setOptionPane(new InputMockOptionPane("Lý do test"));

		main.form2.jButton2ActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String trangThai = main.form2.lblTrangThai.getText();
		String lyDo = main.form2.lblNoiDungHuy.getText();

		assertEquals(trangThai, "Yêu cầu hủy");
		assertEquals(lyDo, "Lý do test");

	}

	// Kiểm tra hành động của nút Xác Nhận Hủy sau khi đã Yêu cầu hủy đơn hàng và
	// chuyển sang Tab Lịch Sử Hóa Đơn
	// PASS
	@Test
	public void TC_HOADON_08() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.form2);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Chọn một hàng chỉ định, ví dụ hàng 1
		int selectedRow = 0;

		// Tạo một sự kiện MouseEvent để mô phỏng việc click đúp liên tiếp vào hàng đã
		// chọn
		MouseEvent clickEvent = new MouseEvent(main.form2.tblHoaDon, MouseEvent.MOUSE_CLICKED,
				System.currentTimeMillis(), 0, 0, 0, 1, false);

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		// lấy mã hóa đơn trước khi xác nhận
		String maHD = (String) main.form2.tblHoaDon.getValueAt(selectedRow, 0);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Gọi phương thức để xác nhận
		main.form2.setOptionPane(new InputMockOptionPane("Lý do test"));

		main.form2.jButton2ActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main.form2.btnXacNhanHuyActionPerformed(null);
		String actualMessage = main.form2.getMessage();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// CHỌN SANG TAB LỊCH SỬ HÓA ĐƠN ĐỂ XÁC NHẬN
		main.form2.jTabbedPane1.setSelectedIndex(1);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// lấy ra mã HĐ vừa mới xác nhận
		String maHDLS = (String) main.form2.tblLSHoaDon.getValueAt(main.form2.tblLSHoaDon.getRowCount() - 1, 0);

		System.out.println(maHDLS);
		System.out.println(maHD);

		// lấy ra trạng thái của đơn hàng đó tại lịch sử hóa đơn
		String trangThai = (String) main.form2.tblLSHoaDon.getValueAt(main.form2.tblLSHoaDon.getRowCount() - 1, 5);

		assertEquals(actualMessage, "Đã xác nhận hủy hóa đơn");
		// so sánh trạng thái
		assertEquals(trangThai, "Đã hủy");
		// so sánh mã hóa đơn
		assertEquals(maHDLS, maHD);

	}

	// Kiểm tra hành động của nút Từ Chối Hủy sau khi đã Yêu cầu hủy đơn hàng
	// PASS
	@Test
	public void TC_HOADON_09() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.form2);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Chọn một hàng chỉ định, ví dụ hàng 1
		int selectedRow = 0;

		// Tạo một sự kiện MouseEvent để mô phỏng việc click đúp liên tiếp vào hàng đã
		// chọn
		MouseEvent clickEvent = new MouseEvent(main.form2.tblHoaDon, MouseEvent.MOUSE_CLICKED,
				System.currentTimeMillis(), 0, 0, 0, 1, false);

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Gọi phương thức để xác nhận
		main.form2.setOptionPane(new InputMockOptionPane("Lý do test"));

		main.form2.jButton2ActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main.form2.btnTuChoiHuyActionPerformed(null);
		String actualMessage = main.form2.getMessage();

		assertEquals(actualMessage, "Đã từ chối hủy hóa đơn");

	}

	// Kiểm tra hành động của nút Xác Nhận Hóa Đơn và xác nhận lại dữ liệu ở Tab
	// Lịch Sử Hóa Đơn
	// PASS
	@Test
	public void TC_HOADON_10() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.form2);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Chọn một hàng chỉ định, ví dụ hàng 1
		int selectedRow = 0;

		// Tạo một sự kiện MouseEvent để mô phỏng việc click đúp liên tiếp vào hàng đã
		// chọn
		MouseEvent clickEvent = new MouseEvent(main.form2.tblHoaDon, MouseEvent.MOUSE_CLICKED,
				System.currentTimeMillis(), 0, 0, 0, 1, false);

		// Đặt row cho bảng là hàng đã chọn
		main.form2.tblHoaDon.setRowSelectionInterval(selectedRow, selectedRow);

		// Gọi phương thức tblGoiTapMouseClicked và truyền vào sự kiện chuột đã tạo
		main.form2.tblHoaDonMouseClicked(clickEvent);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// lấy mã hóa đơn trước khi xác nhận
		String maHD = (String) main.form2.tblHoaDon.getValueAt(selectedRow, 0);

		// xác nhận hóa đơn
		main.form2.jButton1ActionPerformed(null);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main.form2.jTabbedPane1.setSelectedIndex(1);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// lấy ra mã HĐ vừa mới xác nhận
		String maHDLS = (String) main.form2.tblLSHoaDon.getValueAt(main.form2.tblLSHoaDon.getRowCount() - 1, 0);

		System.out.println(maHDLS);
		System.out.println(maHD);

		// so sánh mã hóa đơn
		assertEquals(maHDLS, maHD);
		// so sánh trạng thái
		// lấy ra trạng thái của đơn hàng đó tại lịch sử hóa đơn
		String trangThai = (String) main.form2.tblLSHoaDon.getValueAt(main.form2.tblLSHoaDon.getRowCount() - 1, 5);
		assertEquals(trangThai, "Đã xử lý");

	}

	// Kiểm tra ngày hiển thị mặc định tại nút chọn ngày ở Tab Lịch Sử Hóa Đơn
	// PASS
	@Test
	public void TC_HOADON_11() {
		login.txtTenTK.setText("NV000");
		login.txtPassword.setText("1234");

		main = new MainTestNG();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main = login.btnXacNhanActionPerformed(null);
		main.setForm(main.form2);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		main.form2.jTabbedPane1.setSelectedIndex(1);

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ngayActual = XDate.toString(main.form2.jdcNgay.getDate(), "dd/MM/yyyy");

		String ngayExpected = XDate.toString(new Date(), "dd/MM/yyyy");

		// so sánh ngày hiển thị tai JDateChooser có phải là ngày hiện tại không
		assertEquals(ngayActual, ngayExpected);

	}

	// Kiểm tra chức năng chọn ngày để hiển thị hóa đơn ở Tab Lịch Sử Hóa Đơn
//	@Test
//	public void TC_HOADON_12() {
//		login.txtTenTK.setText("NV000");
//		login.txtPassword.setText("1234");
//
//		main = new MainTestNG();
//
//		try {
//			TimeUnit.SECONDS.sleep(2);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		main = login.btnXacNhanActionPerformed(null);
//		main.setForm(main.form2);
//
//		try {
//			TimeUnit.SECONDS.sleep(3);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		main.form2.jTabbedPane1.setSelectedIndex(1);
//
//		try {
//			TimeUnit.SECONDS.sleep(3);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		main.form2.jdcNgay.setDateFormatString("14/4/2024");
//		
//		try {
//			TimeUnit.SECONDS.sleep(3);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		main.form2.jdcNgay.firePropertyChange("date", null, main.form2.jdcNgay.getDate());
//		
//		int rowCount = main.form2.tblLSHoaDon.getRowCount();
//		
//		try {
//			TimeUnit.SECONDS.sleep(3);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// so sánh ngày hiển thị tai JDateChooser có phải là ngày hiện tại không
//		assertTrue(rowCount>0);
//
//	}

}
