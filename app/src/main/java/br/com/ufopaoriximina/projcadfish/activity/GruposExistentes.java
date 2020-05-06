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

public class GruposExistentes extends AppCompatActivity {

    ListView listView;
    String mNome[] = {"Amigos da Pesca", "Pescaria"};
    String mCriador[] = {"Criado por Luis", "Criado por Samuel"};
    int images[] = {R.drawable.peixe, R.drawable.peixe};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp_existentes);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mNome, mCriador, images);
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

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rNome[];
        String rCriador[];
        int rImgs[];

        MyAdapter(Context c, String Nome[], String Criador[], int Imgs[]) {
            super(c, R.layout.row, R.id.textView1, Nome);
            this.context = c;
            this.rNome = Nome;
            this.rCriador = Criador;
            this.rImgs = Imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myNome = row.findViewById(R.id.textView1);
            TextView myCriador = row.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myNome.setText(rNome[position]);
            myCriador.setText(rCriador[position]);

            return row;
        }
    }

}
