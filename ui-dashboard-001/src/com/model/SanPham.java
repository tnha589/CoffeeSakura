 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author HP
 */
public class SanPham {

    private String maSP;
    private String tenSP;
    private String hinh;
    private Double gia;
    private String ghiChu;
    private String loaiSP;
    private String khuyenMai;
    private boolean trangThai;

    public SanPham() {
    }

    @Override
    public String toString() {
        return this.tenSP;
    }

    @Override
    public boolean equals(Object obj) {
        SanPham sp = (SanPham) obj;
        return sp.getMaSP().equals(this.getMaSP());
    }

    public SanPham(String maSP, String tenSP, String hinh, Double gia, String ghiChu, String loaiSP, String khuyenMai, boolean trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.hinh = hinh;
        this.gia = gia;
        this.ghiChu = ghiChu;
        this.loaiSP = loaiSP;
        this.khuyenMai = khuyenMai;
        this.trangThai = trangThai;
    }

    
   public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

   
    
}
