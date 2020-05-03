package br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_pescador;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.activity.OpcaoPescaActivity;
import br.com.ufopaoriximina.projcadfish.activity.UserCadastroActivity;
import br.com.ufopaoriximina.projcadfish.config.Permissoes;
import br.com.ufopaoriximina.projcadfish.dao.BDDao;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;
import br.com.ufopaoriximina.projcadfish.model.Usuario;
import de.hdodenhof.circleimageview.CircleImageView;

public class Passo5CdPescador extends AppCompatActivity {

    private ImageView imagemCamera, imagemArmazenamento;
    private static final int SELECAO_CAMERA = 100;
    private static final int SELECAO_GALERIA = 200;
    private  String[] permissoesNecessarias = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private CircleImageView fotoUser;
    private Bitmap photoUser;
    private Button finalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_5);
        getSupportActionBar().hide();
        carregarComponentes();
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizarCadastro();
            }
        });
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
    }

    public void carregarComponentes(){
        imagemCamera = findViewById(R.id.openCam);
        imagemArmazenamento = findViewById(R.id.openFolders);
        fotoUser = findViewById(R.id.fotoUser);
    }

    public void finalizarCadastro(){
        Usuario usuario;
        final Bundle dados = getIntent().getExtras();
        if(dados != null){
            String nome = dados.getString(DataModelUsuario.getNome());
            int exp = dados.getInt(DataModelUsuario.getAnosxp());
            String cpf = dados.getString(DataModelUsuario.getCpf());
            String telefone = dados.getString(DataModelUsuario.getTelefone());
            String city = dados.getString(DataModelUsuario.getCidade());
            String estado = dados.getString(DataModelUsuario.getEstado());
            String email = dados.getString(DataModelUsuario.getEmail());
            String senha = dados.getString(DataModelUsuario.getSenha());

            //usuario = new Usuario(nome, exp, cpf, telefone, city, estado, email, senha, er, 2);
            BDDao bd = new BDDao(this);
            try {
                //boolean sucesso = bd.salvarDataInfoGeral(usuario);
                //boolean sucesso2 = bd.salvarDataPerfil(usuario);
                /*if(sucesso){
                    sucessAoCadastrar();
                }*/
            }catch (Exception e){
                Toast.makeText(getApplicationContext(), "Erro ao cadastrar: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(getApplicationContext(), "Dados não passaram", Toast.LENGTH_SHORT).show();
        }

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
                    fotoUser.setImageBitmap(imagem);
                    photoUser = imagem;

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void sucessAoCadastrar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sucesso ao realizar cadastro");
        builder.setCancelable(false);
        builder.setMessage("Usuário cadastrado com sucesso!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), OpcaoPescaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.create();
        builder.show();
    }
}
