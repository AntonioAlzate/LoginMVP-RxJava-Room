package com.alzate.loginmvprepository.ui.login;

import android.app.Application;

import com.alzate.loginmvprepository.dto.InformacionUsuarioDTO;

public class LoginPresenter implements LoginMVP.Presenter{

    LoginMVP.View view;
    LoginMVP.Model model;

    public LoginPresenter(LoginMVP.View view, Application application){
        model = new LoginModel(this, application);
        this.view = view;
    }

    @Override
    public void identificacionRequerida() {
        view.identificacionRequerida();
    }

    @Override
    public void passwordRequerido() {
        view.passwordRequerido();
    }

    @Override
    public void formatoPasswordInvalido() {
        view.formatoPasswordInvalido();
    }

    @Override
    public void validarInformacion() {
        if(view != null){
            model.setIdentificacion(view.getTxtIdentificacion());
            model.setPassword(view.getTxtPassword());
            model.validarDatosIngresados();
        }
    }

    @Override
    public void credencialesCorrectas(InformacionUsuarioDTO informacionUsuarioDTO) {
        view.credencialesValidas(informacionUsuarioDTO);
    }

    @Override
    public void credencialesIncorrectas() {
        view.credencialesNoValidas();
    }
}
