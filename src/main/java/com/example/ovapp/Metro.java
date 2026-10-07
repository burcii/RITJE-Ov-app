package com.example.ovapp;

public class Metro extends Transport {
    public Metro() {
        super("Metro", "Electric", "Medium-High");
    }

    @Override
    public String getTransportInfo() {
        return name + "\nFuel: " + fuel + "\nComfort: " + comfort;
    }
}
