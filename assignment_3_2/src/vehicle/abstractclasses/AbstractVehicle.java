package vehicle.abstractclasses;

import vehicle.interfaces.Vehicle;

public class AbstractVehicle implements Vehicle {
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
    public void start() {

    }

    @Override
    public void stop() {

    }
}
