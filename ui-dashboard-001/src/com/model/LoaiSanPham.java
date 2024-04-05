/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author HP
 */
public class LoaiSanPham {
    private String maLoaiSP;
    private String loaiSP;

    public LoaiSanPham() {
    }
    @Override
    public String toString(){
        return this.loaiSP;
    }
    public LoaiSanPham(String maLoaiSP, String loaiSP) {
        this.maLoaiSP = maLoaiSP;
        this.loaiSP = loaiSP;
    }

    public String getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }
    
}
