package br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.rtoshiro.util.format.MaskFormatter;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.activity.UserCadastroActivity;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;

public class Passo2CdGuia extends AppCompatActivity {

    EditText cpf, numberPhone;
    Button cancelar;
    ImageButton next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        getSupportActionBar().hide();
        carregarComponentes();

        //Máscara cpf
        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(cpf, smf);
        cpf.addTextChangedListener(mtw);

        //Máscara Telefone
        SimpleMaskFormatter smf2 = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        MaskTextWatcher mtw2 = new MaskTextWatcher(numberPhone, smf2);
        numberPhone.addTextChangedListener(mtw2);

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
        cpf = findViewById(R.id.editCpf);
        numberPhone = findViewById(R.id.editTelefone);
        next = findViewById(R.id.next2);
        cancelar = findViewById(R.id.btnCancel2);
    }
    public void abrirProximoPasso(){
        String numCpf = cpf.getText().toString();
        String numTel = numberPhone.getText().toString();
        if(!numCpf.isEmpty() ){
            if(numCpf.length() >= 11) {
                if (!numTel.isEmpty()) {
                    if(numTel.length() >= 11) {
                        final Bundle dados = getIntent().getExtras();
                        if(dados != null){
                            String nome = dados.getString(DataModelUsuario.getNome());
                            int exp = dados.getInt(DataModelUsuario.getAnosxp());
                            Intent i = new Intent(getApplicationContext(), Passo3CdGuia.class);
                            i.putExtra(DataModelUsuario.getNome(), nome);
                            i.putExtra(DataModelUsuario.getAnosxp(), exp);
                            i.putExtra(DataModelUsuario.getCpf(), numCpf);
                            i.putExtra(DataModelUsuario.getTelefone(), numTel);
                            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                                    , R.transition.fade_in, R.transition.fade_out);
                            ActivityCompat.startActivity(Passo2CdGuia.this, i, activityOptionsCompat.toBundle());
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(), "Dados não Passaram", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Número de Telefone Inválido!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Preencha o campo 'TELEFONE'", Toast.LENGTH_SHORT).show();
                }
            }else {
               Toast.makeText(getApplicationContext(), "Número de CPF inválido!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Preencha o campo 'CPF'", Toast.LENGTH_SHORT).show();
        }

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            checkExit();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
    private void checkExit()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja realmente cancelar?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(), UserCadastroActivity.class);
                        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                                , R.transition.fade_in, R.transition.fade_out);
                        ActivityCompat.startActivity(Passo2CdGuia.this, i, activityOptionsCompat.toBundle());
                        finish();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void cancelar(){
        checkExit();
    }

}
