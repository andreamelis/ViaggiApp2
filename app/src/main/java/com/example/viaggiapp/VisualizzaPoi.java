package com.example.viaggiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.Serializable;

public class VisualizzaPoi extends AppCompatActivity {

    EditText nomeTextRes, comuneTextRes, descrizioneTextRes, altitudineTextRes, longitudineTextRes,
            latitudineTextRes, categoriaTextRes, hashtagUnoRes, hashtagDueRes, hashtagTreRes, visitabileRes;

    Button btIndietro, btInvia;
    ImageButton preferiti;

    Poi poi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_poi);

        /**Associo le mie variabili al file xml*/
        nomeTextRes=findViewById(R.id.resultTextNome);
        comuneTextRes = findViewById(R.id.resultTextComune);
        descrizioneTextRes = findViewById(R.id.resultTextDescrizione);
        altitudineTextRes = findViewById(R.id.resultTextAltitudine);
        longitudineTextRes =findViewById(R.id.resultTextLongitudine);
        latitudineTextRes = findViewById(R.id.resultTextLAtitudine);
        categoriaTextRes = findViewById(R.id.resultTextCategoria);
        hashtagUnoRes = findViewById(R.id.resultHashtagUno);
        hashtagDueRes = findViewById(R.id.resultHashtagDue);
        hashtagTreRes = findViewById(R.id.resultHashtagTre);
        visitabileRes = findViewById(R.id.resultVisitabile);

        /**Associo i miei oggetti di tipo Button ai button del file xml*/
        btIndietro = findViewById(R.id.buttonIndietro);
        btInvia = findViewById(R.id.buttonInvia);
        preferiti = findViewById(R.id.buttonPreferiti);

        /**catturo l'intent*/
        Intent intent = getIntent();
        /**l'oggetto che abbiamo passato è un Serializable, per salvarlo uso la stessa stringa
        che ho usato nella putExtra*/
        Serializable obj = intent.getSerializableExtra(Inserimento.PATH);

        if(obj instanceof Poi){
            poi = (Poi) obj; //cast esplicito, se lascio obj non posso chiamare i metodi di poi
        }
        else poi = new Poi();

        /**riempio le mie textview con le proprietà passate dal poi*/
        fillPoi(poi);


        preferiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                preferiti.setBackgroundResource(R.drawable.common_google_signin_btn_icon_dark);
            }
        });

        /**quando premo Indietro torno all'activity precedente*/
        btIndietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisualizzaPoi.this, Inserimento.class);
                startActivity(intent);
            }
        });
        /**quando premo Indietro torno all'activity precedente*/
        btInvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //quando premo il pulsante Inserisci

                    /**genero un Intent*/
                    Intent intent = new Intent(VisualizzaPoi.this, VisualizzaTutto.class);

                    /**appendo all'Intent il mio poi che dovrebbe essere pieno
                     *  perchè ho chiamato la funzione updatePoi*/
                    intent.putExtra("com.example.projectpoi.Poi", poi);
                    /**chiamo la nuova activity (ResultActivity)*/
                    startActivity(intent);
                }

        });

    }

    /**
     * Funzione che riempie le TextView del file activity_result.xml con i valori del poi
     * @param poi
     */
    void fillPoi(Poi poi){
        /**setText prende una stringa*/
        nomeTextRes.setText(poi.getNome());
        comuneTextRes.setText(poi.getComune());
        descrizioneTextRes.setText(poi.getDescrizione());
        longitudineTextRes.setText(Double.toString(poi.getCoordinate().getLongitudine()));
        latitudineTextRes.setText(Double.toString(poi.getCoordinate().getLatitudine()));
        altitudineTextRes.setText(Double.toString(poi.getCoordinate().getAltitudine()));
        hashtagUnoRes.setText(poi.getHashatagUno());
        hashtagDueRes.setText(poi.getHashatagDue());
        hashtagTreRes.setText(poi.getHashatagTre());
        categoriaTextRes.setText(poi.getCategoria().toString());
        visitabileRes.setText(poi.getVisitabile());
    }
}