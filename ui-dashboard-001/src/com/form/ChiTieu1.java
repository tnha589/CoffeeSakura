/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.form;

import com.Dao.ChiTieuDao;
import com.untils.XDialog;
import com.untils.getJOptionePane;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import com.untils.XDate;
import com.model.ChiTieu;
import com.untils.XAuth;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ChiTieu1 extends javax.swing.JPanel {

    ChiTieuDao CTD = new ChiTieuDao();
    List<Integer> listMaHD = new ArrayList<>();
    int row = -1;

    public ChiTieu1() {
        initComponents();
        init();
    }

    public void init() {
        fillTable();
        fillTable2();
        loadNameNV();
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblChiTieu.getModel();
        model.setRowCount(0);
        //listMaHD.clear();
        try {
            List<ChiTieu> list = CTD.selectAll();
            for (ChiTieu CT : list) {
                // listMaHD.add(CT.getMaHD());
                Object[] row = {
                    CT.getMaHD(),
                    CT.getTenNV(),
                    CT.getTien(),
                    CT.getThoiGian(),
                    CT.getGhiChu()};

                model.addRow(row);
            }
        } catch (Exception e) {
          getJOptionePane.methodThatUsesOptionPane(this, "Lỗi truy vấn dữ liệu Chi Tieu");
            e.printStackTrace();
        }
    }

    public ChiTieu getForm() {
        ChiTieu CT = new ChiTieu();
        CT.setTenNV(txtTenNV.getText());
        CT.setTien(Double.parseDouble(txtTien.getText()));
        CT.setThoiGian(txtNgayLay.getDate());
        CT.setGhiChu(txtGhiChu.getText());
        return CT;
    }

    public void setForm(ChiTieu CT) {
        txtTenNV.setText(CT.getTenNV());
        txtTien.setText(String.valueOf(CT.getTien()));
        txtNgayLay.setDate(CT.getThoiGian());
        txtGhiChu.setText(CT.getGhiChu());
    }

    public void edit() {
        int makh = (int) tblChiTieu.getValueAt(this.row, 0);
        ChiTieu kh = CTD.selectById(makh);
        this.setForm(kh);
    }

    public void clearForm() {
        ChiTieu ct = new ChiTieu();
        this.setForm(ct);
        txtTien.setText("");
        row = -1;
    }

    public void them() {
        ChiTieu nv = this.getForm();
        try {
            CTD.insert(nv); // thêm mới
            this.fillTable(); // đỗ lại bảng
            this.clearForm(); // xóa trắng form
          getJOptionePane.methodThatUsesOptionPane(this, "Thêm hóa đơn thành công!");
        } catch (Exception e) {
          getJOptionePane.methodThatUsesOptionPane(this, "Thêm hóa đơn thất bại!");
            e.printStackTrace();
        }
        fillTable2();
    }

    public void fillTable2() {
        DefaultTableModel model = (DefaultTableModel) tblLichSu.getModel();
        model.setRowCount(0);
        listMaHD.clear();
        try {
            List<ChiTieu> list = CTD.selectAll();
            for (ChiTieu CT : list) {
                listMaHD.add(CT.getMaHD());
                Object[] row = {
                    CT.getMaHD(),
                    CT.getTenNV(),
                    CT.getTien(),
                    CT.getThoiGian(),
                    CT.getGhiChu(),
                    CT.isTrangThai() ? "Xác nhận" : "Không xác nhân"};

                model.addRow(row);
            }
        } catch (Exception e) {
          getJOptionePane.methodThatUsesOptionPane(this, "Lỗi truy vấn dữ liệu lịch sử Chi Tieu");
            e.printStackTrace();
        }
    }

    public ChiTieu getForm2() {
        ChiTieu CT = new ChiTieu();
        CT.setMaHD((int) tblLichSu.getValueAt(row, 0));
        if (rboXacNhan.isSelected()) {
            CT.setTrangThai(true);
        } else {
            CT.setTrangThai(false);
        }
        return CT;
    }

    public void setForm2(ChiTieu CT) {
        lblTenNV.setText(CT.getTenNV());
        lblTien.setText(String.valueOf(CT.getTien()));
        lblNgay.setText(XDate.toString(CT.getThoiGian()));
        txtGhiChu2.setText(CT.getGhiChu());
        rboKoXacNhan.setSelected(!CT.isTrangThai());
        rboXacNhan.setSelected(CT.isTrangThai());
    }

    public void edit2() {
        int makh = (int) tblChiTieu.getValueAt(this.row, 0);
        ChiTieu kh = CTD.selectById(makh);
        this.setForm2(kh);
    }

    public void CapNhat() {
        ChiTieu CT = this.getForm2();
        try {
            System.out.println("" + CT.getMaHD() + CT.isTrangThai());
            CTD.update(CT);
            this.fillTable2();
            clearLable();
          getJOptionePane.methodThatUsesOptionPane(this, "Đã xác nhận thành công!");
        } catch (Exception e) {
          getJOptionePane.methodThatUsesOptionPane(this, "Lỗi! Không thể cập nhật");
            e.printStackTrace();
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

        btngTrangThai = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtTenNV = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTieu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnXacNhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        txtNgayLay = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLichSu = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rboXacNhan = new javax.swing.JRadioButton();
        rboKoXacNhan = new javax.swing.JRadioButton();
        btnCapNhat = new javax.swing.JButton();
        btnHUy = new javax.swing.JButton();
        lblTenNV = new javax.swing.JLabel();
        lblTien = new javax.swing.JLabel();
        lblNgay = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhiChu2 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(244, 154, 157));

        jTabbedPane1.setBackground(new java.awt.Color(244, 154, 157));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(244, 154, 157));

        txtTenNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblChiTieu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblChiTieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên NV", "Số tiền", "Ngày lấy", "Ghi chú"
            }
        ));
        tblChiTieu.setSelectionBackground(new java.awt.Color(244, 100, 104));
        tblChiTieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTieuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChiTieu);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tên nhân viên:");

        txtTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Số tiền lấy:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ngày lấy:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGhiChu.setRows(5);
        txtGhiChu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ghi chú", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jScrollPane1.setViewportView(txtGhiChu);

        btnXacNhan.setBackground(new java.awt.Color(175, 42, 46));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Accept.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(41, 157, 175));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-cancel-25.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        txtNgayLay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jScrollPane1)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayLay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNgayLay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lấy tiền", jPanel2);

        jPanel3.setBackground(new java.awt.Color(244, 154, 157));

        tblLichSu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblLichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Tên NV", "Số tiền", "Ngày ", "Ghi chú", "Trạng thái"
            }
        ));
        tblLichSu.setSelectionBackground(new java.awt.Color(244, 100, 104));
        tblLichSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLichSuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblLichSu);

        jPanel5.setBackground(new java.awt.Color(244, 154, 157));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Trạng thái");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setText("Xác nhận trạng thái");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Tên Nhân viên:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Số tiền:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Ngày lấy:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Ghi chú:");

        btngTrangThai.add(rboXacNhan);
        rboXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rboXacNhan.setText("Xác nhận");

        btngTrangThai.add(rboKoXacNhan);
        rboKoXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rboKoXacNhan.setText("Không xác nhận");

        btnCapNhat.setBackground(new java.awt.Color(175, 42, 46));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnHUy.setBackground(new java.awt.Color(41, 117, 175));
        btnHUy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHUy.setForeground(new java.awt.Color(255, 255, 255));
        btnHUy.setText("Hủy");
        btnHUy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHUyActionPerformed(evt);
            }
        });

        lblTenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenNV.setForeground(new java.awt.Color(0, 0, 204));
        lblTenNV.setText("---------------");

        lblTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTien.setForeground(new java.awt.Color(0, 0, 204));
        lblTien.setText("---------------");

        lblNgay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNgay.setForeground(new java.awt.Color(0, 0, 204));
        lblNgay.setText("---------------");

        txtGhiChu2.setColumns(20);
        txtGhiChu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGhiChu2.setRows(5);
        jScrollPane4.setViewportView(txtGhiChu2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel5))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(lblTien, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel4))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rboXacNhan)
                                    .addComponent(jLabel8))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(rboKoXacNhan))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel9)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(btnHUy, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblTien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rboXacNhan)
                            .addComponent(rboKoXacNhan))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHUy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lịch sử", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void btnHUyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHUyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHUyActionPerformed

    public void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    public void txtTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienActionPerformed

    public void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_btnXacNhanActionPerformed

    public void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        //   clearForm();
    }//GEN-LAST:event_btnHuyActionPerformed

    public void tblChiTieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTieuMouseClicked
        // TODO add your handling code here:
        this.row = tblChiTieu.getSelectedRow();
        this.edit();
    }//GEN-LAST:event_tblChiTieuMouseClicked

    public void tblLichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichSuMouseClicked
        // TODO add your handling code here:
        this.row = tblLichSu.getSelectedRow();
        this.edit2();
    }//GEN-LAST:event_tblLichSuMouseClicked

    public void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        CapNhat();
    }//GEN-LAST:event_btnCapNhatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCapNhat;
    public javax.swing.JButton btnHUy;
    public javax.swing.JButton btnHuy;
    public javax.swing.JButton btnXacNhan;
    public javax.swing.ButtonGroup btngTrangThai;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JLabel lblNgay;
    public javax.swing.JLabel lblTenNV;
    public javax.swing.JLabel lblTien;
    public javax.swing.JRadioButton rboKoXacNhan;
    public javax.swing.JRadioButton rboXacNhan;
    public javax.swing.JTable tblChiTieu;
    public javax.swing.JTable tblLichSu;
    public javax.swing.JTextArea txtGhiChu;
    public javax.swing.JTextArea txtGhiChu2;
    public com.toedter.calendar.JDateChooser txtNgayLay;
    public javax.swing.JTextField txtTenNV;
    public javax.swing.JTextField txtTien;
    // End of variables declaration//GEN-END:variables
public void loadNameNV() {
        txtTenNV.setEnabled(false);
        if (XAuth.isLogin()) {
            String tenNV = XAuth.user.getTenNV();
            txtTenNV.setText(tenNV);
        }

    }

public void clearLable(){
lblTenNV.setText("---------------");
lblTien.setText("---------------");
btngTrangThai.clearSelection();
lblNgay.setText("---------------");
txtGhiChu2.setText("");
}

public javax.swing.JTabbedPane getjTabbedPane1() {
	return jTabbedPane1;
}

public void setjTabbedPane1(javax.swing.JTabbedPane jTabbedPane1) {
	this.jTabbedPane1 = jTabbedPane1;
}


}
