package com.example.viaggiapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context; //activity dove è presente la list view
    private ArrayList<Poi> items; //elementi da mostrare

    public MyAdapter(Context context, ArrayList<Poi> items){
        this.context=context;
        this.items=items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    /**
     * Se non mi serve implementarla faccio restituire il parametro passato
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Funzione che genera le singole View della nostra list view (le "celle")
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_visualizza_tutto,
                    parent, false); //se non posso riusare una view già creata ne devo creare una
        }

        //non posso usare findView da solo perché non sono dentro la oncreate
        TextView nome = convertView.findViewById(R.id.textViewNome);
        TextView comune = convertView.findViewById(R.id.textViewComune);


        Poi poi = (Poi) getItem(position); //recupero l'elemento

        if(nome != null) {
            nome.setText(poi.getNome()); //per il nome usa la TextView dentro activity_result e sovrascrivine il testo
        }

        if(comune != null)
            comune.setText(poi.getComune());//per il comune usa la TextView dentro activity_result e sovrascrivine il testo

        return convertView; //ritorna la view generata
    }


}
