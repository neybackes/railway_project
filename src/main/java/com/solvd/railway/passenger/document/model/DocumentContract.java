package com.solvd.railway.passenger.document.model;

import com.solvd.railway.train.model.Train;

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