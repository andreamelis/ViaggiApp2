package com.example.viaggiapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.viaggiapp.ui.main.FragmentMenu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.viaggiapp.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonInserimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        /**Creo un vettore di due elementi per memorizzare la posizione delle icone,
         * nella posizione uno ci sarà l'icona Home, mentre nella due ci sarà l'icona del menù
         */
        int [] icons = {R.drawable.ic_home, R.drawable.ic_menu};

        /**Assegno al tab0 (quello corrispondente a FragmentHome) l'icona home (memorizzata nel
         * vettore in posizione 0), e a tab1 (quello corrispondente a FragmentMenu)
         * l'icona menù (memorizzata nel vettore in posizione 1)
         */
        tabs.getTabAt(0).setIcon(icons[0]);
        tabs.getTabAt(1).setIcon(icons[1]);

    }

}