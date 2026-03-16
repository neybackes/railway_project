package railway.train;

public abstract class Wagon {

    protected int wagonId;
    protected double capacity;

    public Wagon(int wagonId, double capacity) {
        this.wagonId = wagonId;
        this.capacity = capacity;
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
    public void setCapacity(double capacity){
        this.capacity = capacity;
    }

    public abstract void showInfo();
}