package railway.cargo;

import railway.station.Station;

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

}
