package railway.train.wagon;

import java.util.ArrayList;
import java.util.List;

import railway.passenger.person.Passenger;

public final class PassengerWagon extends Wagon {

    private final List<Passenger> passengers;

    {
        System.out.println("New PassengerWagon instance");
    }

    public PassengerWagon(int wagonId, int capacity) {
        super(wagonId, capacity);
        this.passengers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "PassengerWagon{" +
                ", wagonId='" + wagonId + '\'' +
                ", capacity='" + getSeats() + '\'' +
                ", cargoList='" + passengers + '\'' +
                '}';
    }

    @Override
    public void showInfo() {
        System.out.println("Passenger Wagon ID: " + wagonId);
        System.out.println("Capacity: " + capacity);
        System.out.println("Passengers onboard: " + passengers.size());
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

}