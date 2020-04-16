package br.com.ufopaoriximina.projcadfish.dao;

import android.content.ContentValues;
import android.content.Context;

import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;
import br.com.ufopaoriximina.projcadfish.model.Especie;
import br.com.ufopaoriximina.projcadfish.model.Usuario;

public class BDDao extends DataSource{

    ContentValues dados;
    public BDDao(Context context) {
        super(context);
    }

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


}
