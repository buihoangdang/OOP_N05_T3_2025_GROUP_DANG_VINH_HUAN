package com.example.demo.service;

import com.example.demo.model.CuaHang;
import com.example.demo.repository.CuaHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuaHangService {

    @Autowired
    private CuaHangRepository repository;

    public List<CuaHang> findAll() {
        return repository.findAll();
    }

    public Optional<CuaHang> findById(String id) {
        return repository.findById(id);
    }

    public CuaHang save(CuaHang cuaHang) {
        return repository.save(cuaHang);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
