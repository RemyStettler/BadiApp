package com.example.badiappflynnremy.model;

public class Becken {
    private String name;
    private double temperature;
    private String status;

    public Becken(String name, double temperature, String status) {
        this.name = name;
        this.temperature = temperature;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
