package com.solvd.railway.train.model.wagon.model;

public interface WagonContract {

    int getWagonId();

    void setWagonId(int wagonId);

    double getCapacity();

    void setCapacity(double capacity);

    int getSeats();

    void showInfo();
    
    @Override
    String toString();
}