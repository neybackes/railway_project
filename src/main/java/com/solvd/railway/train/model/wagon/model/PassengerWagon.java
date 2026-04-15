package com.solvd.railway.train.model.wagon.model;

import com.solvd.railway.enums.WagonType;
import com.solvd.railway.exception.WagonFullException;
import com.solvd.railway.generics.GenericList;
import com.solvd.railway.generics.Printer;
import com.solvd.railway.passenger.person.model.Passenger;

public final class PassengerWagon extends Wagon {

    private static final Printer<String> logsPrinter = new Printer<>();
    private final GenericList<Passenger> passengers;


    {
        logsPrinter.info("New PassengerWagon instance");
    }

    public PassengerWagon(int wagonId, int capacity) {
        super(wagonId, capacity);
        this.passengers = new GenericList<>();
    }

    @Override
    public String toString() {
        return "PassengerWagon{" + ", wagonId='" + wagonId + '\'' + ", capacity='" + getSeats() + '\'' + ", cargoList='" + passengers + '\'' + '}';
    }

    @Override
    public void showInfo() {
        logsPrinter.info("Passenger Wagon ID: " + wagonId);
        logsPrinter.info("Capacity: " + capacity);
        logsPrinter.info("Passengers onboard: " + passengers.size());
    }
    @Override
    public WagonType getType() {
        return WagonType.PASSENGER;
    }

    public void boardPassenger(Passenger passenger) throws WagonFullException {
        if (passengers.size() >= capacity) {
            throw new WagonFullException("Passenger Wagon is full");
        }

        passengers.add(passenger);
        logsPrinter.info(passenger.getName() + " boarded wagon " + wagonId);
    }

    public void removePassenger(Passenger passenger) {
        if (passengers.remove(passenger)) {
            logsPrinter.info(passenger.getName() + " left wagon " + wagonId);
        } else {
            logsPrinter.warn(passenger.getName() + " is not in wagon " + wagonId);
        }
    }

    public void showPassengers() {
        if (passengers.isEmpty()) {
            logsPrinter.warn("No passengers in wagon " + wagonId);
            return;
        }

        for (Passenger passenger : passengers.getAll()) {
            logsPrinter.info("- " + passenger.getName());
        }
    }
}
