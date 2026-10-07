package com.example.ovapp;

public class Bus extends Transport {
    public Bus() {
        super("Bus", "Diesel", "Medium");
    }

    @Override
    public String getTransportInfo() {
        return name + "\nFuel: " + fuel + "\nComfort: " + comfort;
    }
}