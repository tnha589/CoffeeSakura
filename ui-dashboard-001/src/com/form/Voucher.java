/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.form;

import com.Dao.KhuyenMaiDao;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.untils.getJOptionePane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Admin
 */
public class Voucher extends javax.swing.JDialog {

    static Cipher cipher;
    String maHoa;
    List<Object[]> listma = new ArrayList<>();
    List<Integer> lisdsma = new ArrayList<>();
    String maXT = "";
    KhuyenMaiDao khuyenMaiDao = new KhuyenMaiDao();
    int maVC = 0;
    int giaTri = 0;

    /**
     * Creates new form Voucher
     */
    public Voucher(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Tạo voucher");
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtGia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spnSoLuong = new javax.swing.JSpinner();
        btnTao = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tạo voucher");

        jLabel2.setText("Mệnh giá voucher");

        jLabel3.setText("Số lượng");

        btnTao.setText("Tạo");
        btnTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoActionPerformed
//        demo();
        if (checkForm()) {
            try {
                createVoucher();
            } catch (Exception e) {
//                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_btnTaoActionPerformed

    public void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(Voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Voucher dialog = new Voucher(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton btnTao;
    public javax.swing.JButton btnThoat;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JSpinner spnSoLuong;
    public javax.swing.JTextField txtGia;
    // End of variables declaration//GEN-END:variables
    public void init() {
        spnSoLuong.setModel(new SpinnerNumberModel(1, 1, 20, 1));
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

    public void createVoucher() {
        int i = (int) spnSoLuong.getValue();
        listma = khuyenMaiDao.getMaVC();
        lisdsma.clear();
        for (Object[] objects : listma) {
            lisdsma.add((Integer) objects[0]);
        }
        giaTri = Integer.parseInt(txtGia.getText());
        maVC = Integer.parseInt(lisdsma.get(lisdsma.size() - 1).toString());
        for (int j = 0; j < i; j++) {
            maXT = getRandomString(10);
            maVC++;
            createQR();
            khuyenMaiDao.insertVoucher(giaTri, maXT);
        }
            getJOptionePane.methodThatUsesOptionPane(null, "Tạo voucher thành công");
    }

    public void createQR() {
        String data = maXT;
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200);
            BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix);
            ImageIcon imageIcon = new ImageIcon(
                    new ImageIcon(image)
                            .getImage()
                            .getScaledInstance(
                                    200,
                                    200,
                                    Image.SCALE_DEFAULT));
            Icon icon = imageIcon;
            BufferedImage bi = new BufferedImage(
                    200,
                    200,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.setColor(Color.WHITE);
            g.drawString("", 10, 20);
            g.dispose();

//            JFileChooser filePane = new JFileChooser("D:\\Voucher\\");
//            filePane.setDialogTitle("select folder");
//            filePane.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//            filePane.setAcceptAllFileFilterUsed(false);
//            int ketQua = filePane.showSaveDialog(this);
            try {
                String outputDir = "D:\\";
                ImageIO.write(bi, "png", new File(outputDir + "giatri_" + giaTri + "_ma" + maVC + ".png"));
            } catch (Exception e) {
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void demo() {
        String gia = txtGia.getText();
        int sl = (int) spnSoLuong.getValue();
            getJOptionePane.methodThatUsesOptionPane(null, "gia tri la: " + gia + " so luong la: " + sl);
    }

    public boolean checkForm() {
        if (txtGia.getText().isEmpty()) {
                getJOptionePane.methodThatUsesOptionPane(null, "Vui lòng nhập giá trị voucher");
            return false;
        }
        try {
            int checGiaTri = Integer.parseInt(txtGia.getText());
            if (checGiaTri < 10 || checGiaTri > 500) {
                    getJOptionePane.methodThatUsesOptionPane(null, "Giá trị voucher từ 10 --> 500");
                return false;
            }
        } catch (Exception e) {
                getJOptionePane.methodThatUsesOptionPane(null, "Giá trị chưa đúng");
            return false;
        }
        return true;
    }

}
