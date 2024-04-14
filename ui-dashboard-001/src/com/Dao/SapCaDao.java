/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Dao;

import static com.Dao.ChiTieuDao.SELECT_ALL_SQL;
import static com.Dao.ChiTieuDao.SELECT_BY_ID_SQL;
import static com.Dao.ChiTieuDao.rs;
import static com.Dao.HoaDonDAO_1.UPDATE_SQL;
import com.Helper.JDBC;
import static com.Helper.JDBC.connectionUrl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.ChiTieu;
import com.model.SapCa;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ACER
 */
public class SapCaDao extends PeachCoffeeDao<SapCa, String> {

    public static ResultSet rs = null; // Trả về kết quả truy vấn

    public static String SapCa_ThuNgan = "select MaNV,TenNV from NhanVien where ChucVu like N'Thu Ngân' and TrangThai =1";
    public static String SapCa_PhucVu = "select MaNV,TenNV from NhanVien where ChucVu like N'Nhân Viên' and TrangThai =1";  
    public static String ThemSapCa1 = "{}";
    public static String XapCa_SQL = "{CALL sp_XapCa (?)}";
    public static String LoadNV = "{CALL sp_LoadNVCa (?,?)}";
    //   insert into ChiTietCaLamViec(MaCaLam,MaNV,ChucVu) values (18,'NV006',N'Thu ngân')

    //  public static String INSERT_SQL = "insert into CaLam (MaCaLam, TenCaLam, Thu) VALUES (6, N'Sáng sớm', N'Chủ nhật');";
    public static String SELECT_ALL_SQL = "select* from ChiTietCaLamViec";
    public static String SELECT_BY_ID_SQL = "SELECT * FROM ChiTietCaLamViec WHERE MaNV=?";

    @Override
    public void insert(SapCa entity) {
        JDBC.update(ThemSapCa1,
                entity.getMaCL(),
                entity.getMaNV(),
                entity.getTrangThai(),
                entity.getGhiChu(),
                entity.isChucVu());
    }

    @Override
    public void update(SapCa entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SapCa> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SapCa selectById(String key) {
        List<SapCa> list = selectBySql(SELECT_BY_ID_SQL, key);
        return list.size() > 0 ? list.get(0) : new SapCa();
    }

    @Override
    public List<SapCa> selectBySql(String sql, Object... args) {
        List<SapCa> list = new ArrayList<>();
        try {
            rs = JDBC.query(sql, args);
            while (rs.next()) {
                SapCa entity = new SapCa();
                entity.setMaNV(rs.getString("MaNV"));
//                entity.setTenNV(rs.getString("TenNV"));
                //      entity.setChucVu(rs.getBoolean("ChucVu"));
                entity.setTrangThai(rs.getString("TrangThai"));
                // Thêm tất cả các dòng vào list
                list.add(entity);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();  // Đóng ResultSet khi đã xử lý xong
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
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

    public List<Object[]> getThuNgan() {
        String[] cols = {"MaNV", "TenNV"};
        return this.getListOfArray(SapCa_ThuNgan, cols);
    }

    public List<Object[]> getPhucVu() {
        String[] cols = {"MaNV", "TenNV"};
        return this.getListOfArray(SapCa_PhucVu, cols);
    }

    public List<Object[]> getXapCa(String Thu) {
        String[] cols = {"TenCaLam", "SoLuongNhanVien"};
        return this.getListOfArray(XapCa_SQL, cols, Thu);
    }
    
    public List<Object[]> loadNV(String Thu,String ca) {
        String[] cols = { "MaNV","TenNV","ChucVu"};
        return this.getListOfArray(LoadNV, cols, Thu,ca);
    }

  
}
