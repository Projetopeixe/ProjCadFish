package br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_pescador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.ufopaoriximina.projcadfish.R;

public class Passo1CdPescador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        getSupportActionBar().hide();
    }
}
