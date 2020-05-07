package br.com.ufopaoriximina.projcadfish.activity;

import android.content.Context;
import android.os.Bundle;
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

import br.com.ufopaoriximina.projcadfish.R;

public class GrupoAberto extends AppCompatActivity {

    ListView listView;

    String mIntegrantes[] = {"Pescador A", "Pescador B"};
    int perfil[] = {R.drawable.icon_individual, R.drawable.icon_individual};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp_aberto);
        getSupportActionBar().hide();

        listView = findViewById(R.id.listViewGpAberto);

        GrupoAberto.MyAdapter adapter = new MyAdapter(this, mIntegrantes , perfil);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(GrupoAberto.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(GrupoAberto.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rIntegrante[];
        int rPerfil[];

        MyAdapter(Context c, String Integrante[], int Perfil[]) {
            super(c, R.layout.row_grupo_aberto, R.id.nameIntegrante, Integrante);
            this.context = c;
            this.rIntegrante = Integrante;
            this.rPerfil = Perfil;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_grupo_aberto, parent, false);
            ImageView images = row.findViewById(R.id.imageParticipante);
            TextView myNome = row.findViewById(R.id.nameParticipante);

            images.setImageResource(rPerfil[position]);
            myNome.setText(rIntegrante[position]);

            return row;
        }
    }

}

