package br.com.ufopaoriximina.projcadfish.dao;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;

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

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
    }


    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

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
            db.execSQL("PRAGMA foreign_keys=ON;");
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

    public boolean insert(String table, ContentValues dados){

        boolean sucesso = true;

        try {
            sucesso = db.insert(table, null, dados) > 0;
        }catch (Exception e){

        }
        return sucesso;
    }

    public boolean alterar(String tabela, ContentValues dados){
        boolean sucesso = true;

        int id = dados.getAsInteger("id");

        sucesso = db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)}) >0;

        return sucesso;
    }

    public int getLastId(String tabela){

        int id;
        Cursor c = db.rawQuery("SELECT id FROM "+ tabela + " WHERE id=(SELECT MAX(id) FROM "+ tabela + ");", null);
        if (c.moveToFirst()){
            do{
                id = c.getInt(c.getColumnIndex("id"));
                return id;
            }while (c.moveToNext());
        }
        return 0;
    }

    public ArrayList<String> nomesUsuarios(String tabela){
        SQLiteDatabase db = getReadableDatabase();
        String nome;
        Cursor cursor = db.rawQuery("SELECT nome FROM " + tabela, new String[]{});
        ArrayList<String> lista = new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                nome = cursor.getString(cursor.getColumnIndex(DataModelUsuario.getNome()));
                lista.add(nome);
                if(cursor.isLast()){
                    return lista;
                }
            }while (cursor.moveToNext());
        }
        return lista;
    }

    public ArrayList<byte[]> fotosUsuarios(String tabela){
        SQLiteDatabase db = getReadableDatabase();
        byte[] foto;
        Cursor cursor = db.rawQuery("SELECT foto FROM " + tabela, null);
        ArrayList<byte[]> listaFt = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                foto = cursor.getBlob(cursor.getColumnIndex(DataModelUsuario.getFoto()));
                listaFt.add(foto);
                 if (cursor.isLast()){
                     return listaFt;
                }
            }while (cursor.moveToNext());
        }
        return listaFt;
    }

    public String logar(String email, String senha){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + DataModelUsuario.getTabelaPerfil() + " WHERE " +
                DataModelUsuario.getEmail() + "=?  AND " + DataModelUsuario.getSenha() + "=?", new String[]{email, senha});
        if(c.getCount()>0){
            return "OK";
        }
        return "ERRO";
    }
}
