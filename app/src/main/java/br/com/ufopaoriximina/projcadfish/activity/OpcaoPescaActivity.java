package br.com.ufopaoriximina.projcadfish.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import br.com.ufopaoriximina.projcadfish.R;

public class OpcaoPescaActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_opcao_pesca);
        carregarComponentesOpPesca();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirLIst();
            }
        });
    }

    public void abrirLIst(){
        Intent i = new Intent(getApplicationContext(), GruposExistentes.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                , R.transition.fade_in, R.transition.fade_out);
        ActivityCompat.startActivity(OpcaoPescaActivity.this, i, activityOptionsCompat.toBundle());
        finish();
    }

    public void carregarComponentesOpPesca(){
        imageView = findViewById(R.id.ImagemGrupo);
        menu = findViewById(R.id.menuOpcao);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_op_pesca, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.deslogar_menu:
                return true;
        }
        return super.onOptionsItemSelected(item);
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
