package com.example.viaggiapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VisualizzaComune  extends AppCompatActivity {

    TextView textView;
    EditText etComuneCercato, etComuneTrovato;
    Poi poi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_comune);

        textView = findViewById(R.id.textView);
        ArrayList<Poi> numbersList = (ArrayList<Poi>) getIntent().getSerializableExtra("key");
        //textView.setText(String.valueOf(numbersList));
        //textView.setText(String.valueOf(numbersList.get(1).getNome()));

        /**Associo le mie variabili al file xml*/
        etComuneCercato = findViewById(R.id.etRicercaComune);
        etComuneTrovato = findViewById(R.id.etTrovato);

        /**catturo l'intent*/
        Intent intent = getIntent();
        /**l'oggetto che abbiamo passato è un Serializable, per salvarlo uso la stessa stringa
         che ho usato nella putExtra*/
        Serializable obj = intent.getSerializableExtra(FiltraPerComune.PATH);

        if (obj instanceof Poi) {
            poi = (Poi) obj; //cast esplicito, se lascio obj non posso chiamare i metodi di poi
        } else poi = new Poi();

if(numbersList.get(0).equals("ONE")){
    etComuneTrovato.setText("YES");
}





        /**riempio le mie textview con le proprietà passate dal poi*/
        fillPoi(poi);
    }
    /**
     * Funzione che riempie le TextView del file activity_result.xml con i valori del poi
     * @param poi
     */
    void fillPoi(Poi poi){
        /**setText prende una stringa*/
        etComuneCercato.setText(poi.getComune());


       //if(poi.getComune().equals(prova.get(0).getComune())){
           //etComuneTrovato.setText("Trovato");
       //}
       // if(poi.getComune().equals(poiDinamico.get(0).getComune())){
         //   etComuneTrovato.setText("Eccolo");
        //}
    }
}