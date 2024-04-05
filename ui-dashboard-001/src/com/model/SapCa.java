/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

/**
 *
 * @author ACER
 */
public class SapCa {

    private int CTCL;
    private int MaCL;
    private String TenCL;
    private String TenNV;
    private String MaNV;
    private boolean ChucVu;
    private String TrangThai;
    private String GhiChu;

    public SapCa() {
    }

    public SapCa(int CTCL, int MaCL, String TenCL, String TenNV, String MaNV, boolean ChucVu, String TrangThai, String GhiChu) {
        this.CTCL = CTCL;
        this.MaCL = MaCL;
        this.TenCL = TenCL;
        this.TenNV = TenNV;
        this.MaNV = MaNV;
        this.ChucVu = ChucVu;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
    }

    public int getCTCL() {
        return CTCL;
    }

    public void setCTCL(int CTCL) {
        this.CTCL = CTCL;
    }

    public int getMaCL() {
        return MaCL;
    }

    public void setMaCL(int MaCL) {
        this.MaCL = MaCL;
    }

    public String getTenCL() {
        return TenCL;
    }

    public void setTenCL(String TenCL) {
        this.TenCL = TenCL;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public boolean isChucVu() {
        return ChucVu;
    }

    public void setChucVu(boolean ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    

}
