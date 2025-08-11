package com.mycompany.mavenproject1.model;

public class DonHang {
    private String maDonHang;
    private String maKhachHang;
    private String ngayDat;
    private double tongTien;

    public DonHang() {
    }

    public DonHang(String maDonHang, String maKhachHang, String ngayDat, double tongTien) {
        this.maDonHang = maDonHang;
        this.maKhachHang = maKhachHang;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    
    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
