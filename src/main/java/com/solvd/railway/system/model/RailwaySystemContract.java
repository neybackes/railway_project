package com.solvd.railway.system.model;

import com.solvd.railway.station.model.Station;

public interface RailwaySystemContract {
    static boolean isValidName(String name) {
        return name != null && !name.isEmpty();
    }

    String getSystemName();

    void setSystemName(String name);

    void addStation(Station station);

    void showStations();

    void showTrains();

    @Override
    String toString();

    @Override
    boolean equals(Object compare);
}