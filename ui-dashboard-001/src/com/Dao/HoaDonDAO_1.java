/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Dao;

import com.model.HoaDon;
import com.Helper.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonDAO_1 extends PeachCoffeeDao<HoaDon, String> {

    //Son
    final String INSERT_SQL = "INSERT INTO HoaDon (MaHD, ThoiGianTao, ThoiGianTT, NguoiTao,  TongTien, ChiPhiKhac, HinhThucTT, GhiChu, TrangThai, TenNguoiTao, TienNhan,voucher) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    final String SELECT_ALL_SQL = "select * from HoaDon  ORDER BY CAST(SUBSTRING(HoaDon.MaHD, 3, LEN(HoaDon.MaHD) - 2) AS INT)";
    final String UPDATE_TRANGTHAI_HUY = "update HoaDon set TrangThai = N'Yêu cầu hủy' where MaHD = ?";
    final String UPDATE_TRANGTHAIKHOIPHUC = "update HoaDon set TrangThai = N'Đang xử lý' where MaHD = ?";
    final String UPDATE_TRANGTHAIHUYHOADON = "update HoaDon set TrangThai = N'Đã hủy' where MaHD = ?";
    final String UPDATE_LyDo = "update HoaDon set LyDoHuy = ? where MaHD = ?";
    //PhucDu
    String slect_sp = "SELECT \n"
            + "        SP.TenSP,\n"
            + "        COUNT(HD.SanPham) AS SpLuong,\n"
            + "        SUM(HD.TongTien) AS TongTien\n"
            + "    FROM HoaDon HD\n"
            + "    JOIN SanPham SP ON HD.SanPham = SP.MaSP\n"
            + "    GROUP BY SP.TenSP";

    @Override
    public void insert(HoaDon entity) {
        JDBC.update(INSERT_SQL, entity.getMaHD(), entity.getThoiGianTao(), entity.getThoiGianThanhToan(), entity.getNguoiTao(), entity.getTongTien(), entity.getChiPhiKhac(), entity.getHinhThucThanhToan(), entity.getGhiChu(), entity.getTrangThai(), entity.getTenNguoiTao(), entity.getTienNhan(), entity.getVoucher());
    }

    @Override
    public void update(HoaDon entity) {

    }

    public void updateEmail(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    public List<HoaDon> selectSP() {
        return this.selectBySql(slect_sp);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<HoaDon> selectHDCoDK(Date NgayBDHD, Date NgayKTRHD) {
        String SELECT_HD_SQL_CoDK = "SELECT * FROM HoaDon\n"
                + "WHERE ThoiGianTao >= ? AND ThoiGianTao <= ? "
                + "and TrangThai like N'Đã xử lý';";
        return this.selectBySql(SELECT_HD_SQL_CoDK, NgayBDHD, NgayKTRHD);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDon selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setMaHD(rs.getString("MaHD"));
                entity.setThoiGianTao(rs.getDate("ThoiGianTao"));
                entity.setThoiGianThanhToan(rs.getDate("ThoiGianTT"));
                entity.setNguoiTao(rs.getString("NguoiTao"));
                entity.setTongTien(rs.getDouble("TongTien"));
                entity.setChiPhiKhac(rs.getDouble("ChiPhiKhac"));
                entity.setHinhThucThanhToan(rs.getString("HinhThucTT"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setTrangThai(rs.getString("TrangThai"));
                entity.setTenNguoiTao(rs.getString("TenNguoiTao"));
                entity.setTienNhan(rs.getDouble("TienNhan"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //Nam
    public static ResultSet rs = null; // Trả về kết quả truy vấn
    public static String FULL_HOADON = "Select * From HoaDon where TrangThai like N'Đang xử lý' or TrangThai like N'Yêu cầu hủy' ORDER BY CAST(SUBSTRING(HoaDon.MaHD, 3, LEN(HoaDon.MaHD) - 2) AS INT)";
    public static String FULL_LSHOADON = "SELECT * \n"
            + "FROM HoaDon \n"
            + "WHERE (TrangThai = N'Đã xử lý' OR TrangThai = N'Đã hủy') \n"
            + "AND CONVERT(DATE, ThoiGianTao) = CONVERT(DATE, GETDATE()) ORDER BY CAST(SUBSTRING(HoaDon.MaHD, 3, LEN(HoaDon.MaHD) - 2) AS INT)";
    public static String HoaDonCT_SQL = "{CALL sp_HoaDonChiTiet(?)}";
    public static String ThongTinChiTiet_SQL = "{CALL sp_ThongTinChiTiet(?)}";
    public static String UPDATE_SQL = "Update HoaDon set TrangThai = N'Đã xử lý' where MaHD like ?";

//-----------------------------------------------------------------------------------------------------
    public static String LUONGNGUOIHOC_SQL = "{CALL sp_LuongNguoiHoc}";
    public static String DIEMCHUYENDE_SQL = "{CALL sp_DiemChuyenDe}";
    public static String DOANHTHU_SQL = "{CALL sp_DoanhThu (?)}";
    public static String JChart_SQL = "Select Sum(Kh.HocPhi) Doanhthu,YEAR(NgayKG) Nam from KhoaHoc kh JOIN HocVien hv ON kh.MaKH = hv.MaKH JOIN ChuyenDe cd ON cd.MaCD = kh.MaCD group by YEAR(NgayKG)";
    public static String PieChart_SQL = "SELECT YEAR(NgayDK) Nam,COUNT(*) SoLuong FROM NguoiHoc GROUP BY YEAR(NgayDK)";

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

    public List<Object[]> getHoaDonCT(String maHD) {
        String[] cols = {"TenSP", "DonGia", "SoLuong", "ThanhTien", "GhiChu"};
        return this.getListOfArray(HoaDonCT_SQL, cols, maHD);
    }

    public List<Object[]> getThongTinChiTiet(String maHD) {
        String[] cols = {"MaHD", "TenNguoiTao", "ThoiGianTao", "ThoiGianTT", "GhiChu", "TrangThai", "ThanhTien", "ChiPhiKhac", "TongTien", "LyDoHuy","voucher"};
        return this.getListOfArray(ThongTinChiTiet_SQL, cols, maHD);
    }

    public List<Object[]> getHoaDon() {
        //Thêm ThoiGianTT
        String[] cols = {"MaHD", "ThoiGianTao", "ThoiGianTT", "NguoiTao", "TongTien", "ChiPhiKhac", "HinhThucTT", "GhiChu", "TrangThai", "TenNguoiTao"};
        return this.getListOfArray(FULL_HOADON, cols);
    }

    public List<Object[]> getLSHoaDon() {
        String[] cols = {"MaHD", "TenNguoiTao", "ThoiGianTao", "ThoiGianTT", "TongTien", "TrangThai"};
        return this.getListOfArray(FULL_LSHOADON, cols);
    }

    public void update(String trangThai) {
        JDBC.update(UPDATE_SQL, trangThai);
    }

    public List<Object[]> getHoaDonMenu(String maHD) {
        String SelectHD = "select * from HoaDon where MaHD like ?";
        String[] cols = {"MaHD", "ThoiGianTao", "ThoiGianTT", "NguoiTao", "TongTien", "ChiPhiKhac", "HinhThucTT", "GhiChu", "TrangThai", "TenNguoiTao", "TienNhan", "LyDoHuy","voucher"};
        return this.getListOfArray(SelectHD, cols, maHD);
    }
//-----------------------------------------------------------------------------------------------

    public List<Object[]> getDiemChuyenDe() {
        String[] cols = {"ChuyenDe", "SoHV", "ThapNhat", "CaoNhat", "TrungBinh"};
        return this.getListOfArray(DIEMCHUYENDE_SQL, cols);
    }

    public List<Object[]> getDoanhThu(int nam) {
        String[] cols = {"ChuyenDe", "SoKH", "SoHV", "DoanhThu", "ThapNhat", "CaoNhat", "TrungBinh"};
        return this.getListOfArray(DOANHTHU_SQL, cols, nam);
    }

    public List<Object[]> getJChart() {
        String[] cols = {"Doanhthu", "Nam"};
        return this.getListOfArray(JChart_SQL, cols);
    }

    public List<Object[]> getPieChart() {
        String[] cols = {"Nam", "SoLuong"};
        return this.getListOfArray(PieChart_SQL, cols);
    }

    public void updateTrangThai(String maHD) {
        JDBC.update(UPDATE_TRANGTHAI_HUY, maHD);
    }

    public void updateLyDo(String lyDo, String maHD) {
        JDBC.update(UPDATE_LyDo, lyDo, maHD);
    }

    public void updateTrangThai_KhoiPhuc(String maHD) {
        JDBC.update(UPDATE_TRANGTHAIKHOIPHUC, maHD);
    }

    public void updateTrangThaiHuyHoaDon(String maHD) {
        JDBC.update(UPDATE_TRANGTHAIHUYHOADON, maHD);
    }

    public List<Object[]> loadHDTheoNgay(String date) {
        String SELECT_HD_THEO_NGAY = "SELECT * \n"
                + "FROM HoaDon \n"
                + "WHERE (TrangThai = N'Đã xử lý' OR TrangThai = N'Đã hủy') \n"
                + "AND CONVERT(DATE, ThoiGianTao) = ?;";
        String[] cols = {"MaHD", "TenNguoiTao", "ThoiGianTao", "ThoiGianTT", "TongTien", "TrangThai"};
        return this.getListOfArray(SELECT_HD_THEO_NGAY, cols, date);
    }
}
