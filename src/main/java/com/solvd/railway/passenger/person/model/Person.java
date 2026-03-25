package com.solvd.railway.passenger.person.model;

import com.solvd.railway.station.model.Station;

public

abstract class Person implements PersonContract {

    private String name;
    private Station destination;

    static {
        System.out.println("Person Class Initiated");
    }

    {
        System.out.println("New Person instance");
    }

    @Override
    public abstract String toString();

    public abstract void showInfo();

    public abstract String getName();

    public abstract void setName(String name);

    public abstract Station getDestination();

}
