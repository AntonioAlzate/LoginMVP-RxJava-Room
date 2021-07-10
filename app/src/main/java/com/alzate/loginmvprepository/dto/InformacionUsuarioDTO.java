package com.alzate.loginmvprepository.dto;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

import java.io.Serializable;

public class InformacionUsuarioDTO implements Serializable {

    private String nombre;

    private String identificacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
