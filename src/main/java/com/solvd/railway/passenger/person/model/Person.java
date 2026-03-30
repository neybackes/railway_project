package com.solvd.railway.passenger.person.model;

import com.solvd.railway.generics.Printer;
import com.solvd.railway.station.model.Station;

public abstract class Person implements PersonContract {

    private static final Printer<String> logsPrinter = new Printer<>();
    private String name;
    private Station destination;

    static {
        logsPrinter.info("Person Class Initiated");
    }

    @Override
    public abstract String toString();

    public abstract void showInfo();

    public abstract String getName();

    public abstract void setName(String name);

    public abstract Station getDestination();
}
