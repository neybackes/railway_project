package com.solvd.railway.passenger.person.model;

import com.solvd.railway.generics.Printer;
import com.solvd.railway.station.model.Station;

public final class Passenger extends Person {

    private static final Printer<String> logsPrinter = new Printer<>();
    private String name;
    private Station destination;

    {
        logsPrinter.info("New Passenger instance");
    }

    public Passenger(String name, Station destination) {
        this.name = name;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Passenger{" + "name='" + name + '\'' + ", destination='" + destination + '\'' + '}';
    }

    @Override
    public void showInfo() {
        logsPrinter.info("Passenger: " + name);
        logsPrinter.info("Destination: " + destination.getStationName());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Station getDestination() {
        return destination;
    }
}
