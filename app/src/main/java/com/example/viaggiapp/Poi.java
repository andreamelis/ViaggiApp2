package com.example.viaggiapp;

import java.io.Serializable;

public class Poi implements Serializable {
    private String nome;
    private String comune;
    private String descrizione;
    private Coordinate coordinate;
    private Categoria categoria;
    private String hashatagUno;
    private String hashatagDue;
    private String hashatagTre;
    private String visitabile;


    public Poi(String nome, String comune, String descrizione, Coordinate coordinate, Categoria categoria,
               String hashatagUno, String hashatagDue, String hashatagTre, String visitabile){
        this.setNome(nome);
        this.setComune(comune);
        this.setDescrizione(descrizione);
        this.setCoordinate(coordinate);
        this.setCategoria(categoria);
        this.setHashatagUno(hashatagUno);
        this.setHashatagDue(hashatagDue);
        this.setHashatagTre(hashatagTre);
        this.setVisitabile(visitabile);
    }

    public Poi(String nome, String comune){
        this.setNome(nome);
        this.setComune(comune);

    }

    public Poi(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getHashatagUno() {
        return hashatagUno;
    }

    public void setHashatagUno(String hashatagUno) {
        this.hashatagUno = hashatagUno;
    }

    public String getHashatagDue() {
        return hashatagDue;
    }

    public void setHashatagDue(String hashatagDue) {
        this.hashatagDue = hashatagDue;
    }

    public String getHashatagTre() {
        return hashatagTre;
    }

    public void setHashatagTre(String hashatagTre) {
        this.hashatagTre = hashatagTre;
    }

    public String getVisitabile() {
        return visitabile;
    }

    public void setVisitabile(String visitabile) {
        this.visitabile = visitabile;
    }
}
