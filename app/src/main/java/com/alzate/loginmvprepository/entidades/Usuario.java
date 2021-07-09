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

    @ColumnInfo(name = "nombre")
    @NonNull
    private String nombre;

    @ColumnInfo(name = "identificacion")
    @NonNull
    private String identificacion;

    @ColumnInfo(name = "password")
    @NonNull
    private String password;

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

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }
}
