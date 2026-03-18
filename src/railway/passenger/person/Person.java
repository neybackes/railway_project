package railway.passenger.person;

import railway.station.Station;

public abstract class Person {
    private String name;
    private Station destination;

    public Person() {

    }

    @Override
    public abstract String toString();

    public abstract void showInfo();

    public abstract String getName();

    public abstract void setName(String name);

    public abstract Station getDestination();

}
