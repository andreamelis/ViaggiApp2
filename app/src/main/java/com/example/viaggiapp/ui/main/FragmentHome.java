package com.example.viaggiapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.viaggiapp.Inserimento;
import com.example.viaggiapp.R;
import com.example.viaggiapp.VisualizzaPoi;
import com.example.viaggiapp.VisualizzaTutto;

public class FragmentHome extends  Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;


    public static FragmentHome newInstance(int index) {
        FragmentHome fragment = new FragmentHome();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button btProva;
        btProva = root.findViewById(R.id.btCalaGoloritze);

        /**Se viene premuto il tasto "inserimento", passa all'activity di inserimento*/
        btProva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //quando premo il pulsante Inserisci

                //genero un Intent
                Intent intent = new Intent(getActivity(), VisualizzaTutto.class);

                //chiamo la nuova activity (ResultActivity)
                startActivity(intent);
            }
        });

        return root;


    }
}
