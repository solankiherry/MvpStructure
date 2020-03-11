package com.app.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.app.mvpdemo.databinding.ActivityMainBinding;
import com.app.mvpdemo.mvp.Login.LoginViewClass;
import com.app.mvpdemo.mvp.Login.LoginCredential;
import com.app.mvpdemo.mvp.Login.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginViewClass.LoginView {
    ActivityMainBinding mainBinding;
    LoginPresenter loginPresenter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        loginPresenter = new LoginPresenter(this);
        progressDialog = new ProgressDialog(this);

        mainBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mainBinding.edEmail.getText().toString().trim();
                String password = mainBinding.edPassword.getText().toString().trim();

                LoginCredential loginCredential = new LoginCredential(email, password);
                loginPresenter.onLoginButtonClick(loginCredential);
            }
        });
    }

    @Override
    public void onShowProgress() {
        if (progressDialog != null && !progressDialog.isShowing())
            progressDialog.show();
    }

    @Override
    public void onHideProgress() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.hide();
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "Login Success...", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, HomePageActivity.class));
    }

    @Override
    public void onFailed(String error) {
        Toast.makeText(this, "Fail : " + error, Toast.LENGTH_SHORT).show();
    }
}