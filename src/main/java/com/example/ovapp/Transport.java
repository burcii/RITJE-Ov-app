package com.example.ovapp;

public abstract class Transport {
    protected String name;
    protected String fuel;
    protected String comfort;

    public Transport(String name, String fuel, String comfort) {
        this.name = name;
        this.fuel = fuel;
        this.comfort = comfort;
    }

    public abstract String getTransportInfo();
}
