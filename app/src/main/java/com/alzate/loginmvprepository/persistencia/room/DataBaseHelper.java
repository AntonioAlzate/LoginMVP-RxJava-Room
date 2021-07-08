package com.alzate.loginmvprepository.persistencia.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.alzate.loginmvprepository.entidades.Usuario;
import com.alzate.loginmvprepository.persistencia.dao.UsuarioDAO;

@Database(entities = {Usuario.class}, version = ParametrosConfiguracion.VERSION, exportSchema = false)
public abstract class DataBaseHelper extends RoomDatabase {

    private static DataBaseHelper instancia;

    public static DataBaseHelper getDb(Context context){
        if(instancia == null){
            instancia = Room.databaseBuilder(context, DataBaseHelper.class, ParametrosConfiguracion.NOMBRE_BASE_DATOS)
                    .build();
        }
        return instancia;
    }

    public static DataBaseHelper getDbMainThread(Context context){
        if(instancia == null){
            instancia = Room.databaseBuilder(context, DataBaseHelper.class, ParametrosConfiguracion.NOMBRE_BASE_DATOS)
                    .allowMainThreadQueries().build();
        }
        return instancia;
    }

    public abstract UsuarioDAO getUsuarioDao();
}
