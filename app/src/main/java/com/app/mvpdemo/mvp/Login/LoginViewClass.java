package com.app.mvpdemo.mvp.Login;

public class LoginViewClass {

    public interface LoginView {
        void onShowProgress();

        void onHideProgress();

        void onSuccess();

        void onFailed(String error);
    }

    interface LoginListener {
        void onLoginSuccess();

        void onLoginFailed(String error);
    }
}