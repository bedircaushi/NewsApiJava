package com.example.news.input;


import static com.example.news.input.Hash.sha224;

public class LogIn {
    private String email;
    private String password;

    public LogIn(String email, String password){
        this.email = email;
        this.password = sha224(password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
