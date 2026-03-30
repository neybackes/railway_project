package com.solvd.railway.system.model;

import com.solvd.railway.generics.Printer;
import com.solvd.railway.station.model.Station;


public abstract class RailwaySystem implements RailwaySystemContract {


    private static final Printer<String> logsPrinter = new Printer<>();
    private String name;

    static {
        logsPrinter.info("RailwaySystem Class Initiated");
    }

    {
        logsPrinter.info("New RailwayManager instance");
    }

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object compare);

    public abstract String getSystemName();

    public abstract void setSystemName(String name);

    public abstract void addStation(Station station);

    public abstract void showStations();

    public abstract void showTrains();
}
