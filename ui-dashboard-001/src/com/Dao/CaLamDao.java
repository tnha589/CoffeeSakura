/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Dao;


import com.Helper.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class CaLamDao {
    public static ResultSet rs = null; // Trả về kết quả truy vấn
    public static String CaLam_SQL = "{CALL sp_ThongTinCaLam(?, ?)}";
    public static String UPDATE_SQL = "Update ChiTietCaLamViec set TrangThai = ?, GhiChu =? where MaNV like ?";
    public static String FullCa_SQL = "{CALL sp_FullCaInDay(?)}";
    public static String Ecxel_Fullca = "Select a.Thu,a.TenCaLam,c.TenNV,b.TrangThai,b.GhiChu from CaLam a  Inner join ChiTietCaLamViec b on a.MaCaLam = b.MaCaLam Inner join NhanVien c on b.MaNV = c.MaNV";
    public static String ThemVaoCa = "{CALL sp_Insert (?,?,?,?)}";
    public static String DeleteDataThu = "{CALL sp_DeleteDataThu (?,?)}";
    public static String DeleteByThu = "DELETE FROM ChiTietCaLamViec WHERE MaCaLam IN (SELECT MaCaLam FROM CaLam WHERE Thu LIKE ?) and MaNV is not null;";
    public static String DeleteAllCaLam = "DELETE FROM ChiTietCaLamViec WHERE MaNV is not null;";
//----------------------------------------------------------------------------------------------
    public static String FULL_LSHOADON = "Select * From HoaDon where TrangThai like N'Đã hoàn thành'";
    public static String HoaDonCT_SQL = "{CALL sp_HoaDonChiTiet(?)}";
    public static String ThongTinChiTiet_SQL = "{CALL sp_ThongTinChiTiet(?)}";
    
    
    public List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            rs = JDBC.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getNhanVienTrongCa(String CaLam,String Thu) {
        String[] cols = {"TenNV", "TrangThai", "GhiChu","MaNV"};
        return this.getListOfArray(CaLam_SQL, cols, CaLam,Thu);
    }

    public List<Object[]> getThongTinChiTiet(String maHD) {
        String[] cols = {"MaHD", "TenNguoiTao","TenKM","ThoiGianTao","ThoiGianTT","GhiChu","TrangThai","ThanhTien","ChiPhiKhac","TongTien"};
        return this.getListOfArray(ThongTinChiTiet_SQL, cols, maHD);
    }
    
    public List<Object[]> getFullCa(String Thu) {
        String[] cols = {"TenCaLam", "TenNV", "TrangThai","GhiChu"};
        return this.getListOfArray(FullCa_SQL, cols,Thu);
    }
    public List<Object[]> getExcelFullCa() {
        String[] cols = {"Thu", "TenCaLam", "TenNV","TrangThai","GhiChu"};
        return this.getListOfArray(Ecxel_Fullca, cols);
    }

//    public List<Object[]> getHoaDon() {
//        String[] cols = {"MaHD", "ThoiGianTao", "NguoiTao", "SanPham", "TongTien", "MaKM", "ChiPhiKhac", "HinhThucTT", "GhiChu", "TrangThai", "TenNguoiTao"};
//        return this.getListOfArray(FULL_HOADON, cols);
//    }
    public List<Object[]> getLSHoaDon() {
        String[] cols = {"MaHD","TenNguoiTao","ThoiGianTao",  "ThoiGianTT", "TongTien","TrangThai"};
        return this.getListOfArray(FULL_LSHOADON, cols);
    }
    
    public void update(String trangThai,String GhiChu,String maNV){
        JDBC.update(UPDATE_SQL, trangThai,GhiChu,maNV);
    }
    public void updateDatabase(String thu, String ca, String maNV, String chucVu) {
        JDBC.update(ThemVaoCa, thu,ca,maNV,chucVu);
    }
    public void deleteDataThu(String thu, String ca) {
        JDBC.update(DeleteDataThu, thu,ca);
    }
    
    public void deleteDataByThu(String thu) {
        JDBC.update(DeleteByThu, thu);
    }
    public void deleteAllCaLam() {
        JDBC.update(DeleteAllCaLam);
    }
}
