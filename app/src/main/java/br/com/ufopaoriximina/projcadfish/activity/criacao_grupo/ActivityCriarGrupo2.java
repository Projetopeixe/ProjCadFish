package br.com.ufopaoriximina.projcadfish.activity.criacao_grupo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.icu.text.UnicodeSetSpanner;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.activity.AddParticipantes;
import br.com.ufopaoriximina.projcadfish.activity.EpPescadas;
import br.com.ufopaoriximina.projcadfish.activity.GruposExistentes;
import br.com.ufopaoriximina.projcadfish.activity.OpcaoPescaActivity;
import br.com.ufopaoriximina.projcadfish.config.Permissoes;
import br.com.ufopaoriximina.projcadfish.dao.BDDao;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelGrupo;
import br.com.ufopaoriximina.projcadfish.model.Grupo;
import de.hdodenhof.circleimageview.CircleImageView;

public class ActivityCriarGrupo2 extends AppCompatActivity {

    private ImageView imagemCamera, imagemArmazenamento;
    private static final int SELECAO_CAMERA = 100;
    private static final int SELECAO_GALERIA = 200;
    private  String[] permissoesNecessarias = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private CircleImageView fotoGp;
    private Button finalizar;
    private Bitmap photoGp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_grupo2);
        getSupportActionBar().hide();
        carregarComponentesView();
        Permissoes.validarPermissoes(permissoesNecessarias, this, 1);
        imagemCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(i.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(i, SELECAO_CAMERA);
                }
            }
        });

        imagemArmazenamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if(i.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(i, SELECAO_GALERIA);
                }
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizarCadastro();
            }
        });
    }

    public void carregarComponentesView(){
        imagemCamera = findViewById(R.id.openCam);
        imagemArmazenamento = findViewById(R.id.openFolders);
        fotoGp = findViewById(R.id.fotoGP);
        finalizar = findViewById(R.id.btnFinalize);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Bitmap imagem = null;

            try{
                switch (requestCode){
                    case SELECAO_CAMERA:
                        imagem = (Bitmap)data.getExtras().get("data");
                        break;
                    case SELECAO_GALERIA:
                        Uri localImagemSelecionada = data.getData();
                        imagem = MediaStore.Images.Media.getBitmap(getContentResolver(), localImagemSelecionada);
                        break;
                }

                if(imagem != null){
                    fotoGp.setImageBitmap(imagem);
                    photoGp = imagem;

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void finalizarCadastro(){

        final Bundle dados = getIntent().getExtras();
        String nomeGp = dados.getString(DataModelGrupo.getNome());
        String data = dados.getString(DataModelGrupo.getData());
        BDDao bdDao = new BDDao(this);
        Grupo grupo = new Grupo(nomeGp, convertToByte(fotoGp), data);
        try{
            boolean sucesso = bdDao.salvarGrupo(grupo);
            if(sucesso){
                sucessAoCadastrar();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Erro ao realizar Cadastro", Toast.LENGTH_SHORT).show();
        }
    }

    public void sucessAoCadastrar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sucesso ao realizar cadastro");
        builder.setCancelable(false);
        builder.setMessage("Grupo cadastrado com sucesso!");
        builder.setPositiveButton("Adicionar Participantes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), AddParticipantes.class);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                        , R.transition.fade_in, R.transition.fade_out);
                ActivityCompat.startActivity(ActivityCriarGrupo2.this, intent, activityOptionsCompat.toBundle());
                finish();
            }
        });
        builder.create();
        builder.show();
    }

    public byte[] convertToByte(CircleImageView imagem) {
        BitmapDrawable drawable = (BitmapDrawable) imagem.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte imagemBytes[] = stream.toByteArray();
        return imagemBytes;
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
                        ActivityCompat.startActivity(ActivityCriarGrupo2.this, i, activityOptionsCompat.toBundle());
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
