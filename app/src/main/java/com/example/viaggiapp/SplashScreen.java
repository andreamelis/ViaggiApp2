package com.example.viaggiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /** Creo un thread permostrare la SplashScreen per due secondi, dopo passa automaticamente alla
         *  schermata dall' ActivityMain
         */
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(2 * 1000); /**per 2 secondi dormi (non fare altro)*/

                    /**una volta finiti i tre secondi entro qui e passo a Main Activity*/
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        /**avvio il thread*/
        thread.start();
    }
}
