package com.mycompany.mavenproject1.model;

public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private int tuoi;
    private String viTri;
    private String cuaHang;

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String hoTen, int tuoi, String viTri, String cuaHang) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.viTri = viTri;
        this.cuaHang = cuaHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public String getViTri() {
        return viTri;
    }

    public String getCuaHang() {
        return cuaHang;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public void setCuaHang(String cuaHang) {
        this.cuaHang = cuaHang;
    }
    
}
