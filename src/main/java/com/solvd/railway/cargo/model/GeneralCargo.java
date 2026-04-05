package com.solvd.railway.cargo.model;

import com.solvd.railway.generics.Printer;
import com.solvd.railway.station.model.Station;

public final class GeneralCargo extends Cargo {

    private static final Printer<String> logsPrinter = new Printer<>();
    private String description;
    private double weight;
    private Station destination;

    {
        logsPrinter.info("New GeneralCargo instance");
    }

    public GeneralCargo(String description, double weight, Station destination) {
        this.description = description;
        this.weight = weight;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Cargo{" + "description='" + description + '\'' + ", weight='" + weight + '\'' + ", destination='" + destination + '\'' + '}';
    }

    @Override
    public void showInfo() {
        logsPrinter.info("Cargo: " + description);
        logsPrinter.info("Weight: " + weight + " tons");
        logsPrinter.info("Destination: " + destination.getStationName());
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public Station getDestination() {
        return destination;
    }

    @Override
    public void setDestination(Station destination) {
        this.destination = destination;
    }
}
