/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Dao;

import static com.Dao.nhanVienDao.DELETE_SQL;
import static com.Dao.nhanVienDao.INSERT_SQL;
import static com.Dao.nhanVienDao.SELECT_ALL_SQL;
import static com.Dao.nhanVienDao.SELECT_BY_ID_SQL;
import static com.Dao.nhanVienDao.rs;
import com.Helper.JDBC;
import com.model.NhanVien;
import com.model.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class sanPhamDao extends PeachCoffeeDao<SanPham, String> {

    public static ResultSet rs = null; // Trả về kết quả truy vấn
    public static String INSERT_SQL = "Insert into SanPham(MaSP,TenSP,HinhAnh,Gia,GhiChu,MaLSP,TrangThai)values (?,?,?,?,?,?,?)";
    public static String UPDATE_SQL = "Update SanPham set TenSP = ?,HinhAnh = ?,Gia = ?,GhiChu = ?,MaLSP = ?, TrangThai = ? where MaSP = ?";
    public static String DELETE_SQL = "Delete from SanPham where MaSP = ?";
    public static String SELECT_ALL_SQL = "Select * from SanPham";
    public static String SELECT_BY_ID_SQL = "SELECT * FROM SanPham WHERE MaSP=?";
    public static String SELECT_TLSP = "SELECT a.*, b.TenLSP FROM SanPham a INNER JOIN LoaiSanPham b ON a.MaLSP = b.MaLSP ORDER BY CAST(SUBSTRING(a.MaSP, 3, LEN(a.MaSP) - 2) AS INT)";
    public static String SELECT_BY_KEYWORD_SQL = "SELECT *,b.TenLSP FROM SanPham a Inner join LoaiSanPham b on a.MaLSP = b.MaLSP WHERE (TenSP LIKE ? OR MaSP LIKE ? OR TenLSP like ?)";

    @Override
    public void insert(SanPham entity) {
        JDBC.update(INSERT_SQL,
                entity.getMaSP(),
                entity.getTenSP(),
                entity.getHinh(),
                entity.getGia(),
                entity.getGhiChu(),
                entity.getLoaiSP(),
                entity.isTrangThai()
        );
    }

    @Override
    public void update(SanPham entity) {
        JDBC.update(UPDATE_SQL,
                entity.getTenSP(),
                entity.getHinh(),
                entity.getGia(),
                entity.getGhiChu(),
                entity.getLoaiSP(),
                entity.isTrangThai(),
                entity.getMaSP());
    }

    @Override
    public void delete(String key) {
        JDBC.update(DELETE_SQL, key);
    }

    @Override
    public List<SanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SanPham selectById(String key) {
        List<SanPham> list = selectBySql(SELECT_BY_ID_SQL, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            try {
                rs = JDBC.query(sql, args);
                while (rs.next()) {
                    SanPham entity = new SanPham();
                    entity.setMaSP(rs.getString("MaSP"));
                    entity.setTenSP(rs.getString("TenSP"));
                    entity.setHinh(rs.getString("HinhAnh"));
                    entity.setGia(rs.getDouble("Gia"));
                    entity.setGhiChu(rs.getString("GhiChu"));
                    entity.setLoaiSP(rs.getString("MaLSP"));
                    entity.setKhuyenMai(rs.getString("MaKM"));
                    entity.setTrangThai(rs.getBoolean("TrangThai"));
                    list.add(entity);
                }
            } finally {
                if (rs != null) {
                    rs.close();  // Đóng ResultSet khi đã xử lý xong
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
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

    public List<Object[]> getSanPhamFull() {
        String[] cols = {"MaSP", "TenSP", "HinhAnh", "Gia", "GhiChu", "MaLSP", "TrangThai", "TenLSP"};
        return this.getListOfArray(SELECT_TLSP, cols);
    }

    public  List<Object[]> selectByKeyword(String key) {
        String[] cols = {"MaSP", "TenSP", "Gia", "TenLSP","TrangThai", "GhiChu"};
        return this.getListOfArray(SELECT_BY_KEYWORD_SQL, cols,"%" + key + "%", "%" + key + "%","%" + key + "%");       
    }
     public List<String> selectTenLSP() {
        String sql = "select distinct TenLSP from SanPham\n"
                + "inner join LoaiSanPham on SanPham.MaLSP = LoaiSanPham.MaLSP";
        String all = "Tất cả";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JDBC.query(sql);
            list.add(all);
            while (rs.next()) {
                
                list.add(rs.getString("TenLSP"));
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
     public List<SanPham> selectByKeywordProduct(String keyword) {
        String sql = "SELECT * FROM SanPham WHERE TenSp LIKE ?";
        return selectBySql(sql, "%" + keyword + "%");
    }

    public List<SanPham> selectByLoaiSP(String keyword) {
        String sql = "select * \n"
                + "from SanPham sp\n"
                + "inner join LoaiSanPham lsp on lsp.MaLSP = sp.MaLSP\n"
                + "where TenLSP like ?";
        return selectBySql(sql, "%" + keyword + "%");
    }
    
    public List<SanPham> selectByTenAdnLoaiSP(String ten,String loaiSP) {
        String sql = "select * \n"
                + "from SanPham sp\n"
                + "inner join LoaiSanPham lsp on lsp.MaLSP = sp.MaLSP\n"
                + "where lsp.TenLSP like ? AND sp.TenSp like ?";
        return selectBySql(sql, "%" + loaiSP + "%",  "%" + ten + "%");
    }
      
}
