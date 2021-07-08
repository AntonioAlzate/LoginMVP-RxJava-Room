package com.alzate.loginmvprepository.repository;

import android.app.Application;

import com.alzate.loginmvprepository.entidades.Usuario;
import com.alzate.loginmvprepository.persistencia.dao.UsuarioDAO;
import com.alzate.loginmvprepository.persistencia.room.DataBaseHelper;

import java.util.List;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UsuarioRepository {

    private UsuarioDAO usuarioDAO;

    private Application application;

    public UsuarioRepository(Application application) {
        DataBaseHelper db = DataBaseHelper.getDb(application);
        usuarioDAO = db.getUsuarioDao();

        this.application = application;
    }

    public void insertar(Usuario usuario) {
        Observable.fromCallable(()-> {
            usuarioDAO.insertar(usuario);
            return usuario;
        }).subscribeOn(Schedulers.computation()).subscribe();
    }

    public void eliminar(Usuario usuario) {
        Observable.fromCallable(()-> {
            usuarioDAO.eliminar(usuario);
            return usuario;
        }).subscribeOn(Schedulers.computation()).subscribe();
    }

    public void actualizar(Usuario usuario) {
        Observable.fromCallable(()-> {
            usuarioDAO.actualizar(usuario);
            return usuario;
        }).subscribeOn(Schedulers.computation()).subscribe();
    }

    public List<Usuario> obtenerTodos() {

        return usuarioDAO.obtenerTodos();
    }

}
