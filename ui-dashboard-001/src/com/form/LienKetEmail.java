/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.form;

import com.Dao.nhanVienDao;
import com.model.ChiTieu;
import com.model.NhanVien;
import com.untils.XAuth;
import com.untils.XDialog;
import com.untils.getJOptionePane;

import java.awt.Color;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.Timer;

/**
 *
 * @author ACER
 */
public class LienKetEmail extends javax.swing.JDialog implements Runnable {

    nhanVienDao NVD = new nhanVienDao();
    Timer t = null;
    boolean timer = false;

    /**
     * Creates new form LienKetEmail
     */
    public LienKetEmail(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        init();
    }

    void init() {
        if (XAuth.isLogin() && XAuth.user != null) {
            txtTen.setText(XAuth.user.getMaNV());
            txtTen.setEnabled(false);
        }
        if (XAuth.user != null) {
            txtEmail.setText(XAuth.user.getEmail());
        }
    }

    public String getRandomString(int n) {
        String txt = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            Random rd = new Random();
            sb.append(txt.charAt(rd.nextInt(txt.length())));
            n--;
        }
        return sb.toString();
    }

    public String maXT = getRandomString(6);

    public void sendMail() {
        String dinhangemail = "^[A-Za-z0-9+_.-]+@(.+)$";
        String email = txtEmail.getText();

        ///bắt lỗi trống
        if (email.equals("")) {
              getJOptionePane.methodThatUsesOptionPane(this, "Vui lòng nhập email.");
            return;
        }

        //bắt lỗi định dạng email
        if (!email.matches(dinhangemail)) {
              getJOptionePane.methodThatUsesOptionPane(this, "Email không đúng định dạng.");
            return;
        }

        //bắt lỗi tồn tại
        if (email.equals(XAuth.user.getEmail())) {
              getJOptionePane.methodThatUsesOptionPane(this, "Email đã tồn tại trong hệ thống.");
            return;
        }

        String messageBody
                = "<b> Xin chào <b>"
                + "Đây là email nhận mã xác thực từ <b>SAKURA COFFEE</b>."
                + "<br/><br/>"
                + "Mã xác thực của bạn là: <b>" + maXT + "</b><br/>"
                + "Vui lòng không cung cấp mã xác thực cho bất kỳ ai!"
                + "<br/><br/>"
                + "Nếu bạn gặp sự cố, vui lòng liên hệ với bộ phận hỗ trợ thông qua email: "
                + "<a href='mailto:sakuracoffee1@gmail.com'>sukuracoffee1@gmail.com</a><br/>"
                + "chúng tôi đặc biệt không khuyến khích bạn chia sẻ mật khẩu đó với bất kỳ ai.</div>";

        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);
            p.put("mail.smtp.socketFactory.port", "587");
            p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            p.put("mail.smtp.ssl.protocols", "TLSv1.2");
            String senderEmail = "sakuracoffe1@gmail.com";
            String pass = "louawtomnzrfbzjp";
            Session session = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, pass);
                }
            });
            String receiveEmail = txtEmail.getText();
            String tieuDe = "Liên kết email";
            String noiDung = messageBody;
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiveEmail));
            message.setSubject(tieuDe);
            message.setContent(noiDung, "text/html;charset=utf-8");
            Transport.send(message);
              getJOptionePane.methodThatUsesOptionPane(this, "Đã gửi mã thành công!");
            //   System.out.println("Da gui");
            timer = false;
            Thread time = new Thread(this);
            time.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xacNhan() {
        String maxn = txtMa.getText().trim();
        String email = txtEmail.getText().trim();

        if (maxn.equals("")) {
              getJOptionePane.methodThatUsesOptionPane(this, "Mã xác thực không được để trống");
        }
        if (maxn.equals(maXT)) {
            String maNV = XAuth.user.getMaNV();
            if (maNV != null && !maNV.isEmpty()) {
                NhanVien nv = NVD.selectById(maNV);
                if (nv != null) {
                    nv.setEmail(email);
                    NVD.updateEmail(nv);
                }
            }

            txtEmail.setText("");
            txtMa.setText("");

              getJOptionePane.methodThatUsesOptionPane(this, "Liên kết thành công!");
        } else {

              getJOptionePane.methodThatUsesOptionPane(this, "Sai mã xác thực");

        }
    }

    // Các phương thức và thành phần khác của giao diện người dùng
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        btnGui = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnLienKet = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        txtTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblXN = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 154, 157));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nhập email:");

        txtMa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMaCaretUpdate(evt);
            }
        });

        btnGui.setBackground(new java.awt.Color(175, 42, 46));
        btnGui.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGui.setForeground(new java.awt.Color(255, 255, 255));
        btnGui.setText("Gửi mã");
        btnGui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuiMouseClicked(evt);
            }
        });
        btnGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nhập mã:");

        btnLienKet.setBackground(new java.awt.Color(175, 41, 117));
        btnLienKet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLienKet.setForeground(new java.awt.Color(255, 255, 255));
        btnLienKet.setText("Liên kết");
        btnLienKet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLienKetActionPerformed(evt);
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

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên tài khoản:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("Liên kết email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblXN, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addComponent(btnGui, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 5, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTen)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(69, 69, 69))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLienKet, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblXN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGui, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(txtMa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLienKet, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void btnLienKetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLienKetActionPerformed
        // TODO add your handling code here:
        //  KiemTra();
        xacNhan();
    }//GEN-LAST:event_btnLienKetActionPerformed

    public void btnGuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiActionPerformed
        // TODO add your handling code here:
        //GuiMa();  
        sendMail();

    }//GEN-LAST:event_btnGuiActionPerformed

    public void btnGuiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuiMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_btnGuiMouseClicked

    public void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        if (XDialog.confirm(this, "Bạn chắc chắn thoát!! ")) {
            dispose();
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    public void txtMaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMaCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaCaretUpdate

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
            java.util.logging.Logger.getLogger(LienKetEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LienKetEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LienKetEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LienKetEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LienKetEmail dialog = new LienKetEmail(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton btnGui;
    public javax.swing.JButton btnHuy;
    public javax.swing.JButton btnLienKet;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblEmail;
    public javax.swing.JLabel lblXN;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtMa;
    public javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
 @Override
    public void run() {
        int s = 120;
        while (true) {
            if (timer == true) {
                break;
            }
            btnGui.setText("" + s + "s");
            try {
                Thread.sleep(1000);
                s--;
                if (s == 0) {
                    maXT = "";
                    btnGui.setText("Lấy Mã");
                    return;
                }
            } catch (InterruptedException ex) {
            }
        }
    }

}
