package br.com.ufopaoriximina.projcadfish.activity;

import android.content.Context;
import android.content.Intent;
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

public class PescaEmGrupo extends AppCompatActivity {

    ListView listView;
    String mNomePeixe[] = {"Tambaqui", "Piranha"};
    String mPescador[] = {"Pescado por Luis", "Pescado por Samuel"};
    int photo[] = {R.drawable.peixe, R.drawable.peixe};
    ImageView addPeixe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesca_grupo);
        getSupportActionBar().hide();

        listView = findViewById(R.id.listView);
        addPeixe = findViewById(R.id.btn_adcionar_grupos);

        PescaEmGrupo.MyAdapter adapter = new MyAdapter(this, mNomePeixe, mPescador, photo );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(PescaEmGrupo.this, "Pescador", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(PescaEmGrupo.this, "Pesacador", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void abrirAddGrupo(){
        Intent i = new Intent(getApplicationContext(), PescaEmGrupo.class);
        startActivity(i);
        finish();
    }


    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rNomePeixe[];
        String rPescador[];
        int rPhotos[];

        MyAdapter(Context c, String NomePeixe[], String Pescador[], int Photos[]) {
            super(c, R.layout.row_pesca_grupo, R.id.textView5, NomePeixe);
            this.context = c;
            this.rNomePeixe = NomePeixe;
            this.rPescador = Pescador;
            this.rPhotos = Photos;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_pesca_grupo, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myPeixe = row.findViewById(R.id.textView5);
            TextView myPescador = row.findViewById(R.id.textView6);

            images.setImageResource(rPhotos[position]);
            myPeixe.setText(rNomePeixe[position]);
            myPescador.setText(rPescador[position]);

            return row;
        }
    }

}

