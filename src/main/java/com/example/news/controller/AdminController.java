package com.example.news.controller;

import com.example.news.input.LogIn;
import com.example.news.input.SignUp;
import com.example.news.input.UpdateAdmin;
import com.example.news.pojo.Admin;
import com.example.news.pojo.Message;
import com.example.news.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/admin/login")
    public ResponseEntity login(@RequestBody LogIn logIn) {
        Admin admin = adminService.login(logIn);
        if (admin != null)
            return new ResponseEntity<>(admin, HttpStatus.OK);

        return new ResponseEntity<>(new Message("Wrong email or password"), HttpStatus.OK);
    }

    @PostMapping("/admin/signup")
    public ResponseEntity signUp(@RequestBody SignUp signUp) {
        Admin admin = adminService.signUp(signUp);
        if(admin != null)
            return new ResponseEntity<>(admin, HttpStatus.OK);
        return new ResponseEntity<>(new Message("Admin with the username "
                + signUp.getUsername() + " exists"), HttpStatus.OK);
    }

    @PostMapping("/admin/update")
    public ResponseEntity update(@RequestBody UpdateAdmin updateAdmin) {
        Admin admin = adminService.update(updateAdmin);
        if (admin != null)
            return new ResponseEntity<>(admin, HttpStatus.OK);
        return new ResponseEntity<>(new Message("Admin with the username "
                + updateAdmin.getUsername() + " is not updated or does not exist"), HttpStatus.OK);
    }
}
