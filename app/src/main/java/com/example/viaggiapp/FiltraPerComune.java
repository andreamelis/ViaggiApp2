package com.example.viaggiapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class FiltraPerComune extends AppCompatActivity
{
    /**costante che definisce il path dell'oggetto Poi*/
    public static final String PATH ="com.example.projectpoi.String";

    /**variabili xml*/
    EditText etFiltroComune;
    Button buRicercaComune;

    /**oggetto di tipo Poi*/
    Poi poi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtra_per_comune);

        /**Edit Text*/
        etFiltroComune = findViewById(R.id.etFiltroComune);

        /*Inserisci Button */
        buRicercaComune = findViewById(R.id.buRicercaComune);

        /**creo un oggetto di tipo Poi usando il costruttore vuoto*/
        poi = new Poi();

        buRicercaComune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { /**quando premo il pulsante Inserisci*/

                        UpdatePoi(); /**provo ad aggiornare i valori del Poi*/

                    /**genero un Intent*/
                    Intent intent = new Intent(FiltraPerComune.this, VisualizzaComune.class);

                    /**appendo all'Intent il mio poi che dovrebbe essere pieno
                     *  perchè ho chiamato la funzione updatePoi*/

                    intent.putExtra(PATH, poi);

                    /**chiamo la nuova activity (ResultActivity)*/
                    startActivity(intent);
                }
        });
    }

    /**
     * Funzione che uso per associare all'oggetto poi tutti i campi che l'utente compila
     * nell'editText
     * @throws NumberFormatException
     */
    void UpdatePoi() {//throws NumberFormatException{

        /**la funzione getText chiamata su un editText restituisce un oggetto di tipo Editable
         devo fare il cast per trasformarla in un oggetto che la funzione di set del mio poi riconosca*/

        this.poi.setComune(this.etFiltroComune.getText().toString());

    }
}
