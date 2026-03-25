package com.solvd.railway.train.model;

import com.solvd.railway.station.model.Route;
import com.solvd.railway.station.model.Station;
import com.solvd.railway.train.model.wagon.model.Wagon;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Train {
    private static final Logger logger = LogManager.getLogger(Train.class);
    private int trainId;
    private String name;
    private Locomotive locomotive;
    private Station currentStation;
    private Route route;
    private List<Wagon> wagons;

    static {
        logger.info("Train Class Initiated");
    }

    {
        logger.info("New Train instance");
    }

    public Train(int trainId, String name, Locomotive locomotive, Station currentStation, Route route) {
        this.trainId = trainId;
        this.name = name;
        this.locomotive = locomotive;
        this.currentStation = currentStation;
        this.route = route;
        this.wagons = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId='" + trainId + '\'' +
                ", name='" + name + '\'' +
                ", locomotive='" + locomotive + '\'' +
                ", currentStation='" + currentStation + '\'' +
                ", route='" + route + '\'' +
                ", wagons='" + wagons + '\'' +
                '}';
    }

    public void showInfo() {
        logger.info("Train ID: {}", trainId);
        logger.info("Train Name: {}", name);
        logger.info("Locomotive: {}", locomotive.getName());
        logger.info("Current Station: {}", currentStation.getStationName());
        logger.info("Number of wagons: {}", wagons.size());
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public Station getCurrentStation() {
        return currentStation;
    }

    public Route getRoute() {
        return route;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void addWagon(Wagon wagon) {
        wagons.add(wagon);
        logger.info("Wagon {} added to train {}.", wagon.getWagonId(), name);
    }

    public void moveTo(Station newStation) {

        if (!route.isStationOnRoute(newStation)) {
            logger.warn("Station {} is not on this route.", newStation.getStationName());
            return;
        }

        if (currentStation.equals(newStation)) {
            logger.warn("Train {} is already at {}", name, newStation.getStationName());
            return;
        }

        logger.info("Train {} leaving {}", name, currentStation.getStationName());
        currentStation = newStation;
        logger.info("Train {} arrived at {}", name, currentStation.getStationName());
    }

    public void showCurrentStation() {
        logger.info("Train {} is currently at {}", name, currentStation.getStationName());
    }

    public void showWagons() {
        if (wagons.isEmpty()) {
            logger.warn("No wagons attached to train {}.", name);
            return;
        }

        for (Wagon wagon : wagons) {
            wagon.showInfo();
        }
    }
}