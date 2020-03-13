package br.com.ufopaoriximina.projcadfish.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import br.com.ufopaoriximina.projcadfish.datamodel.DataModelEspecie;
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

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DataModelUsuario.criarTabelaInfoGeral());
            db.execSQL(DataModelUsuario.criarTabelaPerfil());
            db.execSQL(DataModelPeixe.criarTabelaPeixe());
            db.execSQL(DataModelEspecie.criarTabelaEspecie());
        }catch ( Exception e ){

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
