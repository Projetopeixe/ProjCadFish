package br.com.ufopaoriximina.projcadfish.dao;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.ContactsContract;
import android.widget.GridLayout;

import java.io.ByteArrayOutputStream;

import br.com.ufopaoriximina.projcadfish.datamodel.DataModelEspecie;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelGrupo;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelGrupoPerfil;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelPeixe;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;
import br.com.ufopaoriximina.projcadfish.model.Especie;
import br.com.ufopaoriximina.projcadfish.model.Grupo;
import br.com.ufopaoriximina.projcadfish.model.GrupoPerfil;
import br.com.ufopaoriximina.projcadfish.model.Peixe;
import br.com.ufopaoriximina.projcadfish.model.Usuario;
import de.hdodenhof.circleimageview.CircleImageView;

public class BDDao extends DataSource{

    ContentValues dados;
    public BDDao(Context context) {
        super(context);
    }

    public byte[] convertCircleBitmapToByteArray(Bitmap imagem){
           // BitmapDrawable drawable = (BitmapDrawable) imagem.getDrawable();
            //Bitmap bitmap = drawable.getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imagem.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte imagemBytes[] = stream.toByteArray();
            return imagemBytes;

    }

    //To Save datas in local database
    public boolean salvarDataInfoGeral(Usuario obj){

        boolean sucesso = true;
        dados = new ContentValues();

        dados.put(DataModelUsuario.getNome(), obj.getName());
        dados.put(DataModelUsuario.getAnosxp(), obj.getAnosxp());
        dados.put(DataModelUsuario.getCpf(), obj.getCpf());
        dados.put(DataModelUsuario.getTelefone(), obj.getTelefone());
        dados.put(DataModelUsuario.getCidade(), obj.getCidade());
        dados.put(DataModelUsuario.getEstado(), obj.getEstado());

        sucesso = insert(DataModelUsuario.getTabelaInfoGeral(), dados);
        return sucesso;
    }

    public boolean salvarDataPerfil (Usuario obj){

        boolean sucesso = true;
        dados = new ContentValues();

        dados.put(DataModelUsuario.getEmail(), obj.getEmail());
        dados.put(DataModelUsuario.getSenha(), obj.getSenha());
        dados.put(DataModelUsuario.getFoto(), obj.getFoto());
        dados.put(DataModelUsuario.getTipo(), obj.getTipo());
        dados.put(DataModelUsuario.getInfoGeralId(), obj.getIdInfoGeral());

        sucesso = insert(DataModelUsuario.getTabelaPerfil(), dados);
        return sucesso;
    }

    public boolean salvarDataPeixe (Peixe fish){

        boolean sucesso = true;
        dados = new ContentValues();

        dados.put(DataModelPeixe.getEspecie(), fish.getEspecie());
        dados.put(DataModelPeixe.getPeso(), fish.getPeso());
        dados.put(DataModelPeixe.getTamanho(), fish.getTamanho());
        dados.put(DataModelPeixe.getMarca_tag(), fish.getMarca_tag());
        dados.put(DataModelPeixe.getLocation(), fish.getLocation());
        dados.put(DataModelPeixe.getFotoPeixe(), convertCircleBitmapToByteArray(fish.getFotoPeixe()));

        sucesso = insert(DataModelPeixe.getTabelaPeixes(), dados);
        return sucesso;
    }

    public boolean salvarGrupoPerfil (GrupoPerfil grupoPerfil){
        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(DataModelGrupoPerfil.getData_criacao(), grupoPerfil.getData_criacao());

        sucesso = insert(DataModelGrupoPerfil.getTabelaGrupoPerfil(), dados);
        return sucesso;
    }

    public boolean salvarGrupo (Grupo grupo){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(DataModelGrupo.getNome(), grupo.getNome());
        dados.put(DataModelGrupo.getFoto(), convertCircleBitmapToByteArray(grupo.getFoto()));
        dados.put(DataModelGrupo.getData(), grupo.getData());

        sucesso = insert(DataModelGrupo.getTabelaGrupo(), dados);

        return  sucesso;
    }

