package br.com.ufopaoriximina.projcadfish.datamodel;

import android.graphics.Bitmap;

public class DataModelPeixe {


    private final static String TABELA_PEIXES = "peixes";

    private final static String id = "id";
    private final static String especie = "especie";
    private final static String peso = "peso";
    private final static String tamanho = "tamanho";
    private final static String marca_tag = "marca_tag";
    private final static String location = "localizacao";
    private final static String fotoPeixe = "foto";

    private static String queryCriarTabelaPeixes = "";

    public static String criarTabelaPeixe(){
        queryCriarTabelaPeixes += " CREATE TABLE IF NOT EXISTS " + TABELA_PEIXES;
        queryCriarTabelaPeixes += " (";
        queryCriarTabelaPeixes += id + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabelaPeixes += especie + " TEXT NOT NULL, ";
        queryCriarTabelaPeixes += peso + " REAL NOT NULL, ";
        queryCriarTabelaPeixes += tamanho + " REAL NOT NULL, ";
        queryCriarTabelaPeixes += marca_tag + " TEXT NOT NULL, ";
        queryCriarTabelaPeixes += location + " TEXT NOT NULL, ";
        queryCriarTabelaPeixes += fotoPeixe + " BLOB NOT NULL, ";
        queryCriarTabelaPeixes += " especies_id INTEGER NOT NULL REFERENCES especies(id)";
        queryCriarTabelaPeixes += " )";
        return queryCriarTabelaPeixes;
    }

    public static String getTabelaPeixes() {
        return TABELA_PEIXES;
    }

    public static String getId() {
        return id;
    }

    public static String getEspecie() {
        return especie;
    }


    public static String getPeso() {
        return peso;
    }

    public static String getTamanho() {
        return tamanho;
    }

    public static String getMarca_tag() {
        return marca_tag;
    }


    public static String getLocation() {
        return location;
    }


    public static String getFotoPeixe() {
        return fotoPeixe;
    }

    public static String getQueryCriarTabelaPeixes() {
        return queryCriarTabelaPeixes;
    }

    public static void setQueryCriarTabelaPeixes(String queryCriarTabelaPeixes) {
        DataModelPeixe.queryCriarTabelaPeixes = queryCriarTabelaPeixes;
    }
}
