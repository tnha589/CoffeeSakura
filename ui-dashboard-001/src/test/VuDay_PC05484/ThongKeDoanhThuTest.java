package test.VuDay_PC05484;

import com.Dao.ThongKeDao;
import com.form.DangNhap;
import com.form.ThongKe1;
import com.main.Main;
import com.toedter.calendar.JDateChooser;
import com.untils.XAuth;
import com.untils.XDialog;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.awt.Window;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.xml.stream.events.StartDocument;

import org.testng.annotations.AfterMethod;

public class ThongKeDoanhThuTest {
	ThongKe1 tk1;
	Main main;
	private DangNhap login;
	ThongKeDao tkDao = new ThongKeDao();
//	List<thong> list = new ArrayList<>();

	public void sleep(int s) {
		try {
			TimeUnit.SECONDS.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void openTK() throws ParseException {
		main = new Main();
		tk1 = new ThongKe1();
		login = new DangNhap(null, false);
		login.setVisible(true);
		login.getTxtTenTK().setText("NV000");
		login.getTxtPassword().setText("1234");
		sleep(2);
		login.login();

		main.setVisible(true);

		main.setForm(tk1);
	}

	@AfterMethod
	public void closeMenu() {
		XAuth.user = null;
		main.dispose();
	}

		@Test(priority = 1)
	    public void Testdoanhthu1() {

	        Calendar calendar1 = Calendar.getInstance();
	        calendar1.set(2023, Calendar.NOVEMBER, 1);
	        Calendar calendar2 = Calendar.getInstance();
	        calendar2.set(2024, Calendar.NOVEMBER, 11);
	        tk1.getTxtHoaDonTu().setDate(calendar1.getTime());
	        tk1.getTxtHoaDonDen().setDate(calendar2.getTime());
			sleep(3);    
	    }
	@Test(priority = 2)
	public void Testdoanhthu2() {
		new Thread(new Runnable(){
			public void run() {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(2023, Calendar.DECEMBER, 12);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(2023, Calendar.DECEMBER, 11);
		tk1.getTxtHoaDonTu().setDate(calendar1.getTime());
		tk1.getTxtHoaDonDen().setDate(calendar2.getTime());
		
			}
		}).start();
		
		sleep(3);
		tk1.closeJdialog();
		assertEquals(tk1.message,"Ngày bắt đầu phải trước ngày kết thúc");

	}
		@Test(priority = 3)
	    public void Testdoanhthu3() {
			new Thread(new Runnable(){
				public void run() {
	        Calendar calendar2 = Calendar.getInstance();
	        calendar2.set(2023, Calendar.DECEMBER, 11);

	        tk1.getTxtHoaDonDen().setDate(calendar2.getTime());
	       
	        
	        tk1.getTxtHoaDonTu().setDate(null);
				}
			}).start();
			sleep(3);
			tk1.closeJdialog();
	        assertEquals(tk1.message,"Ngày bắt đầu không được bỏ trống");
	    
	    }
		@Test(priority = 4)
	    public void Testdoanhthu4() {
			new Thread(new Runnable(){
				public void run() {
	        Calendar calendar1 = Calendar.getInstance();
	        calendar1.set(2023, Calendar.DECEMBER, 8);
	        tk1.getTxtHoaDonTu().setDate(calendar1.getTime());
	        
	        tk1.getTxtHoaDonDen().setDate(null);
				}
			}).start();
			sleep(3);
			tk1.closeJdialog();
	        assertEquals(tk1.message,"Ngày kết thúc không được bỏ trống");
	    
	    }
		@Test(priority = 5)
	    public void Testdoanhthu5() {
			new Thread(new Runnable(){
				public void run() {
	       tk1.getTxtHoaDonTu().setDate(null);	        
	        tk1.getTxtHoaDonDen().setDate(null);
				}
			}).start();
			sleep(3);
			tk1.closeJdialog();
	        assertEquals(tk1.message,"Ngày không được để trống");
	    
	    }
		
		 
		

}
