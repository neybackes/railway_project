package com.solvd.railway.system.model;

import com.solvd.railway.station.model.Station;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class RailwaySystem implements RailwaySystemContract {

    private static final Logger logger = LogManager.getLogger(RailwaySystem.class);
    private String name;

    static {
        logger.info("RailwaySystem Class Initiated");
    }

    {
        logger.info("New RailwayManager instance");
    }

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object compare);

    public abstract String getSystemName();

    public abstract void setSystemName(String name);

    public abstract void addStation(Station station);

    public abstract void showStations();

    public abstract void showTrains();
}
