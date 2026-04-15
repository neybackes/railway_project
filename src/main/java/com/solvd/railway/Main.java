package com.solvd.railway;

import com.solvd.railway.cargo.model.GeneralCargo;
import com.solvd.railway.exception.InvalidBoardingException;
import com.solvd.railway.exception.InvalidRailwayNameException;
import com.solvd.railway.exception.WagonFullException;
import com.solvd.railway.functional.Show;
import com.solvd.railway.functional.Validate;
import com.solvd.railway.generics.Holder;
import com.solvd.railway.generics.Printer;
import com.solvd.railway.passenger.document.model.Ticket;
import com.solvd.railway.passenger.person.model.Passenger;
import com.solvd.railway.station.model.Route;
import com.solvd.railway.station.model.Station;
import com.solvd.railway.system.model.RailwayManager;
import com.solvd.railway.train.model.Locomotive;
import com.solvd.railway.train.model.Train;
import com.solvd.railway.train.model.wagon.model.CargoWagon;
import com.solvd.railway.train.model.wagon.model.PassengerWagon;
import com.solvd.railway.utils.KeywordCounter;

import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws WagonFullException, InvalidRailwayNameException {

        Printer<String> logsPrinter = new Printer<>();

        logsPrinter.title("\n========== PRINTER GENERICS ==========" );

        logsPrinter.title("========== INSTANTIATING OBJECTS ==========" );

        RailwayManager railway, railway2;
        PassengerWagon passengerWagon;
        CargoWagon cargoWagon;
        Station station1, station2, station3;
        Route route1, route2;
        Locomotive locomotive1, locomotive2;
        Train train1, train2;
        Ticket ticket1, ticket2;

        logsPrinter.title("========== InvalidRailwayNameException ==========" );
        try {
            railway = new RailwayManager("" );
            railway2 = new RailwayManager("" );
        } catch (InvalidRailwayNameException ex) {
            logsPrinter.error("Invalid Name: " + ex.getMessage());
            railway = new RailwayManager("Brazil Railways" );
            railway2 = new RailwayManager("Brazil Railway" );
        }

        station1 = new Station("Central Station ", "Curitiba" );
        station2 = new Station("North Station ", "Londrina" );
        station3 = new Station("South Station ", "Maringa" );
        route1 = new Route(station1, station2, 380);
        route2 = new Route(station2, station3, 300);
        locomotive1 = new Locomotive("Passenger P01", 120);
        locomotive2 = new Locomotive("Cargo C01", 80);
        train1 = new Train(1, "Express", locomotive1, station1, route1);
        train2 = new Train(2, "Regional", locomotive2, station2, route2);
        passengerWagon = new PassengerWagon(1, 0);
        cargoWagon = new CargoWagon(2, 0);
        train1.addWagon(passengerWagon);
        train2.addWagon(cargoWagon);

        Passenger passenger1 = new Passenger("Ana", station2);
        Passenger passenger2 = new Passenger("Pedro", station2);
        ticket1 = new Ticket("T001", passenger1, station1, station2, 120.0);
        ticket2 = new Ticket("T002", passenger2, station1, station2, 130.0);
        GeneralCargo cargo1 = new GeneralCargo("Steel", 10, station2);

        railway.addStation(station1);
        railway.addStation(station2);
        railway.addStation(station3);
        railway.addTrain(train1);
        railway.addTrain(train2);

        logsPrinter.title("========== WagonFullException ==========" );
        try {
            passengerWagon.boardPassenger(passenger1);
            cargoWagon.loadCargo(cargo1);
        } catch (WagonFullException ex) {
            logsPrinter.error("Wagon is full: " + ex.getMessage());
            passengerWagon = new PassengerWagon(1, 20);
            cargoWagon = new CargoWagon(2, 100);
            passengerWagon.boardPassenger(passenger1);
            passengerWagon.boardPassenger(passenger2);
        }

        logsPrinter.title("========== InvalidBoardingException ==========" );
        try {
            ticket1.markUsed();
            ticket1.validateBoarding(train1);
        } catch (InvalidBoardingException ex) {
            logsPrinter.error("Boarding denied: " + ex.getMessage());
        }

        logsPrinter.title("====================" );

        logsPrinter.title("========== HASHCODE TEST ==========" );
        logsPrinter.info("Railway hashCode: " + railway.hashCode());
        logsPrinter.info("Train hashCode: " + train1.hashCode());
        logsPrinter.info("Cargo hashCode: " + cargo1.hashCode());

        logsPrinter.title("\n========== OBJECT INFORMATION ==========" );
        logsPrinter.info("Railway object:" );
        logsPrinter.info(railway.toString());

        logsPrinter.title("\n========== EQUALS TEST ==========" );
        logsPrinter.info("Comparing Ticket objects (ticket1 vs ticket2):" );
        logsPrinter.info("Result: " + ticket1.equals(ticket2));

        logsPrinter.info("Comparing Railway objects (railway vs railway2):" );
        logsPrinter.info("Result: " + railway.equals(railway2));

        logsPrinter.title("\n========== COLLECTION TESTS ==========" );

        RailwayManager managerMap, managerList;
        Train train3, train4, train5, resultant;
        Passenger nextPassenger, boardedPassenger;
        Ticket t1, t2;
        Station lastStation, removedStation;

        logsPrinter.title("\n========== SET (NO DUPLICATES) ==========" );

        t1 = new Ticket("T001", passenger1, station1, station2, 120.0);
        t2 = new Ticket("T001", passenger2, station1, station2, 130.0);

        t1.addTicket(t1);
        logsPrinter.info("Ticket added: " + t1.getTicketId());

        if (t1.addTicket(t2)) {
            logsPrinter.info("Ticket added: " + t2.getTicketId());
        } else {
            logsPrinter.warn("Duplicate ticket detected: " + t2.getTicketId());
        }

        logsPrinter.info("Total unique tickets: " + t1.getTickets().size());

        logsPrinter.title("\n========== MAP ==========" );

        managerMap = new RailwayManager("Central" );
        train3 = new Train(3, "Express", locomotive1, station1, route1);

        managerMap.addTrain(train3);

        resultant = managerMap.getTrainByName("Express" );
        if (resultant != null) {
            logsPrinter.info("Train found: " + resultant.getName());
        } else {
            logsPrinter.warn("Train not found." );
        }

        logsPrinter.title("\n========== LIST ==========" );

        managerList = new RailwayManager("Central" );
        train4 = new Train(1, "Express", locomotive1, station1, route1);
        train5 = new Train(2, "Regional", locomotive2, station2, route2);

        managerList.addTrain(train4);
        managerList.addTrain(train5);

        if (managerList.getTrains().isEmpty()) {
            logsPrinter.warn("No trains in the list." );
        } else {
            for (Train train : managerList.getTrains()) {
                logsPrinter.info("Train in list: " + train.getName());
            }
        }

        logsPrinter.info("First train in list: " + managerList.getTrains().get(0).getName());

        logsPrinter.title("\n========== QUEUE ==========" );

        station1.addPassengerToQueue(passenger1);
        station1.addPassengerToQueue(passenger2);

        nextPassenger = station1.getNextPassenger();
        if (nextPassenger != null) {
            logsPrinter.info("Next passenger in queue: " + nextPassenger.getName());
        } else {
            logsPrinter.warn("No passengers in queue." );
        }

        boardedPassenger = station1.boardNextPassenger();
        if (boardedPassenger != null) {
            logsPrinter.info("Passenger boarded: " + boardedPassenger.getName());
        } else {
            logsPrinter.warn("No passenger available for boarding." );
        }

        logsPrinter.title("\n========== DEQUE ==========" );

        train4.addRecentStation(station1);
        train4.addRecentStation(station2);
        train4.addRecentStation(station3);

        lastStation = train4.getLastVisitedStation();
        if (lastStation != null) {
            logsPrinter.info("Last visited station: " + lastStation.getStationName());
        } else {
            logsPrinter.warn("No recent stations recorded." );
        }

        removedStation = train4.removeLastVisitedStation();
        if (removedStation != null) {
            logsPrinter.info("Removed from history: " + removedStation.getStationName());
        } else {
            logsPrinter.warn("No station to remove from history." );
        }

        logsPrinter.title("\n========== STATIONS ==========" );
        railway.showStations();
        logsPrinter.title("\n========== RAILWAY ==========" );
        railway.showStations();
        logsPrinter.title("\n========== TRAINS ==========" );
//        train2.addWagon(passengerWagon);
        train1.showWagons();
        logsPrinter.title("\n========== PASSENGER WAGON ==========" );
        passengerWagon.boardPassenger(passenger1);
        passengerWagon.showPassengers();
        passengerWagon.removePassenger(passenger1);

        logsPrinter.title("\n========== CARGO WAGON ==========" );

        cargoWagon.loadCargo(cargo1);
        cargoWagon.showCargo();
        cargoWagon.setWagonId(2);
        cargoWagon.unloadCargo(cargo1);
        cargoWagon.setCurrentLoad(100);
        logsPrinter.info(cargoWagon.getCurrentLoad());

        logsPrinter.title("\n========== GENERICS TEMPORARY ITEMS==========" );
        Holder<Train> trainHolder = new Holder<>(train1);
        var tempTrain = trainHolder.getItem();
        logsPrinter.info("Temporary train: " + tempTrain.getName());

        Holder<Ticket> ticketHolder = new Holder<>(ticket1);
        var tempTicket = ticketHolder.getItem();
        logsPrinter.info("Temporary ticket: " + tempTicket.getTicketId());
        tempTicket.setTicketId("3" );
        logsPrinter.warn("Temporary ticket changed to: " + tempTicket.getTicketId());
        logsPrinter.info("Original ticket object now has ID: " + ticket1.getTicketId());
        tempTicket.markUsed();
        logsPrinter.warn("Temporary change of status: " + ticket1.getTicketStatus());


        logsPrinter.title("\n========== ENUM ==========" );

        logsPrinter.title("\n========== TrainStatus ==========" );

        train1.moveTo(station2);

        logsPrinter.title("\n========== LogLevel ==========" );

        logsPrinter.info("INFORMATION EXAMPLE " + train1.getName());
        logsPrinter.warn("WARNING EXAMPLE " + trainHolder.getItem());
        logsPrinter.error("ERROR EXAMPLE " + train1.getName());

        logsPrinter.title("\n========== WagonType ==========" );

        logsPrinter.info("CargoWagon Type: " + cargoWagon.getType());
        logsPrinter.info("PassengerWagon Type:  " + passengerWagon.getType());

        logsPrinter.title("\n========== StringUtils and FileUtils ==========" );

        File inputFile = new File("src/main/resources/article.txt");
        File outputFile = new File("src/main/resources/result.txt");

        KeywordCounter keywordCounter = new KeywordCounter();

        try {
            keywordCounter.countKeywords(inputFile, outputFile);
            logsPrinter.info("Finished counting keywords.");
        } catch (IOException e) {
            logsPrinter.error("Error: " + e.getMessage());
        }

        logsPrinter.title("\n========== Lambda Show ==========");

        Show<Train> showTrainName = train -> logsPrinter.info("Train " + train.getName());
        Show<Station> showStationName = station -> logsPrinter.info("Station " + station.getStationName());

        showTrainName.execute(train1);
        showStationName.execute(station3);

        logsPrinter.title("\n========== Lambda Validate ==========");

        Validate<Train> hasWagons = train -> !train.getWagons().isEmpty();
        logsPrinter.info("Train has wagons: " + hasWagons.test(train1));

        Validate<Ticket> isTicketAvailable = ticket -> !ticket.getTicketStatus();
        logsPrinter.info("Ticket is used: " + isTicketAvailable.test(ticket2));



    }
}
