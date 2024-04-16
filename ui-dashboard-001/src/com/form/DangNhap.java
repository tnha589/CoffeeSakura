/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.form;

import com.Dao.nhanVienDao;
import com.component.Header;
import com.untils.JOptionPane;
import com.untils.XAuth;
import com.untils.XDialog;
import com.untils.getJOptionePane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import com.model.NhanVien;

//import static org.mockito.Mockito.timeout;

import java.awt.Color;
import java.awt.Component;

/**
 *
 * @author ACER
 */
public class DangNhap extends javax.swing.JDialog {

	public javax.swing.JButton getBtnHuy() {
		return btnHuy;
	}

	public void setBtnHuy(javax.swing.JButton btnHuy) {
		this.btnHuy = btnHuy;
	}

	public javax.swing.JButton getBtnXacNhan() {
		return btnXacNhan;
	}

	public void setBtnXacNhan(javax.swing.JButton btnXacNhan) {
		this.btnXacNhan = btnXacNhan;
	}

	public javax.swing.JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(javax.swing.JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public javax.swing.JTextField getTxtTenTK() {
		return txtTenTK;
	}

	public void setTxtTenTK(javax.swing.JTextField txtTenTK) {
		this.txtTenTK = txtTenTK;
	}

	nhanVienDao NVDao = new nhanVienDao();

	/**
	 * Creates new form DangNhap
	 */
	public DangNhap(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		setLocationRelativeTo(null);
//        txtTenTK.setText("NV000");
//        txtPassword.setText("123");
	}

	// Nhập dữ liệu tư
	public void login() {
		String MaNV = txtTenTK.getText();
		String MK = new String(txtPassword.getPassword());
		NhanVien nv = NVDao.selectById(MaNV);
		if (nv == null) {
			XDialog.alert(this, "Sai tên đăng nhập!");
		} else if (!MK.equals(nv.getMatKhau())) {
			XDialog.alert(this, "Sai mật khẩu!");
		} else if (nv.getChuVu().equals("Nhân Viên")) {
			XDialog.alert(this, "Nhân viên không có quyền truy cập ứng dụng");
		} else if (nv.isTrangThai() == false) {
			XDialog.alert(null, "Nhân viên đã nghĩ làm, không thể đăng nhập!");
		} else {
			System.out.println("Logged in successfully...");
			XAuth.user = nv;
			getJOptionePane.methodThatUsesOptionPane(this, "Dangnhap thanh cong");
//			getoptionPane(this, "Đăng nhập thành công");
//            this.dispose();
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	public void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		txtTenTK = new javax.swing.JTextField();
		txtPassword = new javax.swing.JPasswordField();
		btnXacNhan = new javax.swing.JButton();
		btnHuy = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setFocusable(false);
		setUndecorated(true);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jPanel1.setBackground(new java.awt.Color(0, 0, 0, 65));

		jLabel1.setFont(new java.awt.Font("Script MT Bold", 1, 48)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("Login user");

		jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(255, 255, 255));
		jLabel3.setText("Tài khoản:");

		jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		jLabel4.setText("Mật khẩu:");

		jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(255, 255, 255));
		jLabel5.setText("Quên mật khẩu ?");
		jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel5MouseClicked(evt);
			}
		});

		txtTenTK.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

		btnXacNhan.setBackground(new java.awt.Color(0, 204, 102));
		btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnXacNhan.setText("Xác nhận");
		btnXacNhan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btnXacNhan.setRolloverEnabled(false);
		btnXacNhan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXacNhanActionPerformed(evt);
			}
		});

		btnHuy.setBackground(new java.awt.Color(204, 0, 13));
		btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnHuy.setText("Thoát");
		btnHuy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btnHuy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btnHuy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHuyActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel4).addComponent(jLabel3).addComponent(txtTenTK)
								.addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addGap(62, 62, 62)
						.addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
						.addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(62, 62, 62))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup()
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(113, 113, 113))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup()
												.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(159, 159, 159)))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(jLabel1)
						.addGap(41, 41, 41).addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(txtTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(59, 59, 59).addComponent(jLabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(67, 67, 67)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(jLabel5).addContainerGap()));

		getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 470, 550));

		jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/image/02-150ppp.jpg"))); // NOI18N
		getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 610));

		setSize(new java.awt.Dimension(1001, 611));
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	public void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXacNhanActionPerformed
		// TODO add your handling code here:
		if (txtTenTK.getText().trim().length() > 0) {
			if (txtPassword.getPassword().length > 0) {
				this.login();
			} else {
				XDialog.alert(this, "Không được để trống tên mật khẩu.");
			}
		} else {
			XDialog.alert(this, "Không được để trống tên đăng nhập.");
		}

	}// GEN-LAST:event_btnXacNhanActionPerformed

	public void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyActionPerformed
		// TODO add your handling code here:
		if (XDialog.confirm(this, "Bạn chắc chắn thoát!! ")) {
			System.exit(0);
		}

	}// GEN-LAST:event_btnHuyActionPerformed

	public void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MouseClicked
		new QuenMK(null, true).setVisible(true);
		// TODO add your handling code here:
	}// GEN-LAST:event_jLabel5MouseClicked

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
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				DangNhap dialog = new DangNhap(new javax.swing.JFrame(), true);
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
	public javax.swing.JButton btnHuy;
	public javax.swing.JButton btnXacNhan;
	public javax.swing.JLabel jLabel1;
	public javax.swing.JLabel jLabel2;
	public javax.swing.JLabel jLabel3;
	public javax.swing.JLabel jLabel4;
	public javax.swing.JLabel jLabel5;
	public javax.swing.JPanel jPanel1;
	public javax.swing.JPasswordField txtPassword;
	public javax.swing.JTextField txtTenTK;
	// End of variables declaration//GEN-END:variables

	
	

}
