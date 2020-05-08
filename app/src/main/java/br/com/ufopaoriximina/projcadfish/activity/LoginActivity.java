package br.com.ufopaoriximina.projcadfish.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.config.Permissoes;
import br.com.ufopaoriximina.projcadfish.dao.DataSource;

public class LoginActivity extends AppCompatActivity  {

    private  String[] permissoesNecessarias = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private EditText editEmail, editSenha;
    private Button logar;
    DataSource ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        ds = new DataSource(this);
        carregarComponentesLogin();
        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logar();
            }
        });
        Permissoes.validarPermissoes(permissoesNecessarias, this, 1);

    }

    public void logar(){
        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();
        if(!email.isEmpty()){
            if(!senha.isEmpty()){
                String res = ds.logar(email, senha);

                if (res.equals("OK")){
                    Intent i = new Intent(LoginActivity.this, OpcaoPescaActivity.class);
                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                            , R.transition.fade_in, R.transition.fade_out);
                    ActivityCompat.startActivity(LoginActivity.this, i, activityOptionsCompat.toBundle());
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Erro ao logar", Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(getApplicationContext(), "Preencha o campo 'SENHA'", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Preencha o campo 'EMAIL'", Toast.LENGTH_SHORT).show();
        }
    }
    public void carregarComponentesLogin(){
        editEmail = findViewById(R.id.edit_text_email);
        editSenha = findViewById(R.id.edit_text_senha);
        logar = findViewById(R.id.btn_logar);
    }
    public void abrirCadastro(View view){
        Intent i = new Intent(LoginActivity.this, UserCadastroActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                , R.transition.fade_in, R.transition.fade_out);
        ActivityCompat.startActivity(LoginActivity.this, i, activityOptionsCompat.toBundle());

    }

    // Código botão Voltar
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
        builder.setMessage("Deseja realmente sair?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
    //

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int permissaoResultado: grantResults){
            if(permissaoResultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }
        }
    }
    private void alertaValidacaoPermissao(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões Negadas!");
        builder.setMessage("Para utilizar o aplicativo é necessário aceitar as permissões");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
