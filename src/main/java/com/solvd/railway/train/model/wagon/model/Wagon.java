package com.solvd.railway.train.model.wagon.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Wagon implements WagonContract {

    private static final Logger logger = LogManager.getLogger(Wagon.class);
    protected int wagonId;
    protected double capacity;

    static {
        logger.info("Wagon Class Initiated");
    }

    public Wagon(int wagonId, double capacity) {
        this.wagonId = wagonId;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Wagon{" + "wagonId=" + wagonId + ", capacity=" + capacity + '}';
    }

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

    //overloading
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

}