package railway.train;

public abstract class Wagon {

    protected int wagonId;
    protected double capacity;

    public Wagon(int wagonId, double capacity) {
        this.wagonId = wagonId;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "wagonId=" + wagonId +
                ", capacity=" + capacity +
                '}';
    }


    public int getWagonId() {
        return wagonId;
    }

    public void setWagonId(int wagonId){
        this.wagonId = wagonId;
    }

    public double getCapacity() {
        return capacity;
    }

    public int getSeats(){
        return (int) capacity;
    }

    //overloading
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void setCapacity(double capacity){
        this.capacity = capacity;
    }



    public abstract void showInfo();
}