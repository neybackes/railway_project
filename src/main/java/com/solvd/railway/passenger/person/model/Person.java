package com.solvd.railway.passenger.person.model;

import com.solvd.railway.cargo.model.GeneralCargo;
import com.solvd.railway.station.model.Station;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public

abstract class Person implements PersonContract {

    private static final Logger logger = LogManager.getLogger(Person.class);
    private String name;
    private Station destination;

    static {
        logger.info("Person Class Initiated");
    }


    @Override
    public abstract String toString();

    public abstract void showInfo();

    public abstract String getName();

    public abstract void setName(String name);

    public abstract Station getDestination();

}
