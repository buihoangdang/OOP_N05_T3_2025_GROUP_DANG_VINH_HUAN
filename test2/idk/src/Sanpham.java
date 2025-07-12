package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sanpham")
public class SanPham {

    @Id
    private String id;
    private String name;
    private double price;
    private int soluong;

    public SanPham() {
    }

    public SanPham(String id, String name, double price, int soluong) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.soluong = soluong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void hienThiThongTin() {
        System.out.println("Sản phẩm: " + name);
        System.out.println("Giá: " + price + " VND");
        System.out.println("Số lượng còn: " + soluong);
    }
}
