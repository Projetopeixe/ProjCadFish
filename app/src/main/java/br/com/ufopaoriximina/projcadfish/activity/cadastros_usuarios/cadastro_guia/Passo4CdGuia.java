package br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelEspecie;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;

public class Passo4CdGuia extends AppCompatActivity {

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
                    final Bundle dados = getIntent().getExtras();
                    if(dados != null){
                        String nome = dados.getString(DataModelUsuario.getNome());
                        int exp = dados.getInt(DataModelUsuario.getAnosxp());
                        String cpf = dados.getString(DataModelUsuario.getCpf());
                        String telefone = dados.getString(DataModelUsuario.getTelefone());
                        String city = dados.getString(DataModelUsuario.getCidade());
                        String estado = dados.getString(DataModelUsuario.getEstado());
                        Intent i = new Intent(getApplicationContext(), Passo5CdGuia.class);
                        i.putExtra(DataModelUsuario.getNome(), nome);
                        i.putExtra(DataModelUsuario.getAnosxp(), exp);
                        i.putExtra(DataModelUsuario.getCpf(), cpf);
                        i.putExtra(DataModelUsuario.getTelefone(), telefone);
                        i.putExtra(DataModelUsuario.getCidade(), city);
                        i.putExtra(DataModelUsuario.getEstado(), estado);
                        i.putExtra(DataModelUsuario.getCidade(), emailAdress);
                        i.putExtra(DataModelUsuario.getEstado(), password);
                        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                                , R.transition.fade_in, R.transition.fade_out);
                        ActivityCompat.startActivity(Passo4CdGuia.this, i, activityOptionsCompat.toBundle());
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "Dados não passaram", Toast.LENGTH_SHORT).show();
                    }
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
