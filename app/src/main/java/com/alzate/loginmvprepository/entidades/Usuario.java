package com.alzate.loginmvprepository.entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.alzate.loginmvprepository.persistencia.room.Tabla;

@Entity(tableName = Tabla.USUARIO)
public class Usuario {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idUsuario")
    private int idUsuario;

    @ColumnInfo(name = "identificacion")
    @NonNull
    private String identificacion;

    @ColumnInfo(name = "password")
    @NonNull
    private String password;

    @ColumnInfo(name = "rol")
    private String rol;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @NonNull
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(@NonNull String identificacion) {
        this.identificacion = identificacion;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
