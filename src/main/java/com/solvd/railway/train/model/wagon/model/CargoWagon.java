package com.solvd.railway.train.model.wagon.model;

import com.solvd.railway.cargo.model.GeneralCargo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CargoWagon extends Wagon {

    private static final Logger logger = LogManager.getLogger(CargoWagon.class);
    private final List<GeneralCargo> cargoList;
    private double currentLoad;

    {
        logger.info("New CargoWagon instance");
    }

    public CargoWagon(int wagonId, double capacity) {
        super(wagonId, capacity);
        this.cargoList = new ArrayList<>();
        this.currentLoad = 0;
    }

    @Override
    public String toString() {
        return "CargoWagon{" + super.toString() + ", cargoList='" + cargoList + '\'' + '}';
    }

    @Override
    public void showInfo() {
        logger.info("Cargo Wagon ID: {}", wagonId);
        logger.info("Capacity: {} tons", capacity);
        logger.info("Current Load: {} tons", currentLoad);
        logger.info("Cargo items: {}", cargoList.size());
    }

    public void loadCargo(GeneralCargo cargo) {

        if (currentLoad + cargo.getWeight() > capacity) {
            logger.warn("Cannot load cargo. Wagon {} exceeds capacity.", wagonId);
            return;
        }

        cargoList.add(cargo);
        currentLoad += cargo.getWeight();

        logger.info("Cargo loaded into wagon {}", wagonId);
    }

    public void unloadCargo(GeneralCargo cargo) {

        if (cargoList.remove(cargo)) {
            currentLoad -= cargo.getWeight();
            logger.info("Cargo unloaded from wagon {}", wagonId);
        } else {
            logger.warn("Cargo not found in wagon {}", wagonId);
        }
    }

    public void showCargo() {

        if (cargoList.isEmpty()) {
            logger.warn("No cargo in wagon {}", wagonId);
            return;
        }

        for (GeneralCargo cargo : cargoList) {
            logger.info("- {} ({} tons)", cargo.getDescription(), cargo.getWeight());
        }
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(double currentLoad) {
        this.currentLoad = currentLoad;
    }

}