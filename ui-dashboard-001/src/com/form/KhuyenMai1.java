/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.form;

import com.model.KhuyenMai;
import com.model.SanPham;
import com.Dao.KhuyenMaiDao;
import com.Dao.sanPhamDao;
import com.untils.XDate;
import com.untils.XDialog;
import com.untils.getJOptionePane;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class KhuyenMai1 extends javax.swing.JPanel {

	public List<KhuyenMai> listKM = new ArrayList<>();

	public KhuyenMai1() {
		initComponents();
		init();

	}

	public void init() {
		fillTableKM();
		fillTableSP();
		clickCheckBox();
		btnCapNhat.setEnabled(false);
		row2 = -1;
	}

	boolean flag = true;
	public String message = "";

	boolean kiemTraInsert() {
		// String pattenGiaTri = "\\d+(\\.\\d+)?";

		// Bắt lỗi Mã khuyến mãi
		if (txtMaKM.getText().isBlank()) {
			XDialog.alert(this, message = "Hãy điền mã khuyến mãi!");
			flag = false;
		} else if (txtMaKM.getText().length() > 7) {
			XDialog.alert(this, "Mã khuyến mãi quá dài");
			flag = false;
		} else if (daokm.selectById(txtMaKM.getText()) != null) {
			XDialog.alert(this, message = "Mã khuyến mãi đã tồn tại!");
			flag = false;
		}
		// Bắt lỗi tên khuyến mãi

		if (txtTenKM.getText().isBlank()) {
			XDialog.alert(this, message = "hãy nhập tên khuyến mãi!");
			flag = false;
		}
		try {
			// bắt lỗi giá trị khuyến mãi
			if (txtGiaTri.getText().isBlank()) {
				XDialog.alert(this, message = "hãy nhập giá khuyến mãi!");
				flag = false;
			} else if (Double.parseDouble(txtGiaTri.getText()) > 10 || Double.parseDouble(txtGiaTri.getText()) <= 0) {
				XDialog.alert(this, message = "Giá khuyến mãi chưa phù hợp!");
				flag = false;
			}
		} catch (Exception e) {
			XDialog.alert(this, message = "Giá khuyến mãi chỉ nhập số!");
			flag = false;
		}

		// kiểm tra trang thái / loại khuyến mãi
		if (!rdoDaKetThuc.isSelected() && !rdoDangDienRa.isSelected()) {
			XDialog.alert(this, message = "Vui lòng chọn trạng thái!");
			flag = false;
		}
		if (!rdoPhanTram.isSelected() && !rdoVND.isSelected()) {
			XDialog.alert(this, message = "Vui lòng chọn loại khuyến mãi");
			flag = false;
		}
		// Kiểm tra JDateChoser
		if (txtNgayBD.getDate() == null || txtNgayKT.getDate() == null) {
			XDialog.alert(this, message = "Vui lòng chọn ngày khuyến mãi");
			flag = false;
		}
		if (!txtNgayBD.getDate().before(txtNgayKT.getDate())) {
			// Ngày BD trước Ngày KT, hợp lệ
			XDialog.alert(this, message = "Vui lòng chọn ngày khuyến mãi phù hợp");
			flag = false;

		}
		return flag;
	}

	boolean kiemTraUpdate() {
		// Bắt lỗi Mã khuyến mãi
//        if (txtMaKM.getText().isBlank()) {
//            XDialog.alert(this, "Hãy điền mã khuyến mãi!");
//            flag = false;
//        } else if (txtMaKM.getText().length() > 7) {
//            XDialog.alert(this, "Mã khuyến mãi quá dài");
//            flag = false;
//        } else if (daokm.selectById(txtMaKM.getText()) != null) {
//            XDialog.alert(this, "Mã khuyến mãi đã tồn tại!");
//            flag = false;
//        }
		// Bắt lỗi tên khuyến mãi

		if (txtTenKM.getText().isBlank()) {
			XDialog.alert(this, "hãy nhập tên khuyến mãi!");
			flag = false;
		}
		try {
			// bắt lỗi giá trị khuyến mãi
			if (txtGiaTri.getText().isBlank()) {
				XDialog.alert(this, message = "hãy nhập giá khuyến mãi!");
				flag = false;
			} else if (Double.parseDouble(txtGiaTri.getText()) > 10 || Double.parseDouble(txtGiaTri.getText()) <= 0) {
				XDialog.alert(this, message = "Giá khuyến mãi chưa phù hợp!");
				flag = false;
			}
		} catch (Exception e) {
			XDialog.alert(this, message = "Giá khuyến mãi chỉ nhập số!");
			flag = false;
		}

		// kiểm tra trang thái / loại khuyến mãi
		if (!rdoDaKetThuc.isSelected() && !rdoDangDienRa.isSelected()) {
			XDialog.alert(this, message = "Vui lòng chọn trạng thái!");
			flag = false;
		}
		if (!rdoPhanTram.isSelected() && !rdoVND.isSelected()) {
			XDialog.alert(this, message = "Vui lòng chọn loại khuyến mãi");
			flag = false;
		}
		// Kiểm tra JDateChoser
		if (txtNgayBD.getDate() == null || txtNgayKT.getDate() == null) {
			XDialog.alert(this, message = "Vui lòng chọn ngày khuyến mãi");
			flag = false;
		}
		if (!txtNgayBD.getDate().before(txtNgayKT.getDate())) {
			// Ngày BD trước Ngày KT, hợp lệ
			XDialog.alert(this, message = "Vui lòng chọn ngày khuyến mãi phù hợp");
			flag = false;

		}
		return flag;
	}

	KhuyenMaiDao daokm = new KhuyenMaiDao();
	sanPhamDao daosp = new sanPhamDao();
//    KhuyenMai km = new KhuyenMai();
//    loaiSanPhamDao daolsp = new loaiSanPhamDao();
	// int row = 0;
	int row2 = -1;
	// Date currentDate = new Date();

	void fillTableKM() {
		DefaultTableModel model = (DefaultTableModel) tblKhuyenMai.getModel();
		model.setRowCount(0);
		try {
			List<KhuyenMai> list = daokm.selectAll(); // đọc all dữ liệu từ cơ sở dữ liệu
			for (KhuyenMai khuyenMai : list) {
				Object[] row = { khuyenMai.getMaKM(), khuyenMai.getTenKM(), khuyenMai.isLoaiKM() ? "%" : "VNĐ",
						khuyenMai.getGiaKM(), khuyenMai.isTrangThai() ? "Đang diễn ra" : "Đã kết thúc", };

				model.addRow(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
		}
	}

	void fillTableSP() {
		DefaultTableModel model = (DefaultTableModel) tblSanPam.getModel();
		model.setRowCount(0);
		try {
			List<SanPham> list1 = daosp.selectAll();
			List<KhuyenMai> list2 = daokm.selectAll(); // đọc all dữ liệu từ cơ sở dữ liệu
			float GiamGia = 0;
			boolean click = false;
			for (SanPham sp : list1) {
				if (sp.getKhuyenMai() != null) {
					for (KhuyenMai km : list2) {
						if (sp.getKhuyenMai().equals(km.MaKM)) {
							click = true;
							// System.out.println("co ma giong");
							if (km.LoaiKM == true) {
								// float phanTramGiamGia = km.GiaKM; // GiaKM chứa phần trăm giảm giá
								GiamGia = (float) (sp.getGia() - (sp.getGia() * (km.GiaKM / 100)));
							} else {
								GiamGia = (float) (sp.getGia() - km.GiaKM);
							}
						}

					}

				} else {
					click = false;
					GiamGia = 0;
				}
				// System.out.println("" + click);
				Object[] row = { sp.getMaSP(), sp.getTenSP(), sp.getGia(), GiamGia + " VND", click, sp.getKhuyenMai() };
				model.addRow(row);// thêm một hàng vào table
			}
		} catch (Exception e) {
			e.printStackTrace();
			// MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
		}
	}

	void edit() {
		try {
			String MaKM = (String) tblKhuyenMai.getValueAt(this.row2, 0);
			KhuyenMai model = daokm.selectById(MaKM);
			if (model != null) {// Tìm thấy dữ liệu
				setForm(model);
				// updateStatus();
			} else {
				getJOptionePane.methodThatUsesOptionPane(this, "Lỗi truy vấn dữ liệu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void setForm(KhuyenMai km) throws ParseException {
		txtMaKM.setText(km.getMaKM());
		txtTenKM.setText(km.getTenKM());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Định dạng ngày tháng
//        Date date1 = sdf.parse(km.getNgayBD()); // Chuyển đổi ngày tháng thành đối tượng Date
		txtNgayBD.setDate(km.getNgayBD());
		txtNgayKT.setDate(km.getNgayKT());
		rdoDangDienRa.setSelected(km.isTrangThai());
		rdoDaKetThuc.setSelected(!km.isTrangThai());
		rdoPhanTram.setSelected(km.isLoaiKM());
		rdoVND.setSelected(!km.isLoaiKM());
		txtGiaTri.setText(String.valueOf(km.getGiaKM()));
	}

	KhuyenMai getForm() {
		KhuyenMai km = new KhuyenMai();
		km.setMaKM(txtMaKM.getText());
		km.setTenKM(txtTenKM.getText());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Date ngayBDDate = txtNgayBD.getDate();
		Date ngayKTDate = txtNgayKT.getDate();

		String ngayBDString = dateFormat.format(ngayBDDate);
		String ngayKTString = dateFormat.format(ngayKTDate);

		km.setNgayBD(XDate.toDate(ngayBDString, "dd-MM-yyyy"));
		km.setNgayKT(XDate.toDate(ngayKTString));
		km.setLoaiKM(rdoPhanTram.isSelected());
		km.setTrangThai(rdoDangDienRa.isSelected());
		km.setGiaKM(Float.parseFloat(txtGiaTri.getText()));
		return km;
	}

	public void TimKhuyenMai1(String str) {
		DefaultTableModel model = (DefaultTableModel) tblKhuyenMai.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		tblKhuyenMai.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}

	public void TimSanPham1(String str) {
		DefaultTableModel model = (DefaultTableModel) tblSanPam.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		tblSanPam.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
		// row2 = -1;
	}

	void insert() {
		KhuyenMai nv = getForm();
		try {
			daokm.insert(nv);
			this.fillTableKM();
			getJOptionePane.methodThatUsesOptionPane(this, "Thêm mới thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		clearForm();
	}

	void update() {
		KhuyenMai nv = getForm();

		try {
			daokm.update(nv);
			this.fillTableKM();
			getJOptionePane.methodThatUsesOptionPane(this, "Cập nhật thành công!");
			row2 = -1;
			fillTableSP();
		} catch (Exception e) {
			e.printStackTrace();
			// MsgBox.alert(this, "Cập nhật thất bại!");
		}

		clearForm();
	}

	void clearForm() {
		txtMaKM.setText("");
		txtTenKM.setText("");
		txtGiaTri.setText("");
		txtNgayBD.setDate(null);
		txtNgayKT.setDate(null);
		btgHTKM.clearSelection();
		btgTrangThai.clearSelection();
		btnThem.setEnabled(true);
		btnCapNhat.setEnabled(false);
		txtMaKM.setEditable(true);
		// this.updateStatus();
	}

	void delete() {
		String maNV = (String) tblKhuyenMai.getValueAt(row2, 0);
		if (XDialog.confirm(this, "Bạn thật sự muốn xóa khuyến mãi này?")) {
			try {
				daokm.delete(maNV);
				this.fillTableKM();
				this.clearForm();
				XDialog.alert(this, "Xóa thành công");
			} catch (Exception e) {
				XDialog.alert(this, "Xóa thất bại");
			}

			clearForm();
		}
	}

	void LocKhuyenMai() {
		DefaultTableModel model = (DefaultTableModel) tblKhuyenMai.getModel();
		model.setRowCount(0);
		try {
			int number = cboKhuyenMai.getSelectedIndex();

			List<KhuyenMai> list = daokm.selectLoaiKM(number); // đọc all dữ liệu từ cơ sở dữ liệu
			for (KhuyenMai nh : list) {
				Object[] row = { nh.getMaKM(), nh.getTenKM(), nh.isLoaiKM() ? "%" : "VNĐ", nh.getGiaKM(),
						nh.isTrangThai() ? "Đang diễn ra" : "Đã kết thúc" };
				model.addRow(row);
			}
		} catch (Exception e) {
			getJOptionePane.methodThatUsesOptionPane(this, "Lỗi truy vấn dữ liệu!");
		}
	}

	void clickCheckBox() {
		for (int row : tblSanPam.getSelectedRows()) {
			Object value = tblSanPam.getValueAt(row, 4);
			SanPham sp = new SanPham();

			if (value instanceof Boolean) {
				boolean isChecked = (boolean) value;

				if (isChecked) {
					if (row2 != -1 && isChecked) {
						tblSanPam.setEnabled(true);
					} else {
						tblSanPam.setEnabled(false);

						XDialog.alert(this, "Bạn chưa chọn mã khuyến mãi!");
						tblSanPam.setValueAt(false, row, 4);
						tblSanPam.setEnabled(true);
						return;
					}

					if (tblKhuyenMai.getValueAt(row2, 4).equals("Đã kết thúc")) {
						tblSanPam.setEnabled(false);

						XDialog.alert(this, "Khuyến mãi đã kết thúc!");
						tblSanPam.setValueAt(false, row, 4);
						tblSanPam.setEnabled(true);
						return;
					}

					try {

						float khuyenMaiDouble = (Float) tblKhuyenMai.getValueAt(row2, 3);
						double sanPhamDouble = (Double) tblSanPam.getValueAt(row, 2);

						if (khuyenMaiDouble > sanPhamDouble && tblKhuyenMai.getValueAt(row2, 2).equals("VNĐ")) {
							tblSanPam.setEnabled(false);
							XDialog.alert(this, "Giá khuyến mãi lớn hơn giá trị sản phẩm!");
							tblSanPam.setValueAt(false, row, 4);
							tblSanPam.setEnabled(true);
							return;
						}

					} catch (NumberFormatException e) {
						e.printStackTrace();
					}

					row2 = tblKhuyenMai.getSelectedRow();

					row = tblSanPam.getSelectedRow();
					String MaKM = (String) tblKhuyenMai.getValueAt(row2, 0);

					String MaSP = (String) tblSanPam.getValueAt(row, 0);
					daokm.UpdateKM(MaKM, MaSP);
					// System.out.println("" + MaKM + MaSP);
					fillTableSP();

				} else {
					row = tblSanPam.getSelectedRow();
					String MaSP = (String) tblSanPam.getValueAt(row, 0);
					daokm.UpdateKM(null, MaSP);
					fillTableSP();
				}

			}

		}
	}

//    public void fillComboBoxKM() {
//        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiSanPham1.getModel();
//        model.removeAllElements();
//        List<String> list = daosp.selectTenLSP();
//        for (String sp : list) {
//            model.addElement(sp);
//        }
//    }
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	public void initComponents() {

		btgHTKM = new javax.swing.ButtonGroup();
		btgTrangThai = new javax.swing.ButtonGroup();
		cboLoaiSanPham = new javax.swing.JComboBox<>();
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		txtMaKM = new javax.swing.JTextField();
		txtGiaTri = new javax.swing.JTextField();
		txtTenKM = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		rdoPhanTram = new javax.swing.JRadioButton();
		rdoDangDienRa = new javax.swing.JRadioButton();
		rdoDaKetThuc = new javax.swing.JRadioButton();
		jPanel4 = new javax.swing.JPanel();
		btnMoi1 = new javax.swing.JButton();
		txtNgayBD = new com.toedter.calendar.JDateChooser();
		txtNgayKT = new com.toedter.calendar.JDateChooser();
		rdoVND = new javax.swing.JRadioButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		btnThem = new javax.swing.JButton();
		btnCapNhat = new javax.swing.JButton();
		btnMoi = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		txtTenKM1 = new javax.swing.JTextField();
		cboKhuyenMai = new javax.swing.JComboBox<>();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblSanPam = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		tblKhuyenMai = new javax.swing.JTable();
		txtTenSP = new javax.swing.JTextField();

		cboLoaiSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		cboLoaiSanPham.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "--Tất cả--", "Đồ ăn vặt", "Nước uống", " " }));
		cboLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cboLoaiSanPhamActionPerformed(evt);
			}
		});

		setPreferredSize(new java.awt.Dimension(1042, 715));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jPanel2.setBackground(new java.awt.Color(244, 154, 157));
		jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		txtMaKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		txtMaKM.setBorder(null);
		txtMaKM.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtMaKMActionPerformed(evt);
			}
		});

		txtGiaTri.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		txtGiaTri.setForeground(new java.awt.Color(0, 0, 204));
		txtGiaTri.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giá trị khuyến mãi",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
		txtGiaTri.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtGiaTriActionPerformed(evt);
			}
		});

		txtTenKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		txtTenKM.setBorder(null);
		txtTenKM.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtTenKMActionPerformed(evt);
			}
		});

		jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabel6.setText("Hình thức khuyến mãi:");

		jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabel7.setText("Trạng thái:");

		btgHTKM.add(rdoPhanTram);
		rdoPhanTram.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		rdoPhanTram.setText("%");

		btgTrangThai.add(rdoDangDienRa);
		rdoDangDienRa.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		rdoDangDienRa.setText("Đang diễn ra");

		btgTrangThai.add(rdoDaKetThuc);
		rdoDaKetThuc.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		rdoDaKetThuc.setText("Đã kết thúc");

		jPanel4.setBackground(new java.awt.Color(244, 154, 157));

		btnMoi1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnMoi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-voucher-25.png"))); // NOI18N
		btnMoi1.setText("Tạo voucher");
		btnMoi1.setPreferredSize(new java.awt.Dimension(72, 40));
		btnMoi1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnMoi1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(btnMoi1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel4Layout.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE).addComponent(btnMoi1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(17, 17, 17)));

		txtNgayBD.setDateFormatString("dd-MM-yyyy");
		txtNgayBD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		txtNgayKT.setDateFormatString("dd-MM-yyyy");
		txtNgayKT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		btgHTKM.add(rdoVND);
		rdoVND.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		rdoVND.setText("VND");

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel1.setText("Ngày kết thúc:");

		jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel2.setText("Ngày bắt đầu:");

		jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel3.setText("Tên khuyến mãi:");

		jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel4.setText("Mã khuyến mãi:");

		btnThem.setBackground(new java.awt.Color(175, 42, 46));
		btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnThem.setForeground(new java.awt.Color(255, 255, 255));
		btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/Add.png"))); // NOI18N
		btnThem.setText("Thêm");
		btnThem.setPreferredSize(new java.awt.Dimension(72, 40));
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemActionPerformed(evt);
			}
		});

		btnCapNhat.setBackground(new java.awt.Color(175, 41, 120));
		btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
		btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-update-25.png"))); // NOI18N
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setPreferredSize(new java.awt.Dimension(78, 40));
		btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCapNhatActionPerformed(evt);
			}
		});

		btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-reset-25.png"))); // NOI18N
		btnMoi.setText("Mới");
		btnMoi.setPreferredSize(new java.awt.Dimension(72, 40));
		btnMoi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnMoiActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addContainerGap()
								.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(28, 28, 28).addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addComponent(txtGiaTri).addGap(15, 15, 15))
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel2Layout.createSequentialGroup()
												.addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(14, 14, 14)
												.addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 426,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel4).addComponent(jLabel3).addComponent(jLabel2)
										.addComponent(jLabel1)
										.addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 426,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 426,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel6)
														.addGroup(jPanel2Layout.createSequentialGroup()
																.addComponent(rdoPhanTram).addGap(45, 45, 45)
																.addComponent(rdoVND)))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(jPanel2Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(jPanel2Layout.createSequentialGroup()
																		.addComponent(rdoDangDienRa).addGap(6, 6, 6)
																		.addComponent(rdoDaKetThuc))
																.addGroup(jPanel2Layout.createSequentialGroup()
																		.addGap(24, 24, 24).addComponent(jLabel7))))
												.addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 426,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(0, 0, Short.MAX_VALUE)))));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jLabel1).addGap(18, 18, 18)
						.addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel6).addGap(18, 18, 18)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(rdoPhanTram).addComponent(rdoVND)))
								.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel7).addGap(18, 18, 18)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(rdoDangDienRa).addComponent(rdoDaKetThuc))))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(87, 87, 87)));

		jPanel3.setBackground(new java.awt.Color(244, 154, 157));
		jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		txtTenKM1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm khuyến mãi",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 2, 14))); // NOI18N
		txtTenKM1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtTenKM1ActionPerformed(evt);
			}
		});
		txtTenKM1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtTenKM1KeyReleased(evt);
			}
		});

		cboKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		cboKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VNĐ", "%", "Tất cả" }));
		cboKhuyenMai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại khuyến mãi",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 2, 14))); // NOI18N
		cboKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cboKhuyenMaiActionPerformed(evt);
			}
		});

		tblSanPam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		tblSanPam.setModel(
				new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null, null, null } },
						new String[] { "Mã SP", "Tên SP", "Giá gốc", "Đã giảm", "Chọn SP", "Mã KM" }) {
					Class[] types = new Class[] { java.lang.Object.class, java.lang.Object.class,
							java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class,
							java.lang.Object.class };
					boolean[] canEdit = new boolean[] { false, false, false, false, true, false };

					public Class getColumnClass(int columnIndex) {
						return types[columnIndex];
					}

					public boolean isCellEditable(int rowIndex, int columnIndex) {
						return canEdit[columnIndex];
					}
				});
		tblSanPam.setSelectionBackground(new java.awt.Color(244, 100, 104));
		tblSanPam.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblSanPamMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tblSanPam);
		if (tblSanPam.getColumnModel().getColumnCount() > 0) {
			tblSanPam.getColumnModel().getColumn(0).setPreferredWidth(30);
			tblSanPam.getColumnModel().getColumn(1).setPreferredWidth(120);
			tblSanPam.getColumnModel().getColumn(4).setPreferredWidth(30);
			tblSanPam.getColumnModel().getColumn(5).setPreferredWidth(30);
		}

		tblKhuyenMai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Mã KM", "Tên KM", "Loại KM", "Giá trị", "Trạng thái" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblKhuyenMai.setGridColor(new java.awt.Color(204, 204, 204));
		tblKhuyenMai.setSelectionBackground(new java.awt.Color(244, 126, 130));
		tblKhuyenMai.setShowGrid(true);
		tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblKhuyenMaiMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(tblKhuyenMai);

		txtTenSP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm sản phẩm",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 2, 18))); // NOI18N
		txtTenSP.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtTenSPKeyReleased(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
								.addComponent(txtTenKM1, javax.swing.GroupLayout.PREFERRED_SIZE, 283,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(27, 27, 27)
								.addComponent(cboKhuyenMai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
								jPanel3Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(txtTenSP,
										javax.swing.GroupLayout.PREFERRED_SIZE, 530,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(16, Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(43, 43, 43).addComponent(txtTenKM1))
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(24, 24, 24)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(34, 34, 34)
						.addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	public void txtMaKMActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtMaKMActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtMaKMActionPerformed

	public void txtGiaTriActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtGiaTriActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtGiaTriActionPerformed

	public void txtTenKMActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtTenKMActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtTenKMActionPerformed

	public void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCapNhatActionPerformed
		// TODO add your handling code here:
		if (kiemTraUpdate()) {
			update();
		} else {
			flag = true;
		}

	}// GEN-LAST:event_btnCapNhatActionPerformed

	public void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMoiActionPerformed

		clearForm();
	}// GEN-LAST:event_btnMoiActionPerformed

	public void cboLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboLoaiSanPhamActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cboLoaiSanPhamActionPerformed

	public void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblKhuyenMaiMouseClicked
		// TODO add your handling code here:
		btnCapNhat.setEnabled(true);
		btnThem.setEnabled(false);
		txtMaKM.setEditable(false);
		this.row2 = tblKhuyenMai.rowAtPoint(evt.getPoint());
		edit();

	}// GEN-LAST:event_tblKhuyenMaiMouseClicked

	public void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
		// TODO add your handling code here:
		if (kiemTraInsert()) {
			insert();
		} else {

			flag = true;
		}
	}// GEN-LAST:event_btnThemActionPerformed

	public void cboKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboKhuyenMaiActionPerformed
		// TODO add your handling code here:
		// selectKM();
		LocKhuyenMai();
	}// GEN-LAST:event_cboKhuyenMaiActionPerformed

	int row = 0;

	public void tblSanPamMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblSanPamMouseClicked

		clickCheckBox();

	}// GEN-LAST:event_tblSanPamMouseClicked

	public void txtTenKM1KeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtTenKM1KeyReleased
		// TODO add your handling code here:
		String timKiem = txtTenKM1.getText();
		TimKhuyenMai1(timKiem);
		row2 = -1;
		// tblSanPam.setEnabled(false);
	}// GEN-LAST:event_txtTenKM1KeyReleased

	public void txtTenSPKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtTenSPKeyReleased
		// TODO add your handling code here:
		String timKiem = txtTenSP.getText();
		TimSanPham1(timKiem);
	}// GEN-LAST:event_txtTenSPKeyReleased

	public void txtTenKM1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtTenKM1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtTenKM1ActionPerformed

	public void btnMoi1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMoi1ActionPerformed
		Voucher voucher = new Voucher(null, true);
		voucher.setVisible(true);
	}// GEN-LAST:event_btnMoi1ActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	public javax.swing.ButtonGroup btgHTKM;
	public javax.swing.ButtonGroup btgTrangThai;
	public javax.swing.JButton btnCapNhat;
	public javax.swing.JButton btnMoi;
	public javax.swing.JButton btnMoi1;
	public javax.swing.JButton btnThem;
	public javax.swing.JComboBox<String> cboKhuyenMai;
	public javax.swing.JComboBox<String> cboLoaiSanPham;
	public javax.swing.JLabel jLabel1;
	public javax.swing.JLabel jLabel2;
	public javax.swing.JLabel jLabel3;
	public javax.swing.JLabel jLabel4;
	public javax.swing.JLabel jLabel6;
	public javax.swing.JLabel jLabel7;
	public javax.swing.JPanel jPanel1;
	public javax.swing.JPanel jPanel2;
	public javax.swing.JPanel jPanel3;
	public javax.swing.JPanel jPanel4;
	public javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JScrollPane jScrollPane2;
	public javax.swing.JRadioButton rdoDaKetThuc;
	public javax.swing.JRadioButton rdoDangDienRa;
	public javax.swing.JRadioButton rdoPhanTram;
	public javax.swing.JRadioButton rdoVND;
	public javax.swing.JTable tblKhuyenMai;
	public javax.swing.JTable tblSanPam;
	public javax.swing.JTextField txtGiaTri;
	public javax.swing.JTextField txtMaKM;
	public com.toedter.calendar.JDateChooser txtNgayBD;
	public com.toedter.calendar.JDateChooser txtNgayKT;
	public javax.swing.JTextField txtTenKM;
	public javax.swing.JTextField txtTenKM1;
	public javax.swing.JTextField txtTenSP;

	// End of variables declaration//GEN-END:variables
	public javax.swing.JTextField getTxtTenKM1() {
		return txtTenKM1;
	}

	public void setTxtTenKM1(javax.swing.JTextField txtTenKM1) {
		this.txtTenKM1 = txtTenKM1;
	}

	public javax.swing.JComboBox<String> getCboKhuyenMai() {
		return cboKhuyenMai;
	}

	public void setCboKhuyenMai(javax.swing.JComboBox<String> cboKhuyenMai) {
		this.cboKhuyenMai = cboKhuyenMai;
	}

}
