package railway.train;

import railway.passenger.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerWagon extends Wagon {

    private List<Passenger> passengers;

    public PassengerWagon(int wagonId, int capacity) {
        super(wagonId, capacity);
        this.passengers = new ArrayList<>();
    }

    public void boardPassenger(Passenger passenger) {

        if (passengers.size() >= capacity) {
            System.out.println("Wagon " + wagonId + " is full.");
            return;
        }

        passengers.add(passenger);
        System.out.println(passenger.getName() + " boarded wagon " + wagonId);
    }

    public void removePassenger(Passenger passenger) {

        if (passengers.remove(passenger)) {
            System.out.println(passenger.getName() + " left wagon " + wagonId);
        } else {
            System.out.println(passenger.getName() + " is not in wagon " + wagonId);
        }
    }

    public void showPassengers() {

        if (passengers.isEmpty()) {
            System.out.println("No passengers in wagon " + wagonId);
            return;
        }

        for (Passenger passenger : passengers) {
            System.out.println("- " + passenger.getName());
        }
    }


    public void showInfo() {
        System.out.println("Passenger Wagon ID: " + wagonId);
        System.out.println("Capacity: " + capacity);
        System.out.println("Passengers onboard: " + passengers.size());
    }
}