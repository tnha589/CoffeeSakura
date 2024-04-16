/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Dao;

import com.Helper.JDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nguye
 */
public class ThongKeDao {

    public List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getThongKeHoaDonTrongKhoangNgay(Date ngayBD, Date ngayKT) {

        String sql = "{CALL ThongKeHoaDonTrongKhoangNgay(?,?)}";
        String[] cols = {"TongSoTien", "SoHoaDon"};
        return getListOfArray(sql, cols, ngayBD, ngayKT);

    }

    public List<Object[]> getThongKeHoaDonNgayHienTai() {
        String sql = "{CALL ThongKeHoaDonNgayHienTai}";
        String[] cols = {"TongDoanhThu", "SoLuongHoaDon", "MaHD", "TenNguoiTao", "ThoiGianTao", "TongTien", "TrangThai"};
        return getListOfArray(sql, cols);
    }

    public List<Object[]> getThongKeTuanNay() {
        String sql = "{CALL ThongKeTuanNay}";
        String[] cols = {"TongSoTien", "SoHoaDon", "MaHD", "TenNguoiTao", "ThoiGianTao", "TongTien", "TrangThai"};
        return getListOfArray(sql, cols);
    }

    public List<Object[]> getThongKeThangNay() {
        String sql = "{CALL ThongKeThangNay}";
        String[] cols = {"TongSoTien", "SoHoaDon", "MaHD", "TenNguoiTao", "ThoiGianTao", "TongTien", "TrangThai"};
        return getListOfArray(sql, cols);
    }

    public List<Object[]> get_laySPTuHoaDon() {
        String sql = "{CALL sp_laySPTuHoaDon}";
        String[] cols = {"TenSP", "SpLuong", "TongTien"};

        return getListOfArray(sql, cols);
    }

    public List<Object[]> get_chiTietHoaDon() {
        String sql = "SELECT  ROW_NUMBER() OVER (ORDER BY TenSP) AS MaCTHD,\n"
                + "TenSP, COUNT(a.SoLuong) AS SoLuong, SUM(a.ThanhTien) AS ThanhTien \n"
                + "FROM ChiTietHoaDon a\n"
                + "INNER JOIN SanPham b ON a.MaSP = b.MaSP\n"
                + "GROUP BY TenSP";
        String[] cols = {"MaCTHD", "TenSP", "SoLuong", "ThanhTien"};

        return getListOfArray(sql, cols);
    }

    public List<Object[]> LayThongTinHoaDon(Date ngayBD, Date ngayKT) {
        java.sql.Date startDate = new java.sql.Date(ngayBD.getTime());
        java.sql.Date endDate = new java.sql.Date(ngayKT.getTime());
        String sql = "\n"
                + "SELECT  ROW_NUMBER() OVER (ORDER BY TenSP) AS STT, "
                + "TenSP, COUNT(a.SoLuong) AS SoLuong, SUM(a.ThanhTien) AS DoanhThu "
                + "FROM ChiTietHoaDon a "
                + "INNER JOIN SanPham b ON a.MaSP = b.MaSP "
                + "inner join HoaDon HD on HD.MaHD = a.MaHD "
                + "WHERE HD.ThoiGianTao >= ? AND HD.ThoiGianTao < ? "
                + "GROUP BY TenSP";
        String[] cols = {"STT", "TenSP", "SoLuong", "DoanhThu"};
        return getListOfArray(sql, cols, startDate, endDate);

    }
}
