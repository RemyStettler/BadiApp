package com.example.badiappflynnremy.model;

import java.util.List;

public class Badi {
    private int id;
    private String name;
    private List<Becken> becken;
    private String kanton;
    private String ort;

    public Badi(int id, String name, List<Becken> becken, String kanton, String ort) {
        this.id = id;
        this.name = name;
        this.becken = becken;
        this.kanton = kanton;
        this.ort = ort;
    }

    @Override
    public String toString() {
        return "Badi{" +
                "id=" + id +
                ", name=" + name +
                ", becken=" + becken +
                ", kanton=" + kanton +
                ", ort=" + ort +
                '}';
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
