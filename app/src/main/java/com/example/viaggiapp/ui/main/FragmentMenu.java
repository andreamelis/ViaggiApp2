package com.example.viaggiapp.ui.main;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.viaggiapp.FiltraPerComune;
import com.example.viaggiapp.Inserimento;
import com.example.viaggiapp.R;
import com.example.viaggiapp.VisualizzaPoi;
import com.example.viaggiapp.VisualizzaTutto;

public class FragmentMenu extends Fragment   {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab2_menu, container, false);

        /**Inserisco i Button */
        Button buttonInserimento;
        Button buttonVisualizza;
        Button buttonFiltraPerComune;

        /**Associo il button al button nel .xml*/
        buttonInserimento = root.findViewById(R.id.buttonInserisci);
        buttonVisualizza = root.findViewById(R.id.buttonVisualizza);
        buttonFiltraPerComune = root.findViewById(R.id.buttonFiltra);

        /**Se viene premuto il tasto "inserimento", passa all'activity di inserimento*/
        buttonInserimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //quando premo il pulsante Inserisci

                //genero un Intent
                Intent intent = new Intent(getActivity(), Inserimento.class);

                //chiamo la nuova activity (ResultActivity)
                startActivity(intent);
            }
        });

        /**Se viene premuto il tasto "Visualizza", passa all'activity per visualizzare i
         * Poi in memoria*/
        buttonVisualizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //quando premo il pulsante Inserisci

                //genero un Intent
                Intent intent = new Intent(getActivity(), VisualizzaTutto.class);

                //chiamo la nuova activity (ResultActivity)
                startActivity(intent);
            }
        });

        /**Se viene premuto il tasto "Ricerca per Comune", passa all'activity per ricercare  i
         * Poi in memoria tramite il comune*/
        buttonFiltraPerComune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //quando premo il pulsante Inserisci

                //genero un Intent
                Intent intent = new Intent(getActivity(), FiltraPerComune.class);

                //chiamo la nuova activity (ResultActivity)
                startActivity(intent);
            }
        });

        return root;

    }

}
