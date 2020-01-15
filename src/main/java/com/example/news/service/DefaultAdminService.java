package com.example.news.service;

import com.example.news.input.LogIn;
import com.example.news.input.SignUp;
import com.example.news.input.UpdateAdmin;
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

    @Override
    public Admin login(LogIn login) {
        Admin admin = adminRepository.findByEmail(login.getEmail());
        if (admin != null)
            if (admin.getPassword().equals(login.getPassword()))
                return admin;
        return null;
    }


    @Override
    public Admin signUp(SignUp signUp) {
        Admin admin = adminRepository.findByEmail(signUp.getEmail());
        if (admin == null){
            admin = new Admin(signUp.getUsername(), signUp.getName(), signUp.getSurname(),
                    signUp.getAddress(), signUp.getEmail(), signUp.getPassword());
            return adminRepository.save(admin);
        }
        return null;
    }

    @Override
    public Admin update(UpdateAdmin updateAdmin) {
        Admin admin = login(new LogIn(updateAdmin.getEmail(), updateAdmin.getPassword()));
        if(admin != null) {
            admin.setAddress(updateAdmin.getAddress());
            admin.setName(updateAdmin.getName());
            admin.setPassword(updateAdmin.getNewPassword());
            admin.setSurname(updateAdmin.getSurname());
            return adminRepository.save(admin);
        }
        return null;
    }

    @Override
    public void delete(Admin admin) {
        adminRepository.delete(admin);
    }
}
