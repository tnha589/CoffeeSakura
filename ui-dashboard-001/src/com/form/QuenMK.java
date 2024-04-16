/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.form;

import com.Dao.nhanVienDao;
import com.model.NhanVien;
import com.untils.XAuth;
import com.untils.XDialog;
import com.untils.getJOptionePane;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author ACER
 */
public class QuenMK extends javax.swing.JDialog implements Runnable {

    nhanVienDao NVD = new nhanVienDao();
    String tennv = "";
    String manv = "";
    Timer t = null;
    boolean timer = false;
    public String message;

    /**
     * Creates new form QuenMK
     */
    public QuenMK(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    public void init() {

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
        String tenTaiKhoan = txtTK.getText();
        String email = txtEmail.getText();
        String dinhangemail = "^[A-Za-z0-9+_.-]+@(.+)$";
        //bắt lỗi trống
        if (tenTaiKhoan.equals("") || email.equals("")) {
            XDialog.alert(this, message="Vui lòng nhập đầy đủ tên tài khoản và email.");
            return;
        }
        // bắt lỗi ko có dữ liệu 
        NhanVien nv = NVD.selectById(tenTaiKhoan);
        if (nv == null) {
            XDialog.alert(this, message="Tài khoản không tồn tại trên hệ thống.");
            return;
        }

        //bắt lỗi định dạng email
        if (!email.matches(dinhangemail)) {
            XDialog.alert(this, message="Email không đúng định dạng.");
            return;
        }

        //bắt lỗi không tương thích vói tài khoản
        if (!nv.getEmail().equals(email)) {
              getJOptionePane.methodThatUsesOptionPane(this, "Email không tương thích với tài khoản đã nhập.");
            return;
        }

        String messageBody
                = "Xin chào <b>" + "<br/>"
                + "Đây là email nhận mã xác thực từ <b>SakuraCoffee</b>."
                + "<br/><br/>"
                + "Tên tài khoản: " + manv + "<br/>"
                + "Mã xác thực của bạn là: <b>" + maXT + "</b><br/>"
                + "Vui lòng không cung cấp mã xác thực cho bất kỳ ai!"
                + "<br/><br/>"
                + "Nếu bạn gặp sự cố, vui lòng liên hệ với bộ phận hỗ trợ thông qua email: "
                + "<a href='mailto:sakuracoffee1@gmail.com'>sakuracoffee1@gmail.com</a><br/>"
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
            String tieuDe = "Lấy lại mật khẩu EdySys";
            String noiDung = messageBody;
            Message messagesend = new MimeMessage(session);
            messagesend.setFrom(new InternetAddress(senderEmail));
            messagesend.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiveEmail));
            messagesend.setSubject(tieuDe);
            messagesend.setContent(noiDung, "text/html;charset=utf-8");
            Transport.send(messagesend);
            message ="Mã đã được gửi!";
            XDialog.alert(this, message  );

