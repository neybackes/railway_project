package com.solvd.railway.train.model;

import com.solvd.railway.enums.TrainStatus;
import com.solvd.railway.generics.GenericList;
import com.solvd.railway.generics.Printer;
import com.solvd.railway.station.model.Route;
import com.solvd.railway.station.model.Station;
import com.solvd.railway.train.model.wagon.model.Wagon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public final class Train {
    private static final Printer<String> logsPrinter = new Printer<>();
    private int trainId;
    private String name;
    private Locomotive locomotive;
    private Station currentStation;
    private Route route;
    private GenericList<Wagon> wagons;
    private Deque<Station> recentStations = new ArrayDeque<>();
    private TrainStatus status;

    static {
        logsPrinter.info("Train Class Initiated");
    }

    {
        logsPrinter.info("New Train instance");
    }

    public Train(int trainId, String name, Locomotive locomotive, Station currentStation, Route route) {
        this.trainId = trainId;
        this.name = name;
        this.locomotive = locomotive;
        this.currentStation = currentStation;
        this.route = route;
        this.wagons = new GenericList<>();
        this.status = TrainStatus.STOPPED;
    }

    @Override
    public String toString() {
        return "Train{" + "trainId='" + trainId + '\'' + ", name='" + name + '\'' + ", locomotive='" + locomotive + '\'' + ", currentStation='" + currentStation + '\'' + ", route='" + route + '\'' + ", wagons='" + wagons + '\'' + '}';
    }

    public void showInfo() {
        logsPrinter.title("Train Information");
        logsPrinter.info("Train ID: " + trainId);
        logsPrinter.info("Train Name: " + name);
        logsPrinter.info("Locomotive: " + locomotive.name());
        logsPrinter.info("Current Station: " + currentStation.getStationName());
        logsPrinter.info("Number of wagons: " + wagons.size());
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
        return wagons.getAll();
    }

    public void addWagon(Wagon wagon) {
        wagons.add(wagon);
        logsPrinter.info("Wagon " + wagon.getWagonId() + " added to train " + name + ".");
    }

    public void moveTo(Station newStation) {
        if (!route.isStationOnRoute(newStation)) {
            logsPrinter.warn("Station " + newStation.getStationName() + " is not on this route.");
            return;
        }

        if (currentStation.equals(newStation)) {
            logsPrinter.warn("Train " + name + " is already at " + newStation.getStationName());
            return;
        }
        updateStatus(TrainStatus.RUNNING);

        logsPrinter.info("Train " + name + " leaving " + currentStation.getStationName());
        currentStation = newStation;
        logsPrinter.info("Train " + name + " arrived at " + currentStation.getStationName());
        updateStatus(TrainStatus.STOPPED);
    }

    public void showCurrentStation() {
        logsPrinter.info("Train " + name + " is currently at " + currentStation.getStationName());
    }

    public void showWagons() {
        if (wagons.isEmpty()) {
            logsPrinter.warn("No wagons attached to train " + name + ".");
            return;
        }

        wagons.getAll().forEach(Wagon::showInfo);
    }

    public void addRecentStation(Station station) {
        recentStations.addLast(station);
    }

    public Station getLastVisitedStation() {
        return recentStations.peekLast();
    }

    public Station removeLastVisitedStation() {
        return recentStations.pollLast();
    }

    public Deque<Station> getRecentStations() {
        return recentStations;
    }

    private void updateStatus(TrainStatus newStatus) {
        TrainStatus oldStatus = this.status;

        this.status = newStatus;

        logsPrinter.info(
                String.format("Train " + name + " changed to " + newStatus + ". Older status was " + oldStatus)
        );
    }
}
