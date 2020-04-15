package br.com.ufopaoriximina.projcadfish.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.config.AplicationController;
import br.com.ufopaoriximina.projcadfish.datasource.DataSource;

public class SplashActivity extends AppCompatActivity {

    private DataSource mBancoLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        inicializarBancoLocal();
        if(AplicationController.verificarGooglePlayService(SplashActivity.this)){

             apresentarTelaSplash();

        }else {
            Toast.makeText(getApplicationContext(), "Google Services não configurados", Toast.LENGTH_LONG).show();
        }
    }

    public void apresentarTelaSplash(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                abriTelaInicialLogin();
            }
        }, 3000);
    }

    public void abriTelaInicialLogin(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void inicializarBancoLocal(){
        mBancoLocal = new DataSource(this);

        File database = getApplicationContext().getDatabasePath(DataSource.DB_NAME);
        if(database.exists() == false){
            mBancoLocal.getReadableDatabase();

            if(copiaBanco(this)){
                alert("Banco Copiado com Sucesso");
            }else{
                alert("Erro ao copiar o banco");
            }
        }
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public boolean copiaBanco(Context context){
        try {
            InputStream inputStream = context.getAssets().open(DataSource.DB_NAME);
            String outFile = DataSource.LOCALDB + DataSource.DB_NAME;
            OutputStream outputStream = new FileOutputStream(outFile);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0){
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
