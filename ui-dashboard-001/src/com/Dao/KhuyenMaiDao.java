/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Dao;

import com.model.KhuyenMai;
import com.model.SanPham;
import com.Helper.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhuyenMaiDao extends PeachCoffeeDao<KhuyenMai, String> {

    public static ResultSet rs = null;
    String SELECT_ALL_SQL = "Select * from KhuyenMai";
    final String SELECT_BY_ID_SQL = "SELECT * from KhuyenMai where MaKM = ?";
    String INSERT_SQL = "INSERT INTO KhuyenMai (MaKM, TenKM, NgayBD, NgayKT, GiaKM, GhiChu, TrangThai, LoaiKM)\n"
            + "        VALUES (?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE [dbo].[KhuyenMai]\n"
            + "SET TenKM = ?,[NgayBD] =?,[NgayKT] =?,[GiaKM] =?,[GhiChu] = ?,[TrangThai] = ? ,[LoaiKM] = ? WHERE [MaKM] = ? ";
    final String DELETE_SQL = "delete from KhuyenMai where MaKM = ?";
    final String INSERT_VOUCHER = "insert into voucher (giatri, MahoaQR) values(?, ?)";
    final String DELETE_VOUCHER = "delete voucher where maVC = ?";
    final String SELECT_MAVC = "select maVC from voucher";
    final String SELECT_MAHOAQR = "select * from voucher";

    public List<KhuyenMai> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM KhuyenMai WHERE TenKM LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    public List<KhuyenMai> selectLoaiKM(Integer number) {
        if (number != 0 && number != 1) {
            return this.selectAll();
        } else {

            String sql = "SELECT * FROM KhuyenMai WHERE LoaiKM LIKE ?";
            return this.selectBySql(sql, number);
        }

    }

    public void UpdateKM(String MaKM, String MaSP) {
        String sql = "update SanPham  set  MaKM = ? where MaSP = ?  ";
        JDBC.update(sql, MaKM, MaSP);

    }

    public void insertVoucher(Integer giatri, String maHoa) {
        JDBC.update(INSERT_VOUCHER, giatri, maHoa);
    }

    public void deleteVoucher(Integer id) {
        JDBC.update(DELETE_VOUCHER, id);
    }

    @Override
    public void insert(KhuyenMai entity) {
        JDBC.update(INSERT_SQL,
                entity.getMaKM(),
                entity.getTenKM(),
                entity.getNgayBD(),
                entity.getNgayKT(),
                entity.getGiaKM(),
                entity.getGhiChu(),
                entity.isTrangThai(),
                entity.isLoaiKM());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(KhuyenMai entity) {
        JDBC.update(UPDATE_SQL, entity.getTenKM(), entity.getNgayBD(), entity.getNgayKT(), entity.getGiaKM(), entity.getGhiChu(), entity.isTrangThai(), entity.isLoaiKM(), entity.getMaKM());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        JDBC.update(DELETE_SQL, id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KhuyenMai selectById(String id) {
        List<KhuyenMai> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhuyenMai> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<KhuyenMai> selectBySql(String sql, Object... args) {
        List<KhuyenMai> list = new ArrayList<>();
        // Trong đoạn mã lấy giá trị từ ResultSet:

        try {
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                KhuyenMai entiny = new KhuyenMai();
                entiny.setMaKM(rs.getString(1));
                entiny.setTenKM(rs.getString(2));
//                entiny.setNgayBD(rs.getNString(3));
                Date ngayBD = rs.getTimestamp(3);
                Date ngayKT = rs.getTimestamp(4);
// Định dạng ngày tháng
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

// Chuyển đổi thành chuỗi
                String ngayBDString = dateFormat.format(ngayBD);

// Đặt giá trị vào entiny
                entiny.setNgayBD(rs.getDate(3));
                String ngayKTString = dateFormat.format(ngayKT);
                entiny.setNgayKT(rs.getDate(4));
                entiny.setGiaKM(rs.getFloat(5));
                entiny.setGhiChu(rs.getString(6));
                entiny.setTrangThai(rs.getBoolean(7));
                entiny.setLoaiKM(rs.getBoolean(8));
                list.add(entiny);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Boolean> selectKM() {
        String sql = "select distinct LoaiKM from KhuyenMai";

        List<Boolean> list = new ArrayList<>();
        try {
            ResultSet rs = JDBC.query(sql);
            while (rs.next()) {
                list.add(rs.getBoolean("LoaiKM"));
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Boolean> selectLoaiSP() {
        String sql = "select distinct TrangThai from KhuyenMai";

        List<Boolean> list = new ArrayList<>();
        try {
            ResultSet rs = JDBC.query(sql);
            while (rs.next()) {
                list.add(rs.getBoolean("TrangThai"));
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public List<Object[]> getMaVC() {
        String[] cols = {"maVC"};
        return this.getListOfArray(SELECT_MAVC, cols);
    }

    public List<Object[]> getMaHoaQR() {
        String[] cols = {"maVC", "giatri", "MahoaQR"};
        return this.getListOfArray(SELECT_MAHOAQR, cols);
    }

}
