package br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_pescador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia.Passo3CdGuia;
import br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia.Passo4CdGuia;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;

public class Passo3CdPescador extends AppCompatActivity {

    EditText cidade, estado;
    Button cancelar;
    ImageButton next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);
        getSupportActionBar().hide();
        carregarComponentes();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirProximoPasso();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar();
            }
        });
    }

    public void carregarComponentes(){
        cidade = findViewById(R.id.editCidade);
        estado = findViewById(R.id.editEstado);
        next = findViewById(R.id.next3);
        cancelar = findViewById(R.id.btnCancel3);
    }

    public void cancelar(){
        finish();
    }

    public void abrirProximoPasso(){
        String city = cidade.getText().toString();
        String state = estado.getText().toString();
        if(!city.isEmpty() ){
            if (!state.isEmpty()) {

                Intent i = new Intent(getApplicationContext(), Passo4CdPescador.class);
                i.putExtra(DataModelUsuario.getCidade(), city);
                i.putExtra(DataModelUsuario.getEstado(), state);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                        , R.transition.fade_in, R.transition.fade_out);
                ActivityCompat.startActivity(Passo3CdPescador.this, i, activityOptionsCompat.toBundle());
                finish();

            } else {
                Toast.makeText(getApplicationContext(), "Preencha o campo 'ESTADO'", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Preencha o campo 'CIDADE'", Toast.LENGTH_SHORT).show();
        }

    }
}
