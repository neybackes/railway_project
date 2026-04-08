package com.solvd.railway.train.model.wagon.model;

import com.solvd.railway.enums.WagonType;
import com.solvd.railway.generics.Printer;

public abstract class Wagon implements WagonContract {

    private static final Printer<String> logsPrinter = new Printer<>();
    protected int wagonId;
    protected double capacity;

    static {
        logsPrinter.info("Wagon Class Initiated");
    }

    public Wagon(int wagonId, double capacity) {
        this.wagonId = wagonId;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Wagon{" + "wagonId=" + wagonId + ", capacity=" + capacity + '}';
    }

    public abstract WagonType getType();

    public abstract void showInfo();

    public int getWagonId() {
        return wagonId;
    }

    public void setWagonId(int wagonId) {
        this.wagonId = wagonId;
    }

    public double getCapacity() {
        return capacity;
    }

    public int getSeats() {
        return (int) capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
