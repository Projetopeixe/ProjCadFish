package br.com.ufopaoriximina.projcadfish.datamodel;

import android.graphics.Bitmap;

public class DataModelUsuario {

    //Dados para criar as tabelas no banco de dados
    //MOR - Modelo objeto relacional
    //Criar dinamicamente uma query SQL para criar a tabela de Usuários no Banco de dados.

    private final static String TABELA_INFO_GERAL = "info_geral_cadastros";
    private final static String TABELA_PERFIL = "perfil";

    private final static String id = "id";
    private final static String nome = "nome";
    private final static String email = "email";
    private final static String senha = "senha";
    private final static String anosxp = "anos_exp";
    private final static String cpf = "cpf";
    private final static String telefone = "telefone";
    private final static String estado = "estado";
    private final static String cidade = "cidade";
    private final static String foto = "foto";
    private final static String tipo = "tipo";

    private static String queryCriarTabelaInfoGeral = "";
    private static String queryCriarTabelaPerfil = "";

    //Criar dinamicamente uma Query Sql para criar
    //a tabela Info Geral
    public static  String criarTabelaInfoGeral(){

        queryCriarTabelaInfoGeral += "CREATE TABLE IF NOT EXISTS " + TABELA_INFO_GERAL;
        queryCriarTabelaInfoGeral += " (";
        queryCriarTabelaInfoGeral += id + " INT PRIMARY KEY NOT NULL AUTOINCREMENT, ";
        queryCriarTabelaInfoGeral += nome + " TEXT NOT NULL, ";
        queryCriarTabelaInfoGeral += anosxp + " INT NOT NULL, ";
        queryCriarTabelaInfoGeral += cpf + " TEXT NOT NULL, ";
        queryCriarTabelaInfoGeral += telefone + " TEXT NOT NULL, ";
        queryCriarTabelaInfoGeral += cidade + " TEXT NOT NULL, ";
        queryCriarTabelaInfoGeral += estado + " TEXT NOT NULL";
        queryCriarTabelaInfoGeral += " )";
        return  queryCriarTabelaInfoGeral;
    }


    //Criar dinamicamente uma Query Sql para criar
    //a tabela Perfil

    public static String criarTabelaPerfil(){
        queryCriarTabelaPerfil += "CREATE TABLE IF NOT EXISTS " + TABELA_PERFIL;
        queryCriarTabelaPerfil += " (";
        queryCriarTabelaPerfil += id + " INT PRIMARY KEY NOT NULL AUTOINCREMENT, ";
        queryCriarTabelaPerfil += email + " TEXT NOT NULL, ";
        queryCriarTabelaPerfil += senha + " TEXT NOT NULL, ";
        queryCriarTabelaPerfil += foto + " BLOB NOT NULL, ";
        queryCriarTabelaPerfil += tipo + " INT NOT NULL, ";
        queryCriarTabelaPerfil += "FOREIGN KEY (info_geral_cadastros_id) REFERENCES info_geral_cadastros(id)";
        queryCriarTabelaPerfil += " )";
        return queryCriarTabelaPerfil;
    }

    public static String getTabelaInfoGeral() {
        return TABELA_INFO_GERAL;
    }

    public static String getTabelaPerfil() {
        return TABELA_PERFIL;
    }

    public static String getId() {
        return id;
    }

    public static String getNome() {
        return nome;
    }

    public static String getEmail() {
        return email;
    }

    public static String getSenha() {
        return senha;
    }

    public static String getAnosxp() {
        return anosxp;
    }

    public static String getCpf() {
        return cpf;
    }

    public static String getTelefone() {
        return telefone;
    }

    public static String getEstado() {
        return estado;
    }

    public static String getCidade() {
        return cidade;
    }

    public static String getFoto() {
        return foto;
    }

    public static String getTipo() {
        return tipo;
    }

    public static String getQueryCriarTabelaInfoGeral() {
        return queryCriarTabelaInfoGeral;
    }

    public static void setQueryCriarTabelaInfoGeral(String queryCriarTabelaInfoGeral) {
        DataModelUsuario.queryCriarTabelaInfoGeral = queryCriarTabelaInfoGeral;
    }

    public static String getQueryCriarTabelaPerfil() {
        return queryCriarTabelaPerfil;
    }

    public static void setQueryCriarTabelaPerfil(String queryCriarTabelaPerfil) {
        DataModelUsuario.queryCriarTabelaPerfil = queryCriarTabelaPerfil;
    }
}
