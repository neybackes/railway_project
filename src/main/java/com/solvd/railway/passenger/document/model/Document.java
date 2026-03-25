package com.solvd.railway.passenger.document.model;

import com.solvd.railway.exception.InvalidBoardingException;
import com.solvd.railway.train.model.Train;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Document implements DocumentContract {

    private static final Logger logger = LogManager.getLogger(Document.class);

    static {
        logger.info("Document Class Initiated");
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

    public abstract boolean validateBoarding(Train train) throws InvalidBoardingException;

    public abstract void markUsed();


}
