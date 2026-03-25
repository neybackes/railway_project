package com.solvd.railway.system.model;

import com.solvd.railway.station.model.Station;

public abstract class RailwaySystem implements RailwaySystemContract {

    private String name;

    static {
        System.out.println("RailwaySystem Class Initiated");
    }

    {
        System.out.println("New RailwayManager instance");
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
