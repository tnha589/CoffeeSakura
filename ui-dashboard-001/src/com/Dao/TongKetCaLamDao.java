/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Dao;

import static com.Dao.CaLamDao.CaLam_SQL;
import static com.Dao.CaLamDao.DeleteAllCaLam;
import static com.Dao.CaLamDao.DeleteByThu;
import static com.Dao.CaLamDao.DeleteDataThu;
import static com.Dao.CaLamDao.FULL_LSHOADON;
import static com.Dao.CaLamDao.FullCa_SQL;
import static com.Dao.CaLamDao.ThemVaoCa;
import static com.Dao.CaLamDao.ThongTinChiTiet_SQL;
import static com.Dao.CaLamDao.UPDATE_SQL;
import static com.Dao.CaLamDao.rs;
import com.Helper.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class TongKetCaLamDao {
    public static ResultSet rs = null; // Trả về kết quả truy vấn
    public static String FillData = "{CALL sp_DataGiaoCa(?,?)}";
    public static String ThemGiaoCa = "Insert into GiaoCa values(?,?,?,?,?,?,?,?,?,?)";
    public static String UpdateGiaoCa = "update GiaoCa set SLHoaDon = ?,TongHoaDon = ?,SLHoaDonChi = ?,TongHDChi = ?,TongTienCK = ?, TongTienMat = ?, TongTienCa = ?";
    public static String SelectAll = "Select a.*,b.TenNV from GiaoCa a inner join NhanVien b on a.MaNV = b.MaNV";
    public static String SelectByDate = "Select a.*,b.TenNV from GiaoCa a inner join NhanVien b on a.MaNV = b.MaNV where a.NgayGiaoCa =?";
//------------------------------------------------------------------------------
    public static String DeleteDataThu = "{CALL sp_DeleteDataThu (?,?)}";
    public static String DeleteByThu = "DELETE FROM ChiTietCaLamViec WHERE MaCaLam IN (SELECT MaCaLam FROM CaLam WHERE Thu LIKE ?) and MaNV is not null;";
    public static String DeleteAllCaLam = "DELETE FROM ChiTietCaLamViec WHERE MaNV is not null;";
    
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

    public List<Object[]> SelectALl() {
        String[] cols = {"MaGiaoCa", "TenCa", "TenNV","TongHoaDon","TongHDChi","TongTienCa","NgayGiaoCa"};
        return this.getListOfArray(SelectAll, cols);
    }

    public List<Object[]> SelectByDate(String day) {
        String[] cols = {"MaGiaoCa", "TenCa", "TenNV","TongHoaDon","TongHDChi","TongTienCa"};
        return this.getListOfArray(SelectByDate, cols,day);
    }
    
    public void updateDatabase(String MaNV, String TenCa, int SLHoaDon, double TongHoaDon,int SLHoaDonChi,double TongHDC,double TongTienCK,double TongTienMat,double DoanhThu,String NgayGiaoCa) {
        JDBC.update(ThemGiaoCa, MaNV,TenCa,SLHoaDon,TongHoaDon,SLHoaDonChi,TongHDC,TongTienCK,TongTienMat,DoanhThu,NgayGiaoCa);
    }
    public void updateDatabaseTontai( int SLHoaDon, double TongHoaDon,int SLHoaDonChi,double TongHDC,double TongTienCK,double TongTienMat,double DoanhThu) {
        JDBC.update(UpdateGiaoCa,SLHoaDon,TongHoaDon,SLHoaDonChi,TongHDC,TongTienCK,TongTienMat,DoanhThu);
    }
   //-----------------------------------------------------------------------------------
    
    
    public void update(String trangThai,String GhiChu,String maNV){
        JDBC.update(UPDATE_SQL, trangThai,GhiChu,maNV);
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
     public List<Object[]> getDataGiaoCa(String gioBD,String GioKT) {
        String[] cols = {"TongTienHoaDon", "SoLuongHoaDon","TongTienChi","SoLuongHoaDonChi","TongTienMat","TongTienCK","DoanhThu"};
        return this.getListOfArray(FillData, cols,gioBD,GioKT);
    }
    
    public List<Object[]> getFullCa(String Thu) {
        String[] cols = {"TenCaLam", "TenNV", "TrangThai","GhiChu"};
        return this.getListOfArray(FullCa_SQL, cols,Thu);
    }
}