    public boolean salvarEspecie (Especie especie){

        boolean sucesso = true;

        dados = new ContentValues();
        dados.put(DataModelEspecie.getNome(), especie.getNome());
        dados.put(DataModelEspecie.getFoto(), convertCircleBitmapToByteArray(especie.getFoto()));

        sucesso = insert(DataModelEspecie.getTabelaEspecie(), dados);

        return sucesso;
    }

    //Alteração em tabelas

    public boolean uptadeDataInfoGeral(Usuario obj){
        boolean sucesso = true;

        dados = new ContentValues();
        dados.put(DataModelUsuario.getId(), obj.getId());
        dados.put(DataModelUsuario.getNome(), obj.getName());
        dados.put(DataModelUsuario.getAnosxp(), obj.getAnosxp());
        dados.put(DataModelUsuario.getCpf(), obj.getCpf());
        dados.put(DataModelUsuario.getTelefone(), obj.getTelefone());
        dados.put(DataModelUsuario.getCidade(), obj.getCidade());
        dados.put(DataModelUsuario.getEstado(), obj.getEstado());

        sucesso = alterar(DataModelUsuario.getTabelaInfoGeral(), dados);
        return sucesso;
    }

    public boolean updateDataPerfil(Usuario obj){
        boolean sucesso = true;
        dados = new ContentValues();
        dados.put(DataModelUsuario.getId(), obj.getId());
        dados.put(DataModelUsuario.getEmail(), obj.getEmail());
        dados.put(DataModelUsuario.getSenha(), obj.getSenha());
        dados.put(DataModelUsuario.getFoto(), obj.getFoto());
        dados.put(DataModelUsuario.getTipo(), obj.getTipo());
        sucesso = alterar(DataModelUsuario.getTabelaPerfil(), dados);
        return sucesso;
    }

    public boolean updateDataPeixe (Peixe fish){
        boolean sucesso = true;
        dados = new ContentValues();
        dados.put(DataModelPeixe.getId(), fish.getId());
        dados.put(DataModelPeixe.getEspecie(), fish.getEspecie());
        dados.put(DataModelPeixe.getPeso(), fish.getPeso());
        dados.put(DataModelPeixe.getTamanho(), fish.getTamanho());
        dados.put(DataModelPeixe.getMarca_tag(), fish.getMarca_tag());
        dados.put(DataModelPeixe.getLocation(), fish.getLocation());
        dados.put(DataModelPeixe.getFotoPeixe(), convertCircleBitmapToByteArray(fish.getFotoPeixe()));

        sucesso = alterar(DataModelPeixe.getTabelaPeixes(), dados);
        return sucesso;
    }

    public boolean updateDataGrupoPerfil(GrupoPerfil grupoPerfil){
        boolean sucesso = true;

        dados = new ContentValues();
        dados.put(DataModelGrupoPerfil.getId(), grupoPerfil.getId());
        dados.put(DataModelGrupoPerfil.getData_criacao(), grupoPerfil.getData_criacao());
        sucesso = alterar(DataModelGrupoPerfil.getTabelaGrupoPerfil(), dados);
        return sucesso;
    }

    public boolean updateDataGrupo (Grupo grupo){
        boolean sucesso = true;

        dados = new ContentValues();
        dados.put(DataModelGrupo.getId(), grupo.getId());
        dados.put(DataModelGrupo.getNome(), grupo.getNome());
        dados.put(DataModelGrupo.getFoto(), convertCircleBitmapToByteArray(grupo.getFoto()));
        dados.put(DataModelGrupo.getData(), grupo.getData());

        sucesso = alterar(DataModelGrupo.getTabelaGrupo(), dados);

        return  sucesso;
    }

    public boolean updateDataEspecie (Especie especie){
        boolean sucesso = true;

        dados = new ContentValues();
        dados.put(DataModelEspecie.getId(), especie.getId());
        dados.put(DataModelEspecie.getNome(), especie.getNome());
        dados.put(DataModelEspecie.getFoto(), convertCircleBitmapToByteArray(especie.getFoto()));

        sucesso = alterar(DataModelEspecie.getTabelaEspecie(), dados);

        return sucesso;
    }



}
