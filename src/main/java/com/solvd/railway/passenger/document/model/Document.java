package com.solvd.railway.passenger.document.model;

import com.solvd.railway.exception.InvalidBoardingException;
import com.solvd.railway.generics.Printer;
import com.solvd.railway.train.model.Train;

public abstract class Document implements DocumentContract {

    private static final Printer<String> logsPrinter = new Printer<>();

    static {
        logsPrinter.info("Document Class Initiated");
    }

    @Override
    public abstract String toString();

    public abstract void showInfo();

    public abstract String getTicketId();

    public abstract String setTicketId(String ticketId);

    public abstract double getPrice();

    public abstract boolean getTicketStatus();

    public abstract void setTicketStatus(boolean used);

    public abstract void setPrice(double price);

    public abstract boolean validateBoarding(Train train) throws InvalidBoardingException;

    public abstract void markUsed();
}
