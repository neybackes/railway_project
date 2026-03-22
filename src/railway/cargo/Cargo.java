package railway.cargo;

import railway.station.Station;

public abstract class Cargo {

    protected String description;
    protected double weight;
    protected Station destination;

    public abstract void showInfo();

    @Override
    public abstract String toString();

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract double getWeight();

    public abstract void setWeight(double weight);

    public abstract Station getDestination();

    public abstract void setDestination(Station destination);
}
