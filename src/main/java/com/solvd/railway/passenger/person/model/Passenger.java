package com.solvd.railway.passenger.person.model;

import com.solvd.railway.station.model.Station;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Passenger extends Person {

    private static final Logger logger = LogManager.getLogger(Passenger.class);
    private String name;
    private Station destination;

    {
        logger.info("New Passenger instance");
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
        logger.info("Passenger: {}", name);
        logger.info("Destination: {}", destination.getStationName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Station getDestination() {
        return destination;
    }
}