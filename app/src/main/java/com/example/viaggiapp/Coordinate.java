package com.example.viaggiapp;

import java.io.Serializable;

public class Coordinate implements Serializable {
    private double latitudine;
    private double longitudine;
    private double altitudine;

    /**Costruttore per le com.example.viaggiapp.Coordinate dove passo tutti i valori*/
    public Coordinate(double latitudine, double longitudine, double altitudine ){
        this.setAltitudine(altitudine);
        this.setLongitudine(longitudine);
        this.setLatitudine(latitudine);
    }

    /**Costruttore per le com.example.viaggiapp.Coordinate dove passo solo i valori di lat e lon*/
    public Coordinate(double latitudine, double longitudine ){
        this.setLatitudine(latitudine);
        this.setLongitudine(longitudine);
    }

    /**Costruttore per le com.example.viaggiapp.Coordinate dove passo solo il valore dell'altitudine*/
    public Coordinate(double altitudine){
        this.setAltitudine(altitudine);
    }

    public double getAltitudine() {
        return altitudine;
    }

    public void setAltitudine(double altitudine) {
        this.altitudine = altitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }
}
