package br.com.ufopaoriximina.projcadfish.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import br.com.ufopaoriximina.projcadfish.datamodel.DataModelEspecie;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelGrupo;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelPeixe;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;

public class DataSource extends SQLiteOpenHelper {

    private static final String DB_NAME = "projeto_peixe.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    private String infoGeral = DataModelUsuario.criarTabelaInfoGeral();

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(infoGeral);
            db.execSQL(DataModelUsuario.criarTabelaPerfil());
            db.execSQL(DataModelPeixe.criarTabelaPeixe());
            db.execSQL(DataModelEspecie.criarTabelaEspecie());
            db.execSQL(DataModelGrupo.criarTabelaGrupo());
            Log.d("BD", "Sucesso ao criar BD");
        }catch ( Exception e ){
            Log.e("BD", "DB--> ERRO: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
