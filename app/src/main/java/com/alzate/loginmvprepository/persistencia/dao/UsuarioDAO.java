package com.alzate.loginmvprepository.persistencia.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.alzate.loginmvprepository.entidades.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {

    @Insert
    void insertar(Usuario usuario);

    @Update
    void actualizar(Usuario usuario);

    @Delete
    void eliminar(Usuario usuario);

    @Query("SELECT * FROM usuario")
    List<Usuario> obtenerTodos();
}
