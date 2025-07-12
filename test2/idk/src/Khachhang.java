package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang {

    @Id
    private String id;
    private String name;
    private String phone;
    private String address;

    public KhachHang() {
    }

    public KhachHang(String id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void hienThiThongTin() {
        System.out.println("Khách hàng: " + name);
        System.out.println("SĐT: " + phone);
        System.out.println("Địa chỉ: " + address);
    }
}
