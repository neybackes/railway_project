package railway;

import railway.system.RailwaySystem;
import railway.station.Station;
import railway.station.Route;
import railway.train.Train;
import railway.train.Locomotive;
import railway.train.PassengerWagon;
import railway.train.CargoWagon;
import railway.passenger.Passenger;
import railway.passenger.Ticket;
import railway.cargo.Cargo;

public class Main {

    public static void main(String[] args) {


        RailwaySystem railway = new RailwaySystem("Brazil Railway");
        Station station1 = new Station("Central Station ", "Curitiba");
        Station station2 = new Station("North Station ", "Londrina");
        Station station3 = new Station("South Station ", "Maringa");
        Route route1 = new Route(station1, station2, 380);
        Route route2 = new Route(station2, station3, 300);
        Locomotive locomotive1 = new Locomotive("Passenger P01", 120);
        Locomotive locomotive2 = new Locomotive("Cargo C01", 80);
        Train train1 = new Train(1, "Express", locomotive1, station1, route1);
        Train train2 = new Train(2, "Regional", locomotive2, station2, route2);
        PassengerWagon passengerWagon = new PassengerWagon(1, 50);
        CargoWagon cargoWagon = new CargoWagon(2, 20);
        train1.addWagon(passengerWagon);
        train2.addWagon(cargoWagon);
        Passenger passenger1 = new Passenger("Ana", station2);
        Passenger passenger2 = new Passenger("Pedro", station2);
        Ticket ticket1 = new Ticket("T001", passenger1, station1, station2, 120.0);
        Ticket ticket2 = new Ticket("T002", passenger2, station1, station2, 130);
        Cargo cargo1 = new Cargo("Steel", 10, station2);

        railway.addStation(station1);
        railway.addStation(station2);
        railway.addStation(station3);
        railway.addTrain(train1);
        railway.addTrain(train2);
        passengerWagon.boardPassenger(passenger1);
        cargoWagon.loadCargo(cargo1);

        System.out.println(railway.toString());


//        System.out.println("Iniciating the system ..");
//        RailwaySystem railway = new RailwaySystem("Brazil Railway");
//        System.out.println("Welcome to the " + railway.getSystemName());
//        railway.setSystemName("new Brazil Railway");
//        System.out.println();
//        System.out.println("Changing the name ....");
//        System.out.println("Welcome to the...ops. The new.. " + railway.getSystemName());
//        System.out.println();
//
//        System.out.println("Creating new stations ...");
//        Station station1 = new Station("Central Station ", "Curitiba");
//        System.out.println("Station: " + station1.getStationName() + station1.getStationCity());
//        station1.setStationName("Regional Station");
//        station1.setStationCity("Cascavel ");
//        System.out.println("Set a new information...");
//        System.out.println("Station  - New information: " + station1.getStationName() + station1.getStationCity());
//        System.out.println();
//        station1.showInfo();
//        System.out.println();
//        Station station2 = new Station("North Station ", "Londrina");
//        station2.showInfo();
//        System.out.println();
//        Station station3 = new Station("South Station ", "Maringa");
//        station3.showInfo();
//        System.out.println();
//
//        System.out.println("Adding stations to the system....\n");
//        railway.addStation(station1);
//        railway.addStation(station2);
//        railway.addStation(station3);
//        System.out.println();
//        railway.showStations();
//        System.out.println();
//
//
//        System.out.println("Creating new routes...\n");
//        Route route1 = new Route(station1, station2, 380);
//        Route route2 = new Route(station2, station3, 300);
//        System.out.println();
//
//        System.out.println("Set a new distance..\n");
//        System.out.println("Origin: " + route1.getOrigin());
//        System.out.println("Destination " + route1.getDestination());
//        System.out.println("Distance " + route1.getDistance());
//        route1.setDistance(400);
//        System.out.println("Rota 1 - New Distance " + route1.getDistance());
//        System.out.println();
//
//        System.out.println("Creating new locomotives...\n");
//        Locomotive locomotive1 = new Locomotive("Passenger P01", 120);
//        Locomotive locomotive2 = new Locomotive("Cargo C01", 80);
//        locomotive1.showInfo();
//        System.out.println();
//        locomotive2.showInfo();
//        System.out.println();
//
//        System.out.println("Creating trains...\n");
//        Train train1 = new Train(1, "Express", locomotive1, station1, route1);
//        Train train2 = new Train(2, "Regional", locomotive2, station2, route2);
//        System.out.println("Adding trains to the system\n");
//        railway.addTrain(train1);
//        railway.addTrain(train2);
//        railway.showTrains();
//        System.out.println();
//
//        System.out.println("Creating wagons...\n");
//        PassengerWagon passengerWagon = new PassengerWagon(1, 50);
//        CargoWagon cargoWagon = new CargoWagon(2, 20);
//        System.out.println("Adding wagons to the trains..\n");
//        train1.addWagon(passengerWagon);
//        train2.addWagon(cargoWagon);
//        System.out.println();
//
//        System.out.println("Creating passengers and Tickets...\n");
//        Passenger passenger1 = new Passenger("Ana", station2);
//        Passenger passenger2 = new Passenger("Pedro", station2);
//        System.out.println(passenger1.toString());

//        Ticket ticket1 = new Ticket("T001", passenger1, station1, station2, 120.0);
//        Ticket ticket2 = new Ticket("T002", passenger2, station1, station2, 130);
//        ticket1.showInfo();
//        System.out.println("Invalidating boarding ticket...\n");
//        System.out.println("Ticket actual status " + ticket1.getTicketStatus());
//        ticket1.setTicketStatus(true);
//        System.out.println("Tickest change status " + ticket1.getTicketStatus());
//        System.out.println();
//        System.out.println("Validating boarding ticket...\n");
//        if (ticket1.validateBoarding(train1)) {
//            passengerWagon.boardPassenger(passenger1);
//            ticket1.markUsed();
//
//        } else if (ticket2.validateBoarding(train1)){
//            passengerWagon.boardPassenger(passenger2);
//            ticket2.markUsed();
//        }
//        System.out.println();
//
//        System.out.println("Creating cargo....\n");
//        Cargo cargo1 = new Cargo("Steel", 10, station3);
//        cargoWagon.loadCargo(cargo1);
//        System.out.println();
//
//        System.out.println("Showing System Information...\n");
//        railway.showStations();
//        System.out.println();
//        railway.showTrains();
//        System.out.println();
//
//        System.out.println("Moving the trains...\n");
//        train1.moveTo(station2);
//        System.out.println();
//        train2.moveTo(station3);
//        System.out.println();
//
//        System.out.println("Showing train information updated...\n");
//        train1.showCurrentStation();
//        train2.showCurrentStation();
//        System.out.println();
//
//        System.out.println("Showing wagons information...\n");
//        train1.showWagons();
//        System.out.println();
//        train2.showWagons();
    }
}