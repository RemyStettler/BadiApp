package com.example.badiappflynnremy.model;

public class Becken {
    private String name;
    private double temperature;

    public Becken(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public Becken() {
        this.name = name;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return name + " " + temperature +
                "°C";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
