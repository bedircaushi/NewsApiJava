package com.example.news.service;

import com.example.news.pojo.Admin;
import com.example.news.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultAdminService implements AdminService{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }
}
