/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.form;

import com.Dao.nhanVienDao;
import com.untils.XAuth;
import com.untils.XDialog;
import com.untils.getJOptionePane;

import java.awt.Color;

/**
 *
 * @author ACER
 */
public class DoiMatKhau extends javax.swing.JDialog {

    nhanVienDao NVD = new nhanVienDao();

    /**
     * Creates new form DoiMatKhau
     */
    public DoiMatKhau(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        init();
    }

    public void init() {
        if (XAuth.isLogin() && XAuth.user != null) {
            txtTenTK.setText(XAuth.user.getMaNV()); //Lấy tên đăng nhập
            txtTenTK.setEnabled(false); // Không cho chỉnh sửa
        }
    }

    public void DoiMK() {
        if (XAuth.isLogin()) { 
            try {
                String matKhau = new String(txtMKC.getPassword());
                String matKhauMoi = new String(txtMKM.getPassword());
                String xacNhanMK = new String(txtNLMKM.getPassword());

                if (!validateMatKhauCu(matKhau)) {
                    return;
                }

                if (!validateMatKhauMoi(matKhauMoi)) {
                    return;
                }

                if (!validateXacNhanMK(xacNhanMK)) {
                    return;
                }

                XAuth.user.setMatKhau(matKhauMoi);
                NVD.update(XAuth.user);
                  getJOptionePane.methodThatUsesOptionPane(this, "Đổi mật khẩu thành công!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
              getJOptionePane.methodThatUsesOptionPane(this, "Vui lòng đăng nhập trước khi đổi mật khẩu.");
        }
    }
   // -----------------------------------------------Bắt lỗi---------------------------------------------------------
    public boolean validateMatKhauCu(String matKhau) {
        if (matKhau.equals("")) {
              getJOptionePane.methodThatUsesOptionPane(this, "Mật khẩu không được để trống!");
            txtMKC.setForeground(Color.red);
            lblTBcu.setText("(*)Không được để trống!");
            lblTBcu.setVisible(true);
            return false;
        } else if (!matKhau.equals(XAuth.user.getMatKhau())) {
              getJOptionePane.methodThatUsesOptionPane(this, "Sai mật khẩu!");
            txtMKC.setForeground(Color.red);
            lblTBcu.setText("(*)Sai mật khẩu!");
            lblTBcu.setVisible(true);
            return false;
        } else {
            txtMKC.setForeground(Color.black);
            lblTBcu.setVisible(false);
            return true;
        }
    }

    public boolean validateMatKhauMoi(String matKhauMoi) {
        if (matKhauMoi.equals("")) {
              getJOptionePane.methodThatUsesOptionPane(this, "Mật khẩu mới không được để trống!");
            txtMKM.setForeground(Color.red);
            lblTBMoi.setText("(*)Không được để trống!");
            lblTBMoi.setVisible(true);
            return false;
        } else if (matKhauMoi.equals(matKhauMoi)) {
            txtMKM.setForeground(Color.black);
            lblTBMoi.setVisible(false);
            return true;
        } else {

            return true;
        }
    }

    public boolean validateXacNhanMK(String xacNhanMK) {
        if (xacNhanMK.equals("")) {
              getJOptionePane.methodThatUsesOptionPane(this, "Nhập lại không được để trống!");
            txtNLMKM.setForeground(Color.red);
            lblTBnl.setText("(*)Không được để trống");
            lblTBnl.setVisible(true);
            return false;
        } else if (!xacNhanMK.equals(xacNhanMK)) {
              getJOptionePane.methodThatUsesOptionPane(this, "Xác nhận mật khẩu không đúng!");
            txtNLMKM.setForeground(Color.red);
            lblTBnl.setText("(*)Mật khẩu không giống");
            lblTBnl.setVisible(true);
            return false;
        } else {
            txtNLMKM.setForeground(Color.black);
            lblTBnl.setVisible(false);
            return true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTenTK = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCapNhat = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        lblTBcu = new javax.swing.JLabel();
        lblTBMoi = new javax.swing.JLabel();
        lblTBnl = new javax.swing.JLabel();
        txtMKC = new javax.swing.JPasswordField();
        txtMKM = new javax.swing.JPasswordField();
        txtNLMKM = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 154, 157));

        txtTenTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tên tài khoản:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Mật khẩu cũ:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Mật khẩu mới:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Nhập lại mật khẩu mới:");

        btnCapNhat.setBackground(new java.awt.Color(175, 42, 46));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("Lưu");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(41, 157, 175));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        lblTBcu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTBcu.setForeground(new java.awt.Color(255, 0, 51));

        lblTBMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTBMoi.setForeground(new java.awt.Color(255, 0, 51));
        lblTBMoi.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblTBMoiAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblTBnl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTBnl.setForeground(new java.awt.Color(255, 0, 51));

        txtMKC.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMKCCaretUpdate(evt);
            }
        });

        txtMKM.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMKMCaretUpdate(evt);
            }
        });

        txtNLMKM.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNLMKMCaretUpdate(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setText("Đổi mật khẩu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenTK)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTBnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(lblTBcu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(lblTBMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMKC)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMKM)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNLMKM)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTBcu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMKC, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTBMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMKM, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTBnl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNLMKM, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        DoiMK();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    public void txtMKCCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMKCCaretUpdate
        // TODO add your handling code here:

//        try {
//            
//            if (txtMKC.getText().equals("")) {
//                lblTBcu.setText("(*)Vui lòng nhập mật khẩu");
//                lblTBcu.setVisible(true);
//            } else {
//                txtMKC.setForeground(Color.black);
////                    txtMKM.setForeground(Color.black);
//                lblTBcu.setVisible(false);
//            }
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_txtMKCCaretUpdate

    public void txtMKMCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMKMCaretUpdate
        // TODO add your handling code here:
//        try {
//            
//            if (txtMKM.getText().equals("")) {
//                lblTBMoi.setText("(*)Vui lòng nhập mật khẩu mới");
//                lblTBMoi.setVisible(true);
//            } else {
//                txtMKM.setForeground(Color.black);
////                    txtMKM.setForeground(Color.black);
//                lblTBMoi.setVisible(false);
//            }
//        } catch (Exception e) {
//        }

    }//GEN-LAST:event_txtMKMCaretUpdate

    public void txtNLMKMCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNLMKMCaretUpdate
        // TODO add your handling code here:
//        try {
//            
//            if (txtNLMKM.getText().equals("")) {
//                lblTBnl.setText("(*)Không để trống");
//                lblTBnl.setVisible(true);
//            } else {
//                txtNLMKM.setForeground(Color.black);
////                    txtMKM.setForeground(Color.black);
//                lblTBnl.setVisible(false);
//            }
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_txtNLMKMCaretUpdate

    public void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    public void lblTBMoiAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblTBMoiAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTBMoiAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DoiMatKhau dialog = new DoiMatKhau(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton btnCapNhat;
    public javax.swing.JButton btnHuy;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblTBMoi;
    public javax.swing.JLabel lblTBcu;
    public javax.swing.JLabel lblTBnl;
    public javax.swing.JPasswordField txtMKC;
    public javax.swing.JPasswordField txtMKM;
    public javax.swing.JPasswordField txtNLMKM;
    public javax.swing.JTextField txtTenTK;
    // End of variables declaration//GEN-END:variables
}
