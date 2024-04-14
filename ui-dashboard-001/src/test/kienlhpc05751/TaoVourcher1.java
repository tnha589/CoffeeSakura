package test.kienlhpc05751;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.form.Voucher;

import static org.testng.Assert.*;

import javax.swing.JOptionPane;

public class TaoVourcher1 {
	
	private Voucher voucher;


	@BeforeMethod
	public void setUp() {
		 voucher = new Voucher(null, true);
//		voucher = new Voucher();
	}

	@AfterMethod
	public void tearDown() {
		voucher = null;
	}

	@Test
	public void TC_QLCF_QLVOUCHER_01() {
	    // Thiết lập giá trị và số lượng voucher
	    voucher.txtGia.setText("10");
	    voucher.spnSoLuong.setValue(11);

	    // Mô phỏng việc nhấn nút tạo
	    voucher.btnTaoActionPerformed(null);

	    // Kiểm tra xem phương thức createVoucher đã được gọi và trả về thông báo thành công
	    String expectedMessage = "Tạo voucher thành công";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void TC_QLCF_QLVOUCHER_02() {
	    // Thiết lập giá trị và số lượng voucher không hợp lệ
	    voucher.txtGia.setText("a@@");
	    voucher.spnSoLuong.setValue(11);
	    // Mô phỏng việc nhấn nút tạo
	    voucher.btnTaoActionPerformed(null);
	    // Kiểm tra xem phương thức createVoucher không được gọi và trả về thông báo lỗi
	    String expectedMessage = "Giá trị chưa đúng";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void TC_QLCF_QLVOUCHER_03() {
	    // Thiết lập giá trị và số lượng voucher không hợp lệ
	    voucher.txtGia.setText("12,1");
	    voucher.spnSoLuong.setValue(11);

	    // Mô phỏng việc nhấn nút tạo
	    voucher.btnTaoActionPerformed(null);

	    // Kiểm tra xem phương thức createVoucher không được gọi và trả về thông báo lỗi
	    String expectedMessage = "Giá trị chưa đúng";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void TC_QLCF_QLVOUCHER_04() {
	    // Thiết lập giá trị và số lượng voucher không hợp lệ
	    voucher.txtGia.setText("12.1");
	    voucher.spnSoLuong.setValue(12);

	    // Mô phỏng việc nhấn nút tạo
	    voucher.btnTaoActionPerformed(null);

	    // Kiểm tra xem phương thức createVoucher không được gọi và trả về thông báo lỗi
	    String expectedMessage = "Giá trị chưa đúng";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void TC_QLCF_QLVOUCHER_05() {
	    // Thiết lập giá trị và số lượng voucher hợp lệ
	    voucher.txtGia.setText("10");
	    voucher.spnSoLuong.setValue(1000);

	    // Mô phỏng việc nhấn nút tạo
	    voucher.btnTaoActionPerformed(null);

	    // Kiểm tra xem phương thức createVoucher được gọi và trả về thông báo thành công
	    String expectedMessage = "Tạo voucher thành công";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void TC_QLCF_QLVOUCHER_06() {
	    // Thiết lập giá trị và số lượng voucher không hợp lệ
	    voucher.txtGia.setText("10000000000");
	    voucher.spnSoLuong.setValue(1);

	    // Mô phỏng việc nhấn nút tạo
	    voucher.btnTaoActionPerformed(null);

	    // Kiểm tra xem phương thức createVoucher không được gọi và trả về thông báo lỗi
	    String expectedMessage = "Giá trị voucher từ 10-500";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}


	// Các test case khác có thể thực hiện tương tự


	// Add more test methods for other scenarios

}
