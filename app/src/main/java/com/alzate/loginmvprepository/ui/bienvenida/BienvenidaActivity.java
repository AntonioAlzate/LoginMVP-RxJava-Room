package com.alzate.loginmvprepository.ui.bienvenida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alzate.loginmvprepository.R;
import com.alzate.loginmvprepository.dto.InformacionUsuarioDTO;
import com.alzate.loginmvprepository.ui.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BienvenidaActivity extends AppCompatActivity {

    @BindView(R.id.txtNombreEnviado)
    public TextView txtNombreEnviado;
    @BindView(R.id.txtIdentificacionEnviado)
    public TextView txtIdentificacionEnviada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        ButterKnife.bind(this);

        cargarInformacionEnviada();
    }

    private void cargarInformacionEnviada() {
        Bundle objetoEnviado = getIntent().getExtras();
        InformacionUsuarioDTO infoUsuario;

        if(objetoEnviado != null){
            infoUsuario = (InformacionUsuarioDTO) objetoEnviado.getSerializable(LoginActivity.EXTRA_INFO_USUARIO);
            txtNombreEnviado.setText(infoUsuario.getNombre());
            txtIdentificacionEnviada.setText(infoUsuario.getIdentificacion());
        }
    }
}