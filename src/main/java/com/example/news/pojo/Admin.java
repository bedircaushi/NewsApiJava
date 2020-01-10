package com.example.news.pojo;

import javax.persistence.*;

@Entity
@Table(name = "admin_")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "username")
    private String username;

    @Column(name = "name_")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "password_")
    private String password;

    public Admin() {
    }

    public Admin(final String username,final String name, final String address,final String email,final String password){
        this.username=username;
        this.name=name;
        this.address=address;
        this.email=email;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
