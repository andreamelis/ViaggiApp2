package com.example.viaggiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

public class VisualizzaTutto extends AppCompatActivity {

    ArrayList<Poi> numbers = new ArrayList<>();

    /**costante che definisce il path dell'oggetto Poi*/
    public static final String PATH ="com.example.projectpoi.ArrayList";

    /**ListView*/
    ListView listView;

    /**Vettore statico per i POI memorizzati di default*/
    Poi [] poiStatico = new Poi[]{
            new Poi("Marina Piccola","Cagliari","bello",new Coordinate(15,15,15),Categoria.Altro,
                    "s2","s3","s4","si"),
            new Poi("Flyboard Paradise","Cagliari","bellissimo",new Coordinate(16,17,18),Categoria.Altro,
                    "s2","s3","s4","si"),
            new Poi("Cala Goloritze", "Dorgali","bello",new Coordinate(19,20,15),Categoria.Altro,
                    "s2","s3","s4","si"),
            new Poi("Flyboard Paradise", "Cagliari","bello",new Coordinate(15,15,15),Categoria.Altro,
                    "s2","s3","s4","si")
    };

    Poi poi;

    /**Dichiaro un elemento di tipo MyAdapter*/
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_tutto);

        Button btHome, btRicercaComune;



        listView = findViewById(R.id.listView);
        btHome = findViewById(R.id.tastoHome);
        btRicercaComune = findViewById(R.id.tastoCercaComune);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(Inserimento.PATH);

        poi = (Poi) obj;

        numbers.add(new Poi("Marina Piccola","Cagliari","bello",new Coordinate(15,15,15),Categoria.Altro,
                        "s2","s3","s4","si"));
        numbers.add(new Poi("Flyboard Paradise","Cagliari","bellissimo",new Coordinate(16,17,18),Categoria.Altro,
                "s2","s3","s4","si"));

        final ArrayList<Poi> poiDinamico = new ArrayList<Poi>();
        poiDinamico.add(poiStatico[0]);
        poiDinamico.add(poiStatico[1]);
        //poiDinamico.add(poiStatico[2]);
        //poiDinamico.add(poiStatico[3]);

        if(!(poi==null)) {
            poiDinamico.add(poi);
        }

        myAdapter = new MyAdapter(VisualizzaTutto.this,poiDinamico);

        listView.setAdapter(myAdapter);

        //quando premo Indietro torno all'activity Home
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**genero un Intent*/
                Intent intent = new Intent(VisualizzaTutto.this, MainActivity.class);
                intent.putExtra("key", numbers);
                /**chiamo la nuova activity (MainActivity)*/
                startActivity(intent);
            }
        });

        //quando premo Ricerca per Comune passa all'activity VisualizzaComune
        btRicercaComune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(VisualizzaTutto.this, VisualizzaComune.class);
                intent.putExtra("key", numbers);
                startActivity(intent);
            }
        });
    }
}
