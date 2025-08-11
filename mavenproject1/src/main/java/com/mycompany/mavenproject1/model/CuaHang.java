package com.mycompany.mavenproject1.model;

public class CuaHang {
    private String maCuaHang;
    private String tenChiNhanh;
    private String diaChi;

    public CuaHang() {
    }

    public CuaHang(String maCuaHang, String tenChiNhanh, String diaChi) {
        this.maCuaHang = maCuaHang;
        this.tenChiNhanh = tenChiNhanh;
        this.diaChi = diaChi;
    }

    public String getMaCuaHang() {
        return maCuaHang;
    }

    public String getTenChiNhanh() {
        return tenChiNhanh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setMaCuaHang(String maCuaHang) {
        this.maCuaHang = maCuaHang;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        this.tenChiNhanh = tenChiNhanh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}