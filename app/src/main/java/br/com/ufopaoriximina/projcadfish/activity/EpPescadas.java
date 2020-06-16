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

public class EpPescadas extends AppCompatActivity {

    ListView listView;

    String mPeixes[] = {"Tambaqui", "Pirarucu"};
    int icone[] = {R.drawable.icon_individual, R.drawable.icon_individual};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especies_pescadas);
        getSupportActionBar().hide();

        listView = findViewById(R.id.listViewEspecies);

        EpPescadas.MyAdapter adapter = new MyAdapter(this, mPeixes, icone);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(EpPescadas.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(EpPescadas.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rPeixes[];
        int rIcone[];

        MyAdapter(Context c, String Peixes[], int Icone[]) {
            super(c, R.layout.activity_especies_pescadas, R.id.nameEspecie, Peixes);
            this.context = c;
            this.rPeixes = Peixes;
            this.rIcone = Icone;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_especies_pescadas, parent, false);
            ImageView images = row.findViewById(R.id.imagePeixe);
            TextView myNome = row.findViewById(R.id.nameEspecie);

            images.setImageResource(rIcone[position]);
            myNome.setText(rPeixes[position]);

            return row;
        }
    }
}