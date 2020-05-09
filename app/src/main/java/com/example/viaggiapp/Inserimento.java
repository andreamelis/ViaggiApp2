package com.example.viaggiapp;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class Inserimento extends AppCompatActivity
        implements GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks
{
    //costante che definisce il path dell'oggetto Poi

    public static final String PATH ="com.example.projectpoi.Poi";

    /**variabili xml*/
    EditText nomeText, descrizioneText, altitudineText, comuneText;
    Button inviaDatiPoi, inserisciGps;

    /**oggetto di tipo Poi*/
    Poi poi;

    /**Spinner*/
    Spinner spinner;

    /**RadioButton*/
    RadioButton rbVisitabileTrue, rbVisitabileFalse;

    /**CkeckBox*/
    CheckBox cbHashtagUno, cbHashtagDue, cbHashtagTre;

    /**Localizzazione*/
    Location posizione; /**variabile che conterrà la nostra posizione*/

    /**punto d'accesso per le integrazioni dei servizi di google play
     senza questo non posso chiamare le api*/
    GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserimento);

        /**Edit Text*/
        nomeText = findViewById(R.id.editTextNome);
        descrizioneText = findViewById(R.id.editTextDescrizione);
        altitudineText = findViewById(R.id.editTextAltitudine);
        comuneText = findViewById(R.id.editTextComune);

        /**CheckBox*/
        cbHashtagUno = findViewById(R.id.checkBoxHashtagUno);
        cbHashtagDue = findViewById(R.id.checkBoxHashtagDue);
        cbHashtagTre = findViewById(R.id.checkBoxHashtagTre);

        /**Button*/
        inserisciGps = findViewById(R.id.buttonPosition);

        /**RadioButton*/
        rbVisitabileFalse = findViewById(R.id.rbVisitabileFalse);
        rbVisitabileTrue = findViewById(R.id.rbVisitabileTrue);

        /** Spinner */
        spinner = findViewById(R.id.spinnerCategoria);

        /**L'adapter è quell'elemento che contiene i singoli blocchi con le opzioni
         per creare l'adapter uso la funzione createFromResource a cui passo il contesto,
         l'array di stringhe che ho definito in strings.xml e un layout per ogni elemento della lista*/
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);

        /**volendo posso non chiamare questa funzione, ma le singole opzioni saranno tutte attaccate
         e non avremo un effetto grafico soddisfacente (commentare per credere)*/
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        /**associo allo spinner l'adapter*/
        spinner.setAdapter(adapter);

        /**Quando seleziono un elemento nella lista*/
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //recupero l'elemento selezionato
                Object categoria = parent.getItemAtPosition(position);
                //setto la categoria del poi con il valore dell'enumerazione ottenuto dalla selezione
                poi.setCategoria(Categoria.valueOf(categoria.toString()));
            }

            /**Volendo posso sovrascrivere il comportamento di cosa succede quando non seleziono niente*/
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*Inserisci Button */
        inviaDatiPoi = findViewById(R.id.buttonInviaDati);

        /**creo un oggetto di tipo Poi usando il costruttore vuoto*/
        poi = new Poi();

        inviaDatiPoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //quando premo il pulsante Inserisci
                if (checkData()) {
                    try {
                        UpdatePoi(); //provo ad aggiornare i valori del Poi
                    } catch (NumberFormatException e) { //se qualcosa è andato storto catturo l'eccezione
                        /**genero il toast*/
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Inserisci una categoria tra quelle indicate", Toast.LENGTH_LONG);
                        toast.show(); //mostro il toast
                        return; //esco
                    }
                    /**genero un Intent*/
                    Intent intent = new Intent(Inserimento.this, VisualizzaTutto.class);
                    /**appendo all'Intent il mio poi che dovrebbe essere pieno
                     *  perchè ho chiamato la funzione updatePoi*/
                    intent.putExtra(PATH, poi);
                    /**chiamo la nuova activity (ResultActivity)*/
                    startActivity(intent);
                }
            }
        });

        /*Localizzazione */

        /**mi serve per chiamare l'Api di Google Play Service*/
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API) //api di google play service
                .addOnConnectionFailedListener(this) //aggiungo i listener in caso di connessione fallita
                .addConnectionCallbacks(this) //listener in caso di connessione sospesa o successo
                .build(); //costruisce l'oggetto

        mGoogleApiClient.connect(); //connetto

        /**Quando premo il pulsante per acquisire la connessione GPS*/
        inserisciGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //la mia variabile prende l'ultima posizione salvata nella localizzazione
                posizione = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
                if(posizione!= null){
                    //se l'ho acquisita correttamente la salvo nelle coordinate
                    poi.setCoordinate(new Coordinate(
                            posizione.getLatitude(),
                            posizione.getLongitude(),
                            Double.parseDouble(altitudineText.getText().toString())
                    ));
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Qualcosa è andato storto", Toast.LENGTH_LONG);

                    toast.show();
                }
            }
        });
    }

    /**
     * Funzione associata all'android:onClick dei RadioButtons dell'activity_main.xml
     * @param view
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbVisitabileTrue:
                if (checked)
                    this.poi.setVisitabile("Si");
                break;
            case R.id.rbVisitabileFalse:
                if (checked)
                    this.poi.setVisitabile("No");
                break;
        }
    }
    /**
     * Funzione associata all'android:onClick dei RadioButtons dell'activity_main.xml
     * @param view
     */
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBoxHashtagUno:
                if (checked)
                    this.poi.setHashatagUno(this.cbHashtagUno.getText().toString());
                else
                    this.poi.setHashatagUno("");
                break;
            case R.id.checkBoxHashtagDue:
                if (checked)
                    this.poi.setHashatagDue(this.cbHashtagDue.getText().toString());
                else
                    this.poi.setHashatagDue("");
                break;
            case R.id.checkBoxHashtagTre:
                if (checked)
                    this.poi.setHashatagTre(this.cbHashtagTre.getText().toString());
                else
                    this.poi.setHashatagTre("");
                break;

            // TODO: Veggie sandwich
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Connessione riuscita", Toast.LENGTH_LONG);

        toast.show();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Mancanza di connessione", Toast.LENGTH_LONG);

        toast.show();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Connessione persa", Toast.LENGTH_LONG);

        toast.show();
    }

    /**
     * Funzione che uso per associare all'oggetto poi tutti i campi che l'utente compila
     * nell'editText
     * @throws NumberFormatException
     */
    void UpdatePoi() {//throws NumberFormatException{

        /**la funzione getText chiamata su un editText restituisce un oggetto di tipo Editable
         devo fare il cast per trasformarla in un oggetto che la funzione di set del mio poi riconosca*/
        this.poi.setNome(this.nomeText.getText().toString());
        this.poi.setDescrizione(this.descrizioneText.getText().toString());
        this.poi.setComune(this.comuneText.getText().toString());
        posizione.setAltitude(Double.parseDouble(this.altitudineText.getText().toString()));
        onCheckboxClicked(cbHashtagUno);
        onCheckboxClicked(cbHashtagDue);
        onCheckboxClicked(cbHashtagTre);
        onRadioButtonClicked(rbVisitabileFalse);


    }

    private boolean checkData(){
        int nErrors =0; //variabile con il numero di errori
       /* if(nomeText.getText().length() == 0){ //se cancello
            nomeText.setError("Inserire il nome");
            nErrors++;
             }
        }*/
        /*if((posizione== null)){
            inserisciGps.setError("Inserire il nome");
            nErrors++;
        }
*/
        /*if(descrizioneText.getText().length() == 0){
            descrizioneText.setError("Inserire la descrizione");
            nErrors++;
        }*/

        switch (nErrors){
            case 0: //se ho zero errori non faccio niente
                break;
            case 1:
                Toast toast = Toast.makeText(getBaseContext(), "Si è verificato un Errore", Toast.LENGTH_LONG);
                toast.show();
                break;
            default:
                Toast toast2 = Toast.makeText(getBaseContext(), "Si sono verificati " + nErrors + " errori", Toast.LENGTH_LONG);
                toast2.show();
                break;
        }
        /**se non ci sono errori ritorna true*/
        return nErrors == 0;
    }
}
