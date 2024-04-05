/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Dao;

import com.Helper.JDBC;
import com.model.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class nhanVienDao extends PeachCoffeeDao<NhanVien, String> {

    public static ResultSet rs = null; // Trả về kết quả truy vấn
    public static String INSERT_SQL = "Insert into NhanVien (MaNV,TenNV,Email,SDT,MatKhau,NgayVaoLam,GhiChu,GioiTinh,TrangThai,ChucVu,Hinh)values (?,?,?,?,?,?,?,?,?,?,?)";
    public static String UPDATE_SQL = "Update NhanVien set TenNV = ?,Email = ?,SDT= ?,MatKhau = ?,NgayVaoLam=?,GhiChu=?,GioiTinh = ?,TrangThai = ?,ChucVu = ?,Hinh = ?  where MaNV = ?";
    public static String DELETE_SQL = "Delete from NhanVien where MaNV = ?";
    public static String SELECT_ALL_SQL = "Select * from NhanVien";
    public static String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV=?";
    public static String SELECT_BY_KEYWORD_SQL = "SELECT * FROM NhanVien WHERE (TenNV LIKE ? OR MaNV LIKE ? OR SDT LIKE ? OR ChucVu like ? OR TrangThai = ?)";
    public static String SELECT_BY_KEYWORD_SQL1 = "SELECT * FROM NhanVien WHERE TrangThai like ? and ChucVu like ?";
    public static String SELECT_BY_TrangThai = "SELECT * FROM NhanVien WHERE TrangThai like ?";
    public static final String UPDATE_EMAIL_SQL = "UPDATE NhanVien SET Email = ? WHERE MaNV = ?";
    public static String Update_MaHoa = "update NhanVien set MaHoaQR = ? where MaNV = ?";
    @Override
    public void insert(NhanVien entity) {
        JDBC.update(INSERT_SQL,
                entity.getMaNV(),
                entity.getTenNV(),
                entity.getEmail(),
                entity.getSoDT(),
                entity.getMatKhau(),
                entity.getNgayVaoLam(),
                entity.getGhiChu(),
                entity.isGioiTinh(),
                entity.isTrangThai(),
                entity.getChuVu(),
                entity.getHinh());

    }

    @Override
    public void update(NhanVien entity) {
        JDBC.update(UPDATE_SQL,
                entity.getTenNV(),
                entity.getEmail(),
                entity.getSoDT(),
                entity.getMatKhau(),
                entity.getNgayVaoLam(),
                entity.getGhiChu(),
                entity.isGioiTinh(),
                entity.isTrangThai(),
                entity.getChuVu(),
                entity.getHinh(),
                entity.getMaNV());
    }

    @Override
    public void delete(String key) {
        JDBC.update(DELETE_SQL, key);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String key) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            try {
                rs = JDBC.query(sql, args);
                while (rs.next()) {
                    NhanVien entity = new NhanVien();
                    entity.setMaNV(rs.getString("MaNV"));
                    entity.setTenNV(rs.getString("TenNV"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setSoDT(rs.getString("SDT"));
                    entity.setMatKhau(rs.getString("MatKhau"));
                    entity.setNgayVaoLam(rs.getDate("NgayVaoLam"));
                    entity.setGhiChu(rs.getString("GhiChu"));
                    entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                    entity.setTrangThai(rs.getBoolean("TrangThai"));
                    entity.setChuVu(rs.getString("ChucVu"));
                    entity.setHinh(rs.getString("Hinh"));
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

    public List<NhanVien> selectByKeyword(String key) {
        return this.selectBySql(SELECT_BY_KEYWORD_SQL, "%" + key + "%", "%" + key + "%", "%" + key + "%", "%" + key + "%", "%" + key + "%");
    }

    public List<NhanVien> selectBy2Keyword(boolean key1, String key2) {
        return this.selectBySql(SELECT_BY_KEYWORD_SQL1, key1, key2);
    }

    public List<NhanVien> selectByTrangThai(boolean key1) {
        return this.selectBySql(SELECT_BY_TrangThai, key1);
    }

    public void updateEmail(NhanVien entity) {
        JDBC.update(UPDATE_EMAIL_SQL,
                entity.getEmail(),
                entity.getMaNV());
    }
    public List<NhanVien> updateMaHoa(String maHoa, String MaNV ){
     return selectBySql(Update_MaHoa, maHoa, MaNV);
    }
}
