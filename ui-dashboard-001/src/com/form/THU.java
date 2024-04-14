/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.form;

import com.Dao.CaLamDao;
import com.Dao.SapCaDao;
import com.untils.XDialog;
import com.untils.XExcel;
import com.untils.XExcel1;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class THU extends javax.swing.JDialog {

    int row = -1;
    int col = -1;
    String Thu;
    String Ca;

    SapCaDao scDao = new SapCaDao();
    CaLamDao clDao = new CaLamDao();

    /**
     * Creates new form THU
     */
    public THU(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cboThu = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCaLam = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnXoaAll = new javax.swing.JButton();
        btnXoaAll1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 154, 157));

        cboThu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy", "Chủ Nhật" }));
        cboThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboThuMouseClicked(evt);
            }
        });
        cboThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Thứ:");

        jPanel2.setBackground(new java.awt.Color(244, 154, 157));

        tblCaLam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblCaLam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Ca làm", "Số lượng ", "Chi tiết"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCaLam.setSelectionBackground(new java.awt.Color(244, 100, 104));
        tblCaLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCaLamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCaLam);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnXoa.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnXoaAll.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnXoaAll.setText("Xóa tất cả");
        btnXoaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAllActionPerformed(evt);
            }
        });

        btnXoaAll1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnXoaAll1.setText("Xuất Exel");
        btnXoaAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAll1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboThu, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaAll1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(btnXoaAll, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(btnXoaAll1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                    .addComponent(cboThu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCaLamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCaLamMouseClicked
        int col = tblCaLam.getSelectedColumn();
        int row = tblCaLam.getSelectedRow();
        Thu = String.valueOf(cboThu.getSelectedItem());
        Ca = String.valueOf(tblCaLam.getValueAt(row, 1));
        if (col == 3 && row != -1) {
            String calam = (String) tblCaLam.getValueAt(row, 3);
            SapCa1 sapCa1 = new SapCa1(null, true);
            sapCa1.getThu(Thu);
            sapCa1.getCa(Ca);
            sapCa1.init();
            sapCa1.setVisible(true);
            fillTableCaLam();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_tblCaLamMouseClicked

    private void cboThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboThuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboThuMouseClicked

    private void cboThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThuActionPerformed
        fillTableCaLam();
        // TODO add your handling code here:
    }//GEN-LAST:event_cboThuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        Thu = String.valueOf(cboThu.getSelectedItem());
        boolean userConfirmed = XDialog.confirm(null, "Bạn có chắt muốn xóa!");
        if (userConfirmed) {
            clDao.deleteDataByThu(Thu);
        }
        fillTableCaLam();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAllActionPerformed
        boolean userConfirmed = XDialog.confirm(null, "Bạn có chắt muốn xóa!");
        if (userConfirmed) {
            clDao.deleteAllCaLam();
        }
        fillTableCaLam();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaAllActionPerformed

    private void btnXoaAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAll1ActionPerformed
       List<Object[]> list = clDao.getExcelFullCa();
        XExcel1.writeToExcel(list, "Lich Ca Lam Nhan Vien");
    for(Object[] row:list){
        System.out.println(""+row[0]+row[1]+row[2]+row[3]+row[4]);
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaAll1ActionPerformed

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
            java.util.logging.Logger.getLogger(THU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(THU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(THU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(THU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                THU dialog = new THU(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaAll;
    private javax.swing.JButton btnXoaAll1;
    private javax.swing.JComboBox<String> cboThu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCaLam;
    // End of variables declaration//GEN-END:variables

    public void init() {
        fillTableCaLam();
    }

    public void fillTableCaLam() {

        DefaultTableModel model = (DefaultTableModel) tblCaLam.getModel();
        model.setRowCount(0);
        //row = tblCaLam.getSelectedRow();
        try {
            // String calam = String.valueOf(tblCaLam.getValueAt(row, 1));
            String thu = (String) cboThu.getSelectedItem();
            List<Object[]> list = scDao.getXapCa(thu);
            int i = 0;
            for (Object[] row : list) {
                i++;
                model.addRow(new Object[]{i, row[0], row[1], "Chi tiết"});
            }
        } catch (Exception e) {
            XDialog.alert(this, "Lỗi truy vấn dữ liệu Sap ca");
            e.printStackTrace();
        }

    }

//    public String ThuString() {
//        return Thu1;
//    }
//
//    public String CaLamString() {
//        return Ca1;
//    }
}
