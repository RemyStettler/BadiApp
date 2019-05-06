package com.example.badiappflynnremy.model;

import java.util.ArrayList;
import java.util.List;

public class Badi {
    private int id;
    private String name;
    private List<Becken> becken;
    private String kanton;
    private String ort;
    private String adresse;
    private String öffungszeiten;

    public Badi(int id, String name, String kanton, String ort, String adresse, String öffnungszeiten) {
        this.id = id;
        this.name = name;
        this.kanton = kanton;
        this.ort = ort;
        this.becken = new ArrayList<Becken>();
        this.adresse = adresse;
        this.öffungszeiten = öffnungszeiten;
    }

    public String getÖffungszeiten() {
        return öffungszeiten;
    }

    public void setÖffungszeiten(String öffungszeiten) {
        this.öffungszeiten = öffungszeiten;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Badi() {
        this.id = id;
        this.name = name;
        this.kanton = kanton;
        this.ort = ort;
        this.becken = new ArrayList<Becken>();
        this.adresse = adresse;
        this.öffungszeiten = öffungszeiten;
    }

    @Override
    public String toString() {
        return name + " " + kanton + " (" + ort + ')';
    }

    public void addBecken(Becken becken) {
        this.becken.add(becken);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Becken> getBecken() {
        return becken;
    }

    public void setBecken(List<Becken> becken) {
        this.becken = becken;
    }

    public String getKanton() {
        return kanton;
    }

    public void setKanton(String kanton) {
        this.kanton = kanton;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
