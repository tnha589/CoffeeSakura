/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.util.Date;

/**
 *
 * @author HP
 */
public class NhanVien {

    private String maNV;
    private String tenNV;
    private String Email;
    private String soDT;
    private String matKhau;
    private Date ngayVaoLam;
    private String ghiChu;
    private boolean gioiTinh;
    private boolean trangThai;
    private String chuVu;
    private String hinh;
    private String maHoa;
    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String Email, String soDT, String matKhau, Date ngayVaoLam, String ghiChu, boolean gioiTinh, boolean trangThai, String chuVu, String hinh, String maHoa) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.Email = Email;
        this.soDT = soDT;
        this.matKhau = matKhau;
        this.ngayVaoLam = ngayVaoLam;
        this.ghiChu = ghiChu;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
        this.chuVu = chuVu;
        this.hinh = hinh;
        this.maHoa = maHoa;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getChuVu() {
        return chuVu;
    }

    public void setChuVu(String chuVu) {
        this.chuVu = chuVu;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMaHoa() {
        return maHoa;
    }

    public void setMaHoa(String maHoa) {
        this.maHoa = maHoa;
    }



}
