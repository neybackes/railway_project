package railway.system;

import java.util.ArrayList;
import java.util.List;
import railway.station.Station;
import railway.train.Train;

public final class RailwayManager extends RailwaySystem {

    private String name;
    private List<Station> stations;
    private List<Train> trains;

    public RailwayManager(String name) {
        this.name = name;
        this.stations = new ArrayList<>();
        this.trains = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "RailwaySystem{" +
                "name='" + name + '\'' +
                ", stations=" + stations +
                ", trains=" + trains +
                '}';
    }

    @Override
    public boolean equals(Object compare) {
        //explicit casting -- needs more research
        RailwayManager compareCast = (RailwayManager) compare;
        if (this.name.equals(compareCast.name)) {
            System.out.println("Atribute " + name + " is equals.");
            return true;
        } else {
            System.out.println("Attribute " + name + " is not equal.");
            return false;
        }
    }

    public int hashCode() {
        return name.hashCode();
    }

    public String getSystemName() {
        return name;
    }

    public void setSystemName(String name) {
        this.name = name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void addStation(Station station) {
        stations.add(station);
        System.out.println("Station " + station.getStationName() + " added to railway system.");
    }

    public void addTrain(Train train) {
        trains.add(train);
        System.out.println("Train " + train.getName() + " added to railway system.");
    }

    public void showStations() {
        if (stations.isEmpty()) {
            System.out.println("No stations registered.");
        }

        System.out.println("Stations in " + name + ":");
        for (Station station : stations) {
            System.out.println("- " + station.getStationName() + " (" + station.getStationCity() + ")");
        }
    }

    public void showTrains() {
        if (trains.isEmpty()) {
            System.out.println("No trains registered.");
            return;
        }

        System.out.println("Trains in " + name + ":");
        for (Train train : trains) {
            System.out.println("- " + train.getName() + " (ID: " + train.getTrainId() + ")");
        }
    }
}