package br.com.ufopaoriximina.projcadfish.datamodel;

import android.graphics.Bitmap;

public class DataModelPeixe {


    private final static String TABELA_PEIXES = "peixes";

    private String id = "id";
    private String especie = "especie";
    private String peso = "peso";
    private String tamanho = "tamanho";
    private String marca_tag = "marca_tag";
    private String location = "localizacao";
    private String fotoPeixe = "foto";

    private static String queryCriarTabelaPeixes = "";

    public String criarTabelaPeixe(){
        queryCriarTabelaPeixes += " CREATE TABLE IF NOT EXISTS " + TABELA_PEIXES;
        queryCriarTabelaPeixes += " (";
        queryCriarTabelaPeixes += id + " INT PRIMARY KEY NOT NULL, ";
        queryCriarTabelaPeixes += especie + " TEXT NOT NULL, ";
        queryCriarTabelaPeixes += peso + " REAL NOT NULL, ";
        queryCriarTabelaPeixes += tamanho + " REAL NOT NULL, ";
        queryCriarTabelaPeixes += marca_tag + " TEXT NOT NULL, ";
        queryCriarTabelaPeixes += location + " TEXT NOT NULL, ";
        queryCriarTabelaPeixes += fotoPeixe + " BLOB NOT NULL";
        queryCriarTabelaPeixes += " )";
        return queryCriarTabelaPeixes;
    }

    public static String getTabelaPeixes() {
        return TABELA_PEIXES;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getMarca_tag() {
        return marca_tag;
    }

    public void setMarca_tag(String marca_tag) {
        this.marca_tag = marca_tag;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFotoPeixe() {
        return fotoPeixe;
    }

    public void setFotoPeixe(String fotoPeixe) {
        this.fotoPeixe = fotoPeixe;
    }

    public static String getQueryCriarTabelaPeixes() {
        return queryCriarTabelaPeixes;
    }

    public static void setQueryCriarTabelaPeixes(String queryCriarTabelaPeixes) {
        DataModelPeixe.queryCriarTabelaPeixes = queryCriarTabelaPeixes;
    }
}
