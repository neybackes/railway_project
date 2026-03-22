package railway.passenger.document;

import railway.train.Train;

public interface DocumentContract {

    void showInfo();

    String getTicketId();

    void setTicketId(String ticketId);

    double getPrice();

    void setPrice(double price);

    boolean getTicketStatus();

    void setTicketStatus(boolean used);

    boolean validateBoarding(Train train);

    void markUsed();

    @Override
    String toString();
}