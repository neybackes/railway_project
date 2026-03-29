package com.solvd.railway.station.model;

import com.solvd.railway.passenger.person.model.Passenger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Queue;
import java.util.LinkedList;

public final class Station {

    private static final Logger logger = LogManager.getLogger(Station.class);
    private String name;
    private String city;
    private Queue<Passenger> waitingPassengers = new LinkedList<>();

    static {
        logger.info("Station Class Initiated");
    }

    {
        logger.info("New Station instance");
    }

    public Station(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Station{" + "name='" + name + '\'' + ", city='" + city + '\'' + '}';
    }

    public void showInfo() {
        logger.info("Station: {}", name);
        logger.info("City: {}", city);
    }

    public String getStationName() {
        return name;
    }

    public void setStationName(String name) {
        this.name = name;
    }

    public String getStationCity() {
        return city;
    }

    public void setStationCity(String city) {
        this.city = city;
    }

    public void addPassengerToQueue(Passenger passenger) {
        waitingPassengers.offer(passenger);
    }

    public Passenger boardNextPassenger() {
        return waitingPassengers.poll();
    }

    public Passenger getNextPassenger() {
        return waitingPassengers.peek();
    }

    public Queue<Passenger> getWaitingPassengers() {
        return waitingPassengers;
    }

}