package railway.train.wagon;

public interface WagonContract {

    int getWagonId();

    void setWagonId(int wagonId);

    double getCapacity();

    void setCapacity(double capacity);

    int getSeats();

    void showInfo();
    
    @Override
    String toString();
}