/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.form;

import com.Dao.CaLamDao;
import com.model.SapCa;
import com.Dao.SapCaDao;
import com.untils.XDialog;
import com.untils.getJOptionePane;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import com.model.ChiTieu;
import com.model.NhanVien;

/**
 *
 * @author ACER
 */
public class SapCa1 extends javax.swing.JDialog {

	String Ca;
	String Ngay;
	SapCaDao SCD = new SapCaDao();
	int row = -1;
	int rowtn = -1;
	public List<Object[]> listNV = new ArrayList<>();
	public List<Object[]> listTN = new ArrayList<>();
	CaLamDao clDao = new CaLamDao();

	public SapCa1(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		setLocationRelativeTo(null);
		init();
	}


	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	public void initComponents() {

		jPopupMenu1 = new javax.swing.JPopupMenu();
		Them = new javax.swing.JMenuItem();
		jPopupMenu2 = new javax.swing.JPopupMenu();
		Xoa = new javax.swing.JMenuItem();
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel3 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		txtThuNgan = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblTen = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		tblThuNgan = new javax.swing.JTable();
		jLabel5 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		btnXacNhan = new javax.swing.JButton();
		jScrollPane6 = new javax.swing.JScrollPane();
		tblPhucVu = new javax.swing.JTable();
		jLabel6 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		lblThu = new javax.swing.JLabel();
		lblCaLam = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jLabel1 = new javax.swing.JLabel();

		Them.setText("Thêm");
		Them.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				ThemMouseClicked(evt);
			}
		});
		Them.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ThemActionPerformed(evt);
			}
		});
		jPopupMenu1.add(Them);

		Xoa.setText("Xóa");
		Xoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				XoaActionPerformed(evt);
			}
		});
		jPopupMenu2.add(Xoa);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jPanel2.setBackground(new java.awt.Color(244, 154, 157));

		jTabbedPane1.setBackground(new java.awt.Color(244, 154, 157));
		jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

		jPanel3.setBackground(new java.awt.Color(244, 154, 157));

		jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel3.setText("Thu ngân:");

		txtThuNgan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel4.setText("Phục vụ:");

		tblTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		tblTen.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null }, { null }, { null }, { null } }, new String[] { "Tên NV" }) {
			boolean[] canEdit = new boolean[] { false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblTen.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblTenMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tblTen);

		tblThuNgan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		tblThuNgan.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null }, { null, null } },
				new String[] { "Mã NV", "Tên NV" }) {
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblThuNgan.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblThuNganMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(tblThuNgan);

		jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel5.setText("Nhân viên thu ngân:");

		jButton1.setBackground(new java.awt.Color(41, 157, 175));
		jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jButton1.setForeground(new java.awt.Color(255, 255, 255));
		jButton1.setText("Thoát");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		btnXacNhan.setBackground(new java.awt.Color(175, 42, 46));
		btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
		btnXacNhan.setText("Xác nhận");
		btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXacNhanActionPerformed(evt);
			}
		});

		tblPhucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		tblPhucVu.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null } },
				new String[] { "Ma NV", "Tên NV" }) {
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblPhucVu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblPhucVuMouseClicked(evt);
			}
		});
		jScrollPane6.setViewportView(tblPhucVu);

		jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel6.setText("Nhân viên phục vụ:");

		jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel2.setText("Thứ:");

		jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel7.setText("Ca làm:");

		lblThu.setText("--------");

		lblCaLam.setText("--------");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel5)))
						.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtThuNgan, javax.swing.GroupLayout.PREFERRED_SIZE, 267,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel3Layout.createSequentialGroup()
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
																37, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(lblThu, javax.swing.GroupLayout.PREFERRED_SIZE,
																65, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(57, 57, 57)
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblCaLam, javax.swing.GroupLayout.DEFAULT_SIZE,
																52, Short.MAX_VALUE)))))
								.addGap(140, 140, 140).addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
										140, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 246,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(34, 34, 34)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5).addComponent(jLabel6))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 280,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(30, 30, 30)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(19, Short.MAX_VALUE))
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(15, 15, 15)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jLabel7))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblThu).addComponent(lblCaLam))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(txtThuNgan, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(56, 56, 56).addComponent(jLabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(29, 29, 29)));

		jTabbedPane1.addTab("Sắp ca", jPanel3);

		jTable2.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "STT", "Mã NV", "Tên NV", "Vai Trò" }));
		jScrollPane3.setViewportView(jTable2);

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane3,
								javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane3,
								javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Chi tiết", jPanel4);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
		jLabel1.setText("Sắp xếp ca làm");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(289, 289, 289))
				.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jTabbedPane1).addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jTabbedPane1).addContainerGap()));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 6, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		this.dispose();
	}// GEN-LAST:event_jButton1ActionPerformed

	public void tblThuNganMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblThuNganMouseClicked
		// TODO add your handling code here:
		this.rowtn = tblThuNgan.getSelectedRow();
		listTN.clear();
		String MaNV = (String) tblThuNgan.getValueAt(rowtn, 0);
		String TenNV = (String) tblThuNgan.getValueAt(rowtn, 1);
		listTN.add(new Object[] { MaNV, TenNV });
		txtThuNgan.setText(TenNV);
	}// GEN-LAST:event_tblThuNganMouseClicked

	public void tblPhucVuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblPhucVuMouseClicked
		// TODO add your handling code here:
		jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());

	}// GEN-LAST:event_tblPhucVuMouseClicked

	public void ThemMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_ThemMouseClicked

	}// GEN-LAST:event_ThemMouseClicked

	public void ThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ThemActionPerformed
		// TODO add your handling code here:
		ThemPV();
	}// GEN-LAST:event_ThemActionPerformed

	public void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXacNhanActionPerformed
		// TODO add your handling code here:
		deleteDataThu();
		Them();
		THU thu = new THU(null, true);
		thu.init();
	}// GEN-LAST:event_btnXacNhanActionPerformed

	public void tblTenMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblTenMouseClicked
		jPopupMenu2.show(evt.getComponent(), evt.getX(), evt.getY());
		// TODO add your handling code here:
	}// GEN-LAST:event_tblTenMouseClicked

	public void XoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_XoaActionPerformed
		Xoa();
		// TODO add your handling code here:
	}// GEN-LAST:event_XoaActionPerformed

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
			java.util.logging.Logger.getLogger(SapCa1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SapCa1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SapCa1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SapCa1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				SapCa1 dialog = new SapCa1(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	public javax.swing.JMenuItem Them;
	public javax.swing.JMenuItem Xoa;
	public javax.swing.JButton btnXacNhan;
	public javax.swing.JButton jButton1;
	public javax.swing.JLabel jLabel1;
	public javax.swing.JLabel jLabel2;
	public javax.swing.JLabel jLabel3;
	public javax.swing.JLabel jLabel4;
	public javax.swing.JLabel jLabel5;
	public javax.swing.JLabel jLabel6;
	public javax.swing.JLabel jLabel7;
	public javax.swing.JPanel jPanel1;
	public javax.swing.JPanel jPanel2;
	public javax.swing.JPanel jPanel3;
	public javax.swing.JPanel jPanel4;
	public javax.swing.JPopupMenu jPopupMenu1;
	public javax.swing.JPopupMenu jPopupMenu2;
	public javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JScrollPane jScrollPane2;
	public javax.swing.JScrollPane jScrollPane3;
	public javax.swing.JScrollPane jScrollPane6;
	public javax.swing.JTabbedPane jTabbedPane1;
	public javax.swing.JTable jTable2;
	public javax.swing.JLabel lblCaLam;
	public javax.swing.JLabel lblThu;
	public javax.swing.JTable tblPhucVu;
	public javax.swing.JTable tblTen;
	public javax.swing.JTable tblThuNgan;
	public javax.swing.JTextField txtThuNgan;
	// End of variables declaration//GEN-END:variables

	public void init() {
		fillTable();
		fillTable2();
		lblThu.setText(Ngay);
		lblCaLam.setText(Ca);
		loadNV();

	}

	public void fillTable() {
		DefaultTableModel model = (DefaultTableModel) tblThuNgan.getModel();
		model.setRowCount(0);

		try {
			List<Object[]> list = SCD.getThuNgan();
			for (Object[] row : list) {
				model.addRow(new Object[] { row[0], row[1] });

			}
		} catch (Exception e) {
			getJOptionePane.methodThatUsesOptionPane(this, "Lỗi truy vấn dữ liệu Sap ca");
			e.printStackTrace();
		}
	}

	public void fillTable2() {
		DefaultTableModel model = (DefaultTableModel) tblPhucVu.getModel();
		model.setRowCount(0);

		try {
			List<Object[]> list = SCD.getPhucVu();
			for (Object[] row : list) {
				model.addRow(new Object[] { row[0], row[1] });

			}
		} catch (Exception e) {
			getJOptionePane.methodThatUsesOptionPane(this, "Lỗi truy vấn dữ liệu Sap ca");
			e.printStackTrace();
		}
	}

	public void ThemPV() {

		for (int row : tblPhucVu.getSelectedRows()) {
			// Kiểm tra xem MaNV đã có trong listNV chưa
			String MaNV = (String) tblPhucVu.getValueAt(row, 0);
			String TenNV = (String) tblPhucVu.getValueAt(row, 1);

			boolean existed = false;
			for (Object[] nv : listNV) {
				String existingMaNV = (String) nv[0];
				if (existingMaNV.equals(MaNV)) {
					existed = true;
					break;
				}
			}

			if (!existed) {
				listNV.add(new Object[] { MaNV, TenNV });
			} else {
				getJOptionePane.methodThatUsesOptionPane(this, "Đã thêm nhân viên vào ca");
				return;
			}
		}
		FillPhucVu();
	}

	public void FillPhucVu() {
		DefaultTableModel model = (DefaultTableModel) tblTen.getModel();
		model.setRowCount(0);

		try {
			for (Object[] row : listNV) {
				model.addRow(new Object[] { row[1] });
			}

		} catch (Exception e) {
			getJOptionePane.methodThatUsesOptionPane(this, "Lỗi truy vấn dữ liệu Sap ca");
			e.printStackTrace();
		}
	}

	public void loadNV() {
		DefaultTableModel model = (DefaultTableModel) tblTen.getModel();
		model.setRowCount(0);
		List<Object[]> list = SCD.loadNV(lblThu.getText(), lblCaLam.getText());
		try {
			for (Object[] row : list) {
				String chucvu = (String) row[2];
				if (chucvu.equalsIgnoreCase("Thu Ngân")) {
					txtThuNgan.setText((String) row[1]);
					String MaNV = (String) row[0];
					String TenNV = (String) row[1];
					listTN.add(new Object[] { MaNV, TenNV });
				} else {
					String MaNV = (String) row[0];
					String TenNV = (String) row[1];
					model.addRow(new Object[] { row[1] });
					listNV.add(new Object[] { MaNV, TenNV });

				}

			}

		} catch (Exception e) {
			getJOptionePane.methodThatUsesOptionPane(this, "Lỗi truy vấn dữ liệu Sap ca");
			e.printStackTrace();
		}
	}

	public void Xoa() {
		int[] selectedRows = tblTen.getSelectedRows();

		// Đảm bảo rằng chúng ta xóa từ dưới lên để tránh vấn đề với chỉ số khi xóa
		for (int i = selectedRows.length - 1; i >= 0; i--) {
			int row = selectedRows[i];
			listNV.remove(row);
		}

		FillPhucVu();
	}

	public void deleteDataThu() {
		clDao.deleteDataThu(lblThu.getText(), lblCaLam.getText());
	}

	public void Them() {
		String maTN = String.valueOf(((Object[]) listTN.get(0))[0]);
		System.out.println("MaTN: " + maTN);
		clDao.updateDatabase(lblThu.getText(), lblCaLam.getText(), maTN, "Thu Ngân");
		for (Object[] nv : listNV) {
			String manv = (String) nv[0];
			clDao.updateDatabase(lblThu.getText(), lblCaLam.getText(), manv, "Nhân Viên");
		}
		getJOptionePane.methodThatUsesOptionPane(null, "Thêm Thành Công!");
	}
	public String getThu(String thu) {
		return Ngay = thu;
	}

	public String getCa(String ca) {
		return Ca = ca;
	}

}
