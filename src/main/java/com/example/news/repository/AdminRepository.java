package com.example.news.repository;

import com.example.news.pojo.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Admin,String> {
    List<Admin> findAll();
    Admin save(Admin admin);
    Admin findByEmail(String email);
}
