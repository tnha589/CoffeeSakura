/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Dao;

import com.Helper.JDBC;
import com.Dao.PeachCoffeeDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.ChiTieu;

/**
 *
 * @author ACER
 */
public class ChiTieuDao extends PeachCoffeeDao<ChiTieu, String> {

    public static ResultSet rs = null; // Trả về kết quả truy vấn
    public static String INSERT_SQL = "Insert into HoaDonChi (NguoiTao,TenNguoiTao,TienLay,ThoiGianTao,GhiChu)values (?,?,?,?,?)";
    public static String UPDATE_SQL = "Update HoaDonChi set TrangThai = ? where MaHD = ?";
    public static String SELECT_ALL_SQL = "Select * from HoaDonChi";
    public static String SELECT_BY_ID_SQL = "SELECT * FROM HoaDonChi WHERE MaHD=?";

    @Override
    public void insert(ChiTieu entity) {
        JDBC.update(INSERT_SQL,
                entity.getMaNV(), // NguoiTao
                entity.getTenNV(),
                entity.getTien(), // TienLay
                entity.getThoiGian(), // ThoiGianTao
                entity.getGhiChu());
    }

    @Override
    public void update(ChiTieu entity) {
        JDBC.update(UPDATE_SQL,
                entity.isTrangThai(),
                entity.getMaHD());

    }

    @Override
    public void delete(String key) {
        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTieu> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChiTieu selectById(String key) {
        List<ChiTieu> list = selectBySql(SELECT_BY_ID_SQL, key);
        return list.size() > 0 ? list.get(0) : new ChiTieu();
    }

   


    @Override
    public List<ChiTieu> selectBySql(String sql, Object... args) {
        List<ChiTieu> list = new ArrayList<>();
        try {
            try {
                rs = JDBC.query(sql, args);
                while (rs.next()) {
                    ChiTieu entity = new ChiTieu();
                    entity.setMaHD(rs.getInt("MaHD"));
                    entity.setMaNV(rs.getString("NguoiTao"));
                    entity.setTenNV(rs.getString("TenNguoiTao"));
                    entity.setTien(rs.getDouble("TienLay"));
                    entity.setThoiGian(rs.getDate("ThoiGianTao"));
                    entity.setGhiChu(rs.getString("GhiChu"));
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

    public ChiTieu selectById(int MaHD) {
          List<ChiTieu> list = selectBySql(SELECT_BY_ID_SQL, MaHD);
        return list.size() > 0 ? list.get(0) : new ChiTieu();
    }

    
}
