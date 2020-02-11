package br.com.ufopaoriximina.projcadfish.Fragement;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.ufopaoriximina.projcadfish.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuiaFragment extends Fragment {


    public GuiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guia2, container, false);
    }

}
