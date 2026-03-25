package com.solvd.railway.passenger.document.model;

import com.solvd.railway.passenger.person.model.Passenger;
import com.solvd.railway.station.model.Station;
import com.solvd.railway.train.model.Train;

public abstract class Document implements DocumentContract {

    private String ticketId;
    private Passenger passenger;
    private Station origin;
    private Station destination;
    private double price;
    private boolean used;

    static {
        System.out.println("Document Class Initiated");
    }

    {
        System.out.println("New Document instance");
    }

    @Override
    public abstract String toString();

    public abstract void showInfo();

    public abstract String getTicketId();

    public abstract void setTicketId(String ticketId);

    public abstract double getPrice();

    public abstract boolean getTicketStatus();

    public abstract void setTicketStatus(boolean used);

    public abstract void setPrice(double price);

    public abstract boolean validateBoarding(Train train);

    public abstract void markUsed();

    public static final class Ticket extends Document {

        private String ticketId;
        private Passenger passenger;
        private Station origin;
        private Station destination;
        private double price;
        private boolean used;

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
            return "Ticket{" +
                    "ticketId='" + ticketId + '\'' +
                    ", passenger='" + passenger + '\'' +
                    ", origin='" + origin + '\'' +
                    ", destination='" + destination + '\'' +
                    ", price='" + price + '\'' +
                    ", used='" + used + '\'' +
                    '}';
        }

        @Override
        public void showInfo() {
            System.out.println("Ticket ID: " + ticketId);
            System.out.println("Passenger: " + passenger.getName());
            System.out.println("Origin: " + origin.getStationName());
            System.out.println("Destination: " + destination.getStationName());
            System.out.println("Price: $" + price);
            System.out.println("Used: " + used);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Ticket ticket)) return false;
            return ticketId.equals(ticket.ticketId);
        }

        @Override
        public int hashCode() {
            return ticketId.hashCode();
        }

        public String getTicketId() {
            return ticketId;
        }

        public void setTicketId(String ticketId) {
            this.ticketId = ticketId;
        }

        public double getPrice() {
            return price;
        }

        public boolean getTicketStatus() {
            return used;
        }

        public void setTicketStatus(boolean used) {
            this.used = used;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean validateBoarding(Train train) {

            if (used) {
                System.out.println("Ticket already used.");
                return false;
            }

            if (!train.getCurrentStation().equals(origin)) {
                System.out.println("Passenger is at the wrong station.");
                return false;
            }

            return true;
        }

        public void markUsed() {
            used = true;
        }

    }
}
