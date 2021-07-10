package com.alzate.loginmvprepository.ui.login;

import com.alzate.loginmvprepository.dto.InformacionUsuarioDTO;

public interface LoginMVP {

    public interface View{

        void identificacionRequerida();

        void passwordRequerido();

        void formatoPasswordInvalido();

        String getTxtIdentificacion();
        String getTxtPassword();

        void credencialesValidas(InformacionUsuarioDTO informacionUsuarioDTO);

        void credencialesNoValidas();
    }

    public interface Presenter{

        void identificacionRequerida();

        void passwordRequerido();

        void formatoPasswordInvalido();

        void validarInformacion();

        void credencialesCorrectas(InformacionUsuarioDTO informacionUsuarioDTO);

        void credencialesIncorrectas();
    }

    public interface Model{
        boolean esValidaPassword(String password);

        void setIdentificacion(String identificacion);
        void setPassword(String password);

        void validarDatosIngresados();

        void validarCredenciales();
    }
}
