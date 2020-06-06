package br.com.ufopaoriximina.projcadfish.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.ufopaoriximina.projcadfish.activity.AddParticipantes;
import br.com.ufopaoriximina.projcadfish.model.Usuario;

public class ParticipanteDAO {

    private final DataSource dataSource;

    public ParticipanteDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long salvarParticipanteDAO(Usuario pUsuario) {

        SQLiteDatabase db = dataSource.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put("id", pUsuario.getId());
            values.put("nome", pUsuario.getName());
            values.put("email", pUsuario.getEmail());
            values.put("senha", pUsuario.getSenha());
            values.put("anosxp", pUsuario.getAnosxp());
            values.put("cpf", pUsuario.getCpf());
            values.put("telefone", pUsuario.getTelefone());
            values.put("estado", pUsuario.getEstado());
            values.put("cidade", pUsuario.getCidade());
            values.put("foto", pUsuario.getFoto());
            values.put("tipo", pUsuario.getTipo());
            values.put("infogeralId", pUsuario.getIdInfoGeral());

            long idParticipanteInserido = db.insert("participante", null, values);

            return idParticipanteInserido;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return 0;
    }

    @SuppressLint("LongLogTag")
    public List<Usuario> getListaParticipanteDAO() {

        List<Usuario> addParticipantes = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT *FROM InfoGeral;";

        try {

            db = this.dataSource.getReadableDatabase();

            cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()){

                Usuario usuarioTeste = null;

             do {

                 usuarioTeste = new Usuario();
                 usuarioTeste.setId((int) cursor.getLong(0));
                 usuarioTeste.setName(cursor.getString(1));
                 usuarioTeste.setAnosxp(cursor.getInt(2));
                 usuarioTeste.setCpf(cursor.getString(3));
                 usuarioTeste.setTelefone(cursor.getString(4));
                 usuarioTeste.setCidade(cursor.getString(5));
                 usuarioTeste.setEstado(cursor.getString(6));

                 addParticipantes.add(usuarioTeste);

             }while (cursor.moveToNext());

            }

        }catch (Exception e){
            Log.d("ERRO LISTA PARTICIPANTES", "Erro ao retornar os participantes");
            return null;
        }finally {
            if (db != null){
                db.close();
            }
        }

        return addParticipantes;

    }
}