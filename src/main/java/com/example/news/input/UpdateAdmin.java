package com.example.news.input;
import static com.example.news.input.Hash.sha224;

public class UpdateAdmin {

    private String username;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String password;
    private String newPassword;

    public UpdateAdmin(String username, String name, String surname, String address, String email, String password, String newPassword) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.newPassword = sha224(newPassword);
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

    public String getNewPassword() {
        return newPassword;
    }
}
