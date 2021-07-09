package com.alzate.loginmvprepository.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alzate.loginmvprepository.R;

public class LoginActivity extends AppCompatActivity implements LoginMVP.View {

    LoginMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this, getApplication());
    }
}