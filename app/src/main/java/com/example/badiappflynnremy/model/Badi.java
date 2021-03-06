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
    private String information;

    public Badi(int id, String name, String kanton, String ort, String adresse, String information) {
        this.id = id;
        this.name = name;
        this.kanton = kanton;
        this.ort = ort;
        this.becken = new ArrayList<Becken>();
        this.adresse = adresse;
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
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
        this.information = information;
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
