package railway.system;

import railway.station.Station;

public abstract class RailwaySystem {

    private String name;

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
