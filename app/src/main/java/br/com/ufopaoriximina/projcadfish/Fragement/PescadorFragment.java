package br.com.ufopaoriximina.projcadfish.Fragement;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_pescador.Passo1CdPescador;

/**
 * A simple {@link Fragment} subclass.
 */
public class PescadorFragment extends Fragment {


    private Button btnStart;

    public PescadorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_pescador, container, false);
        btnStart = view.findViewById(R.id.iniciarCadPescador);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Passo1CdPescador.class);
                startActivity(i);

            }
        });
        return view;
    }

}
