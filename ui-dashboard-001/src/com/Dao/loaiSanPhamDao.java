/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Dao;

import static com.Dao.sanPhamDao.DELETE_SQL;
import static com.Dao.sanPhamDao.INSERT_SQL;
import static com.Dao.sanPhamDao.SELECT_ALL_SQL;
import static com.Dao.sanPhamDao.SELECT_BY_ID_SQL;
import static com.Dao.sanPhamDao.rs;
import com.Helper.JDBC;
import com.model.LoaiSanPham;
import com.model.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class loaiSanPhamDao extends PeachCoffeeDao<LoaiSanPham, String> {
    public static ResultSet rs = null; // Trả về kết quả truy vấn
    public static String INSERT_SQL = "Insert into LoaiSanPham (MaLSP,TenLSP) VALUES (?,?)";
    public static String UPDATE_SQL = "Update LoaiSanPham set TenLSP = ? where MaLSP = ?";
    public static String DELETE_SQL = "Delete from LoaiSanPham where MaLSP = ?";
    public static String SELECT_ALL_SQL = "Select * from LoaiSanPham";
    public static String SELECT_BY_ID_SQL = "SELECT * FROM LoaiSanPham WHERE MaLSP=?";
    @Override
    public void insert(LoaiSanPham entity) {
       JDBC.update(INSERT_SQL,
                entity.getMaLoaiSP(),
                entity.getLoaiSP()              
        );
    }

    @Override
    public void update(LoaiSanPham entity) {
       JDBC.update(INSERT_SQL,
                entity.getLoaiSP(),
               entity.getMaLoaiSP()
        );
    }

    @Override
    public void delete(String key) {
       JDBC.update(DELETE_SQL, key);
    }

    @Override
    public List<LoaiSanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public LoaiSanPham selectById(String key) {
        List<LoaiSanPham> list = selectBySql(SELECT_BY_ID_SQL, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<LoaiSanPham> selectBySql(String sql, Object... args) {
        List<LoaiSanPham> list = new ArrayList<>();
        try {
            try {
                rs = JDBC.query(sql, args);
                while (rs.next()) {
                    LoaiSanPham entity = new LoaiSanPham();
                    entity.setMaLoaiSP(rs.getString("MaLSP"));
                    entity.setLoaiSP(rs.getString("TenLSP"));
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
    
}
