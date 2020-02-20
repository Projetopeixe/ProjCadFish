package br.com.ufopaoriximina.projcadfish.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.com.ufopaoriximina.projcadfish.R;

public class ActivityInicial extends AppCompatActivity {

    private ImageView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        getSupportActionBar().hide();

        login = findViewById(R.id.btn_login_inicial);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abriTelaInicialLogin();
            }
        });
    }

    public void abriTelaInicialLogin(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
