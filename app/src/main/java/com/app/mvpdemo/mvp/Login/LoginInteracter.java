package com.app.mvpdemo.mvp.Login;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Patterns;

public class LoginInteracter {

    LoginViewClass.LoginListener loginListener;

    public LoginInteracter(LoginViewClass.LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public void login(LoginCredential loginCredential) {
        if (hasError(loginCredential)) {
            return;
        }

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                loginListener.onLoginSuccess();
            }
        }, 3000);
    }

    public boolean hasError(LoginCredential loginCredential) {
        String email = loginCredential.getEmail();
        String password = loginCredential.getPassword();

        if (TextUtils.isEmpty(email)) {
            loginListener.onLoginFailed("Please enter email.");
            return true;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loginListener.onLoginFailed("Invalid email.");
            return true;
        }

        if (TextUtils.isEmpty(password)) {
            loginListener.onLoginFailed("Please enter password.");
            return true;
        }

        if (password.length() < 5) {
            loginListener.onLoginFailed("Week Password");
            return true;
        }
        return false;
    }
}