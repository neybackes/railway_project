package railway.system;

import railway.station.Station;
import railway.train.Train;

import java.util.ArrayList;
import java.util.List;

public class RailwaySystem {

    private String name;
    private List<Station> stations;
    private List<Train> trains;

    public RailwaySystem(String name) {
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

    public String getSystemName() {
        return name;
    }

    public void setSystemName(String name){
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
            return;
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