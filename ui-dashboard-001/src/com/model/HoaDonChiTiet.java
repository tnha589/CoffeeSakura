/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author Admin
 */
public class HoaDonChiTiet {

    private int maHDCT;
    private String MaHD;
    private String MaSP;
    private int soLuong;
    private double giaSP;
    private double tongTien;
    private String maKM;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int maHDCT, String MaHD, String MaSP, int soLuong, double giaSP, double tongTien, String maKM) {
        this.maHDCT = maHDCT;
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.soLuong = soLuong;
        this.giaSP = giaSP;
        this.tongTien = tongTien;
        this.maKM = maKM;
    }

    public int getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

}
