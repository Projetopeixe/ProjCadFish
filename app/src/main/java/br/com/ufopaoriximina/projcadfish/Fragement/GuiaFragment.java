package br.com.ufopaoriximina.projcadfish.Fragement;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.ufopaoriximina.projcadfish.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuiaFragment extends Fragment {


    public GuiaFragment() {
        // Required empty public constructor
    }

    private Button btProx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guia2, container, false);
        btProx = view.findViewById(R.id.btProx);

        btProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), TestFragment.class);
                startActivity(i);
            }
        });
        return view;
    }



}
