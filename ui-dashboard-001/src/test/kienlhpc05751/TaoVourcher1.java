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

	@Test(priority = 1)
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

	@Test(priority = 2)
	public void TC_QLCF_QLVOUCHER_02() {
	    voucher.txtGia.setText("a@@");
	    voucher.spnSoLuong.setValue(11);
	    // Mô phỏng việc nhấn nút tạo
	    voucher.btnTaoActionPerformed(null);
	    String expectedMessage = "Giá trị chưa đúng";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test(priority = 3)
	public void TC_QLCF_QLVOUCHER_03() {
	    voucher.txtGia.setText("12,1");
	    voucher.spnSoLuong.setValue(11);
	    voucher.btnTaoActionPerformed(null);
	    String expectedMessage = "Giá trị chưa đúng";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}

	@Test(priority = 4)
	public void TC_QLCF_QLVOUCHER_04() {
	    voucher.txtGia.setText("12.1");
	    voucher.spnSoLuong.setValue(12);
	    voucher.btnTaoActionPerformed(null);
	    String expectedMessage = "Giá trị chưa đúng";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}

	@Test(priority = 5)
	public void TC_QLCF_QLVOUCHER_05() {
	    voucher.txtGia.setText("10");
	    voucher.spnSoLuong.setValue(1000);
	    voucher.btnTaoActionPerformed(null);
	    String expectedMessage = "Tạo voucher thành công";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}

	@Test(priority = 6)
	public void TC_QLCF_QLVOUCHER_06() {
	    voucher.txtGia.setText("10000000000");
	    voucher.spnSoLuong.setValue(1);
	    voucher.btnTaoActionPerformed(null);
	    String expectedMessage = "Giá trị voucher từ 10-500";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}
    
	@Test(priority = 7)
	public void TC_QLCF_QLVOUCHER_07() {
	    voucher.txtGia.setText(null);
	    voucher.spnSoLuong.setValue(1);
	    voucher.btnTaoActionPerformed(null);
	    String expectedMessage = "Vui lòng nhập giá trị voucher";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test(priority = 8)
	public void TC_QLCF_QLVOUCHER_08() {
	    voucher.txtGia.setText("-1");
	    voucher.spnSoLuong.setValue(1);
	    voucher.btnTaoActionPerformed(null);
	    String expectedMessage = "Giá trị voucher từ 10-500";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test(priority = 9)
	public void TC_QLCF_QLVOUCHER_09() {
	    voucher.txtGia.setText("kien");
	    voucher.spnSoLuong.setValue(1);
	    voucher.btnTaoActionPerformed(null);
	    String expectedMessage = "Giá trị chưa đúng";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}
    
	@Test(priority = 10)
	public void TC_QLCF_QLVOUCHER_10() {
	    voucher.txtGia.setText("10");
	    voucher.spnSoLuong.setValue(-1);
	    voucher.btnTaoActionPerformed(null);
	    String expectedMessage = "Số lượng phải là số nguyên dương";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test(priority = 11)
	public void TC_QLCF_QLVOUCHER_11() {
	    voucher.txtGia.setText("10");
	    voucher.spnSoLuong.setValue("");
	    voucher.btnTaoActionPerformed(null);
	    String expectedMessage = "Số lượng không được để trống";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test(priority = 12)
	public void TC_QLCF_QLVOUCHER_12() {
	    voucher.txtGia.setText("10");
	    voucher.spnSoLuong.setValue("kien");
	    voucher.btnTaoActionPerformed(null);
	    String expectedMessage = "Số lượng phải là số nguyên dương";
	    String actualMessage = voucher.message;
	    Assert.assertEquals(expectedMessage, actualMessage);
	}

}
