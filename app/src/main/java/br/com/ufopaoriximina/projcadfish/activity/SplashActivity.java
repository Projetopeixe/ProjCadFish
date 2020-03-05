package br.com.ufopaoriximina.projcadfish.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.config.AplicationConrtoller;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(AplicationConrtoller.verificarGooglePlayService(SplashActivity.this)){
            apresentarTelaSplash();
        }else {
            Toast.makeText(getApplicationContext(), "Google Services não configurados", Toast.LENGTH_LONG).show();
        }
    }

    public void apresentarTelaSplash(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                abriTelaInicialLogin();
            }
        }, 3000);
    }

    public void abriTelaInicialLogin(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }
}