            Thread time = new Thread(this);
            time.start();
            timer = false;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xacNhan() {
        String maxn = txtMaXT.getText().trim();
        String email = txtEmail.getText();
        String TenTK = txtTK.getText();
        String emailMau = "^[A-Za-z0-9+_.-]+@(.+)$";

        if (TenTK.equals("")) {

            XDialog.alert(this, message="Vui lòng nhập tài khoản");
        } else if (email.equals("")) {
            XDialog.alert(this,message= "Vui lòng nhập email");
            return;
        } else if (!email.matches(emailMau)) {
            XDialog.alert(this, message="Email không đúng định dạng");
            return;
        } else if (maxn.isEmpty()) {
            XDialog.alert(this, message= "Vui lòng nhập mã xác thực!");
            return;
        } else if (maxn.equals(maXT)) {
            String strMaNV = txtTK.getText();
            NhanVien nv = NVD.selectById(strMaNV);
            XAuth.user = nv;
            timer = true;
            txtTK.setText("");
            txtEmail.setText("");
            txtMaXT.setText("");
            MatKhauMoi matkhaumoi = new MatKhauMoi(null, true);
            matkhaumoi.setVisible(true);
            dispose();
        } else {
            XDialog.alert(this,message= "Sai mã xác thực!");

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
        txtEmail = new javax.swing.JTextField();
        txtMaXT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLayMa = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        txtTK = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(244, 154, 157));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaXT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("Quên mật khẩu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Địa chỉ email:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nhập mã xác thực:");

        btnLayMa.setBackground(new java.awt.Color(175, 42, 46));
        btnLayMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLayMa.setForeground(new java.awt.Color(255, 255, 255));
        btnLayMa.setText("Lấy mã");
        btnLayMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLayMaActionPerformed(evt);
            }
        });

        btnXacNhan.setBackground(new java.awt.Color(175, 41, 117));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
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

        txtTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tên tài khoản:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtMaXT, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnLayMa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTK, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaXT, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLayMa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
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

    public void btnLayMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLayMaActionPerformed
        // TODO add your handling code here:
        sendMail();

    }//GEN-LAST:event_btnLayMaActionPerformed

    public void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        if (XDialog.confirm(this, message= "Bạn chắc chắn thoát!! ")) {
            dispose();
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    public void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        xacNhan();
    }//GEN-LAST:event_btnXacNhanActionPerformed

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
            java.util.logging.Logger.getLogger(QuenMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuenMK dialog = new QuenMK(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton btnLayMa;
    public javax.swing.JButton btnXacNhan;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtMaXT;
    public javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables
 @Override
    public void run() {
        int s = 120;
        while (true) {
            if (timer == true) {
                break;
            }
            btnLayMa.setText("" + s + "s");
            try {
                Thread.sleep(1000);
                s--;
                if (s == 0) {
                    maXT = "";
                    btnLayMa.setText("Lấy Mã");
                    return;
                }
            } catch (InterruptedException ex) {
            }
        }
    }

public nhanVienDao getNVD() {
	return NVD;
}

public void setNVD(nhanVienDao nVD) {
	NVD = nVD;
}

public String getTennv() {
	return tennv;
}

public void setTennv(String tennv) {
	this.tennv = tennv;
}

public String getManv() {
	return manv;
}

public void setManv(String manv) {
	this.manv = manv;
}

public Timer getT() {
	return t;
}

public void setT(Timer t) {
	this.t = t;
}

public boolean isTimer() {
	return timer;
}

public void setTimer(boolean timer) {
	this.timer = timer;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public String getMaXT() {
	return maXT;
}

public void setMaXT(String maXT) {
	this.maXT = maXT;
}

public javax.swing.JButton getBtnHuy() {
	return btnHuy;
}

public void setBtnHuy(javax.swing.JButton btnHuy) {
	this.btnHuy = btnHuy;
}

public javax.swing.JButton getBtnLayMa() {
	return btnLayMa;
}

public void setBtnLayMa(javax.swing.JButton btnLayMa) {
	this.btnLayMa = btnLayMa;
}

public javax.swing.JButton getBtnXacNhan() {
	return btnXacNhan;
}

public void setBtnXacNhan(javax.swing.JButton btnXacNhan) {
	this.btnXacNhan = btnXacNhan;
}

public javax.swing.JLabel getjLabel1() {
	return jLabel1;
}

public void setjLabel1(javax.swing.JLabel jLabel1) {
	this.jLabel1 = jLabel1;
}

public javax.swing.JLabel getjLabel2() {
	return jLabel2;
}

public void setjLabel2(javax.swing.JLabel jLabel2) {
	this.jLabel2 = jLabel2;
}

public javax.swing.JLabel getjLabel3() {
	return jLabel3;
}

public void setjLabel3(javax.swing.JLabel jLabel3) {
	this.jLabel3 = jLabel3;
}

public javax.swing.JLabel getjLabel4() {
	return jLabel4;
}

public void setjLabel4(javax.swing.JLabel jLabel4) {
	this.jLabel4 = jLabel4;
}

public javax.swing.JPanel getjPanel1() {
	return jPanel1;
}

public void setjPanel1(javax.swing.JPanel jPanel1) {
	this.jPanel1 = jPanel1;
}

public javax.swing.JTextField getTxtEmail() {
	return txtEmail;
}

public void setTxtEmail(javax.swing.JTextField txtEmail) {
	this.txtEmail = txtEmail;
}

public javax.swing.JTextField getTxtMaXT() {
	return txtMaXT;
}

public void setTxtMaXT(javax.swing.JTextField txtMaXT) {
	this.txtMaXT = txtMaXT;
}

public javax.swing.JTextField getTxtTK() {
	return txtTK;
}

public void setTxtTK(javax.swing.JTextField txtTK) {
	this.txtTK = txtTK;
}
 

}
