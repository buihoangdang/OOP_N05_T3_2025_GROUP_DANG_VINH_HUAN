package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuahang")
public class CuaHang {

    @Id
    private String id;
    private String name;
    private String location;

    public CuaHang() {
    }

    public CuaHang(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void hienThiThongTin() {
        System.out.println("Cửa hàng: " + name);
        System.out.println("Địa điểm: " + location);
    }
}
