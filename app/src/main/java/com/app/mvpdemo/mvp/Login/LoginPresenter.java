package com.app.mvpdemo.mvp.Login;

public class LoginPresenter implements LoginViewClass.LoginListener {

    LoginViewClass.LoginView loginView;
    LoginInteracter interacter;

    public LoginPresenter(LoginViewClass.LoginView loginView) {
        this.loginView = loginView;
        interacter = new LoginInteracter(this);
    }

    public void onLoginButtonClick(LoginCredential loginCredential) {
        loginView.onShowProgress();
        interacter.login(loginCredential);
    }

    @Override
    public void onLoginSuccess() {
        loginView.onHideProgress();
        loginView.onSuccess();
    }

    @Override
    public void onLoginFailed(String error) {
        loginView.onHideProgress();
        loginView.onFailed(error);
    }
}