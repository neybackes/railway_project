package com.solvd.railway.passenger.document.model;

import com.solvd.railway.passenger.person.model.Passenger;
import com.solvd.railway.station.model.Station;
import com.solvd.railway.train.model.Train;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ticket extends Document {

    private static final Logger logger = LogManager.getLogger(Ticket.class);
    private String ticketId;
    private final Passenger passenger;
    private final Station origin;
    private final Station destination;
    private double price;
    private boolean used;

    {
        logger.info("New Ticket instance");
    }

    public Ticket(String ticketId, Passenger passenger, Station origin, Station destination, double price) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.used = false;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketId='" + ticketId + '\'' + ", passenger='" + passenger + '\'' + ", origin='" + origin + '\'' + ", destination='" + destination + '\'' + ", price='" + price + '\'' + ", used='" + used + '\'' + '}';
    }

    @Override
    public void showInfo() {
        logger.info("Ticket ID: {}", ticketId);
        logger.info("Passenger: {}", passenger.getName());
        logger.info("Origin: {}", origin.getStationName());
        logger.info("Destination: {}", destination.getStationName());
        logger.info("Price: ${}", price);
        logger.info("Used: {}", used);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return ticketId.equals(ticket.getTicketId());
    }

    @Override
    public int hashCode() {
        return ticketId.hashCode();
    }

    @Override
    public String getTicketId() {
        return ticketId;
    }

    @Override
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean getTicketStatus() {
        return used;
    }

    @Override
    public void setTicketStatus(boolean used) {
        this.used = used;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean validateBoarding(Train train) {

        if (used) {
            logger.warn("Ticket already used.");
            return false;
        }

        if (!train.getCurrentStation().equals(origin)) {
            logger.warn("Passenger is at the wrong station.");
            return false;
        }

        return true;
    }

    @Override
    public void markUsed() {
        used = true;
    }

}
