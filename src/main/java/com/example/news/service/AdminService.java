package com.example.news.service;

import com.example.news.input.LogIn;
import com.example.news.input.SignUp;
import com.example.news.input.UpdateAdmin;
import com.example.news.pojo.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> findAll();
    Admin login(LogIn login);
    Admin signUp(SignUp signUp);
    Admin update(UpdateAdmin updateAdmin);
    void delete(Admin admin);
}
