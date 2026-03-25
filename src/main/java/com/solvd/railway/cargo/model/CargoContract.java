package com.solvd.railway.cargo.model;

import com.solvd.railway.station.model.Station;

public interface CargoContract {

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