package br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.ufopaoriximina.projcadfish.R;

public class Passo1CdGuia extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        getSupportActionBar().hide();


    }

    public void abrirProximoPasso(View view){
        Intent i = new Intent(getApplicationContext(), Passo2CdGuia.class);
        startActivity(i);
        finish();;
    }
}
