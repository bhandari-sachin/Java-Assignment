package vehicle.abstractclasses;

import vehicle.interfaces.Vehicle;
import vehicle.interfaces.ElectricVehicle;

public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type;
    protected String fuel;
    protected String color;
    protected int capacity;


    public AbstractVehicle(String type, String fuel, String color, int capacity) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
        this.capacity = capacity;
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
    public void charge() {
        System.out.println("Not possible to charge for " + type);
    }

    @Override
    public abstract void start();

    @Override
    public abstract void stop();

}
