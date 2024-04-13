package test;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.form.DangNhap;
import com.form.Menu1;
import com.main.Main;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dao.sanPhamDao;
import com.form.DangNhap;
import com.model.SanPham;
import com.untils.XAuth;


public class MenuTest {
	Menu1 menu1;
	Main main;
	private DangNhap login;
	sanPhamDao spDao = new sanPhamDao();
	List<SanPham> list;

	public void sleep(int s) {
		try {
			TimeUnit.SECONDS.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void openMenu() {
		main = new Main();
		menu1 = new Menu1();
		login = new DangNhap(null, false);
		list = new ArrayList<>();
		login.setVisible(true);
		login.getTxtTenTK().setText("NV001");
		login.getTxtPassword().setText("matkhau123");
		sleep(2);
		login.login();
		
		main.setVisible(true);
		menu1.fillPanelSP();
		menu1.fillToTableHoaDon();
		main.setForm(menu1);
	}

	@AfterMethod
	public void closeMenu() {
		list.clear();
		XAuth.user = null;
		main.dispose();
	}
	
//	@Test
//	public void CF_02() {
//		sleep(1);
//		menu1.getTxtSearch().setText("");
//		sleep(1);
//		menu1.SearchProduct();
//		sleep(1);
//		list = spDao.selectAll();
//		sleep(1);
//		assertEquals(menu1.listSP, list);
//		sleep(1);
//	}
//	
//	@Test
//	public void CF_03() {
//		sleep(1);
//		menu1.getTxtSearch().setText("abc");
//		sleep(1);
//		menu1.SearchProduct();
//		sleep(1);
//		list = new ArrayList<SanPham>();
//		sleep(1);
//		assertEquals(menu1.listSP, list);
//		sleep(1);
//	}
	
//	@Test
//	public void CF_04() {
//		sleep(1);
//		menu1.getTxtSearch().setText("Nước");
//		sleep(1);
//		menu1.SearchProduct();
//		sleep(1);
//		list = spDao.selectByKeywordProduct("Nước");
//		sleep(1);
//		assertEquals(menu1.listSP, list);
//		sleep(1);
//	}
//	
	@Test
	public void CF_05() {
		sleep(1);
		menu1.getCboLoaiSP().setSelectedItem("Thức ăn");
		menu1.getCboLoaiSP().setSelectedIndex(1);
		sleep(1);
		menu1.clickCboLoaiSP();
		sleep(1);
		list = spDao.selectByLoaiSP("Thức ăn");
		sleep(1);
		assertEquals(menu1.listSP, list);
		sleep(1);
	}
	
}
