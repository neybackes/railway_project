package railway.station;

public class Station {

    private String name;
    private String city;

    public Station(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getStationName() {
        return name;
    }

    public void setStationName(String name) {
        this.name = name;
    }

    public String getStationCity() {
        return city;
    }

    public void setStationCity(String city) {
        this.city = city;
    }

    public void showInfo() {
        System.out.println("Station: " + name);
        System.out.println("City: " + city);
    }
}