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
        queryCriarTabelaPeixes += id + " INT NOT NULL PRIMARY KEY AUTO_INCREMENT, ";
        queryCriarTabelaPeixes += especie + " TEXT NOT NULL, ";
        queryCriarTabelaPeixes += peso + " REAL NOT NULL, ";
        queryCriarTabelaPeixes += tamanho + " REAL NOT NULL, ";
        queryCriarTabelaPeixes += marca_tag + " TEXT NOT NULL, ";
        queryCriarTabelaPeixes += location + " TEXT NOT NULL, ";
        queryCriarTabelaPeixes += fotoPeixe + " BLOB NOT NULL, ";
        queryCriarTabelaPeixes += " FOREIGN KEY (especies_id) REFERENCES especies(id)";
        queryCriarTabelaPeixes += " )";
        return queryCriarTabelaPeixes;
    }

    public static String getTabelaPeixes() {
        return TABELA_PEIXES;
    }

    public String getId() {
        return id;
    }

    public String getEspecie() {
        return especie;
    }


    public String getPeso() {
        return peso;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getMarca_tag() {
        return marca_tag;
    }


    public String getLocation() {
        return location;
    }


    public String getFotoPeixe() {
        return fotoPeixe;
    }

    public static String getQueryCriarTabelaPeixes() {
        return queryCriarTabelaPeixes;
    }

    public static void setQueryCriarTabelaPeixes(String queryCriarTabelaPeixes) {
        DataModelPeixe.queryCriarTabelaPeixes = queryCriarTabelaPeixes;
    }
}
