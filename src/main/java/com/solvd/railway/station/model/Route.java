package com.solvd.railway.station.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Route {

    private static final Logger logger = LogManager.getLogger(Route.class);
    private Station origin;
    private Station destination;
    private double distance;

    static {
        logger.info("Route Class Initiated");
    }

    {
        logger.info("New Route instance");
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
        logger.info("Route:");
        logger.info("Origin: {}", origin.getStationName());
        logger.info("Destination: {}", destination.getStationName());
        logger.info("Distance: {} km", distance);
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