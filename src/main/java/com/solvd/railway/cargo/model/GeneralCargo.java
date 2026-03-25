package com.solvd.railway.cargo.model;

import com.solvd.railway.station.model.Station;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GeneralCargo extends Cargo {

    private static final Logger logger = LogManager.getLogger(GeneralCargo.class);
    private String description;
    private double weight;
    private Station destination;

    {
        logger.info("New GeneralCargo instance");
    }

    public GeneralCargo(String description, double weight, Station destination) {
        this.description = description;
        this.weight = weight;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Cargo{" + "description='" + description + '\'' + ", weight='" + weight + '\''
                + ", destination='" + destination + '\'' + '}';
    }

    @Override
    public void showInfo() {
        logger.info("Cargo: {}", description);
        logger.info("Weight: {} tons", weight);
        logger.info("Destination: {}", destination.getStationName());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }
    
}
