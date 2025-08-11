package com.mycompany.mavenproject1.model;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String loai;
    private double gia;
    private String size;
    private int soLuongTon;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, String loai, double gia, String size, int soLuongTon) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.loai = loai;
        this.gia = gia;
        this.size = size;
        this.soLuongTon = soLuongTon;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public String getLoai() {
        return loai;
    }

    public double getGia() {
        return gia;
    }

    public String getSize() {
        return size;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }
}
