package br.com.ufopaoriximina.projcadfish.datamodel;

public class DataModelGrupoPerfil {

    private static String TABELA_GRUPO_PERFIL = "grupo_perfil";

    private final static String id = "id";
    private final static String data_criacao = "data_criacao";

    private static String queryCriarTabelaGrupoPerfil = "";

    public static String criarTabelaGrupoPerfil(){

        queryCriarTabelaGrupoPerfil += "CREATE TABLE IF NOT EXISTS " + TABELA_GRUPO_PERFIL;
        queryCriarTabelaGrupoPerfil += " (";
        queryCriarTabelaGrupoPerfil += id + " INT NOT NULL AUTOINCREMENT, ";
        queryCriarTabelaGrupoPerfil += data_criacao + " TEXT NOT NULL, ";
        queryCriarTabelaGrupoPerfil += " FOREIGN KEY (info_geral_cadastro_id) REFERENCES info_geral_cadastros(id),";
        queryCriarTabelaGrupoPerfil += " FOREIGN KEY (perfil_id) REFERENCES perfil(id), ";
        queryCriarTabelaGrupoPerfil += "FOREIGN KEY (grupo_id) REFERENCES grupo(id), ";
        queryCriarTabelaGrupoPerfil += "FOREIGN KEY (peixes_id) REFERENCES peixes(id)";
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
