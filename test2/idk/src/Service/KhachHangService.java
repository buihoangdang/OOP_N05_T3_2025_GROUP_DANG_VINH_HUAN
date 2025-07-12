package com.example.demo.service;

import com.example.demo.model.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository repository;

    public List<KhachHang> findAll() {
        return repository.findAll();
    }

    public Optional<KhachHang> findById(String id) {
        return repository.findById(id);
    }

    public KhachHang save(KhachHang khachHang) {
        return repository.save(khachHang);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
