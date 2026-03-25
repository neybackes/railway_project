package com.solvd.railway;


import com.solvd.railway.cargo.model.GeneralCargo;
import com.solvd.railway.exception.InvalidRailwayNameException;
import com.solvd.railway.exception.WagonFullException;
import com.solvd.railway.passenger.document.model.Ticket;
import com.solvd.railway.passenger.person.model.Passenger;
import com.solvd.railway.station.model.Route;
import com.solvd.railway.station.model.Station;
import com.solvd.railway.system.model.RailwayManager;
import com.solvd.railway.train.model.Locomotive;
import com.solvd.railway.train.model.Train;
import com.solvd.railway.train.model.wagon.model.CargoWagon;
import com.solvd.railway.train.model.wagon.model.PassengerWagon;
import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws WagonFullException, InvalidRailwayNameException {

        logger.info("========== INSTANTIATING OBJECTS ==========");

        RailwayManager railway;
        RailwayManager railway2;

        try {
            railway = new RailwayManager("");
            railway2 = new RailwayManager("");
        } catch (InvalidRailwayNameException ex) {
            logger.warn("Show problem: {}", ex.getMessage());
            railway = new RailwayManager("Brazil Railways"); // retry
            railway2 = new RailwayManager("Brazil Railway");
        }

        Station station1 = new Station("Central Station ", "Curitiba");
        Station station2 = new Station("North Station ", "Londrina");
        Station station3 = new Station("South Station ", "Maringa");
        Route route1 = new Route(station1, station2, 380);
        Route route2 = new Route(station2, station3, 300);
        Locomotive locomotive1 = new Locomotive("Passenger P01", 120);
        Locomotive locomotive2 = new Locomotive("Cargo C01", 80);
        Train train1 = new Train(1, "Express", locomotive1, station1, route1);
        Train train2 = new Train(2, "Regional", locomotive2, station2, route2);
        PassengerWagon passengerWagon = new PassengerWagon(1, 0);
        CargoWagon cargoWagon = new CargoWagon(2, 0);
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

        try {
            passengerWagon.boardPassenger(passenger1);
            cargoWagon.loadCargo(cargo1);

        } catch (WagonFullException ex) {
            logger.warn("Show Error: {}", ex.getMessage());
        }


//        logger.info("====================\n");
//
//        logger.info("========== HASHCODE TEST ==========");
//        logger.info("Railway hashCode: {}", railway.hashCode());
//        logger.info("Train hashCode: {}", train1.hashCode());
//        logger.info("Cargo hashCode: {}", cargo1.hashCode());
//
//        logger.info("\n========== OBJECT INFORMATION ==========");
//        logger.info("Railway object:");
//        logger.info(railway.toString());
//
//        logger.info("\n========== EQUALS TEST ==========");
//        logger.info("Comparing Ticket objects (ticket1 vs ticket2):");
//        logger.info("Result: {}", ticket1.equals(ticket2));
//
//        logger.info("\nComparing Railway objects (railway vs railway2):");
//        logger.info("Result: {}", railway.equals(railway2));

//        logger.info("\n========== HASHSET VALIDATION (NO DUPLICATES) ==========");
//
//        Set<Ticket> tickets = new HashSet<>();
//
//        Ticket t1 = new Ticket("T001", passenger1, station1, station2, 120.0);
//        Ticket t2 = new Ticket("T001", passenger2, station1, station2, 130.0);
//
//        tickets.add(t1);
//        logger.info("Ticket added: {}", t1.getTicketId());
//
//        if (tickets.add(t2)) {
//            logger.info("Ticket added: {}", t2.getTicketId());
//        } else {
//            logger.warn("Duplicate ticket detected: {}", t2.getTicketId());
//        }
//
//        logger.info("Total unique tickets: {}", tickets.size());
//        logger.info("[TEST] Ticket uniqueness validation finished");

    }
}