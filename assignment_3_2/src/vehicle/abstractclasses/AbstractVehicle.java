package vehicle.abstractclasses;

import vehicle.interfaces.Vehicle;
import vehicle.interfaces.ElectricVehicle;

public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type;
    protected String fuel;
    protected String color;
    protected int capacity;
    protected double fuelEfficiency;
    protected String fuelEfficiencyUnit;

    public AbstractVehicle(String type, String fuel, String color, int capacity, double fuelEfficiency, String fuelEfficiencyUnit) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
        this.capacity = capacity;
        this.fuelEfficiency = fuelEfficiency;
        this.fuelEfficiencyUnit = fuelEfficiencyUnit; /*   L/100km or kWh/100 km   */
    }

    @Override
    public String getInfo() {
        String info = "Vehicle Information:\nType: " + type + "\nFuel: " + fuel;
        if (capacity > 0) {
            info += "\nCapacity: " + capacity + " passengers";
        }
        info += "\nColor: " + color;
        info += String.format("\nFuel Efficiency: %.2f %s", fuelEfficiency, fuelEfficiencyUnit);
        return info;
    }

    @Override
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }


    @Override
    public void charge() {
        System.out.println("Not possible to charge for " + type);
    }

    @Override
    public abstract void start();

    @Override
    public abstract void stop();
}
