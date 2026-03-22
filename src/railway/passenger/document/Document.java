package railway.passenger.document;

import railway.passenger.person.Passenger;
import railway.station.Station;
import railway.train.Train;

public abstract class Document {

    private String ticketId;
    private Passenger passenger;
    private Station origin;
    private Station destination;
    private double price;
    private boolean used;

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

}
