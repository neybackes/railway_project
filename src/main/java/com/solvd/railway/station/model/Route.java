package com.solvd.railway.station.model;

import com.solvd.railway.generics.Printer;

public record Route(Station origin, Station destination, double distance) {

    private static final Printer<String> logsPrinter = new Printer<>();

    static {
        logsPrinter.info("Route Class Initiated");
    }

    public Route {
        logsPrinter.info("New Route instance");
    }

    public void showInfo() {
        logsPrinter.info("Route:");
        logsPrinter.info("Origin: " + origin.getStationName());
        logsPrinter.info("Destination: " + destination.getStationName());
        logsPrinter.info("Distance: " + distance + " km");
    }

    public boolean isStationOnRoute(Station station) {
        return station.equals(origin) || station.equals(destination);
    }
}