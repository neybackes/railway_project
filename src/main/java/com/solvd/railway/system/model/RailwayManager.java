package com.solvd.railway.system.model;

import com.solvd.railway.station.model.Station;
import com.solvd.railway.train.model.Train;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class RailwayManager extends RailwaySystem {

    private static final Logger logger = LogManager.getLogger(RailwayManager.class);
    private String name;
    private List<Station> stations;
    private List<Train> trains;

    public RailwayManager(String name) {
        if (RailwaySystemContract.isValidName(name)) {
            this.name = name;
            this.stations = new ArrayList<>();
            this.trains = new ArrayList<>();
        } else {
            logger.warn("Invalid Name");

        }
    }

    @Override
    public String toString() {
        return "RailwaySystem{" +
                "name='" + name + '\'' +
                ", stations=" + stations +
                ", trains=" + trains +
                '}';
    }

    @Override
    public boolean equals(Object compare) {
        //explicit casting -- needs more research
        RailwayManager compareCast = (RailwayManager) compare;
        if (this.name.equals(compareCast.name)) {
            logger.info("Atribute {} is equals.", name);
            return true;
        } else {
            logger.warn("Attribute {} is not equal.", name);
            return false;
        }
    }

    public int hashCode() {
        return name.hashCode();
    }

    public String getSystemName() {
        return name;
    }

    public void setSystemName(String name) {
        this.name = name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void addStation(Station station) {
        stations.add(station);
        logger.info("Station {} added to railway system.", station.getStationName());
    }

    public void addTrain(Train train) {
        trains.add(train);
        logger.info("Train {} added to railway system.", train.getName());
    }

    public void showStations() {
        if (stations.isEmpty()) {
            logger.warn("No stations registered.");
        }

        logger.info("Stations in {}:", name);
        for (Station station : stations) {
            logger.info("- {} ({})", station.getStationName(), station.getStationCity());
        }
    }

    public void showTrains() {
        if (trains.isEmpty()) {
            logger.warn("No trains registered.");
            return;
        }

        logger.info("Trains in {}:", name);
        for (Train train : trains) {
            logger.info("- {} (ID: {})", train.getName(), train.getTrainId());
        }
    }
}