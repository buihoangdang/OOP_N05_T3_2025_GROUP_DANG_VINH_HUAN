package com.example.demo.service;

import com.example.demo.model.SanPham;
import com.example.demo.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository repository;

    public List<SanPham> findAll() {
        return repository.findAll();
    }

    public Optional<SanPham> findById(String id) {
        return repository.findById(id);
    }

    public SanPham save(SanPham sanPham) {
        return repository.save(sanPham);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
