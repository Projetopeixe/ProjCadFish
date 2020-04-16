package br.com.ufopaoriximina.projcadfish.datamodel;

public class DataModelGrupo {

    private final static String TABELA_GRUPO = "grupo";

    private final static String id = "id";
    private final static String nome = "nome";
    private final static String foto = "foto";
    private final static String data = "data";

    private static String queryCriarTabelaGrupo = "";

    public static String criarTabelaGrupo(){
        queryCriarTabelaGrupo += " CREATE TABLE IF NOT EXISTS " + TABELA_GRUPO;
        queryCriarTabelaGrupo += " (";
        queryCriarTabelaGrupo += id + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabelaGrupo += nome + " TEXT NOT NULL, ";
        queryCriarTabelaGrupo += foto + " BLOB NOT NULL,";
        queryCriarTabelaGrupo += data + " DATETIME NOT NULL ";
        queryCriarTabelaGrupo += ")";
        return queryCriarTabelaGrupo;
    }

    public static String getData() {
        return data;
    }

    public static String getTabelaGrupo() {
        return TABELA_GRUPO;
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

    public static String getQueryCriarTabelaGrupo() {
        return queryCriarTabelaGrupo;
    }

    public static void setQueryCriarTabelaGrupo(String queryCriarTabelaGrupo) {
        DataModelGrupo.queryCriarTabelaGrupo = queryCriarTabelaGrupo;
    }
}
