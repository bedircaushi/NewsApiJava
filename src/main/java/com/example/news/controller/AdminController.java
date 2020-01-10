package com.example.news.controller;

import com.example.news.pojo.Admin;
import com.example.news.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public List<Admin> getAllAdmin(){
        return adminService.findAll();
    }
}
