/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.Dao.sanPhamDao;
import com.event.EventMenuSelected;
import com.form.ChiTieu1;
import com.form.DangNhap;
import com.form.HoaDon2;
import com.form.KhuyenMai1;
import com.form.Menu1;
import com.form.QuanLyNhanVien1;
import com.form.QuanLySanPham1;
import com.form.ThongKe1;
import com.form.TrangChu;
import com.UI.model.ModelItem;
import com.component.Header;
import com.untils.XAuth;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

	sanPhamDao spDao = new sanPhamDao();

	/**
	 * Creates new form Main
	 */
	public TrangChu home;
	public Menu1 form1;
	public HoaDon2 form2;
	public QuanLySanPham1 form3;
	public KhuyenMai1 form4;
	public ThongKe1 form5;
	public QuanLyNhanVien1 form6;
	public ChiTieu1 form7;
	public ModelItem itemSelected;
	Header h = new Header();

	public Main() {
		initComponents();
		setBackground(new Color(0, 0, 0, 0));
		home = new TrangChu();
		form1 = new Menu1();
		form2 = new HoaDon2();
		form3 = new QuanLySanPham1();
		form4 = new KhuyenMai1();
		try {
			form5 = new ThongKe1();
		} catch (ParseException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		form6 = new QuanLyNhanVien1();
		form7 = new ChiTieu1();
		init();
		menu.initMoving(Main.this);
		menu.addEventMenuSelected(new EventMenuSelected() {
			@Override
			public void selected(int index) {
				if (index == 0) {
					setForm(home);
				} else if (index == 1) {
					form1.fillPanelSP();
					form1.fillToTableHoaDon();
					setForm(form1);
				} else if (index == 2) {
					form2.init();
					setForm(form2);
				} else if (index == 3) {
					if (checkADM()) {
						setForm(form3);
					}
				} else if (index == 4) {
					if (checkADM()) {
						form4.init();
						setForm(form4);
					}

				} else if (index == 5) {
					if (checkADM()) {
						try {
							form5.init();
						} catch (ParseException ex) {
//                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
						}
						setForm(form5);
					}

				} else if (index == 6) {
					if (checkADM()) {
						setForm(form6);
					}
				} else if (index == 7) {
					form7.loadNameNV();
					setForm(form7);
				}
			}
		});
		// set when system open start with home form
		setForm(new TrangChu());
	}

	public void setForm(JComponent com) {
		mainPanel.removeAll();
		mainPanel.add(com);
		mainPanel.repaint();
		mainPanel.revalidate();
	}

	public void init() {
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(form1);
		form1.testData();
//        openLogin();


	}

	public Point getLocationOf(Component com) {
		Point p = form1.getPanelItemLocation();
		int x = p.x;
		int y = p.y;
		int itemX = com.getX();
		int itemY = com.getY();
		int left = 10;
		int top = 35;
		return new Point(x + itemX + left, y + itemY + top);
	}

	public void openLogin() {
		new DangNhap(null, true).setVisible(true);

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	public void initComponents() {

		panelBorder1 = new com.swing.PanelBorder();
		menu = new com.component.Menu();
		header2 = new com.component.Header();
		mainPanel = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		panelBorder1.setBackground(new java.awt.Color(244, 154, 157));

		header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		mainPanel.setOpaque(false);
		mainPanel.setLayout(new java.awt.BorderLayout());

		javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
		panelBorder1.setLayout(panelBorder1Layout);
		panelBorder1Layout
				.setHorizontalGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(panelBorder1Layout.createSequentialGroup()
								.addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 245,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 1313, Short.MAX_VALUE));
		panelBorder1Layout.setVerticalGroup(panelBorder1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelBorder1Layout.createSequentialGroup()
						.addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(panelBorder1Layout.createSequentialGroup().addGap(1, 1, 1)
										.addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap())
								.addGroup(panelBorder1Layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 743,
												javax.swing.GroupLayout.PREFERRED_SIZE)))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelBorder1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelBorder1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	public com.component.Header header2;
	public javax.swing.JPanel mainPanel;
	public com.component.Menu menu;
	public com.swing.PanelBorder panelBorder1;

	// End of variables declaration//GEN-END:variables
	public void DangXuat() {
		this.dispose();
	}

	public boolean checkADM() {
		if (!XAuth.isManager()) {
			JOptionPane.showMessageDialog(null, "Chỉ quản lí mới vào được chức năng này");
			return false;
		}
		return true;
	}

	public sanPhamDao getSpDao() {
		return spDao;
	}

	public void setSpDao(sanPhamDao spDao) {
		this.spDao = spDao;
	}

	public TrangChu getHome() {
		return home;
	}

	public void setHome(TrangChu home) {
		this.home = home;
	}

	public Menu1 getForm1() {
		return form1;
	}

	public void setForm1(Menu1 form1) {
		this.form1 = form1;
	}

	public HoaDon2 getForm2() {
		return form2;
	}

	public void setForm2(HoaDon2 form2) {
		this.form2 = form2;
	}

	public QuanLySanPham1 getForm3() {
		return form3;
	}

	public void setForm3(QuanLySanPham1 form3) {
		this.form3 = form3;
	}

	public KhuyenMai1 getForm4() {
		return form4;
	}

	public void setForm4(KhuyenMai1 form4) {
		this.form4 = form4;
	}

	public ThongKe1 getForm5() {
		return form5;
	}

	public void setForm5(ThongKe1 form5) {
		this.form5 = form5;
	}

	public QuanLyNhanVien1 getForm6() {
		return form6;
	}

	public void setForm6(QuanLyNhanVien1 form6) {
		this.form6 = form6;
	}

	public ChiTieu1 getForm7() {
		return form7;
	}

	public void setForm7(ChiTieu1 form7) {
		this.form7 = form7;
	}

	public ModelItem getItemSelected() {
		return itemSelected;
	}

	public void setItemSelected(ModelItem itemSelected) {
		this.itemSelected = itemSelected;
	}

	public Header getH() {
		return h;
	}

	public void setH(Header h) {
		this.h = h;
	}

	public com.component.Header getHeader2() {
		return header2;
	}

	public void setHeader2(com.component.Header header2) {
		this.header2 = header2;
	}

	public javax.swing.JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(javax.swing.JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public com.component.Menu getMenu() {
		return menu;
	}

	public void setMenu(com.component.Menu menu) {
		this.menu = menu;
	}

	public com.swing.PanelBorder getPanelBorder1() {
		return panelBorder1;
	}

	public void setPanelBorder1(com.swing.PanelBorder panelBorder1) {
		this.panelBorder1 = panelBorder1;
	}

	public void openQuanLyNhanVien() {

		setForm(form6);
	}

	public void openChiTieu() {
		setForm(form7);
	}

	public void openThongKe() {
		setForm(form5);
	}
	public void openKhuyenMai() {
		setForm(form4);

	}
	public void openSanPham() {
		setForm(form3);

	}

}
