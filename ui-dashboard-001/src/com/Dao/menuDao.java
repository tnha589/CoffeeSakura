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
public class menuDao{
    
    public static ResultSet rs = null; // Trả về kết quả truy vấn
    public static String JChart_SQL = "Select Sum(Kh.HocPhi) Doanhthu,YEAR(NgayKG) Nam from KhoaHoc kh JOIN HocVien hv ON kh.MaKH = hv.MaKH JOIN ChuyenDe cd ON cd.MaCD = kh.MaCD group by YEAR(NgayKG)";
    public static String PieChart_SQL = "SELECT YEAR(NgayDK) Nam,COUNT(*) SoLuong FROM NguoiHoc GROUP BY YEAR(NgayDK)";
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


    public List<Object[]> getJChart() {
        String[] cols = {"Doanhthu", "Nam"};
        return this.getListOfArray(JChart_SQL, cols);
    }
    public List<Object[]> getPieChart() {
        String[] cols = {"Nam", "SoLuong"};
        return this.getListOfArray(PieChart_SQL, cols);
    }
}
