package com.example.badiappflynnremy.model;

public class Badi {
    private int id;
    private string name;
    private List<Becken> becken;
    private string kanton;
    private string ort;

    public Badi(int id, string name, List<Becken> becken, string kanton, string ort) {
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

    public string getName() {
        return name;
    }

    public void setName(string name) {
        this.name = name;
    }

    public List<Becken> getBecken() {
        return becken;
    }

    public void setBecken(List<Becken> becken) {
        this.becken = becken;
    }

    public string getKanton() {
        return kanton;
    }

    public void setKanton(string kanton) {
        this.kanton = kanton;
    }

    public string getOrt() {
        return ort;
    }

    public void setOrt(string ort) {
        this.ort = ort;
    }
}
