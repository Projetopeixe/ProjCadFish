package br.com.ufopaoriximina.projcadfish.datamodel;

public class DataModelGrupo {

    private final static String TABELA_GRUPO = "grupo";

    private final static String id = "id";
    private final static String nome = "nome";
    private final static String foto = "foto";

    private static String queryCriarTabelaGrupo = "";

    public static String criarTabelaGrupo(){
        queryCriarTabelaGrupo += " CREATE TABLE IF NOT EXISTS " + TABELA_GRUPO;
        queryCriarTabelaGrupo += " (";
        queryCriarTabelaGrupo += id + " INT NOT NULL PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabelaGrupo += nome + " TEXT NOT NULL, ";
        queryCriarTabelaGrupo += foto + " BLOB NOT NULL ";
        queryCriarTabelaGrupo += ")";
        return queryCriarTabelaGrupo;
    }
}
