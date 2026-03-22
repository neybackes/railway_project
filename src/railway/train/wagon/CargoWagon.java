package railway.train.wagon;

import java.util.ArrayList;
import java.util.List;
import railway.cargo.GeneralCargo;

public final class CargoWagon extends Wagon {

    private final List<GeneralCargo> cargoList;
    private double currentLoad;

    public CargoWagon(int wagonId, double capacity) {
        super(wagonId, capacity);
        this.cargoList = new ArrayList<>();
        this.currentLoad = 0;
    }

    @Override
    public String toString() {
        return "CargoWagon{" +
                super.toString() +
                ", cargoList='" + cargoList + '\'' +
                '}';
    }

    @Override
    public void showInfo() {
        System.out.println("Cargo Wagon ID: " + wagonId);
        System.out.println("Capacity: " + capacity + " tons");
        System.out.println("Current Load: " + currentLoad + " tons");
        System.out.println("Cargo items: " + cargoList.size());
    }

    public void loadCargo(GeneralCargo cargo) {

        if (currentLoad + cargo.getWeight() > capacity) {
            System.out.println("Cannot load cargo. Wagon " + wagonId + " exceeds capacity.");
            return;
        }

        cargoList.add(cargo);
        currentLoad += cargo.getWeight();

        System.out.println("Cargo loaded into wagon " + wagonId);
    }

    public void unloadCargo(GeneralCargo cargo) {

        if (cargoList.remove(cargo)) {
            currentLoad -= cargo.getWeight();
            System.out.println("Cargo unloaded from wagon " + wagonId);
        } else {
            System.out.println("Cargo not found in wagon " + wagonId);
        }
    }

    public void showCargo() {

        if (cargoList.isEmpty()) {
            System.out.println("No cargo in wagon " + wagonId);
            return;
        }

        for (GeneralCargo cargo : cargoList) {
            System.out.println("- " + cargo.getDescription() + " (" + cargo.getWeight() + " tons)");
        }
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(double currentLoad) {
        this.currentLoad = currentLoad;
    }

}