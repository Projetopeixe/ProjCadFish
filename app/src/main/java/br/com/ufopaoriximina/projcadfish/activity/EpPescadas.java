package br.com.ufopaoriximina.projcadfish.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

import br.com.ufopaoriximina.projcadfish.R;

public class EpPescadas extends AppCompatActivity {

    ListView listView;
    ImageView addEspecie;
    ImageView retornarToOpcao;
    String mPeixes[] = {"Tambaqui", "Pirarucu"};
    int icone[] = {R.drawable.icon_individual, R.drawable.icon_individual};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especies_pescadas);
        getSupportActionBar().hide();
        getComponentesView();

        addEspecie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hello World", Toast.LENGTH_SHORT).show();
            }
        });

        retornarToOpcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), OpcaoPescaActivity.class);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                        , R.transition.fade_in, R.transition.fade_out);
                ActivityCompat.startActivity(EpPescadas.this, i, activityOptionsCompat.toBundle());
                finish();
            }
        });

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

    public void getComponentesView(){
        addEspecie = findViewById(R.id.btn_add_especie);
        retornarToOpcao = findViewById(R.id.btn_retornar_to_opcao_pesca);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i = new Intent(getApplicationContext(), OpcaoPescaActivity.class);
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                    , R.transition.fade_in, R.transition.fade_out);
            ActivityCompat.startActivity(EpPescadas.this, i, activityOptionsCompat.toBundle());
            finish();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }


}