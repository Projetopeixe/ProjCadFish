package br.com.ufopaoriximina.projcadfish.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.ufopaoriximina.projcadfish.R;

public class OpcaoPescaActivity extends AppCompatActivity {

    ImageView opcaoGrupo;
    ImageView opcaoIndividual;
    ImageView image;
    private TextView nameUserHader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_opcao_pesca);
        carregarComponentesOpPesca();
        opcaoIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirListPescaIndividual();
            }
        });
        opcaoGrupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirListGrupo();
            }
        });

    }

    public void abrirListPescaIndividual(){
        Intent i = new Intent(getApplicationContext(), EpPescadas.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                , R.transition.fade_in, R.transition.fade_out);
        ActivityCompat.startActivity(OpcaoPescaActivity.this, i, activityOptionsCompat.toBundle());
        finish();
    }
    public void abrirListGrupo(){
        Intent i = new Intent(getApplicationContext(), GruposExistentes.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                , R.transition.fade_in, R.transition.fade_out);
        ActivityCompat.startActivity(OpcaoPescaActivity.this, i, activityOptionsCompat.toBundle());
        finish();
    }

    public void carregarComponentesOpPesca(){
        opcaoGrupo = findViewById(R.id.ImagemGrupo);
        opcaoIndividual = findViewById(R.id.menuOpcaoIndividual);
        image = findViewById(R.id.fotoUser);
        nameUserHader = findViewById(R.id.nomeUser);
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
}
