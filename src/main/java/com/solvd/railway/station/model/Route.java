package com.solvd.railway.station.model;

import com.solvd.railway.generics.Printer;

public final class Route {

    private static final Printer<String> logsPrinter = new Printer<>();
    private Station origin;
    private Station destination;
    private double distance;

    static {
        logsPrinter.info("Route Class Initiated");
    }

    {
        logsPrinter.info("New Route instance");
    }

    public Route(Station origin, Station destination, double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" + "origin ='" + origin + '\'' + ", destination='" + destination + '\'' + ", distance='" + distance + '\'' + '}';
    }

    public void showInfo() {
        logsPrinter.info("Route:");
        logsPrinter.info("Origin: " + origin.getStationName());
        logsPrinter.info("Destination: " + destination.getStationName());
        logsPrinter.info("Distance: " + distance + " km");
    }

    public String getOrigin() {
        return origin.getStationName();
    }

    public String getDestination() {
        return destination.getStationName();
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isStationOnRoute(Station station) {
        return station.equals(origin) || station.equals(destination);
    }
}
