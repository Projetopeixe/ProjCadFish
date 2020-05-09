package br.com.ufopaoriximina.projcadfish.Fragement;


import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.ufopaoriximina.projcadfish.R;
import br.com.ufopaoriximina.projcadfish.activity.LoginActivity;
import br.com.ufopaoriximina.projcadfish.activity.cadastros_usuarios.cadastro_guia.Passo1CdGuia;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuiaFragment extends Fragment {


    public GuiaFragment() {
        // Required empty public constructor
    }

    private Button btStart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_guia2, container, false);

        btStart = view.findViewById(R.id.iniciarCadGuia);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Passo1CdGuia.class);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getContext()
                        , R.transition.fade_in, R.transition.fade_out);
                ActivityCompat.startActivity(getContext(), i, activityOptionsCompat.toBundle());
                getActivity().finish();
            }
        });

        return view;
    }



}
