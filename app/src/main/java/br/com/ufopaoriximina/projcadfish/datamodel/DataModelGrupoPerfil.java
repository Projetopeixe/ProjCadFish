package br.com.ufopaoriximina.projcadfish.datamodel;

public class DataModelGrupoPerfil {

    private static String TABELA_GRUPO_PERFIL = "grupo_perfil";

    private final static String id = "id";
    private final static String data_criacao = "data_criacao";

    private static String queryCriarTabelaGrupoPerfil = "";

    public static String criarTabelaGrupoPerfil(){

        queryCriarTabelaGrupoPerfil += "CREATE TABLE IF NOT EXISTS " + TABELA_GRUPO_PERFIL;
        queryCriarTabelaGrupoPerfil += " (";
        queryCriarTabelaGrupoPerfil += id + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabelaGrupoPerfil += data_criacao + " TEXT NOT NULL, ";
        queryCriarTabelaGrupoPerfil += " info_geral_cadastros_id INTEGER NOT NULL REFERENCES info_geral_cadastros(id),";
        queryCriarTabelaGrupoPerfil += " perfil_id INTEGER NOT NULL REFERENCES perfil(id), ";
        queryCriarTabelaGrupoPerfil += "grupo_id INTEGER NOT NULL REFERENCES grupo(id), ";
        queryCriarTabelaGrupoPerfil += "peixes_id INTEGER NOT NULL REFERENCES peixes(id)";
        queryCriarTabelaGrupoPerfil += ")";
        return queryCriarTabelaGrupoPerfil;
    }

    public static String getTabelaGrupoPerfil() {
        return TABELA_GRUPO_PERFIL;
    }

    public static void setTabelaGrupoPerfil(String tabelaGrupoPerfil) {
        TABELA_GRUPO_PERFIL = tabelaGrupoPerfil;
    }

    public static String getId() {
        return id;
    }

    public static String getData_criacao() {
        return data_criacao;
    }

    public static String getQueryCriarTabelaGrupoPerfil() {
        return queryCriarTabelaGrupoPerfil;
    }

    public static void setQueryCriarTabelaGrupoPerfil(String queryCriarTabelaGrupoPerfil) {
        DataModelGrupoPerfil.queryCriarTabelaGrupoPerfil = queryCriarTabelaGrupoPerfil;
    }
}
