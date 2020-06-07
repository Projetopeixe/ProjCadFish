package br.com.ufopaoriximina.projcadfish.activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.controller.UsuarioCtlr;
import br.com.ufopaoriximina.projcadfish.dao.BDDao;
import br.com.ufopaoriximina.projcadfish.dao.DataSource;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelUsuario;
import br.com.ufopaoriximina.projcadfish.model.Usuario;

public class AddParticipantes extends AppCompatActivity {

    ListView listView;
    ArrayList<String> mParticipante = new ArrayList<>();
    int fotos[] = {R.drawable.icon_individual, R.drawable.peixe, R.drawable.icon_grupo, R.drawable.icon_grupo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participantes);
        getSupportActionBar().hide();

        // Buscar os participantes do banco

        DataSource ds = new DataSource(this);
        mParticipante = ds.usuarios(DataModelUsuario.getTabelaInfoGeral());

        String[] valores = new String[mParticipante.size()];
        mParticipante.toArray(valores);

        //adapter

        listView = findViewById(R.id.listViewAddPt);

        MyAdapter adapter = new MyAdapter(this, valores , fotos);
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
        int rFotos[];

        MyAdapter(Context c, String[] Participante, int Fotos[]) {
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

            images.setImageResource(rFotos[position]);
            myNome.setText(rParticipante[position]);

            return row;
            
        }
    }
}