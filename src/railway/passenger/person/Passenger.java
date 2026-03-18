package railway.passenger.person;

import railway.station.Station;

public final class Passenger extends Person {

    private String name;
    private Station destination;

    public Passenger(String name, Station destination) {
        this.name = name;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", destination='" + destination+ '\'' +
                '}';
    }
    @Override
    public void showInfo() {
        System.out.println("Passenger: " + name);
        System.out.println("Destination: " + destination.getStationName());
    }
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Station getDestination() {
        return destination;
    }
}