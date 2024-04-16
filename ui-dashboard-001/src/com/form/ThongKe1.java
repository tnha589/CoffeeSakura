/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.form;

import com.Dao.HoaDonDAO_1;
import com.Dao.sanPhamDao;
import com.Dao.ThongKeDao;
import com.Helper.JDBC;
import static com.Helper.JDBC.conn;
import static com.Helper.JDBC.connectionUrl;
import static com.Helper.JDBC.ps;
import com.model.HoaDon;
import com.model.SanPham;
import com.chart.ModelChart;
import com.untils.XDialog;
import com.untils.XExcel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author HP
 */
public class ThongKe1 extends javax.swing.JPanel {

	/**
	 * Creates new form ThongKe1
	 */
	boolean ktra = true;
	DecimalFormat decimalFormat2 = new DecimalFormat("#,###,###,###,### VNĐ");
	public String message = "";

	boolean kiemtraNgay() {

		if (txtHoaDonTu.getDate() != null && txtHoaDonDen.getDate() != null) {
			if (!txtHoaDonTu.getDate().before(txtHoaDonDen.getDate())) {
				message = "Ngày bắt đầu phải trước ngày kết thúc";
				XDialog.alert(this, message);
				ktra = false;
			}
		}
		return ktra;
	}

	public ThongKe1() throws ParseException {
		initComponents();

		init();
		txtHoaDonDen.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() { // Sử lý sự kiện lắng nghe
																								// mục ngày kết thúc của
																								// txtNgayKT
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					// Xử lý khi ngày thay đổi ở đây
					Date selectedDate = (Date) e.getNewValue();
					try {
						// Thực hiện các thao tác cần thiết khi ngày thay đổi

						if (kiemtraNgay()) {
							fillThongKeHoaDonTrongKhoangNgay();

						}
					} catch (ParseException ex) {
						Logger.getLogger(ThongKe1.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		});

		txtHoaDonTu.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() { // Sử lý sự kiện lắng nghe
																								// mục ngày kết thúc của
																								// txtNgayKT
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					// Xử lý khi ngày thay đổi ở đây
					Date selectedDate = (Date) e.getNewValue();
					try {
						// Thực hiện các thao tác cần thiết khi ngày thay đổi

						if (kiemtraNgay()) {
							fillThongKeHoaDonTrongKhoangNgay();

						}
					} catch (ParseException ex) {
						Logger.getLogger(ThongKe1.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		});

		txtHoaDonDen.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					// Xử lý khi ngày thay đổi ở đây
					Date selectedDate = (Date) e.getNewValue();
					try {
						// Thực hiện các thao tác cần thiết khi ngày thay đổi
						if (txtHoaDonTu.getDate() != null && txtHoaDonDen.getDate() != null) {
							if (txtHoaDonTu.getDate().before(txtHoaDonDen.getDate())) {
								fillTableHoaDonTheoDK();
								fillThongKeHoaDonTrongKhoangNgay();
							} else {
								message = "Ngày bắt đầu phải trước ngày kết thúc";
								XDialog.alert(jPanel1, message);
							}
						} else {
							message = "Ngày không được để trống";
							XDialog.alert(jPanel1, message);
						}

					} catch (ParseException ex) {
						Logger.getLogger(ThongKe1.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		});

		txtHoaDonTu.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					// Xử lý khi ngày thay đổi ở đây
					Date selectedDate = (Date) e.getNewValue();
					try {
						if (txtHoaDonTu.getDate() != null && txtHoaDonDen.getDate() != null) {
							if (txtHoaDonTu.getDate().before(txtHoaDonDen.getDate())) {
								fillTableHoaDonTheoDK();
								fillThongKeHoaDonTrongKhoangNgay();
							} else {
								message = "Ngày bắt đầu phải trước ngày kết thúc";
								XDialog.alert(jPanel1, message);
							}
						}
					} catch (ParseException ex) {
						Logger.getLogger(ThongKe1.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		});
// Lắng nghe sự kiện nut btnHomnay khi nhấn vào
		btnHomNay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "{CALL GetTop5ProductSalesWithName}";
				// executeSQLQuery();
			}
		});
		// Lắng nghe sự kiện nut btnTuannay khi nhấn vào
		btnTuanNay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "{CALL GetTop5ProductSalesOfWeek}";
				// executeSQLQuery();
			}
		});
		// Xử lý sự kiện cho btnThangNay
		btnThangNay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = "{CALL GetTop5ProductSalesOfMonth}";
				// executeSQLQuery();
			}
		});

		txtSPDenNgay.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					// Xử lý khi ngày thay đổi ở đây
					Date selectedDate = (Date) e.getNewValue();
					try {
						// Thực hiện các thao tác cần thiết khi ngày thay đổi
						if (txtSPTuNgay.getDate() != null && txtSPDenNgay.getDate() != null) {
							if (txtSPTuNgay.getDate().before(txtSPDenNgay.getDate())) {
								LayThongTinHoaDon();
							} else {
								message = "Ngày bắt đầu phải lớn hơn ngày kết thúc";
								XDialog.alert(jPanel1, message);
							}
						} else {
							message = "Ngày bắt đầu trống";
							XDialog.alert(jPanel1, message);
						}
					} catch (SQLException ex) {
						Logger.getLogger(ThongKe1.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		});

		// Lắng nghe sự kiện thay đổi JDateChoser cho text field txtSPTuNgay
		txtSPTuNgay.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					// Xử lý khi ngày thay đổi ở đây
					Date selectedDate = (Date) e.getNewValue();
					try {
						// Thực hiện các thao tác cần thiết khi ngày thay đổi
						if (txtSPTuNgay.getDate() != null && txtSPDenNgay.getDate() != null) {
							if (txtSPTuNgay.getDate().before(txtSPDenNgay.getDate())) {
								LayThongTinHoaDon();
							} else {
								message = "Ngày bắt đầu phải lớn hơn ngày kết thúc";
								XDialog.alert(jPanel1, message);
							}
						}

					} catch (SQLException ex) {
						Logger.getLogger(ThongKe1.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		});

		txtNgayKTTK.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() { // Sử lý sự kiện lắng nghe
																								// mục ngày kết thúc của
																								// txtNgayKT
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					Date selectedDate = (Date) e.getNewValue();

					if (txtNgayBDTK.getDate() != null && txtNgayKTTK.getDate() != null) {
						if (txtNgayBDTK.getDate().before(txtNgayKTTK.getDate())) {
							if (flag4) {
								chart4.setVisible(true);
								batDauTKKhoangNgay();
								chart4.start();
								fillTableChiTietHoaDon();

								// flag4 = true;
							} else {
								try {
									LayThongTinHoaDon();
								} catch (SQLException ex) {
									Logger.getLogger(ThongKe1.class.getName()).log(Level.SEVERE, null, ex);
								}

								chart4.start();
							}
						} else {
							message = "Ngày bắt phải lớn hơn đầu kết thúc";
							XDialog.alert(jPanel1, message);
						}
					} else {
						message = "Ngày bắt đầu không được để trống!";
						XDialog.alert(jPanel1, message);
					}

				}
			}
		});

		txtNgayBDTK.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() { // Sử lý sự kiện lắng nghe
																								// mục ngày kết thúc của
																								// txtNgayKT
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					Date selectedDate = (Date) e.getNewValue();

					if (txtNgayBDTK.getDate() != null && txtNgayKTTK.getDate() != null) {
						if (txtNgayBDTK.getDate().before(txtNgayKTTK.getDate())) {
							if (flag4) {
								chart4.setVisible(true);
								batDauTKKhoangNgay();
								chart4.start();
								fillTableChiTietHoaDon();

								// flag4 = true;
							} else {
								try {
									LayThongTinHoaDon();
								} catch (SQLException ex) {
									Logger.getLogger(ThongKe1.class.getName()).log(Level.SEVERE, null, ex);
								}
//                        chart5.setVisible(true);
//                        batDauTKKhoangNgay();
								chart4.start();
							}
						} else {
							message = "Ngày bắt phải lớn hơn đầu kết thúc";
							XDialog.alert(jPanel1, message);
						}
					}
				}

			}
		});
	}

	HoaDonDAO_1 daohd = new HoaDonDAO_1();
	ThongKeDao daotk = new ThongKeDao();
	sanPhamDao daosp = new sanPhamDao();

	int row = 0;

	public void init() throws ParseException {
		fillTableHoaDon();
		fillThongKeHoaDonNgayHienTai();
		fillThongKeTuanNay();
		fillThongKeThangNay();
		fillTableChiTietHoaDon();

		chart1.setVisible(false);
		chart2.setVisible(false);
		chart3.setVisible(false);
		// tblThongKeClick.setVisible(false);

		txtSPDenNgay.setVisible(false);
		txtSPTuNgay.setVisible(false);
		// txtNgayBD.setVisible(false);
		// txtNgayKT.setVisible(false);
	}

	public void fillTableHoaDon() {
		DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
		model.setRowCount(0);
		try {
			List<HoaDon> list = daohd.selectAll();
			DecimalFormat decimalFormat = new DecimalFormat("#,###,### VNĐ");
			for (HoaDon hd : list) {
				String formattedTongTien = decimalFormat.format(hd.getTongTien());
				Object[] row = { hd.getMaHD(), hd.getTenNguoiTao(), hd.getThoiGianTao(), formattedTongTien,
						hd.getTrangThai() };
				model.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
		}

	}

//-------------------------NamJavaDoIt---------------------------------------
	public void fillTableThongKeByCard1() {
		DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
		model.setRowCount(0);
		try {
			List<Object[]> list = daotk.getThongKeHoaDonNgayHienTai();
			// DecimalFormat decimalFormat = new DecimalFormat("#,###,### VNĐ");
			for (Object[] row : list) {
				// String formattedTongTien = decimalFormat.format(hd.getTongTien());
				model.addRow(new Object[] { row[2], row[3], row[4], row[5], row[6] });
			}
		} catch (Exception e) {
			e.printStackTrace();
			// MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
		}

	}

	public void fillTableThongKeByCard2() {
		DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
		model.setRowCount(0);
		try {
			List<Object[]> list = daotk.getThongKeTuanNay();
			// DecimalFormat decimalFormat = new DecimalFormat("#,###,### VNĐ");
			for (Object[] row : list) {
				// String formattedTongTien = decimalFormat.format(hd.getTongTien());
				model.addRow(new Object[] { row[2], row[3], row[4], row[5], row[6] });
			}
		} catch (Exception e) {
			e.printStackTrace();
			// MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
		}

	}

	public void fillTableThongKeByCard3() {
		DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
		model.setRowCount(0);
		try {
			List<Object[]> list = daotk.getThongKeThangNay();
			// DecimalFormat decimalFormat = new DecimalFormat("#,###,### VNĐ");
			for (Object[] row : list) {
				// String formattedTongTien = decimalFormat.format(hd.getTongTien());
				model.addRow(new Object[] { row[2], row[3], row[4], row[5], row[6] });
			}
		} catch (Exception e) {
			e.printStackTrace();
			// MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
		}

	}

//----------------------------------------------------------------------------------------------------
	void fillThongKeHoaDonNgayHienTai() {
		List<Object[]> list = daotk.getThongKeHoaDonNgayHienTai();

		if (!list.isEmpty()) {
			Object[] data = list.get(0); // Lấy mảng Object[] đầu tiên từ danh sách

			if (data.length >= 2) { // Kiểm tra có đủ phần tử trong mảng Object[] không
				if (data[0] != null) { // Kiểm tra data[0] có null không trước khi sử dụng

					String soTienChuoi = decimalFormat2.format(data[0]);
					lblSoTienHomNay.setText(soTienChuoi);// Thiết lập giá trị số hóa đơn lên JLabel
				} else {
					lblSoTienHomNay.setText("0");
				}

				if (data[1] != null) { // Kiểm tra data[1] có null không trước khi sử dụng
					lblSoHDHomNay.setText(data[1].toString() + " Hóa đơn");
					// Thiết lập giá trị số tiền lên JLabel
				} else {
					lblSoHDHomNay.setText("0");
				}
			}
		}
	}

	void fillThongKeTuanNay() {
		List<Object[]> list = daotk.getThongKeTuanNay();

		if (!list.isEmpty()) {
			Object[] data = list.get(0); // Lấy mảng Object[] đầu tiên từ danh sách

			if (data.length >= 1 && data[0] != null) { // Kiểm tra có đủ phần tử trong mảng Object[] không và phần tử
														// đầu không phải null

				String soTienChuoi = decimalFormat2.format(data[0]);
				lblSoTienTuanNay.setText(soTienChuoi);
			} else {
				lblSoTienTuanNay.setText("0");
			}
			if (data.length >= 2 && data[1] != null) { // Kiểm tra có đủ phần tử và phần tử thứ hai không phải null
														// trước khi sử dụng
				lblSoHoaTuanNay.setText(data[1].toString() + " Hóa đơn"); // Thiết lập giá trị số tiền lên JLabel
			} else {
				lblSoHoaTuanNay.setText("0");
			}
		}
	}

	void fillThongKeThangNay() {
		List<Object[]> list = daotk.getThongKeThangNay();

		if (!list.isEmpty()) {
			Object[] data = list.get(0); // Lấy mảng Object[] đầu tiên từ danh sách

			if (data.length >= 1 && data[0] != null) { // Kiểm tra có đủ phần tử trong mảng Object[] không và phần tử
														// đầu không phải null

				String soTienChuoi = decimalFormat2.format(data[0]);
				lblTongTienThangNay.setText(soTienChuoi);
			} else {
				lblTongTienThangNay.setText("0");
			}
			if (data.length >= 2 && data[1] != null) { // Kiểm tra có đủ phần tử và phần tử thứ hai không phải null
														// trước khi sử dụng
				lblTongHDThangNay.setText(data[1].toString() + " Hóa đơn"); // Thiết lập giá trị số tiền lên JLabel
			} else {
				lblTongHDThangNay.setText("0");
			}
		}
	}

	public void fillThongKeHoaDonTrongKhoangNgay() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

// Lấy ngày tháng từ JDateChooser và chuyển đổi thành đối tượng Date
//        Date ngayBD = dateFormat.parse(dateFormat.format(txtNgayBD.getDate()));
//        Date ngayKT = dateFormat.parse(dateFormat.format(txtNgayKT.getDate()));
//        
		Date ngayBD = null;
		Date ngayKT = null;

		if (txtHoaDonTu.getDate() != null && txtHoaDonDen.getDate() != null) {
			ngayBD = dateFormat.parse(dateFormat.format(txtHoaDonTu.getDate()));
			ngayKT = dateFormat.parse(dateFormat.format(txtHoaDonDen.getDate()));
		}

		List<Object[]> list = daotk.getThongKeHoaDonTrongKhoangNgay(ngayBD, ngayKT);

		if (!list.isEmpty()) {
			Object[] data = list.get(0); // Lấy mảng Object[] đầu tiên từ danh sách

			if (data.length >= 2) {
				if (data[0] != null && txtHoaDonDen.getDate() != null) {

					String soTienChuoi = decimalFormat2.format(data[0]);
					lblTienTuyChon.setText(soTienChuoi);// Thiết lập giá trị số hóa đơn lên JLabel
				} else {
					lblTienTuyChon.setText("0");
				}

				if (data[1] != null) {
					lblHoaDonTuyChon.setText(data[1].toString() + " Hóa đơn"); // Thiết lập giá trị số tiền lên JLabel
				} else {
					lblHoaDonTuyChon.setText("0");
				}
			}
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
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		tabs = new javax.swing.JTabbedPane();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblThongKe = new javax.swing.JTable();
		jSeparator1 = new javax.swing.JSeparator();
		txtHoaDonTu = new com.toedter.calendar.JDateChooser();
		txtHoaDonDen = new com.toedter.calendar.JDateChooser();
		panelRound1 = new com.JpanelBoder.PanelRound();
		jLabel1 = new javax.swing.JLabel();
		lblSoTienHomNay = new javax.swing.JLabel();
		lblSoHDHomNay = new javax.swing.JLabel();
		panelRound2 = new com.JpanelBoder.PanelRound();
		jLabel2 = new javax.swing.JLabel();
		lblSoTienTuanNay = new javax.swing.JLabel();
		lblSoHoaTuanNay = new javax.swing.JLabel();
		panelRound3 = new com.JpanelBoder.PanelRound();
		jLabel3 = new javax.swing.JLabel();
		lblTongTienThangNay = new javax.swing.JLabel();
		lblTongHDThangNay = new javax.swing.JLabel();
		panelRound4 = new com.JpanelBoder.PanelRound();
		jLabel16 = new javax.swing.JLabel();
		lblTienTuyChon = new javax.swing.JLabel();
		lblHoaDonTuyChon = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		btnExcel = new javax.swing.JButton();
		jPanel7 = new javax.swing.JPanel();
		jPanel8 = new javax.swing.JPanel();
		chart1 = new com.chart.Chart();
		chart2 = new com.chart.Chart();
		chart3 = new com.chart.Chart();
		chart4 = new com.chart.Chart();
		btnHomNay = new javax.swing.JButton();
		btnTuanNay = new javax.swing.JButton();
		btnThangNay = new javax.swing.JButton();
		txtNgayBDTK = new com.toedter.calendar.JDateChooser();
		txtNgayKTTK = new com.toedter.calendar.JDateChooser();
		jScrollPane3 = new javax.swing.JScrollPane();
		tblSanPham = new javax.swing.JTable();
		txtSPTuNgay = new com.toedter.calendar.JDateChooser();
		txtSPDenNgay = new com.toedter.calendar.JDateChooser();
		btnExcelSP = new javax.swing.JButton();

		jPanel1.setBackground(new java.awt.Color(244, 154, 157));
		jPanel1.setPreferredSize(new java.awt.Dimension(1194, 737));

		tabs.setBackground(new java.awt.Color(244, 154, 157));
		tabs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

		jPanel2.setBackground(new java.awt.Color(244, 154, 157));

		tblThongKe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "Mã HĐ", "Người Tạo", "Ngày Tạo", "Tổng Tiền", "Trạng Thái" }));
		tblThongKe.setSelectionBackground(new java.awt.Color(244, 100, 104));
		jScrollPane1.setViewportView(tblThongKe);

		txtHoaDonTu.setDateFormatString("dd-MM-yyyy");
		txtHoaDonTu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		txtHoaDonDen.setDateFormatString("dd-MM-yyyy");
		txtHoaDonDen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		panelRound1.setBackground(new java.awt.Color(244, 136, 186));
		panelRound1.setRoundBottomRight(50);
		panelRound1.setRoundTopLeft(250);
		panelRound1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				panelRound1MouseClicked(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				panelRound1MousePressed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("Hôm Nay");

		lblSoTienHomNay.setBackground(new java.awt.Color(0, 0, 255));
		lblSoTienHomNay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblSoTienHomNay.setForeground(new java.awt.Color(255, 255, 255));
		lblSoTienHomNay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblSoTienHomNay.setText("0");

		lblSoHDHomNay.setBackground(new java.awt.Color(0, 0, 255));
		lblSoHDHomNay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblSoHDHomNay.setForeground(new java.awt.Color(255, 255, 255));
		lblSoHDHomNay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblSoHDHomNay.setText("0");

		javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
		panelRound1.setLayout(panelRound1Layout);
		panelRound1Layout.setHorizontalGroup(panelRound1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound1Layout.createSequentialGroup().addContainerGap()
						.addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelRound1Layout.createSequentialGroup().addGap(63, 63, 63)
										.addComponent(jLabel1).addGap(0, 42, Short.MAX_VALUE))
								.addComponent(lblSoTienHomNay, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblSoHDHomNay, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap()));
		panelRound1Layout.setVerticalGroup(panelRound1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addGap(38, 38, 38).addComponent(lblSoTienHomNay)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
						.addComponent(lblSoHDHomNay).addGap(22, 22, 22)));

		panelRound2.setBackground(new java.awt.Color(244, 41, 135));
		panelRound2.setRoundBottomRight(50);
		panelRound2.setRoundTopLeft(270);
		panelRound2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				panelRound2MouseClicked(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setText("Tuần Này");

		lblSoTienTuanNay.setBackground(new java.awt.Color(0, 0, 255));
		lblSoTienTuanNay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblSoTienTuanNay.setForeground(new java.awt.Color(255, 255, 255));
		lblSoTienTuanNay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblSoTienTuanNay.setText("0");

		lblSoHoaTuanNay.setBackground(new java.awt.Color(0, 0, 255));
		lblSoHoaTuanNay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblSoHoaTuanNay.setForeground(new java.awt.Color(255, 255, 255));
		lblSoHoaTuanNay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblSoHoaTuanNay.setText("0");

		javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
		panelRound2.setLayout(panelRound2Layout);
		panelRound2Layout.setHorizontalGroup(panelRound2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound2Layout.createSequentialGroup().addContainerGap()
						.addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelRound2Layout.createSequentialGroup().addGap(0, 69, Short.MAX_VALUE)
										.addComponent(jLabel2).addGap(42, 42, 42))
								.addComponent(lblSoTienTuanNay, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblSoHoaTuanNay, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		panelRound2Layout.setVerticalGroup(panelRound2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel2)
						.addGap(32, 32, 32).addComponent(lblSoTienTuanNay)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
						.addComponent(lblSoHoaTuanNay).addGap(38, 38, 38)));

		panelRound3.setBackground(new java.awt.Color(186, 16, 94));
		panelRound3.setRoundBottomRight(50);
		panelRound3.setRoundTopLeft(270);
		panelRound3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				panelRound3MouseClicked(evt);
			}
		});

		jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(255, 255, 255));
		jLabel3.setText("Tháng này");

		lblTongTienThangNay.setBackground(new java.awt.Color(0, 0, 255));
		lblTongTienThangNay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblTongTienThangNay.setForeground(new java.awt.Color(255, 255, 255));
		lblTongTienThangNay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTongTienThangNay.setText("0");

		lblTongHDThangNay.setBackground(new java.awt.Color(0, 0, 255));
		lblTongHDThangNay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblTongHDThangNay.setForeground(new java.awt.Color(255, 255, 255));
		lblTongHDThangNay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTongHDThangNay.setText("0");

		javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
		panelRound3.setLayout(panelRound3Layout);
		panelRound3Layout.setHorizontalGroup(panelRound3Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound3Layout.createSequentialGroup().addContainerGap()
						.addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										panelRound3Layout.createSequentialGroup().addGap(0, 16, Short.MAX_VALUE)
												.addComponent(lblTongHDThangNay, javax.swing.GroupLayout.PREFERRED_SIZE,
														166, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(15, 15, 15))
								.addComponent(lblTongTienThangNay, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						panelRound3Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel3).addGap(44, 44, 44)));
		panelRound3Layout.setVerticalGroup(panelRound3Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel3)
						.addGap(35, 35, 35).addComponent(lblTongTienThangNay)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
						.addComponent(lblTongHDThangNay).addGap(27, 27, 27)));

		panelRound4.setBackground(new java.awt.Color(147, 0, 67));
		panelRound4.setRoundBottomRight(50);
		panelRound4.setRoundTopLeft(270);

		jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
		jLabel16.setForeground(new java.awt.Color(255, 255, 255));
		jLabel16.setText("Tùy chọn");

		lblTienTuyChon.setBackground(new java.awt.Color(0, 0, 255));
		lblTienTuyChon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblTienTuyChon.setForeground(new java.awt.Color(255, 255, 255));
		lblTienTuyChon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTienTuyChon.setText("0");

		lblHoaDonTuyChon.setBackground(new java.awt.Color(0, 0, 255));
		lblHoaDonTuyChon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblHoaDonTuyChon.setForeground(new java.awt.Color(255, 255, 255));
		lblHoaDonTuyChon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblHoaDonTuyChon.setText("0");

		javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
		panelRound4.setLayout(panelRound4Layout);
		panelRound4Layout.setHorizontalGroup(panelRound4Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound4Layout.createSequentialGroup().addContainerGap()
						.addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblTienTuyChon, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblHoaDonTuyChon, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
						.addContainerGap(72, Short.MAX_VALUE).addComponent(jLabel16).addGap(53, 53, 53)));
		panelRound4Layout.setVerticalGroup(panelRound4Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelRound4Layout.createSequentialGroup().addContainerGap().addComponent(jLabel16)
						.addGap(40, 40, 40).addComponent(lblTienTuyChon)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
						.addComponent(lblHoaDonTuyChon).addGap(28, 28, 28)));

		jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		jLabel4.setText("Chi tiết hóa đơn");

		jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
		jLabel5.setText("Từ ngày:");

		jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
		jLabel6.setText("Đến ngày:");

		btnExcel.setBackground(new java.awt.Color(0, 153, 51));
		btnExcel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		btnExcel.setForeground(new java.awt.Color(255, 255, 255));
		btnExcel.setText("Xuất Excel");
		btnExcel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExcelActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jSeparator1)
				.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(14, 14, 14)
								.addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jPanel2Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabel5).addComponent(jLabel6)
										.addComponent(txtHoaDonDen, javax.swing.GroupLayout.DEFAULT_SIZE, 169,
												Short.MAX_VALUE)
										.addComponent(txtHoaDonTu, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(382, 382, 382).addComponent(jLabel4)))
						.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(btnExcel).addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 1061,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(0, 24, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(65, 65, 65).addComponent(panelRound1,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(panelRound2, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(panelRound3, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel5)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtHoaDonTu, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(10, 10, 10).addComponent(jLabel6).addGap(9, 9, 9)
												.addComponent(txtHoaDonDen, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(18, 18, 18)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(btnExcel)
						.addContainerGap(64, Short.MAX_VALUE)));

		tabs.addTab("Doanh Thu", jPanel2);

		jPanel7.setBackground(new java.awt.Color(244, 154, 157));

		jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		chart1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

		chart2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

		chart3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

		chart4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup().addContainerGap()
						.addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 1040,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel8Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))
				.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chart3, javax.swing.GroupLayout.PREFERRED_SIZE, 1034,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(12, Short.MAX_VALUE)))
				.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel8Layout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(chart4, javax.swing.GroupLayout.PREFERRED_SIZE, 1023,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(23, Short.MAX_VALUE))));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup().addContainerGap()
						.addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 284,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 287,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(10, Short.MAX_VALUE)))
				.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel8Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chart3, javax.swing.GroupLayout.PREFERRED_SIZE, 291,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel8Layout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(chart4, javax.swing.GroupLayout.PREFERRED_SIZE, 285,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(12, Short.MAX_VALUE))));

		btnHomNay.setBackground(new java.awt.Color(51, 153, 255));
		btnHomNay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		btnHomNay.setForeground(new java.awt.Color(255, 255, 255));
		btnHomNay.setText("Hôm Nay");
		btnHomNay.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHomNayActionPerformed(evt);
			}
		});

		btnTuanNay.setBackground(new java.awt.Color(153, 0, 204));
		btnTuanNay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		btnTuanNay.setForeground(new java.awt.Color(255, 255, 255));
		btnTuanNay.setText("Tuần Này");
		btnTuanNay.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTuanNayActionPerformed(evt);
			}
		});

		btnThangNay.setBackground(new java.awt.Color(255, 51, 51));
		btnThangNay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		btnThangNay.setForeground(new java.awt.Color(255, 255, 255));
		btnThangNay.setText("Tháng Này");
		btnThangNay.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThangNayActionPerformed(evt);
			}
		});

		txtNgayBDTK.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông kê từ ngày",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 2, 14))); // NOI18N
		txtNgayBDTK.setDateFormatString("dd-MM-yyyy");

		txtNgayKTTK.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thống kê đến ngày",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 2, 14))); // NOI18N
		txtNgayKTTK.setDateFormatString("dd-MM-yyyyy");

		tblSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		tblSanPham
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "STT", "Tên SP", "Số Lượng", "Doanh Thu" }));
		tblSanPham.setSelectionBackground(new java.awt.Color(244, 100, 104));
		jScrollPane3.setViewportView(tblSanPham);

		txtSPTuNgay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm bán ra từ ngày",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 2, 14))); // NOI18N
		txtSPTuNgay.setDateFormatString("dd-MM-yyyy");

		txtSPDenNgay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm bán ra đến ngày",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 2, 14))); // NOI18N
		txtSPDenNgay.setDateFormatString("dd-MM-yyyy");

		btnExcelSP.setBackground(new java.awt.Color(0, 153, 51));
		btnExcelSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		btnExcelSP.setForeground(new java.awt.Color(255, 255, 255));
		btnExcelSP.setText("Xuất Excel");
		btnExcelSP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExcelSPActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanel7Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel7Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel7Layout
										.createSequentialGroup()
										.addGroup(jPanel7Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtSPDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 11,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtSPTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel7Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel7Layout.createSequentialGroup().addGap(155, 155, 155)
														.addComponent(txtNgayBDTK,
																javax.swing.GroupLayout.PREFERRED_SIZE, 290,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel7Layout.createSequentialGroup().addGap(78, 78, 78)
														.addComponent(btnHomNay, javax.swing.GroupLayout.PREFERRED_SIZE,
																164, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(52, 52, 52).addComponent(btnTuanNay,
																javax.swing.GroupLayout.PREFERRED_SIZE, 152,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(54, 54, 54)
										.addGroup(jPanel7Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel7Layout.createSequentialGroup()
														.addComponent(btnThangNay,
																javax.swing.GroupLayout.PREFERRED_SIZE, 154,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(51, 51, 51).addComponent(btnExcelSP,
																javax.swing.GroupLayout.PREFERRED_SIZE, 154,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(txtNgayKTTK, javax.swing.GroupLayout.PREFERRED_SIZE, 292,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1037,
										javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(23, Short.MAX_VALUE)));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup().addGap(23, 23, 23)
						.addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 295,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnTuanNay).addComponent(btnHomNay).addComponent(btnThangNay)
										.addComponent(btnExcelSP, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(txtSPTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtSPDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNgayKTTK, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNgayBDTK, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane3,
								javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(72, Short.MAX_VALUE)));

		tabs.addTab("Sản Phẩm", jPanel7);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(tabs,
						javax.swing.GroupLayout.PREFERRED_SIZE, 1085, javax.swing.GroupLayout.PREFERRED_SIZE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(tabs,
								javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1085, javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE));
	}// </editor-fold>//GEN-END:initComponents

	private void btnHomNayActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHomNayActionPerformed
		// TODO add your handling code here:
		if (flag) {
			chart1.setVisible(true);
			batDauTKHomNay();
			chart1.start();

		} else if (flag3) {
			chart1.setVisible(true);
			chart1.start();
		} else if (flag4) {

			chart1.setVisible(true);
			chart1.start();
		} else {

			chart1.setVisible(true);
			chart1.start();
		}
	}// GEN-LAST:event_btnHomNayActionPerformed

	private void btnTuanNayActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTuanNayActionPerformed
		// TODO add your handling code here:
		if (flag3) {
			chart3.setVisible(true);
			batDauTKTuanNay();
			chart3.start();
		} else if (flag2) {
			chart3.setVisible(true);
			chart3.start();
		} else if (flag4) {
			chart3.setVisible(true);
			chart3.start();
		} else {
			chart3.setVisible(true);
			chart3.start();
		}
	}// GEN-LAST:event_btnTuanNayActionPerformed

	private void btnThangNayActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThangNayActionPerformed
		// TODO add your handling code here:
		if (flag2) {
			chart2.setVisible(true);
			batDauTKThangNay();
			chart2.start();
		} else if (flag3) {
			chart2.setVisible(true);
			chart2.start();
		} else if (flag4) {
			chart2.setVisible(true);
			chart2.start();
		} else {
			chart2.setVisible(true);
			chart2.start();
		}
	}// GEN-LAST:event_btnThangNayActionPerformed

	private void panelRound1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_panelRound1MouseClicked
		// TODO add your handling code here:
		// fillTableChiTietHoaDonClick();
		// System.out.println("He");
		fillTableThongKeByCard1();
	}// GEN-LAST:event_panelRound1MouseClicked

	private void panelRound1MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_panelRound1MousePressed
		// TODO add your handling code here:

	}// GEN-LAST:event_panelRound1MousePressed

	private void panelRound2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_panelRound2MouseClicked
		fillTableThongKeByCard2();
		// TODO add your handling code here:
	}// GEN-LAST:event_panelRound2MouseClicked

	private void panelRound3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_panelRound3MouseClicked
		fillTableThongKeByCard3();
		// TODO add your handling code here:
	}// GEN-LAST:event_panelRound3MouseClicked

	private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExcelActionPerformed
		if (tabs.getTitleAt(tabs.getSelectedIndex()).equalsIgnoreCase("Doanh Thu")) {
			XExcel.writeToExcel(tblThongKe, "Thống kê Doanh thu");
		}
		// TODO add your handling code here:
	}// GEN-LAST:event_btnExcelActionPerformed

	private void btnExcelSPActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExcelSPActionPerformed
		if (tabs.getTitleAt(tabs.getSelectedIndex()).equalsIgnoreCase("Sản Phẩm")) {
			XExcel.writeToExcel(tblSanPham, "Thống kê sản phẩm");
		}
		// TODO add your handling code here:
	}// GEN-LAST:event_btnExcelSPActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnExcel;
	private javax.swing.JButton btnExcelSP;
	private javax.swing.JButton btnHomNay;
	private javax.swing.JButton btnThangNay;
	private javax.swing.JButton btnTuanNay;
	private com.chart.Chart chart1;
	private com.chart.Chart chart2;
	private com.chart.Chart chart3;
	private com.chart.Chart chart4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JLabel lblHoaDonTuyChon;
	private javax.swing.JLabel lblSoHDHomNay;
	private javax.swing.JLabel lblSoHoaTuanNay;
	private javax.swing.JLabel lblSoTienHomNay;
	private javax.swing.JLabel lblSoTienTuanNay;
	private javax.swing.JLabel lblTienTuyChon;
	private javax.swing.JLabel lblTongHDThangNay;
	private javax.swing.JLabel lblTongTienThangNay;
	private com.JpanelBoder.PanelRound panelRound1;
	private com.JpanelBoder.PanelRound panelRound2;
	private com.JpanelBoder.PanelRound panelRound3;
	private com.JpanelBoder.PanelRound panelRound4;
	private javax.swing.JTabbedPane tabs;
	private javax.swing.JTable tblSanPham;
	private javax.swing.JTable tblThongKe;
	private com.toedter.calendar.JDateChooser txtHoaDonDen;
	private com.toedter.calendar.JDateChooser txtHoaDonTu;
	private com.toedter.calendar.JDateChooser txtNgayBDTK;
	private com.toedter.calendar.JDateChooser txtNgayKTTK;
	private com.toedter.calendar.JDateChooser txtSPDenNgay;
	private com.toedter.calendar.JDateChooser txtSPTuNgay;

	// End of variables declaration//GEN-END:variables
	public void fillTableHoaDonTheoDK() throws ParseException {
		DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
		model.setRowCount(0);
		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Date ngayBD = txtHoaDonTu.getDate();
		Date ngayKT = txtHoaDonDen.getDate();
		if (ngayBD != null && ngayKT != null) {
			try {

				List<HoaDon> list = daohd.selectHDCoDK(ngayBD, ngayKT);

				for (HoaDon hd : list) {
					Object[] row = { hd.getMaHD(), hd.getTenNguoiTao(), hd.getThoiGianTao(), hd.getTongTien(),
							hd.getTrangThai() };
					model.addRow(row);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
			}

		} else {
			System.out.println("Chưa lấy được");
		}
	}

	void TimKhuyenMai1(String str) {
		DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		tblThongKe.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}

	void fillTableChiTietHoaDon() {
		DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
		model.setRowCount(0);
		try {
			List<Object[]> list = daotk.get_chiTietHoaDon();
			for (Object[] row : list) {

				double doanhThu = (double) row[3]; //
				// Làm tròn giá trị doanh thu và chỉ lấy hai số sau dấu thập phân
				DecimalFormat decimalFormat = new DecimalFormat("#.## VNĐ");
				String doanhThuFormatted = String.format("%,.0f", doanhThu);
				row[3] = doanhThuFormatted; // Gán lại giá trị sau khi đã được định dạng
			}
			for (Object[] row : list) {
				model.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
		}
	}

	public void LayThongTinHoaDon() throws SQLException {

		DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
		model.setRowCount(0);

		Date ngayBD = txtNgayBDTK.getDate();
		Date ngayKT = txtNgayKTTK.getDate();
		if (ngayBD != null && ngayKT != null) {
			List<Object[]> list = daotk.LayThongTinHoaDon(ngayBD, ngayKT);
			for (Object[] row : list) {

				// Thêm hàng vào model của bảng
				model.addRow(row);

			}
		}

	}

	boolean flag = true;
	boolean flag2 = true;
	boolean flag3 = true;
	boolean flag4 = true;
	boolean flag5 = true;

	private List<ModelChart> callStoredProcedureAndGetChartData() {
		List<ModelChart> chartData = new ArrayList<>();
		try {
			conn = JDBC.conn;
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(connectionUrl);
			}

			if (!sql.isEmpty()) {
				ps = conn.prepareCall(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					String productName = rs.getString("TenSP");
					int quantitySold = rs.getInt("TongSoLuong");
					ModelChart dataPoint = new ModelChart(productName, quantitySold);
					chartData.add(dataPoint);

				}

				rs.close();
				ps.close();
			}

			// Đóng kết nối sau khi sử dụng
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return chartData;
	}

	void batDauTKHomNay() {
		// chart1.clear();
		List<ModelChart> chartData = callStoredProcedureAndGetChartData();
		Color[] colors = new Color[] { new Color(255, 64, 64)

		};
		for (int i = 0; i < chartData.size(); i++) {
			ModelChart data = chartData.get(i);
			chart1.addLegend(data.getProductName(), colors[i % colors.length]); // Sử dụng màu tương ứng
			chart1.addData(data);
			flag = false;
		}
		chart1.start();
		flag = false;

	}

	void batDauTKTuanNay() {
		// chart.clear();
		List<ModelChart> chartData = callStoredProcedureAndGetChartData();
		Color[] colors = new Color[] { new Color(255, 64, 64) };
		for (int i = 0; i < chartData.size(); i++) {
			ModelChart data = chartData.get(i);
			chart3.addLegend(data.getProductName(), colors[i % colors.length]); // Sử dụng màu tương ứng
			chart3.addData(data);
			flag3 = false;
		}
		chart3.start();
		flag3 = false;

	}

	void batDauTKThangNay() {
		// chart.clear();
		List<ModelChart> chartData = callStoredProcedureAndGetChartData();
		Color[] colors = new Color[] { new Color(255, 64, 64) };
		for (int i = 0; i < chartData.size(); i++) {

			ModelChart data = chartData.get(i);

			chart2.addLegend(data.getProductName(), colors[i % colors.length]); // Sử dụng màu tương ứng
			chart2.addData(data);
			flag2 = false;
		}
		chart2.start();

	}

	String sql = "";

	private List<ModelChart> callStoredProcedureAndGetChartData2(Date startDate, Date endDate) {
		List<ModelChart> chartData = new ArrayList<>();
		try {
			conn = JDBC.conn;
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(connectionUrl);
			}
			if (!sql.isEmpty()) {
				ps = conn.prepareStatement(sql);
				ps.setDate(1, new java.sql.Date(startDate.getTime())); // Truyền ngày bắt đầu vào tham số 1
				ps.setDate(2, new java.sql.Date(endDate.getTime())); // Truyền ngày kết thúc vào tham số 2
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String productName = rs.getString("TenSP");
					int quantitySold = rs.getInt("TongSoLuong");
					ModelChart dataPoint = new ModelChart(productName, quantitySold);
					chartData.add(dataPoint);
				}

				rs.close();
				ps.close();
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return chartData;
	}

	void batDauTKKhoangNgay() {
		Date ngayBD = txtNgayBDTK.getDate();
		Date ngayKT = txtNgayKTTK.getDate();
		sql = "SELECT TOP 5 SP.TenSP, SUM(CTHD.SoLuong) AS TongSoLuong\n" + "    FROM ChiTietHoaDon CTHD\n"
				+ "    JOIN SanPham SP ON CTHD.MaSP = SP.MaSP\n" + "    JOIN HoaDon HD ON CTHD.MaHD = HD.MaHD\n"
				+ "    WHERE HD.ThoiGianTao >= ?\n" + "      AND HD.ThoiGianTao <= ?\n" + "    GROUP BY SP.TenSP\n"
				+ "    ORDER BY TongSoLuong DESC;";
		if (ngayBD != null && ngayKT != null) {

			List<ModelChart> chartData = callStoredProcedureAndGetChartData2(ngayBD, ngayKT);
//            System.out.println("" + ngayBD);
//            System.out.println("" + ngayKT);
			Color[] colors = new Color[] { new Color(255, 64, 64) };
			for (int i = 0; i < chartData.size(); i++) {
				ModelChart data = chartData.get(i);
				chart4.addLegend(data.getProductName(), colors[i % colors.length]);
				chart4.addData(data);
				flag4 = false;
				// flag5 = true;
			}

			chart4.start();
			flag4 = false;

		}
	}

	public boolean isKtra() {
		return ktra;
	}

	public void setKtra(boolean ktra) {
		this.ktra = ktra;
	}

	public DecimalFormat getDecimalFormat2() {
		return decimalFormat2;
	}

	public void setDecimalFormat2(DecimalFormat decimalFormat2) {
		this.decimalFormat2 = decimalFormat2;
	}

	public HoaDonDAO_1 getDaohd() {
		return daohd;
	}

	public void setDaohd(HoaDonDAO_1 daohd) {
		this.daohd = daohd;
	}

	public ThongKeDao getDaotk() {
		return daotk;
	}

	public void setDaotk(ThongKeDao daotk) {
		this.daotk = daotk;
	}

	public sanPhamDao getDaosp() {
		return daosp;
	}

	public void setDaosp(sanPhamDao daosp) {
		this.daosp = daosp;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public javax.swing.JButton getBtnExcel() {
		return btnExcel;
	}

	public void setBtnExcel(javax.swing.JButton btnExcel) {
		this.btnExcel = btnExcel;
	}

	public javax.swing.JButton getBtnExcelSP() {
		return btnExcelSP;
	}

	public void setBtnExcelSP(javax.swing.JButton btnExcelSP) {
		this.btnExcelSP = btnExcelSP;
	}

	public javax.swing.JButton getBtnHomNay() {
		return btnHomNay;
	}

	public void setBtnHomNay(javax.swing.JButton btnHomNay) {
		this.btnHomNay = btnHomNay;
	}

	public javax.swing.JButton getBtnThangNay() {
		return btnThangNay;
	}

	public void setBtnThangNay(javax.swing.JButton btnThangNay) {
		this.btnThangNay = btnThangNay;
	}

	public javax.swing.JButton getBtnTuanNay() {
		return btnTuanNay;
	}

	public void setBtnTuanNay(javax.swing.JButton btnTuanNay) {
		this.btnTuanNay = btnTuanNay;
	}

	public com.chart.Chart getChart1() {
		return chart1;
	}

	public void setChart1(com.chart.Chart chart1) {
		this.chart1 = chart1;
	}

	public com.chart.Chart getChart2() {
		return chart2;
	}

	public void setChart2(com.chart.Chart chart2) {
		this.chart2 = chart2;
	}

	public com.chart.Chart getChart3() {
		return chart3;
	}

	public void setChart3(com.chart.Chart chart3) {
		this.chart3 = chart3;
	}

	public com.chart.Chart getChart4() {
		return chart4;
	}

	public void setChart4(com.chart.Chart chart4) {
		this.chart4 = chart4;
	}

	public javax.swing.JLabel getjLabel1() {
		return jLabel1;
	}

	public void setjLabel1(javax.swing.JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}

	public javax.swing.JLabel getjLabel16() {
		return jLabel16;
	}

	public void setjLabel16(javax.swing.JLabel jLabel16) {
		this.jLabel16 = jLabel16;
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

	public javax.swing.JLabel getjLabel5() {
		return jLabel5;
	}

	public void setjLabel5(javax.swing.JLabel jLabel5) {
		this.jLabel5 = jLabel5;
	}

	public javax.swing.JLabel getjLabel6() {
		return jLabel6;
	}

	public void setjLabel6(javax.swing.JLabel jLabel6) {
		this.jLabel6 = jLabel6;
	}

	public javax.swing.JPanel getjPanel1() {
		return jPanel1;
	}

	public void setjPanel1(javax.swing.JPanel jPanel1) {
		this.jPanel1 = jPanel1;
	}

	public javax.swing.JPanel getjPanel2() {
		return jPanel2;
	}

	public void setjPanel2(javax.swing.JPanel jPanel2) {
		this.jPanel2 = jPanel2;
	}

	public javax.swing.JPanel getjPanel7() {
		return jPanel7;
	}

	public void setjPanel7(javax.swing.JPanel jPanel7) {
		this.jPanel7 = jPanel7;
	}

	public javax.swing.JPanel getjPanel8() {
		return jPanel8;
	}

	public void setjPanel8(javax.swing.JPanel jPanel8) {
		this.jPanel8 = jPanel8;
	}

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public javax.swing.JScrollPane getjScrollPane3() {
		return jScrollPane3;
	}

	public void setjScrollPane3(javax.swing.JScrollPane jScrollPane3) {
		this.jScrollPane3 = jScrollPane3;
	}

	public javax.swing.JSeparator getjSeparator1() {
		return jSeparator1;
	}

	public void setjSeparator1(javax.swing.JSeparator jSeparator1) {
		this.jSeparator1 = jSeparator1;
	}

	public javax.swing.JLabel getLblHoaDonTuyChon() {
		return lblHoaDonTuyChon;
	}

	public void setLblHoaDonTuyChon(javax.swing.JLabel lblHoaDonTuyChon) {
		this.lblHoaDonTuyChon = lblHoaDonTuyChon;
	}

	public javax.swing.JLabel getLblSoHDHomNay() {
		return lblSoHDHomNay;
	}

	public void setLblSoHDHomNay(javax.swing.JLabel lblSoHDHomNay) {
		this.lblSoHDHomNay = lblSoHDHomNay;
	}

	public javax.swing.JLabel getLblSoHoaTuanNay() {
		return lblSoHoaTuanNay;
	}

	public void setLblSoHoaTuanNay(javax.swing.JLabel lblSoHoaTuanNay) {
		this.lblSoHoaTuanNay = lblSoHoaTuanNay;
	}

	public javax.swing.JLabel getLblSoTienHomNay() {
		return lblSoTienHomNay;
	}

	public void setLblSoTienHomNay(javax.swing.JLabel lblSoTienHomNay) {
		this.lblSoTienHomNay = lblSoTienHomNay;
	}

	public javax.swing.JLabel getLblSoTienTuanNay() {
		return lblSoTienTuanNay;
	}

	public void setLblSoTienTuanNay(javax.swing.JLabel lblSoTienTuanNay) {
		this.lblSoTienTuanNay = lblSoTienTuanNay;
	}

	public javax.swing.JLabel getLblTienTuyChon() {
		return lblTienTuyChon;
	}

	public void setLblTienTuyChon(javax.swing.JLabel lblTienTuyChon) {
		this.lblTienTuyChon = lblTienTuyChon;
	}

	public javax.swing.JLabel getLblTongHDThangNay() {
		return lblTongHDThangNay;
	}

	public void setLblTongHDThangNay(javax.swing.JLabel lblTongHDThangNay) {
		this.lblTongHDThangNay = lblTongHDThangNay;
	}

	public javax.swing.JLabel getLblTongTienThangNay() {
		return lblTongTienThangNay;
	}

	public void setLblTongTienThangNay(javax.swing.JLabel lblTongTienThangNay) {
		this.lblTongTienThangNay = lblTongTienThangNay;
	}

	public com.JpanelBoder.PanelRound getPanelRound1() {
		return panelRound1;
	}

	public void setPanelRound1(com.JpanelBoder.PanelRound panelRound1) {
		this.panelRound1 = panelRound1;
	}

	public com.JpanelBoder.PanelRound getPanelRound2() {
		return panelRound2;
	}

	public void setPanelRound2(com.JpanelBoder.PanelRound panelRound2) {
		this.panelRound2 = panelRound2;
	}

	public com.JpanelBoder.PanelRound getPanelRound3() {
		return panelRound3;
	}

	public void setPanelRound3(com.JpanelBoder.PanelRound panelRound3) {
		this.panelRound3 = panelRound3;
	}

	public com.JpanelBoder.PanelRound getPanelRound4() {
		return panelRound4;
	}

	public void setPanelRound4(com.JpanelBoder.PanelRound panelRound4) {
		this.panelRound4 = panelRound4;
	}

	public javax.swing.JTabbedPane getTabs() {
		return tabs;
	}

	public void setTabs(javax.swing.JTabbedPane tabs) {
		this.tabs = tabs;
	}

	public javax.swing.JTable getTblSanPham() {
		return tblSanPham;
	}

	public void setTblSanPham(javax.swing.JTable tblSanPham) {
		this.tblSanPham = tblSanPham;
	}

	public javax.swing.JTable getTblThongKe() {
		return tblThongKe;
	}

	public void setTblThongKe(javax.swing.JTable tblThongKe) {
		this.tblThongKe = tblThongKe;
	}

	public com.toedter.calendar.JDateChooser getTxtHoaDonDen() {
		return txtHoaDonDen;
	}

	public void setTxtHoaDonDen(com.toedter.calendar.JDateChooser txtHoaDonDen) {
		this.txtHoaDonDen = txtHoaDonDen;
	}

	public com.toedter.calendar.JDateChooser getTxtHoaDonTu() {
		return txtHoaDonTu;
	}

	public void setTxtHoaDonTu(com.toedter.calendar.JDateChooser txtHoaDonTu) {
		this.txtHoaDonTu = txtHoaDonTu;
	}

	public com.toedter.calendar.JDateChooser getTxtNgayBDTK() {
		return txtNgayBDTK;
	}

	public void setTxtNgayBDTK(com.toedter.calendar.JDateChooser txtNgayBDTK) {
		this.txtNgayBDTK = txtNgayBDTK;
	}

	public com.toedter.calendar.JDateChooser getTxtNgayKTTK() {
		return txtNgayKTTK;
	}

	public void setTxtNgayKTTK(com.toedter.calendar.JDateChooser txtNgayKTTK) {
		this.txtNgayKTTK = txtNgayKTTK;
	}

	public com.toedter.calendar.JDateChooser getTxtSPDenNgay() {
		return txtSPDenNgay;
	}

	public void setTxtSPDenNgay(com.toedter.calendar.JDateChooser txtSPDenNgay) {
		this.txtSPDenNgay = txtSPDenNgay;
	}

	public com.toedter.calendar.JDateChooser getTxtSPTuNgay() {
		return txtSPTuNgay;
	}

	public void setTxtSPTuNgay(com.toedter.calendar.JDateChooser txtSPTuNgay) {
		this.txtSPTuNgay = txtSPTuNgay;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag2() {
		return flag2;
	}

	public void setFlag2(boolean flag2) {
		this.flag2 = flag2;
	}

	public boolean isFlag3() {
		return flag3;
	}

	public void setFlag3(boolean flag3) {
		this.flag3 = flag3;
	}

	public boolean isFlag4() {
		return flag4;
	}

	public void setFlag4(boolean flag4) {
		this.flag4 = flag4;
	}

	public boolean isFlag5() {
		return flag5;
	}

	public void setFlag5(boolean flag5) {
		this.flag5 = flag5;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void closeJdialog() {
		Thread loginThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// Tạm dừng thực thi trong 3 giây

					Thread.sleep(4000);
					// Sau khi tạm dừng, gọi phương thức đăng nhập
					JOptionPane.getRootFrame().dispose();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		loginThread.start();
	}

}
