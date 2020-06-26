package br.com.ufopaoriximina.projcadfish.activity.cadastro_peixes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import br.com.ufopaoriximina.projcadfish.R;

public class ActivityCadPeixe1 extends AppCompatActivity {

    EditText especie;
    ImageView imgEspecie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_peixe1);
    }

    public void carregarElementosView(){
        especie = findViewById(R.id.editEspecieCadP);
        imgEspecie = findViewById(R.id.fotoEspecieCadP);
    }
}
