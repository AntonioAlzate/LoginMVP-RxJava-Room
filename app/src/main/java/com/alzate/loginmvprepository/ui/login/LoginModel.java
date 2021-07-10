package com.alzate.loginmvprepository.ui.login;

import android.app.Application;

import com.alzate.loginmvprepository.dto.InformacionUsuarioDTO;
import com.alzate.loginmvprepository.entidades.Usuario;
import com.alzate.loginmvprepository.repository.UsuarioRepository;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginModel implements LoginMVP.Model {

    LoginMVP.Presenter presenter;

    UsuarioRepository usuarioRepository;

    private String identificacion;
    private String password;

    public LoginModel(LoginMVP.Presenter presenter, Application application) {
        this.presenter = presenter;
        usuarioRepository = new UsuarioRepository(application);
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void validarDatosIngresados() {
        if ("".equals(password)) {
            presenter.passwordRequerido();
        } else if (!esValidaPassword(password)) {
            presenter.formatoPasswordInvalido();
        }

        if ("".equals(identificacion)) {
            presenter.identificacionRequerida();
        }

        validarCredenciales();
    }

    @Override
    public void validarCredenciales() {
        usuarioRepository.existeUsuarioCredenciales(identificacion, password)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Usuario>() {
                    @Override
                    public void accept(Usuario usuario) throws Exception {
                        if(usuario != null){
                            InformacionUsuarioDTO infoUsuario = usuarioToInformacionUsuarioDTO(usuario);
                            presenter.credencialesCorrectas(infoUsuario);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        presenter.credencialesIncorrectas();
                    }
                });
    }

    private InformacionUsuarioDTO usuarioToInformacionUsuarioDTO(Usuario usuario){
        InformacionUsuarioDTO infoUsuario = new InformacionUsuarioDTO();
        infoUsuario.setNombre(usuario.getNombre());
        infoUsuario.setIdentificacion(usuario.getIdentificacion());

        return infoUsuario;
    }

    @Override
    public boolean esValidaPassword(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        if (password.matches(pattern))
            return true;

        return false;
    }
}
