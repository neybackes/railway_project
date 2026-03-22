package railway;

import java.util.HashSet;
import java.util.Set;
import railway.cargo.GeneralCargo;
import railway.passenger.document.Ticket;
import railway.passenger.person.Passenger;
import railway.station.Route;
import railway.station.Station;
import railway.system.RailwayManager;
import railway.train.Locomotive;
import railway.train.Train;
import railway.train.wagon.CargoWagon;
import railway.train.wagon.PassengerWagon;

public class Main {

    public static void main(String[] args) {

        System.out.println("========== INSTANTIATING OBJECTS ==========");
        RailwayManager railway = new RailwayManager("Brazil Railways");
        RailwayManager railway2 = new RailwayManager("Brazil Railway");
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
        GeneralCargo cargo1 = new GeneralCargo("Steel", 10, station2);

        railway.addStation(station1);
        railway.addStation(station2);
        railway.addStation(station3);
        railway.addTrain(train1);
        railway.addTrain(train2);
        passengerWagon.boardPassenger(passenger1);
        cargoWagon.loadCargo(cargo1);

        System.out.println("====================\n");

        System.out.println("========== HASHCODE TEST ==========");
        System.out.println("Railway hashCode: " + railway.hashCode());
        System.out.println("Train hashCode: " + train1.hashCode());
        System.out.println("Cargo hashCode: " + cargo1.hashCode());

        System.out.println("\n========== OBJECT INFORMATION ==========");
        System.out.println("Railway object:");
        System.out.println(railway.toString());

        System.out.println("\n========== EQUALS TEST ==========");
        System.out.println("Comparing Ticket objects (ticket1 vs ticket2):");
        System.out.println("Result: " + ticket1.equals(ticket2));

        System.out.println("\nComparing Railway objects (railway vs railway2):");
        System.out.println("Result: " + railway.equals(railway2));

        System.out.println("\n========== HASHSET VALIDATION (NO DUPLICATES) ==========");

        Set<Ticket> tickets = new HashSet<>();

        Ticket t1 = new Ticket("T001", passenger1, station1, station2, 120.0);
        Ticket t2 = new Ticket("T001", passenger2, station1, station2, 130.0);

        if (tickets.add(t1)) {
            System.out.println("Ticket added: " + t1.getTicketId());
        } else {
            System.out.println("Duplicate ticket detected: " + t1.getTicketId());
        }

        if (tickets.add(t2)) {
            System.out.println("Ticket added: " + t2.getTicketId());
        } else {
            System.out.println("Duplicate ticket detected: " + t2.getTicketId());
        }

        System.out.println("Total unique tickets: " + tickets.size());

    }
}