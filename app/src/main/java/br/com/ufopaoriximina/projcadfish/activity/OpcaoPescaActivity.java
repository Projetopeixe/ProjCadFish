package br.com.ufopaoriximina.projcadfish.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.com.ufopaoriximina.projcadfish.R;

public class OpcaoPescaActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcao_pesca);
        imageView = findViewById(R.id.ImagemGrupo);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirLIst();
            }
        });
    }

    public void abrirLIst(){
        Intent i = new Intent(getApplicationContext(), GruposExistentes.class);
        startActivity(i);
        finish();
    }
}
