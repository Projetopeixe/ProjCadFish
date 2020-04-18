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
import br.com.ufopaoriximina.projcadfish.activity.UserCadastroActivity;
import br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia.Passo1CdGuia;
import br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia.Passo2CdGuia;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;

public class Passo1CdPescador extends AppCompatActivity {

    EditText nome, experiencia;
    Button cancelar;
    ImageButton next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
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

    public void abrirProximoPasso(){
        String nomeString = nome.getText().toString();
        String exp = experiencia.getText().toString();
        if(!nomeString.isEmpty()){
            if (!exp.isEmpty()){
                int expInt = Integer.parseInt(exp);
                Intent i = new Intent(getApplicationContext(), Passo2CadPescador.class);
                i.putExtra(DataModelUsuario.getNome(), nomeString);
                i.putExtra(DataModelUsuario.getAnosxp(), expInt);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                        , R.transition.fade_in, R.transition.fade_out);
                ActivityCompat.startActivity(Passo1CdPescador.this, i, activityOptionsCompat.toBundle());
                finish();
            }else {
                Toast.makeText(getApplicationContext(), "Preencha o campo 'EXPERIÊNCIA'", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Preencha o campo 'NOME'", Toast.LENGTH_SHORT).show();
        }

    }

    public void carregarComponentes(){
        nome = findViewById(R.id.editNome);
        experiencia = findViewById(R.id.editExperiencia);
        cancelar = findViewById(R.id.btnCancel);
        next = findViewById(R.id.next);
    }

    public void cancelar(){
        finish();
    }
}
