package br.com.ufopaoriximina.projcadfish.activity.criacao_grupo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.activity.GruposExistentes;
import br.com.ufopaoriximina.projcadfish.activity.UserCadastroActivity;
import br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia.Passo1CdGuia;
import br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia.Passo2CdGuia;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelGrupo;

public class ActivityCriarGrupo1 extends AppCompatActivity {

    EditText nameGrupo;
    EditText dataExpedicao;
    ImageView next;
    Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_grupo1);
        getSupportActionBar().hide();
        carregarComponentesView();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkExit();
            }
        });

        SimpleMaskFormatter smf = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(dataExpedicao, smf);
        dataExpedicao.addTextChangedListener(mtw);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNextStepGpCriation();
            }
        });
    }

    public void carregarComponentesView(){
        nameGrupo = findViewById(R.id.editNomeGP);
        dataExpedicao = findViewById(R.id.editExpedicao) ;
        next = findViewById(R.id.proximoPassoGpCriation) ;
        cancel = findViewById(R.id.btnCancelGpCriation);
    }

    public void openNextStepGpCriation(){
        String nomeGp = nameGrupo.getText().toString();
        String datExpe = dataExpedicao.getText().toString();
        if(!nomeGp.isEmpty()){
            if(!datExpe.isEmpty()){
                Intent i = new Intent(getApplicationContext(), ActivityCriarGrupo2.class);
                i.putExtra(DataModelGrupo.getNome(), nomeGp);
                i.putExtra(DataModelGrupo.getData(), datExpe);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                        , R.transition.fade_in, R.transition.fade_out);
                ActivityCompat.startActivity(ActivityCriarGrupo1.this, i, activityOptionsCompat.toBundle());
                finish();
            }else {
                Toast.makeText(getApplicationContext(), "Preencha o campo 'DATA DE EXPEDIÇÃO'", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Preencha o campo 'NOME DO GRUPO'", Toast.LENGTH_SHORT).show();
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
                        Intent i = new Intent(getApplicationContext(), GruposExistentes.class);
                        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                                , R.transition.fade_in, R.transition.fade_out);
                        ActivityCompat.startActivity(ActivityCriarGrupo1.this, i, activityOptionsCompat.toBundle());
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
