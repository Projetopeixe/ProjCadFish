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
import br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia.Passo4CdGuia;
import br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia.Passo5CdGuia;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;

public class Passo4CdPescador extends AppCompatActivity {

    EditText email, senha;
    Button cancelar;
    ImageButton next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_4);
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
        email = findViewById(R.id.editEmail);
        senha = findViewById(R.id.editSenha);
        next = findViewById(R.id.next4);
        cancelar = findViewById(R.id.btnCancel4);
    }

    public void cancelar(){
        finish();
    }

    public void abrirProximoPasso(){
        String emailAdress = email.getText().toString();
        String password = senha.getText().toString();
        if(!emailAdress.isEmpty() ){
            if (!password.isEmpty()) {
                if(password.length() >= 8){
                    Intent i = new Intent(getApplicationContext(), Passo5CdPescador.class);
                    i.putExtra(DataModelUsuario.getCidade(), emailAdress);
                    i.putExtra(DataModelUsuario.getEstado(), password);
                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                            , R.transition.fade_in, R.transition.fade_out);
                    ActivityCompat.startActivity(Passo4CdPescador.this, i, activityOptionsCompat.toBundle());
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Senha muito curta!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Preencha o campo 'SENHA'", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Preencha o campo 'EMAIL'", Toast.LENGTH_SHORT).show();
        }

    }
}
