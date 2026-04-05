package com.solvd.railway.cargo.model;

import com.solvd.railway.generics.Printer;
import com.solvd.railway.station.model.Station;

public abstract class Cargo implements CargoContract {

    private static final Printer<String> logsPrinter = new Printer<>();

    static {
        logsPrinter.info("Cargo Class Initiated");
    }

    public abstract void showInfo();

    @Override
    public abstract String toString();

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract double getWeight();

    public abstract void setWeight(double weight);

    public abstract Station getDestination();

    public abstract void setDestination(Station destination);
}
