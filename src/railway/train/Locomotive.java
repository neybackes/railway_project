package railway.train;

public class Locomotive {

    private String name;
    private int maxSpeed;

    public Locomotive(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "name='" + name + '\'' +
                ", capacity='" + maxSpeed + '\'' +
                '}';
    }
    public void showInfo() {
        System.out.println("Locomotive: " + name);
        System.out.println("Max speed: " + maxSpeed + " km/h");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

}