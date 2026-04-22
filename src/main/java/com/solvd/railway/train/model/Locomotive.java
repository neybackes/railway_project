package com.solvd.railway.train.model;



import com.solvd.railway.generics.Printer;

public record Locomotive(String name, int maxSpeed) {

    private static final Printer<String> logsPrinter = new Printer<>();

    static {
    logsPrinter.info("Train Locomotive Initiated");
}

    public Locomotive {
        logsPrinter.info("New Locomotive instance");
    }

    public void showInfo() {
        logsPrinter.info("Locomotive: " + name);
        logsPrinter.info("Max speed: " + maxSpeed + " km/h");
    }
}



