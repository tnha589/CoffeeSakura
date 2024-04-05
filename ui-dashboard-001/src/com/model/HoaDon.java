/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {

    private String maHD;
    private Date thoiGianTao;
    private Date thoiGianThanhToan;
    private String nguoiTao;
    private double tongTien;
    private double chiPhiKhac;
    private String hinhThucThanhToan;
    private String ghiChu;
    private String trangThai;
    private String tenNguoiTao;
    private double tienNhan;
    private String voucher;

    public HoaDon() {
    }

    public HoaDon(String maHD, Date thoiGianTao, Date thoiGianThanhToan, String nguoiTao, double tongTien, double chiPhiKhac, String hinhThucThanhToan, String ghiChu, String trangThai, String tenNguoiTao, double tienNhan, String voucher) {
        this.maHD = maHD;
        this.thoiGianTao = thoiGianTao;
        this.thoiGianThanhToan = thoiGianThanhToan;
        this.nguoiTao = nguoiTao;
        this.tongTien = tongTien;
        this.chiPhiKhac = chiPhiKhac;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.tenNguoiTao = tenNguoiTao;
        this.tienNhan = tienNhan;
        this.voucher = voucher;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Date thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public Date getThoiGianThanhToan() {
        return thoiGianThanhToan;
    }

    public void setThoiGianThanhToan(Date thoiGianThanhToan) {
        this.thoiGianThanhToan = thoiGianThanhToan;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getChiPhiKhac() {
        return chiPhiKhac;
    }

    public void setChiPhiKhac(double chiPhiKhac) {
        this.chiPhiKhac = chiPhiKhac;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenNguoiTao() {
        return tenNguoiTao;
    }

    public void setTenNguoiTao(String tenNguoiTao) {
        this.tenNguoiTao = tenNguoiTao;
    }

    public double getTienNhan() {
        return tienNhan;
    }

    public void setTienNhan(double tienNhan) {
        this.tienNhan = tienNhan;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

}
