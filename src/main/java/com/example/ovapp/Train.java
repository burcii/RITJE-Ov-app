package com.example.ovapp;

public class Train extends Transport {
    public Train() {
        super("Train", "Electric", "High");
    }

    @Override
    public String getTransportInfo() {
        return name + "\nFuel: " + fuel + "\nComfort: " + comfort;
    }
}