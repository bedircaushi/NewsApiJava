package com.example.news.controller;

import com.example.news.input.LogIn;
import com.example.news.input.SignUp;
import com.example.news.input.UpdateAdmin;
import com.example.news.pojo.Admin;
import com.example.news.input.Message;
import com.example.news.pojo.News;
import com.example.news.service.AdminService;
import com.example.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private NewsService newsService;

    @GetMapping("/admin")
    public List<Admin> getAllAdmins(){
        return adminService.findAll();
    }

    @PostMapping("/admin/login")
    public ResponseEntity login(@RequestBody LogIn logIn, HttpServletRequest request) {
        Admin admin = adminService.login(logIn);
        if (admin != null) {
            request.getSession().setAttribute("admin", admin);
            return new ResponseEntity<>(admin, HttpStatus.OK);
        }

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
    public ResponseEntity update(@RequestBody UpdateAdmin updateAdmin, HttpServletRequest request) {
        if (request.getSession() != null){
            Admin admin = adminService.update(updateAdmin);
            if (admin != null)
                return new ResponseEntity<>(admin, HttpStatus.OK);
            return new ResponseEntity<>(new Message("Admin with the username "
                    + updateAdmin.getUsername() + " is not updated or does not exist"), HttpStatus.OK);
        }
        return new ResponseEntity<>("Not logged in", HttpStatus.OK);
    }

    @GetMapping("/admin/news")
    public ResponseEntity getAllNews(HttpServletRequest request){
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if (admin != null) {
            List<News> news = newsService.findByUsername(admin);

            if (news.isEmpty())
                return new ResponseEntity<>(new Message("No news found for this admin"), HttpStatus.OK);

            return new ResponseEntity<>(news, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Not logged in", HttpStatus.OK);

    }

    @GetMapping("/admin/logout")
    public String logout(HttpServletRequest request, HttpServletResponse res) throws IOException {
        if(request.getSession() != null){
            request.getSession().invalidate();
        }
        res.sendRedirect("/news");
        return null;
    }
}
