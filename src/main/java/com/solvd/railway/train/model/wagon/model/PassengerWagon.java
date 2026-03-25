package com.solvd.railway.train.model.wagon.model;

import com.solvd.railway.passenger.person.model.Passenger;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PassengerWagon extends Wagon {

    private static final Logger logger = LogManager.getLogger(PassengerWagon.class);
    private final List<Passenger> passengers;

    {
        logger.info("New PassengerWagon instance");
    }

    public PassengerWagon(int wagonId, int capacity) {
        super(wagonId, capacity);
        this.passengers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "PassengerWagon{" + ", wagonId='" + wagonId + '\'' + ", capacity='" + getSeats() + '\'' + ", cargoList='" + passengers + '\'' + '}';
    }

    @Override
    public void showInfo() {
        logger.info("Passenger Wagon ID: {}", wagonId);
        logger.info("Capacity: {}", capacity);
        logger.info("Passengers onboard: {}", passengers.size());
    }

    public void boardPassenger(Passenger passenger) {

        if (passengers.size() >= capacity) {
            logger.warn("Wagon {} is full.", wagonId);
            return;
        }

        passengers.add(passenger);
        logger.info("{} boarded wagon {}", passenger.getName(), wagonId);
    }

    public void removePassenger(Passenger passenger) {

        if (passengers.remove(passenger)) {
            logger.info("{} left wagon {}", passenger.getName(), wagonId);
        } else {
            logger.warn("{} is not in wagon {}", passenger.getName(), wagonId);
        }
    }

    public void showPassengers() {

        if (passengers.isEmpty()) {
            logger.warn("No passengers in wagon {}", wagonId);
            return;
        }

        for (Passenger passenger : passengers) {
            logger.info("- {}", passenger.getName());
        }
    }

}