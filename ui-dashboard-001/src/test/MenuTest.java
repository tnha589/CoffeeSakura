package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.form.DangNhap;
import com.form.Menu1;
import com.main.Main;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
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

	public void closeJOptionPane() {
		Window[] windows = Window.getWindows();
		for (Window window : windows) {
			if (window instanceof JDialog) {
				JDialog dialog = (JDialog) window;
				if (dialog.getContentPane().getComponentCount() == 1
						&& dialog.getContentPane().getComponent(0) instanceof JOptionPane) {
					dialog.dispose();
				}
			}
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
	
	@Test(priority = 0)
	public void CF_02() {
		sleep(1);
		menu1.getTxtSearch().setText("");
		sleep(1);
		menu1.SearchProduct();
		sleep(1);
		list = spDao.selectAll();
		sleep(1);
		assertEquals(menu1.listSP, list);
		sleep(1);
	}
	
	@Test(priority = 1)
	public void CF_03() {
		sleep(1);
		menu1.getTxtSearch().setText("abc");
		sleep(1);
		menu1.SearchProduct();
		sleep(1);
		list = new ArrayList<SanPham>();
		sleep(1);
		assertEquals(menu1.listSP, list);
		sleep(1);
	}
	
	@Test(priority = 2)
	public void CF_04() {
		sleep(1);
		menu1.getTxtSearch().setText("Nước");
		sleep(1);
		menu1.SearchProduct();
		sleep(1);
		list = spDao.selectByKeywordProduct("Nước");
		sleep(1);
		assertEquals(menu1.listSP, list);
		sleep(1);
	}
	
	@Test (priority = 3)
	public void CF_05() {
		sleep(1);
		menu1.getCboLoaiSP().setSelectedIndex(2); // 2 la loai thức ăn
		sleep(1);
		sleep(1);
		list = spDao.selectByLoaiSP("Thức ăn");
		sleep(1);
		assertEquals(menu1.listSP, list);
		sleep(1);
	}
	
	@Test(priority = 4)
	public void CF_06() {
		sleep(1);
		menu1.getCboLoaiSP().setSelectedIndex(2); // 2 la loai thức ăn
		sleep(1);
		menu1.getTxtSearch().setText("Nước");
		menu1.SearchProduct();
		sleep(1);
		list = spDao.selectByTenAdnLoaiSP("Nước", "Thức ăn");
		System.out.println(list);
		sleep(1);
		assertEquals(menu1.listSP, list);
		sleep(1);
	}
	
	@Test (priority = 5)
	public void CF_07() {
		sleep(1);
		menu1.getCboLoaiSP().setSelectedIndex(2); // 2 la loai thức ăn
		sleep(1);
		menu1.getTxtSearch().setText("pizza");
		menu1.SearchProduct();
		sleep(1);
		list = spDao.selectByTenAdnLoaiSP("pizza", "Thức ăn");
		System.out.println(list);
		sleep(1);
		assertEquals(menu1.listSP, list);	
		sleep(1);
	}
	
	@Test(priority = 6)
	public void CF_10() {
		sleep(1);
		SanPham sp = new SanPham("SP1", "Nước ngọt cola", "tra-Lipton.jpg", 15.0, "Sản phẩm phổ biến", "LSP001", "KM001", true);
		menu1.fillToTable(sp);
		sleep(1);
		SanPham sp2 = new SanPham("SP10", "Nước lọc h2so4", "tra-Lipton.jpg", 5.0, "Dinh dưỡng và khoáng chất", "LSP001", null, true);
		menu1.fillToTable(sp2);
		sleep(1);
		sleep(2);
		menu1.cleadTable();
		sleep(2);
		assertEquals(menu1.getLblTongTien().getText(), "0");	
	}
	
	
	@Test(priority = 7,dataProvider = "DataHoaDon")
	public void CF_11_17(String chiPhiKhac, String tienNhan, String expected ) {
		sleep(1);
		SanPham sp = new SanPham("SP1", "Nước ngọt cola", "tra-Lipton.jpg", 15.0, "Sản phẩm phổ biến", "LSP001", "KM001", true);
		menu1.fillToTable(sp);
		sleep(1);
		menu1.getTxtChiPhiKhac().setText(chiPhiKhac);
		menu1.getTxtTienNhan().setText(tienNhan);
		menu1.tinhPhiKhac();
		menu1.tinhTienNhan();
		sleep(1);
		new Thread(()->{
			menu1.getBtnThanhToan1().doClick();
		}).start();
		sleep(2);
		menu1.closeJdialog();
		sleep(1);
		assertEquals(menu1.getMessage(), expected);
	}
	
	@DataProvider
	public Object[][] DataHoaDon(){
		return new Object[][] {
			new Object[] {"","20","Không được bỏ trống chi phí khác"},
			new Object[] {"abcxyz","20","Chi phí khác phải là số"},
			new Object[] {"-1234","20","Chi phí khác phải là số dương"},
			new Object[] {"1000","","Không được bỏ trống tiền nhận"},
			new Object[] {"1000","abc","Tiền nhận phải là số"},
			new Object[] {"1000","-1235","Tiền nhận phải là số dương"},
			new Object[] {"1000","500","Tiền nhận chưa đủ"},
		};
	}
	
//	@Test(priority = 8)
//	public void CF_18() {
//		sleep(1);
//		SanPham sp = new SanPham("SP1", "Nước ngọt cola", "tra-Lipton.jpg", 15.0, "Sản phẩm phổ biến", "LSP001", "KM001", true);
//		menu1.fillToTable(sp);
//		sleep(1);
//		menu1.getTxtChiPhiKhac().requestFocus();
//		menu1.getTxtChiPhiKhac().setText(String.valueOf(1000));
//		menu1.getTxtTienNhan().requestFocus();
//		menu1.getTxtTienNhan().setText(String.valueOf(1500));
//		menu1.tinhPhiKhac();
//		menu1.tinhTienNhan();
//		sleep(1);
//		new Thread(()->{
//			menu1.getBtnThanhToan1().doClick();
//		}).start();
//		sleep(2);
//		closeJOptionPane();
//		sleep(2);
//		try {
//			Robot robot = new Robot();
//			sleep(1);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		sleep(3);
//		assertEquals(menu1.getMessage(), "Tạo hóa đơn thành công");	
//	}
	
	@Test(priority = 9)
	public void CF_21() {
		sleep(1);
		new Thread(()->{
			menu1.getBtnInHoaDon().doClick();
		}).start();
		sleep(3);
		menu1.closeJdialog();
		sleep(1);
		assertEquals(menu1.getMessage(), "Hãy chọn một hóa đơn chờ hoặc thanh toán hóa đơn mới để in!");
	}
	
	@Test(priority = 10)
	public void CF_22() {
		sleep(1);
		new Thread(()->{
			menu1.setCheckselected(false);
			menu1.row2 = 2;
			menu1.fillTableHoaDonCT();
			menu1.getTblHoaDonCho().setEditingRow(2);
			menu1.tinhPhiKhac();
			menu1.tinhTienNhan();
		}).start();
		sleep(4);
		new Thread(()->{
			menu1.getBtnInHoaDon().doClick();
		}).start();
		sleep(3);
		menu1.closeJdialog();
		sleep(1);
		new Thread(()->{
			try {
				Robot robot = new Robot();
				sleep(1);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}).start();
		sleep(3);
		assertEquals(menu1.getMessage(), "In hóa đơn thành công!");
		sleep(1);
	}
	
}
