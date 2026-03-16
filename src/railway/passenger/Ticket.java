package railway.passenger;

import railway.station.Station;
import railway.train.Train;

public class Ticket {

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

    public Passenger getPassenger() {
        return passenger;
    }

    public String getTicketId() {
        return ticketId;
    }
    public void setTicketId(String ticketId){
        this.ticketId = ticketId;
    }

    public double getPrice(){
        return price;
    }
    public boolean getTicketStatus(){
        return used;
    }
    public void setTicketStatus(boolean used){
        this.used = used;
    }

    public void setPrice(double price){
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

    public void showInfo() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Passenger: " + passenger.getName());
        System.out.println("Origin: " + origin.getStationName());
        System.out.println("Destination: " + destination.getStationName());
        System.out.println("Price: $" + price);
        System.out.println("Used: " + used);
    }
}