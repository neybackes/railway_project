package railway.station;

public class Route {

    private Station origin;
    private Station destination;
    private double distance;

    public Route(Station origin, Station destination, double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }
    @Override
    public String toString() {
        return "Route{" +
                "origin ='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
    public void showInfo() {
        System.out.println("Route:");
        System.out.println("Origin: " + origin.getStationName());
        System.out.println("Destination: " + destination.getStationName());
        System.out.println("Distance: " + distance + " km");
    }
    public String getOrigin() {
        return origin.getStationName();
    }

    public String getDestination() {
        return destination.getStationName();
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance){
        this.distance = distance;
    }


    public boolean isStationOnRoute(Station station) {
        return station.equals(origin) || station.equals(destination);
    }
}