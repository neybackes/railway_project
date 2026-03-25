package com.solvd.railway.cargo.model;

import com.solvd.railway.station.model.Station;

public final class GeneralCargo extends Cargo {

    private String description;
    private double weight;
    private Station destination;

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
        System.out.println("Cargo: " + description);
        System.out.println("Weight: " + weight + " tons");
        System.out.println("Destination: " + destination.getStationName());
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

    public static interface CargoContract {

        static boolean isValidWeight(double weight) {
            return weight > 0;
        }

        String getDescription();

        void setDescription(String description);

        double getWeight();

        void setWeight(double weight);

        Station getDestination();

        void setDestination(Station destination);

        void showInfo();

        @Override
        String toString();
    }
}
