package com.solvd.railway.train.model.wagon.model;

import com.solvd.railway.cargo.model.GeneralCargo;
import com.solvd.railway.exception.WagonFullException;
import com.solvd.railway.generics.Printer;

import java.util.ArrayList;
import java.util.List;

public final class CargoWagon extends Wagon {

    private static final Printer<String> logsPrinter = new Printer<>();
    private final List<GeneralCargo> cargoList;
    private double currentLoad;

    {
        logsPrinter.info("New CargoWagon instance");
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
        logsPrinter.info("Cargo Wagon ID: " + wagonId);
        logsPrinter.info("Capacity: " + capacity + " tons");
        logsPrinter.info("Current Load: " + currentLoad + " tons");
        logsPrinter.info("Cargo items: " + cargoList.size());
    }

    public void loadCargo(GeneralCargo cargo) throws WagonFullException {
        if (currentLoad + cargo.getWeight() > capacity) {
            throw new WagonFullException("Cargo Wagon is full");
        }

        cargoList.add(cargo);
        currentLoad += cargo.getWeight();

        logsPrinter.info("Cargo loaded into wagon " + wagonId);
    }

    public void unloadCargo(GeneralCargo cargo) {
        if (cargoList.remove(cargo)) {
            currentLoad -= cargo.getWeight();
            logsPrinter.info("Cargo unloaded from wagon " + wagonId);
        } else {
            logsPrinter.warn("Cargo not found in wagon " + wagonId);
        }
    }

    public void showCargo() {
        if (cargoList.isEmpty()) {
            logsPrinter.warn("No cargo in wagon " + wagonId);
            return;
        }

        for (GeneralCargo cargo : cargoList) {
            logsPrinter.info("- " + cargo.getDescription() + " (" + cargo.getWeight() + " tons)");
        }
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(double currentLoad) {
        this.currentLoad = currentLoad;
    }
}
