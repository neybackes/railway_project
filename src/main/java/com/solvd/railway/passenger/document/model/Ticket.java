package com.solvd.railway.passenger.document.model;

import com.solvd.railway.exception.InvalidBoardingException;
import com.solvd.railway.generics.Printer;
import com.solvd.railway.passenger.person.model.Passenger;
import com.solvd.railway.station.model.Station;
import com.solvd.railway.train.model.Train;

import java.util.HashSet;
import java.util.Set;

public class Ticket extends Document {

    private static final Printer<String> logsPrinter = new Printer<>();
    private String ticketId;
    private final Passenger passenger;
    private final Station origin;
    private final Station destination;
    private double price;
    private boolean used;
    private Set<Ticket> tickets = new HashSet<>();

    {
        logsPrinter.info("New Ticket instance");
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
        logsPrinter.info("Ticket ID: " + ticketId);
        logsPrinter.info("Passenger: " + passenger.getName());
        logsPrinter.info("Origin: " + origin.getStationName());
        logsPrinter.info("Destination: " + destination.getStationName());
        logsPrinter.info("Price: $" + price);
        logsPrinter.info("Used: " + used);
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
    public String setTicketId(String ticketId) {
        this.ticketId = ticketId;
        return ticketId;
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
    public boolean validateBoarding(Train train) throws InvalidBoardingException {
        if (used) {
            throw new InvalidBoardingException("Ticket already used.");
        }
        if (!train.getCurrentStation().equals(origin)) {
            throw new InvalidBoardingException("Passenger is at the wrong station.");
        }
        return true;
    }

    @Override
    public void markUsed() {
        used = true;
    }

    public boolean addTicket(Ticket ticket) {
        return tickets.add(ticket);
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }
}
