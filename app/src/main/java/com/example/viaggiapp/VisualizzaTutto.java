package com.example.viaggiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class VisualizzaTutto extends AppCompatActivity {

    /**ListView*/
    ListView listView;

    /**Vettore statico per i POI memorizzati di default*/
    Poi [] poiStatico = new Poi[]{
            new Poi("Marina Piccola","Cagliari"),
            new Poi("Flyboard Paradise","Cagliari"),
            new Poi("Cala Goloritze", "Dorgali")
    };

    Poi poi;

    /**Dichiaro un elemento di tipo MyAdapter*/
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_tutto);


        listView = findViewById(R.id.listView);


        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(Inserimento.PATH);

        poi = (Poi) obj;

        ArrayList<Poi> poiDinamico = new ArrayList<Poi>();
        poiDinamico.add(poiStatico[0]);
        poiDinamico.add(poiStatico[1]);
        poiDinamico.add(poiStatico[2]);

        if(!(poi==null)) {
            poiDinamico.add(poi);
        }

        myAdapter = new MyAdapter(VisualizzaTutto.this,poiDinamico);

        listView.setAdapter(myAdapter);

    }


}
