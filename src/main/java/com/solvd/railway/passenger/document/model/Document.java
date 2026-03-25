package com.solvd.railway.passenger.document.model;

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

    @Override
    public abstract void showInfo();

    @Override
    public abstract String getTicketId();

    @Override
    public abstract void setTicketId(String ticketId);

    @Override
    public abstract double getPrice();

    @Override
    public abstract boolean getTicketStatus();

    @Override
    public abstract void setTicketStatus(boolean used);

    @Override
    public abstract void setPrice(double price);

    @Override
    public abstract boolean validateBoarding(Train train);

    @Override
    public abstract void markUsed();


}
