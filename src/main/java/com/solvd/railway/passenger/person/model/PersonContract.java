package com.solvd.railway.passenger.person.model;

import com.solvd.railway.station.model.Station;

public interface PersonContract {

    String getName();

    void setName(String name);

    Station getDestination();

    void showInfo();

    @Override
    String toString();
}