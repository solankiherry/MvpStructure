package com.app.mvpdemo.mvp.Login;

public class LoginCredential {
    String email, password;

    public LoginCredential(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}