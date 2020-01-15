package com.example.news.input;

import static com.example.news.input.Hash.sha224;

public class SignUp {
    private String username;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String password;

    public SignUp(String username, String name, String surname, String address, String email, String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
