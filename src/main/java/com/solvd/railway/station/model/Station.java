package com.solvd.railway.station.model;

import com.solvd.railway.generics.Printer;
import com.solvd.railway.passenger.person.model.Passenger;

import java.util.LinkedList;
import java.util.Queue;

public final class Station {

    private static final Printer<String> logsPrinter = new Printer<>();
    private String name;
    private String city;
    private Queue<Passenger> waitingPassengers = new LinkedList<>();

    static {
        logsPrinter.info("Station Class Initiated");
    }

    {
        logsPrinter.info("New Station instance");
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
        logsPrinter.info("Station: " + name);
        logsPrinter.info("City: " + city);
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
