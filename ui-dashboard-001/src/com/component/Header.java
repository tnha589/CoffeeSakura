package com.component;

import com.form.Calam;
import com.form.DangNhap;
import com.form.DoiMatKhau;
import com.form.GiaoCa;
import com.form.LienKetEmail;
import com.form.THU;
import com.main.Main;
import com.untils.XAuth;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
//        init();
        setOpaque(false);
        new Timer(1000, new ActionListener() {
            SimpleDateFormat fomat = new SimpleDateFormat("hh:mm");

            @Override
            public void actionPerformed(ActionEvent e) {
                lblTime.setText(fomat.format(new Date()));
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        mnuAcccount = new javax.swing.JPopupMenu();
        doimatkhau = new javax.swing.JMenuItem();
        lienKetGmail = new javax.swing.JMenuItem();
        quanLyCa = new javax.swing.JMenuItem();
        dangxuat = new javax.swing.JMenuItem();
        lblTime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/menu.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        mnuAcccount.setBackground(new java.awt.Color(150, 78, 83));
        mnuAcccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mnuAcccount.setForeground(new java.awt.Color(255, 255, 255));
        mnuAcccount.setToolTipText("");

        doimatkhau.setBackground(new java.awt.Color(150, 78, 83));
        doimatkhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        doimatkhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/password.png"))); // NOI18N
        doimatkhau.setText("Đổi mật khẩu");
        doimatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doimatkhauActionPerformed(evt);
            }
        });
        mnuAcccount.add(doimatkhau);

        lienKetGmail.setBackground(new java.awt.Color(150, 78, 83));
        lienKetGmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lienKetGmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/email.png"))); // NOI18N
        lienKetGmail.setText("Liên kết Gmail");
        lienKetGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lienKetGmailActionPerformed(evt);
            }
        });
        mnuAcccount.add(lienKetGmail);

        quanLyCa.setBackground(new java.awt.Color(150, 78, 83));
        quanLyCa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quanLyCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/time-management.png"))); // NOI18N
        quanLyCa.setText("Quản lý ca");
        quanLyCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyCaActionPerformed(evt);
            }
        });
        mnuAcccount.add(quanLyCa);

        dangxuat.setBackground(new java.awt.Color(150, 78, 83));
        dangxuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/logout.png"))); // NOI18N
        dangxuat.setText("Đăng xuất");
        dangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangxuatActionPerformed(evt);
            }
        });
        mnuAcccount.add(dangxuat);

        setBackground(new java.awt.Color(150, 78, 83));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Alarm.png"))); // NOI18N
        lblTime.setText("12:12:59");
        add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SAKURA COFFEE");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/menu3.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 40, 50));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Delete.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 43, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        int getwidth = 0 - jLabel5.getWidth();
        mnuAcccount.show(jLabel5, getwidth, jLabel5.getHeight());
    }//GEN-LAST:event_jLabel5MouseClicked

    private void quanLyCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyCaActionPerformed
        if (checkADM2()) {
            THU thu = new THU(null, true);
            thu.setVisible(true);
            Calam calam = new Calam(null, true);
            calam.fillTableNhanVien();
            calam.fillTableFullCa();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_quanLyCaActionPerformed

    public void lienKetGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lienKetGmailActionPerformed
        new LienKetEmail(null, true).setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_lienKetGmailActionPerformed

    private void doimatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doimatkhauActionPerformed
        new DoiMatKhau(null, true).setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_doimatkhauActionPerformed

    private void dangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangxuatActionPerformed
        XAuth.clear();
        DangNhap dangNhap = new DangNhap(null, true);
        dangNhap.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_dangxuatActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem dangxuat;
    private javax.swing.JMenuItem doimatkhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblTime;
    private javax.swing.JMenuItem lienKetGmail;
    public javax.swing.JPopupMenu mnuAcccount;
    private javax.swing.JMenuItem quanLyCa;
    // End of variables declaration//GEN-END:variables
public boolean checkADM2() {
        if (!XAuth.isManager()) {
            JOptionPane.showMessageDialog(null, "Bạn không đủ quyền truy cập");
            return false;
        }
        return true;
    }

//    public void init() {
//        if (XAuth.isLogin()) {
//            lblTen.setText(XAuth.user.getTenNV());
//        }else{
//        lblTen.setText("No Name");
//        }
//    }

}
