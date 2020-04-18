package br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_pescador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia.Passo3CdGuia;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;

public class Passo2CadPescador extends AppCompatActivity {
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
                        Intent i = new Intent(getApplicationContext(), Passo3CdPescador.class);
                        i.putExtra(DataModelUsuario.getCpf(), numCpf);
                        i.putExtra(DataModelUsuario.getTelefone(), numTel);
                        startActivity(i);
                        finish();
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
    public void cancelar(){
        finish();
    }
}
