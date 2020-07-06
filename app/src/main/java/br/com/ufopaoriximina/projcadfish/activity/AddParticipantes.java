package br.com.ufopaoriximina.projcadfish.activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.activity.criacao_grupo.ActivityCriarGrupo1;
import br.com.ufopaoriximina.projcadfish.controller.UsuarioCtlr;
import br.com.ufopaoriximina.projcadfish.dao.BDDao;
import br.com.ufopaoriximina.projcadfish.dao.DataSource;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;
import br.com.ufopaoriximina.projcadfish.model.Usuario;

public class AddParticipantes extends AppCompatActivity {

    ListView listView;
    ArrayList<String> mParticipante = new ArrayList<>();
    ArrayList<Drawable> fotos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participantes);
        getSupportActionBar().hide();

        // Buscar os participantes do banco

        DataSource ds = new DataSource(this);
        mParticipante = ds.nomesUsuarios(DataModelUsuario.getTabelaInfoGeral());

        ArrayList<byte[]> fotsBd = new ArrayList<>();
        fotsBd = ds.fotosUsuarios(DataModelUsuario.getTabelaPerfil());
        for (byte[] i : fotsBd){
            BDDao conv = new BDDao(this);
            Bitmap imagBitmap = conv.converteByteArrayToBitmap(i);
            Drawable d = new BitmapDrawable(getResources(), imagBitmap);
            fotos.add(d);
        }
        Drawable[] valoresImg = new Drawable[fotos.size()];
        fotos.toArray(valoresImg);
        String[] valores = new String[mParticipante.size()];
        mParticipante.toArray(valores);

        //adapter

        listView = findViewById(R.id.listViewAddPt);

        MyAdapter adapter = new MyAdapter(this, valores , valoresImg);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(AddParticipantes.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(AddParticipantes.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rParticipante[];
        Drawable rFotos[];

        MyAdapter(Context c, String[] Participante, Drawable[] Fotos) {
            super(c, R.layout.row_participantes, R.id.nameParticipante, Participante);
            this.context = c;
            this.rParticipante = Participante;
            this.rFotos = Fotos;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_participantes, parent, false);
            ImageView images = row.findViewById(R.id.imageParticipante);
            TextView myNome = row.findViewById(R.id.nameParticipante);
            images.setImageDrawable(rFotos[position]);
            myNome.setText(rParticipante[position]);

            return row;
            
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            checkExit();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
    private void checkExit()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja realmente cancelar?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(), GruposExistentes.class);
                        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                                , R.transition.fade_in, R.transition.fade_out);
                        ActivityCompat.startActivity(AddParticipantes.this, i, activityOptionsCompat.toBundle());
                        finish();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}