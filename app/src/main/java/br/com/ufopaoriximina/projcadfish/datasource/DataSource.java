package br.com.ufopaoriximina.projcadfish.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import br.com.ufopaoriximina.projcadfish.datamodel.DataModelEspecie;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelGrupo;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelGrupoPerfil;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelPeixe;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;

public class DataSource extends SQLiteOpenHelper {

    public static final String DB_NAME = "banco_local.db";
    private Context mContext;
    public static final String LOCALDB = "/data/data/br.com.ufopabr.com.ufopaoriximina.projcadfish/databases";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    private String infoGeral = DataModelUsuario.criarTabelaInfoGeral();
    private String perfil = DataModelUsuario.criarTabelaPerfil();
    private String peixe = DataModelPeixe.criarTabelaPeixe();
    private String especie = DataModelEspecie.criarTabelaEspecie();
    private String grupo = DataModelGrupo.criarTabelaGrupo();
    private String grupo_perfil = DataModelGrupoPerfil.criarTabelaGrupoPerfil();

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(infoGeral);
            db.execSQL(grupo);
            db.execSQL(perfil);
            db.execSQL(peixe);
            db.execSQL(especie);
            db.execSQL(grupo_perfil);
            Log.d("BD", "Sucesso ao criar BD");
        }catch ( Exception e ){
            Log.e("BD", "DB--> ERRO: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
