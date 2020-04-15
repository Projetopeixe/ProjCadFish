package br.com.ufopaoriximina.projcadfish.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            openDatabase();
            Log.d("BD", "Sucesso ao criar BD");
        }catch ( Exception e ){
            Log.e("BD", "DB--> ERRO: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase(){
        String dbPath = mContext.getDatabasePath(DB_NAME).getPath();
        if(db != null && db.isOpen()){
            return;
        }
        db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase(){
        if(db != null){
            db.close();
        }
    }

}
