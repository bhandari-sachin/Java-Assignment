package vehicle.abstractclasses;

import vehicle.interfaces.Vehicle;
import vehicle.interfaces.ElectricVehicle;

public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type;
    protected String fuel;
    protected String color;
    protected int capacity;

    // For fuel efficiency calculation
    protected double distance; // in km
    protected double fuelConsumed; // consumed fuel in liters or kWh
    protected String fuelEfficiencyUnit; //   L/ 100km or kWh/100 km

    public AbstractVehicle(String type, String fuel, String color, int capacity, double distance, double fuelConsumed, String fuelEfficiencyUnit) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
        this.capacity = capacity;
        this.distance = distance;
        this.fuelConsumed = fuelConsumed;
        this.fuelEfficiencyUnit = fuelEfficiencyUnit;
    }

    @Override
    public String getInfo() {
        String info = "Vehicle Information:\nType: " + type + "\nFuel: " + fuel;
        if (capacity > 0) {
            info += "\nCapacity: " + capacity + " passengers";
        }
        info += "\nColor: " + color;
        return info;
    }

    @Override
    public double calculateFuelEfficiency() {
        if (distance == 0) {
            return 0;
        }
        return (fuelConsumed / distance) * 100;
    }

    public String getFuelEfficiencyUnit() {
        return fuelEfficiencyUnit;
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
