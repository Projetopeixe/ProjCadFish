package br.com.ufopaoriximina.projcadfish.activity.cadastro_peixes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.activity.EpPescadas;
import br.com.ufopaoriximina.projcadfish.activity.GruposExistentes;
import br.com.ufopaoriximina.projcadfish.activity.OpcaoPescaActivity;
import br.com.ufopaoriximina.projcadfish.activity.criacao_grupo.ActivityCriarGrupo1;

public class ActivityCadPeixe1 extends AppCompatActivity {

    EditText especie;
    ImageView imgEspecie;
    Button finalizar;
    ImageView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_peixe1);
        carregarElementosView();
        getSupportActionBar().hide();
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkExit();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextPassRegister();
            }
        });
    }

    public void carregarElementosView(){
        especie = findViewById(R.id.editEspecieCadP);
        imgEspecie = findViewById(R.id.fotoEspecieCadP);
        finalizar = findViewById(R.id.btnFinalize);
        next = findViewById(R.id.proximoCadFish);
    }

    public void openNextPassRegister(){
        String nomeE = especie.getText().toString();

        if(!nomeE.isEmpty()){
            Intent i = new Intent(getApplicationContext(), ActivityCadPeixe2.class);
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                    , R.transition.fade_in, R.transition.fade_out);
            ActivityCompat.startActivity(ActivityCadPeixe1.this, i, activityOptionsCompat.toBundle());
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Preencha o campo 'ESPECIE'", Toast.LENGTH_SHORT).show();
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
    private void checkExit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja realmente cancelar?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(), EpPescadas.class);
                        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                                , R.transition.fade_in, R.transition.fade_out);
                        ActivityCompat.startActivity(ActivityCadPeixe1.this, i, activityOptionsCompat.toBundle());
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
