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
}
