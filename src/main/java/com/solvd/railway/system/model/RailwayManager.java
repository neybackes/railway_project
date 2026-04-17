package com.solvd.railway.system.model;

import com.solvd.railway.exception.InvalidRailwayNameException;
import com.solvd.railway.generics.GenericList;
import com.solvd.railway.generics.Printer;
import com.solvd.railway.station.model.Station;
import com.solvd.railway.train.model.Train;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public final class RailwayManager extends RailwaySystem {

    private static final Printer<String> logsPrinter = new Printer<>();
    private String name;
    private GenericList<Station> stations;
    private GenericList<Train> trains;
    private Map<String, Train> trainMap;

    public RailwayManager(String name) throws InvalidRailwayNameException {
        if (RailwaySystemContract.isValidName(name)) {
            this.name = name;
            this.stations = new GenericList<>();
            this.trains = new GenericList<>();
            this.trainMap = new HashMap<>();
        } else {
            throw new InvalidRailwayNameException("Invalid railway name: " + name);
        }
    }

    @Override
    public String toString() {
        return "RailwaySystem{" + "name='" + name + '\'' + ", stations=" + stations + ", trains=" + trains + '}';
    }

    @Override
    public boolean equals(Object compare) {
        RailwayManager compareCast = (RailwayManager) compare;
        if (this.name.equals(compareCast.name)) {
            logsPrinter.info("Attribute " + name + " is equal.");
            return true;
        } else {
            logsPrinter.warn("Attribute " + name + " is not equal.");
            return false;
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String getSystemName() {
        return name;
    }

    @Override
    public void setSystemName(String name) {
        this.name = name;
    }

    public List<Station> getStations() {
        return stations.getAll();
    }

    public List<Train> getTrains() {
        return trains.getAll();
    }

    @Override
    public void addStation(Station station) {
        stations.add(station);
        logsPrinter.info("Station added to railway system: " + station.getStationName());
    }

    public void addTrain(Train train) {
        trains.add(train);
        logsPrinter.info("Train added to railway system: " + train.getName());
        trainMap.put(train.getName(), train);
    }

    public Train getTrainByName(String name) {
        return trainMap.get(name);
    }

    @Override
    public void showStations() {
        if (stations.isEmpty()) {
            logsPrinter.warn("No stations registered.");
            return;
        }

        logsPrinter.info("Stations in " + name + ":");
        stations.getAll().forEach(station ->
                logsPrinter.info("- " + station.getStationName() + " (" + station.getStationCity() + ")"));
    }

    @Override
    public void showTrains() {
        if (trains.isEmpty()) {
            logsPrinter.warn("No trains registered.");
            return;
        }

        logsPrinter.info("Trains in " + name + ":");
        trains.getAll().forEach(train ->
                logsPrinter.info("- " + train.getName() + " (ID: " + train.getTrainId() + ")"));
    }
}
