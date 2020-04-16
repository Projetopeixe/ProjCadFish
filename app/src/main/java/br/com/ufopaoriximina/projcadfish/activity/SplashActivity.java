package br.com.ufopaoriximina.projcadfish.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.config.AplicationController;
import br.com.ufopaoriximina.projcadfish.dao.BDDao;
import br.com.ufopaoriximina.projcadfish.dao.DataSource;

public class SplashActivity extends AppCompatActivity {

    private DataSource mBancoLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

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
                BDDao bd = new BDDao(getBaseContext());
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


