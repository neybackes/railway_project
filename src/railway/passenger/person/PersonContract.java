package railway.passenger.person;

import railway.station.Station;

public interface PersonContract {

    String getName();

    void setName(String name);

    Station getDestination();

    void showInfo();

    @Override
    String toString();
}