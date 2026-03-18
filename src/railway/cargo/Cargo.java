package railway.cargo;

import railway.station.Station;

public class Cargo {

    private String description;
    private double weight;
    private Station destination;

    public Cargo(String description, double weight, Station destination) {
        this.description = description;
        this.weight = weight;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "description='" + description + '\'' +
                ", weight='" + weight + '\'' +
                ", destination='" + destination+ '\'' +
                '}';
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

    public void setWeight(double weight){
        this.weight = weight;
    }

    public Station getDestination() {
        return destination;
    }


    public void showInfo() {
        System.out.println("Cargo: " + description);
        System.out.println("Weight: " + weight + " tons");
        System.out.println("Destination: " + destination.getStationName());
    }
}