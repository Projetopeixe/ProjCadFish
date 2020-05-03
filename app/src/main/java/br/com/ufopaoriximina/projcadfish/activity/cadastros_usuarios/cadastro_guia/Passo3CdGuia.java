package br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.activity.OpcaoPescaActivity;
import br.com.ufopaoriximina.projcadfish.dao.BDDao;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelEspecie;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;
import br.com.ufopaoriximina.projcadfish.model.Usuario;

public class Passo3CdGuia extends AppCompatActivity {

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
                        final Bundle dados = getIntent().getExtras();
                        if(dados != null){
                            String nome = dados.getString(DataModelUsuario.getNome());
                            int exp = dados.getInt(DataModelUsuario.getAnosxp());
                            String cpf = dados.getString(DataModelUsuario.getCpf());
                            String telefone = dados.getString(DataModelUsuario.getTelefone());
                            Usuario usuario = new Usuario(nome, exp, cpf, telefone, city, state);
                            BDDao bd = new BDDao(this);
                            try {
                                boolean sucesso = bd.salvarDataInfoGeral(usuario);
                                if(sucesso){
                                    sucessAoCadastrar();
                                }
                            }catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Erro ao cadastrar: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(getApplicationContext(), "Dados não passaram", Toast.LENGTH_SHORT).show();
                        }
                } else {
                    Toast.makeText(getApplicationContext(), "Preencha o campo 'ESTADO'", Toast.LENGTH_SHORT).show();
                }
        }else{
            Toast.makeText(getApplicationContext(), "Preencha o campo 'CIDADE'", Toast.LENGTH_SHORT).show();
        }

    }

    public void sucessAoCadastrar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sucesso ao realizar cadastro");
        builder.setCancelable(false);
        builder.setMessage("Usuário cadastrado com sucesso!");
        builder.setPositiveButton("Criar Perfil", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getApplicationContext(), Passo4CdGuia.class);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                        , R.transition.fade_in, R.transition.fade_out);
                ActivityCompat.startActivity(Passo3CdGuia.this, i, activityOptionsCompat.toBundle());
                finish();
            }
        });
        builder.create();
        builder.show();
    }
}
