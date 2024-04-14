/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.form;

import com.Dao.loaiSanPhamDao;
import com.Dao.nhanVienDao;
import com.Dao.sanPhamDao;
import com.model.LoaiSanPham;
import com.model.NhanVien;
import com.model.SanPham;
import com.untils.XAuth;
import com.untils.XDialog;
import com.untils.XImage;
import com.untils.getJOptionePane;

import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class QuanLySanPham1 extends javax.swing.JPanel {

    JFileChooser fileChooser = new JFileChooser();
    sanPhamDao spDao = new sanPhamDao();
    loaiSanPhamDao lspDao = new loaiSanPhamDao();

    int row = -1;

    /**
     * Creates new form QuanLySanPham1
     */
    public QuanLySanPham1() {
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGiaSP = new javax.swing.JTextField();
        cboLoaiSP = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtFindTen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        cboFindLoai = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnThemLSP = new javax.swing.JButton();
        ErrorMaSP = new javax.swing.JLabel();
        ErrorGiaSP = new javax.swing.JLabel();
        ErrorTenSP = new javax.swing.JLabel();
        ErrorTrangThai = new javax.swing.JLabel();
        ErrorLoaiSP = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(959, 615));

        jPanel1.setBackground(new java.awt.Color(244, 154, 157));

        lblHinh.setBackground(new java.awt.Color(255, 255, 255));
        lblHinh.setForeground(new java.awt.Color(255, 0, 51));
        lblHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã sản phẩm");

        txtMaSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên sản phẩm");

        txtTenSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Giá sản phẩm");

        txtGiaSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cboLoaiSP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cboLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------------", "Coffee", "Nước trái cây", "Trà sữa", "Sữa", "Trà", "Nước lọc" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Loại sản phẩm");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Trạng thái");

        cboTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "Đang bán", "Ngừng bán" }));

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Ghi chú");

        btnThem.setBackground(new java.awt.Color(175, 42, 46));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(175, 41, 120));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-update-25.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-reset-25.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(244, 154, 157));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtFindTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tên sản phẩm");

        btnFind.setBackground(new java.awt.Color(175, 65, 68));
        btnFind.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFind.setForeground(new java.awt.Color(255, 255, 255));
        btnFind.setText("Tìm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        cboFindLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboFindLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFindLoaiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Loại sản phẩm");

        tblSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Giá bán", "Loại SP", "Trạng thái"
            }
        ));
        tblSanPham.setSelectionBackground(new java.awt.Color(244, 126, 130));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboFindLoai, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFindTen, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 271, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFind)
                        .addGap(12, 12, 12))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtFindTen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboFindLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThemLSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemLSP.setText("+");

        ErrorMaSP.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        ErrorMaSP.setForeground(new java.awt.Color(204, 0, 51));
        ErrorMaSP.setText("*");

        ErrorGiaSP.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        ErrorGiaSP.setForeground(new java.awt.Color(204, 0, 51));
        ErrorGiaSP.setText("*");

        ErrorTenSP.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        ErrorTenSP.setForeground(new java.awt.Color(204, 0, 51));
        ErrorTenSP.setText("*");

        ErrorTrangThai.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        ErrorTrangThai.setForeground(new java.awt.Color(204, 0, 51));
        ErrorTrangThai.setText("*");

        ErrorLoaiSP.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        ErrorLoaiSP.setForeground(new java.awt.Color(204, 0, 51));
        ErrorLoaiSP.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(7, 7, 7)
                                    .addComponent(ErrorGiaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGiaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenSP)
                                .addComponent(txtMaSP)
                                .addComponent(cboTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(cboLoaiSP, 0, 228, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnThemLSP))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ErrorMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ErrorTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ErrorLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ErrorTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(jLabel6)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ErrorMaSP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ErrorTenSP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(ErrorGiaSP)
                    .addComponent(ErrorLoaiSP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaSP)
                    .addComponent(btnThemLSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ErrorTrangThai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        this.row = tblSanPham.getSelectedRow();
        this.edit();
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamMouseClicked

    public void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    public void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    public void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clearForm();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoiActionPerformed

    public void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        chonHinh();
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHinhMouseClicked

    public void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        search(txtFindTen.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFindActionPerformed

    public void cboFindLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFindLoaiActionPerformed
        Loc();
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFindLoaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ErrorGiaSP;
    public javax.swing.JLabel ErrorLoaiSP;
    public javax.swing.JLabel ErrorMaSP;
    public javax.swing.JLabel ErrorTenSP;
    public javax.swing.JLabel ErrorTrangThai;
    public javax.swing.JButton btnFind;
    public javax.swing.JButton btnMoi;
    public javax.swing.JButton btnSua;
    public javax.swing.JButton btnThem;
    public javax.swing.JButton btnThemLSP;
    public javax.swing.JComboBox<String> cboFindLoai;
    public javax.swing.JComboBox<String> cboLoaiSP;
    public javax.swing.JComboBox<String> cboTrangThai;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblHinh;
    public javax.swing.JTable tblSanPham;
    public javax.swing.JTextField txtFindTen;
    public javax.swing.JTextArea txtGhiChu;
    public javax.swing.JTextField txtGiaSP;
    public javax.swing.JTextField txtMaSP;
    public javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
public void init() {
        fillTable();
        updateStatus();
        fillComboBoxLoaiSP();
        FillMaSP();
        txtMaSP.setEnabled(false);
        btnThemLSP.setVisible(false);
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        try {
            List<Object[]> list = spDao.getSanPhamFull();
            for (Object[] row : list) {

                int trangThai = Integer.parseInt((String) row[6]);
                String trangThai1 = "";
                if (trangThai == 0) {
                    trangThai1 = "Ngừng bán";
                } else {
                    trangThai1 = "Đang bán";
                }
                model.addRow(new Object[]{row[0], row[1], row[3], row[7], trangThai1});
            }
            FillMaSP();
        } catch (Exception e) {
              getJOptionePane.methodThatUsesOptionPane(this, "Lỗi truy vấn dữ liệu sản phẩm");
            e.printStackTrace();
        }
    }

    public void fillComboBoxLoaiSP() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiSP.getModel();
        DefaultComboBoxModel model1 = (DefaultComboBoxModel) cboFindLoai.getModel();
        model.removeAllElements();
        model1.removeAllElements();
        model1.insertElementAt("Tất cả", 0);
        cboFindLoai.setSelectedIndex(0);
        try {
            List<LoaiSanPham> list = lspDao.selectAll();
            for (LoaiSanPham cd : list) {
                model.addElement(cd);

                Object[] row = {
                    cd.getLoaiSP()
                };

                // Thêm từng phần tử của mảng vào model1
                for (Object element : row) {
                    model1.addElement(element);
                }

            }
        } catch (Exception e) {
                getJOptionePane.methodThatUsesOptionPane(this, "Lỗi CD");
        }
    }

    public void hienThiHinh(String image) {
        ImageIcon image1 = new ImageIcon("images\\" + image);
        Image img = image1.getImage();
        Image scaledImg = img.getScaledInstance(175, 194, Image.SCALE_SMOOTH); // Chỉnh kích thước hình ảnh
        ImageIcon icon = new ImageIcon(scaledImg);
        lblHinh.setText("");
        lblHinh.setIcon(icon);
    }

    public void chonHinh() {
        try {
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                XImage.save(file);
                ImageIcon icon = XImage.read(file.getName());
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(175, 194, Image.SCALE_SMOOTH);
                jPanel2.setSize(175, 194);
                lblHinh.setSize(175, 194);
                ImageIcon scaledIcon = new ImageIcon(scaledImg);
                lblHinh.setIcon(scaledIcon);
                lblHinh.setToolTipText(file.getName());
                lblHinh.setText("");

            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        // TODO add your handling code here:
    }

    public void insert() {
        if (ValidateForm()) {
            return;
        }
//        XValidate.checkMaNV(txtMa);
        SanPham sp = this.getForm();
        try {
            spDao.insert(sp); // thêm mới
            this.fillTable(); // đỗ lại bảng
            this.clearForm(); // xóa trắng form
              getJOptionePane.methodThatUsesOptionPane(this, "Thêm sản phẩm thành công!");
        } catch (Exception e) {
              getJOptionePane.methodThatUsesOptionPane(this, "Thêm sản phẩm mới thất bại!");
            e.printStackTrace();
        }
    }

    public void update() {
        if (ValidateForm()) {
            return;
        }
        SanPham sp = this.getForm();

        try {
            spDao.update(sp); // cập nhật
            this.fillTable(); // đổ lại bảng
            clearForm();
              getJOptionePane.methodThatUsesOptionPane(this, "Cập nhật sản phẩm thành công!");
        } catch (Exception e) {
              getJOptionePane.methodThatUsesOptionPane(this, "Cập nhật sản phẩm thất bại!");
            e.printStackTrace();
        }

    }

    public void delete() {
//        if (!XAuth.isManager()) {
//              getJOptionePane.methodThatUsesOptionPane(this, "Chỉ trưởng phòng mới được phép xóa nhân viên!");
//        } else 
        {
//            String manv = txtMaSP.getText();
//            if (manv.equals(XAuth.user.getMaNV())) {
//                  getJOptionePane.methodThatUsesOptionPane(this, "Bạn không được phép xóa chính mình!");
//            } else if (XDialog.confirm(this, "Bạn có thực sự muốn xóa nhân viên này không?")) {
            try {
                spDao.delete(txtMaSP.getText());
                this.fillTable();
                this.clearForm();
                  getJOptionePane.methodThatUsesOptionPane(this, "Xóa sản phẩm thành công!");
            } catch (Exception e) {
                  getJOptionePane.methodThatUsesOptionPane(this, "Xóa sản phẩm thất bại!");
                e.printStackTrace();
            }
            //       }
        }
    }

    public SanPham getForm() {
        SanPham sp = new SanPham();
        sp.setMaSP(txtMaSP.getText());
        sp.setTenSP(txtTenSP.getText());
        sp.setGia(Double.parseDouble(txtGiaSP.getText()));
        List<LoaiSanPham> listlsp = lspDao.selectAll();
        for (LoaiSanPham loaiSanPham : listlsp) {
            if (cboLoaiSP.getSelectedItem().toString().equals(loaiSanPham.getLoaiSP())) {
                sp.setLoaiSP(loaiSanPham.getMaLoaiSP());
                break;
            }
        }
        boolean TrangThai;
        int trangThaiIndex = cboTrangThai.getSelectedIndex();
        if (trangThaiIndex == 1) {
            TrangThai = true; // Đang bán
        } else {
            TrangThai = false; // Ngừng bán
        }
        sp.setTrangThai(TrangThai);
        sp.setGhiChu(txtGhiChu.getText());
        sp.setHinh(lblHinh.getToolTipText());
        return sp;
    }

    public void setForm(SanPham sp) {
        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
        txtGiaSP.setText(String.valueOf(sp.getGia()));
        if (sp.isTrangThai()) {
            cboTrangThai.setSelectedIndex(1);
        } else {
            cboTrangThai.setSelectedIndex(2);
        }
        String lsp = (String) tblSanPham.getValueAt(row, 3);
        int selectedIndex = -1;
        List<LoaiSanPham> listlsp = lspDao.selectAll();
        for (LoaiSanPham loaiSanPham : listlsp) {
            if (sp.getLoaiSP().equals(loaiSanPham.getMaLoaiSP())) {
                lsp = loaiSanPham.getLoaiSP();
                selectedIndex = listlsp.indexOf(loaiSanPham);
                break;
            }
        }
        cboLoaiSP.setSelectedIndex(selectedIndex);
        txtGhiChu.setText(sp.getGhiChu());
        lblHinh.setIcon(XImage.read("NoImage.png"));

        if (sp.getHinh() != null && !sp.getHinh().equals("")) {
            lblHinh.setToolTipText(sp.getHinh());
            try {
                ImageIcon imgIcon = new ImageIcon(getClass().getResource("/com/image/" + sp.getHinh().toString()));
                Image img = imgIcon.getImage();
                lblHinh.setIcon(new ImageIcon(img.getScaledInstance(175, 195, 0)));
            } catch (Exception e) {
            }
        }
    }

    public void edit() {
        String maSP = (String) tblSanPham.getValueAt(this.row, 0);
        SanPham sp = spDao.selectById(maSP);
        this.setForm(sp);
        this.updateStatus();
    }

    public void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblSanPham.getRowCount() - 1);
        // Trạng thái form
        txtMaSP.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);

        // Trạng thái điều hướng
    }

    public void clearForm() {
        this.row = -1;
        this.updateStatus();
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtGiaSP.setText("");
        //  cboLoaiSP.setSelectedIndex(0);
        cboTrangThai.setSelectedIndex(0);
        txtGhiChu.setText("");
        lblHinh.setIcon(null);
        FillMaSP();
    }

    public void FillMaSP() {
        List<Object[]> list = spDao.getSanPhamFull();
        if (!list.isEmpty()) {
            Object[] lastRow = list.get(list.size() - 1);
            if (lastRow.length > 0) {
                Object lastMaSP = lastRow[0];
                String inputString = String.valueOf(lastMaSP);
                String[] parts = inputString.split("(?<=\\D)(?=\\d)");
                int SoMa = 1 + Integer.parseInt(parts[1]);
                String maSP = parts[0] + String.valueOf(SoMa);
                txtMaSP.setText(maSP);
            }
        }
    }

    public void search(String keyword) {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        try {
            List<Object[]> list = spDao.selectByKeyword(keyword);
            for (Object[] row : list) {
                String trangThai = null;
                if (String.valueOf(row[5]).equals("false")) {
                    trangThai = "Ngừng bán";
                } else {
                    trangThai = "Đang bán";
                }
                model.addRow(new Object[]{row[0], row[1], row[2], row[3], trangThai});
            }
            FillMaSP();
        } catch (Exception e) {
              getJOptionePane.methodThatUsesOptionPane(this, "Lỗi truy vấn dữ liệu nhân viên!");
            e.printStackTrace();
        }

        // Không cần fillTable() ở đây.
        this.clearForm();
        this.row = -1;
        this.updateStatus();
    }

    public void Loc() {
        String key2 = (String) cboFindLoai.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        if (cboFindLoai.getSelectedIndex() == 0) {
            fillTable();
        } else {
            search(key2);
        }
        this.clearForm();
        this.row = -1;
        this.updateStatus();
    }

    public boolean ValidateForm() {
        int check = 0;
        if (txtMaSP.getText().isEmpty()) {
            ErrorMaSP.setText("Không được trống!");
            check = 1;
        } else {
            ErrorMaSP.setText("");
        }

        if (txtTenSP.getText().isEmpty()) {
            ErrorTenSP.setText("Không được trống!");
            check = 1;
        } else {
            ErrorTenSP.setText("");
        }

        if (txtGiaSP.getText().isEmpty()) {
            ErrorGiaSP.setText("Không được trống!");
            check = 1;
        } else {
            ErrorGiaSP.setText("");
        }

        try {
            Double.parseDouble(txtGiaSP.getText());
        } catch (NumberFormatException e) {
            ErrorGiaSP.setText("Sai định dạng!");
            check = 1;
        }

        if (cboTrangThai.getSelectedIndex() == 0) {
            ErrorTrangThai.setText("Chưa chọn trạng thái!");
            check = 1;
        } else {
            ErrorTrangThai.setText("");
        }
        if (lblHinh.getIcon() == null) {
            lblHinh.setText("Vui lòng chọn hình!");
            check = 1;
        } else {
            lblHinh.setText("");
        }

        if (check == 1) {
            return true;
        } else {
            return false;
        }

    }

}
