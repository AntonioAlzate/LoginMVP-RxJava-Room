package com.alzate.loginmvprepository.ui.login;

import android.app.Application;

public class LoginPresenter implements LoginMVP.Presenter{

    LoginMVP.View view;
    LoginMVP.Model model;

    public LoginPresenter(LoginMVP.View view, Application application){
        model = new LoginModel(this, application);
        this.view = view;
    }
}
