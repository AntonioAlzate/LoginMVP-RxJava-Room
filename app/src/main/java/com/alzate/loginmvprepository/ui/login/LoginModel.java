package com.alzate.loginmvprepository.ui.login;

import android.app.Application;

public class LoginModel implements LoginMVP.Model{

    LoginMVP.Presenter presenter;

    public LoginModel(LoginMVP.Presenter presenter, Application application) {
        this.presenter = presenter;
    }
}
