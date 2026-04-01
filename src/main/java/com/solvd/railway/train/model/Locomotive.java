package com.solvd.railway.train.model;

import com.solvd.railway.generics.Printer;

public final class Locomotive {

    private static final Printer<String> logsPrinter = new Printer<>();
    private String name;
    private int maxSpeed;

    static {
        logsPrinter.info("Train Locomotive Initiated");
    }

    {
        logsPrinter.info("New Locomotive instance");
    }

    public Locomotive(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Locomotive{" + "name='" + name + '\'' + ", capacity='" + maxSpeed + '\'' + '}';
    }

    public void showInfo() {
        logsPrinter.info("Locomotive: " + name);
        logsPrinter.info("Max speed: " + maxSpeed + " km/h");
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
