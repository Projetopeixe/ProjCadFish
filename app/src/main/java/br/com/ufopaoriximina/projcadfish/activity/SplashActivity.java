package br.com.ufopaoriximina.projcadfish.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.config.AplicationController;
import br.com.ufopaoriximina.projcadfish.datasource.DataSource;

public class SplashActivity extends AppCompatActivity {

    private DataSource mBancoLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (AplicationController.verificarGooglePlayService(SplashActivity.this)) {
            apresentarTelaSplash();
        } else {
            Toast.makeText(getApplicationContext(), "Google Services não configurados", Toast.LENGTH_LONG).show();
        }
    }

    public void apresentarTelaSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DataSource ds = new DataSource(getApplicationContext());
                abriTelaInicialLogin();

            }
        }, 3000);
    }

    public void abriTelaInicialLogin() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }

}


