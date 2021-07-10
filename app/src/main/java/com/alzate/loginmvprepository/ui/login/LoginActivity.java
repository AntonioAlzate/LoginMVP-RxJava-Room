package com.alzate.loginmvprepository.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alzate.loginmvprepository.R;
import com.alzate.loginmvprepository.dto.InformacionUsuarioDTO;
import com.alzate.loginmvprepository.entidades.Usuario;
import com.alzate.loginmvprepository.persistencia.room.DataBaseHelper;
import com.alzate.loginmvprepository.ui.bienvenida.BienvenidaActivity;
import com.alzate.loginmvprepository.ui.registro.RegistroUsuarioActivity;

import java.util.Observable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity implements LoginMVP.View {

    LoginMVP.Presenter presenter;

    @BindView(R.id.txtIdentificacion)
    public EditText txtIdentificacion;
    @BindView(R.id.txtPassword)
    public EditText txtPassword;

    public static final String EXTRA_INFO_USUARIO = "com.alzate.loginmvprepository.ui.login.EXTRA_INFO_USUARIO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this, getApplication());
    }

    @OnClick(R.id.btnIngresar)
    public void ingresarSistema(View view){
        presenter.validarInformacion();
    }

    @OnClick(R.id.btnRegistroUsuario)
    public void irRegistroUsuario(View view){
        Intent intent = new Intent(this, RegistroUsuarioActivity.class);
        startActivity(intent);
    }

    // Forma directa en Activity
    public void consultaCredenciales(){
        DataBaseHelper.getDb(this).getUsuarioDao()
                .verificarCredenciales(getTxtIdentificacion(), getTxtPassword())
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Usuario>() {
                    @Override
                    public void accept(Usuario usuario) throws Exception {
                        if(usuario != null)
                            Toast.makeText(LoginActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(LoginActivity.this, "Pailas", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public String getTxtIdentificacion() {
        return txtIdentificacion.getText().toString();
    }

    public String getTxtPassword() {
        return txtPassword.getText().toString();
    }

    @Override
    public void passwordRequerido() {
        txtPassword.setError(getString(R.string.requerido));
    }

    @Override
    public void formatoPasswordInvalido() {
        txtPassword.setError(getString(R.string.formato_pass_incorrecta));
    }

    @Override
    public void identificacionRequerida() {
        txtIdentificacion.setError(getString(R.string.requerido));
    }

    @Override
    public void credencialesValidas(InformacionUsuarioDTO informacionUsuarioDTO) {
        Intent intent = new Intent(this, BienvenidaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_INFO_USUARIO, informacionUsuarioDTO);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    @Override
    public void credencialesNoValidas() {
        Toast.makeText(this, R.string.credenciales_incorrectas, Toast.LENGTH_SHORT).show();
    }
}