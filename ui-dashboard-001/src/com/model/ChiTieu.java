/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class ChiTieu {
    private int MaHD;
    private String MaNV;
    private String TenNV;
    private double Tien;
    private Date ThoiGian;
    private boolean TrangThai;
    private String GhiChu;

    public ChiTieu() {
    }

    public ChiTieu(int MaHD, String MaNV, String TenNV, double Tien, Date ThoiGian, boolean TrangThai, String GhiChu) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.Tien = Tien;
        this.ThoiGian = ThoiGian;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public double getTien() {
        return Tien;
    }

    public void setTien(double Tien) {
        this.Tien = Tien;
    }

    public Date getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Date ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

   
    
    
}
