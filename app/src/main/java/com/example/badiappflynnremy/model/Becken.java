package com.example.badiappflynnremy.model;

public class Becken {
    private string name;
    private double temperature;

    public Becken(string name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Becken{" +
                "name=" + name +
                ", temperature=" + temperature +
                '}';
    }

    public string getName() {
        return name;
    }

    public void setName(string name) {
        this.name = name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
