package railway.train;

import railway.station.Route;
import railway.station.Station;
import railway.train.wagon.Wagon;

import java.util.ArrayList;
import java.util.List;

public class Train {

    private int trainId;
    private String name;
    private Locomotive locomotive;
    private Station currentStation;
    private Route route;
    private List<Wagon> wagons;

    public Train(int trainId, String name, Locomotive locomotive, Station currentStation, Route route) {
        this.trainId = trainId;
        this.name = name;
        this.locomotive = locomotive;
        this.currentStation = currentStation;
        this.route = route;
        this.wagons = new ArrayList<>();

    }


    @Override
    public String toString() {
        return "Train{" +
                "trainId='" + trainId + '\'' +
                ", name='" + name + '\'' +
                ", locomotive='" + locomotive + '\'' +
                ", currentStation='" + currentStation + '\'' +
                ", route='" + route + '\'' +
                ", wagons='" + wagons + '\'' +
                '}';
    }

    public void showInfo() {
        System.out.println("Train ID: " + trainId);
        System.out.println("Train Name: " + name);
        System.out.println("Locomotive: " + locomotive.getName());
        System.out.println("Current Station: " + currentStation.getStationName());
        System.out.println("Number of wagons: " + wagons.size());
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {

        this.trainId = trainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public Station getCurrentStation() {
        return currentStation;
    }

    public Route getRoute() {
        return route;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void addWagon(Wagon wagon) {
        wagons.add(wagon);
        System.out.println("Wagon " + wagon.getWagonId() + " added to train " + name + ".");
    }

    public void moveTo(Station newStation) {

        if (!route.isStationOnRoute(newStation)) {
            System.out.println("Station " + newStation.getStationName() + " is not on this route.");
            return;
        }

        if (currentStation.equals(newStation)) {
            System.out.println("Train " + name + " is already at " + newStation.getStationName());
            return;
        }

        System.out.println("Train " + name + " leaving " + currentStation.getStationName());
        currentStation = newStation;
        System.out.println("Train " + name + " arrived at " + currentStation.getStationName());
    }

    public void showCurrentStation() {
        System.out.println("Train " + name + " is currently at " + currentStation.getStationName());
    }

    public void showWagons() {
        if (wagons.isEmpty()) {
            System.out.println("No wagons attached to train " + name + ".");
            return;
        }

        for (Wagon wagon : wagons) {
            wagon.showInfo();
        }
    }
}