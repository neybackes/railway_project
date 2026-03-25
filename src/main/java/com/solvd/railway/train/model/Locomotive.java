package com.solvd.railway.train.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Locomotive {

    private static final Logger logger = LogManager.getLogger(Locomotive.class);
    private String name;
    private int maxSpeed;

    static {
        logger.info("Train Locomotive Initiated");
    }

    {
        logger.info("New Locomotive instance");
    }


    public Locomotive(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "name='" + name + '\'' +
                ", capacity='" + maxSpeed + '\'' +
                '}';
    }

    public void showInfo() {
        logger.info("Locomotive: {}", name);
        logger.info("Max speed: " + maxSpeed + " km/h");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

}