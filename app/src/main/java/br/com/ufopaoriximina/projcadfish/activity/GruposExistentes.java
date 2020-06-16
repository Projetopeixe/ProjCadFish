package br.com.ufopaoriximina.projcadfish.activity;
import android.content.Context;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import java.util.ArrayList;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.dao.BDDao;
import br.com.ufopaoriximina.projcadfish.dao.DataSource;
import br.com.ufopaoriximina.projcadfish.datamodel.DataModelGrupo;

public class GruposExistentes extends AppCompatActivity {

    ListView listView;
    ArrayList<String> mNome= new ArrayList<>();
    ArrayList<Drawable> images = new ArrayList<>();
    ImageView addGrupo;
    ImageView returnBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp_existentes);
        getSupportActionBar().hide();

        //Buscar os grupos do banco;
        DataSource ds = new DataSource(this);
        mNome = ds.getNomesGrupos(DataModelGrupo.getTabelaGrupo());
        String[] valoresNome = new String[mNome.size()];
        mNome.toArray(valoresNome);

        ArrayList<byte[]> fotsGpBd = new ArrayList<>();
        fotsGpBd = ds.getFotosGrupos(DataModelGrupo.getTabelaGrupo());
        for (byte[] i: fotsGpBd){
            BDDao conv = new BDDao(this);
            Bitmap imagBitmap = conv.converteByteArrayToBitmap(i);
            Drawable d = new BitmapDrawable(getResources(), imagBitmap);
            images.add(d);
        }
        Drawable[] valoresImg = new Drawable[images.size()];
        images.toArray(valoresImg);

        listView = findViewById(R.id.listView);
        addGrupo = findViewById(R.id.btn_adcionar_grupos);
        addGrupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirAddGrupo();
            }
        });
        returnBtn = findViewById(R.id.btn_retornar_opcao_pesca);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirOpcaoPesca();
            }
        });

        MyAdapter adapter = new MyAdapter(this, valoresNome,  valoresImg);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(GruposExistentes.this, "Criador do Grupo", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(GruposExistentes.this, "Criador do Grupo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void abrirAddGrupo(){
        Intent i = new Intent(getApplicationContext(), AddParticipantes.class);
        startActivity(i);
        finish();
    }


    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rNome[];
        Drawable rImgs[];

        MyAdapter(Context c, String Nome[],  Drawable Imgs[]) {
            super(c, R.layout.row, R.id.textView1, Nome);
            this.context = c;
            this.rNome = Nome;
            this.rImgs = Imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myNome = row.findViewById(R.id.textView1);
            images.setImageDrawable(rImgs[position]);
            myNome.setText(rNome[position]);
            return row;
        }
    }

    public void abrirOpcaoPesca(){
        Intent i = new Intent(getApplicationContext(), OpcaoPescaActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                , R.transition.fade_in, R.transition.fade_out);
        ActivityCompat.startActivity(GruposExistentes.this, i, activityOptionsCompat.toBundle());
        finish();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i = new Intent(getApplicationContext(), OpcaoPescaActivity.class);
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                    , R.transition.fade_in, R.transition.fade_out);
            ActivityCompat.startActivity(GruposExistentes.this, i, activityOptionsCompat.toBundle());
            finish();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

}
