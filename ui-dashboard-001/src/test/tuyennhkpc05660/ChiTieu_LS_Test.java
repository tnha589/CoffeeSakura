package test.tuyennhkpc05660;

import org.testng.annotations.Test;

import com.Dao.ChiTieuDao;
import com.form.ChiTieu1;
import com.form.DangNhap;
import com.main.Main;
import com.model.ChiTieu;
import com.untils.JOptionPane;
import com.untils.XDate;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;

import org.testng.annotations.AfterClass;

public class ChiTieu_LS_Test {
	DangNhap login;
	Main main;
	ChiTieu1 form_CT;
	JOptionPane jOptionPane;

	@DataProvider(name = "dataHistory")
	public Object[][] dataHistory() {
		ChiTieuDao dao = new ChiTieuDao();
		ChiTieu entity = dao.selectById(1);
		return new Object[][] {
				// Huy_01: Kiểm tra khi click vào button Hủy có tự động hoàn tác lại dữ liệu
				new Object[] { entity.isTrangThai() }, new Object[] { !entity.isTrangThai() }, 
				};
	}

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
		form_CT.getjTabbedPane1().setSelectedIndex(1);
	}

	@BeforeMethod
	public void beformethod() {
		jOptionPane = new JOptionPane();
	}

	@Test(priority = 1)
	public void Click() throws InterruptedException {
		ChiTieuDao dao = new ChiTieuDao();
		ChiTieu entity = dao.selectById(1);
		TimeUnit.SECONDS.sleep(5);
		form_CT.tblLichSu.setRowSelectionInterval(0, 0);
		form_CT.tblLichSuMouseClicked(null);
		form_CT.setForm2(entity);
//		form_CT.txtTenNV.setText("123");;
		TimeUnit.SECONDS.sleep(5);
		assertEquals(form_CT.lblTenNV.getText(), entity.getTenNV());
		assertEquals(form_CT.lblTien.getText(), entity.getTien() + "");
		assertEquals(form_CT.lblNgay.getText(), XDate.toString(entity.getThoiGian()));
		assertEquals(form_CT.txtGhiChu2.getText(), entity.getGhiChu());
		assertTrue(entity.isTrangThai() ? form_CT.rboXacNhan.isSelected() : form_CT.rboKoXacNhan.isSelected());
	}


	@Test(priority = 2)
	public void testHuy() throws InterruptedException {
		ChiTieuDao dao = new ChiTieuDao();
		ChiTieu entity = dao.selectById(1);
		form_CT.tblLichSu.setRowSelectionInterval(0, 0);
		form_CT.tblLichSuMouseClicked(null);
		
		form_CT.txtGhiChu2.setText("tiền nhập nguyên liệu");
		form_CT.btnHUy.doClick();
		TimeUnit.SECONDS.sleep(5);
		assertEquals(form_CT.txtGhiChu2.getText(), entity.getGhiChu());
	}

	@Test(priority = 3, dataProvider = "dataHistory")
	public void testUpdate(boolean trangthai) throws InterruptedException {
		form_CT.tblLichSu.setRowSelectionInterval(0, 0);
		form_CT.tblLichSuMouseClicked(null);

		if (trangthai) {
			form_CT.rboXacNhan.setSelected(true);
		} else {
			form_CT.rboKoXacNhan.setSelected(true);
		}
//		TimeUnit.SECONDS.sleep(10);
		form_CT.btnCapNhat.doClick();
		jOptionPane.dialog.dispose();

		ChiTieuDao dao = new ChiTieuDao();
		ChiTieu entity = dao.selectById(1);
		assertEquals(entity.isTrangThai(), trangthai);

	}

	@AfterClass
	public void afterClass() {
		form_CT.setVisible(false);
	}
}
