package br.com.ufopaoriximina.projcadfish.datamodel;

import android.graphics.Bitmap;

public class DataModelEspecie {

    private final static String TABELA_ESPECIE = "especies";

    private final static String id = "id";
    private final static String nome = "nome";
    private final static String foto = "foto";

    private static String queryCriarTabelaEspecie = "";


    public static String criarTabelaEspecie(){
        queryCriarTabelaEspecie += " CREATE TABLE IF NOT EXISTS " + TABELA_ESPECIE;
        queryCriarTabelaEspecie += " (";
        queryCriarTabelaEspecie += id + " INTEGER NOT NULL PRIMARY KEY  AUTOINCREMENT, ";
        queryCriarTabelaEspecie += nome + " TEXT NOT NULL, ";
        queryCriarTabelaEspecie += foto + " BLOB NOT NULL";
        queryCriarTabelaEspecie += " )";
        return queryCriarTabelaEspecie;
    }


    public static String getTabelaEspecie() {
        return TABELA_ESPECIE;
    }

    public static String getId() {
        return id;
    }

    public static String getNome() {
        return nome;
    }

    public static String getFoto() {
        return foto;
    }

    public static String getQueryCriarTabelaEspecie() {
        return queryCriarTabelaEspecie;
    }

    public static void setQueryCriarTabelaEspecie(String queryCriarTabelaEspecie) {
        DataModelEspecie.queryCriarTabelaEspecie = queryCriarTabelaEspecie;
    }
}
