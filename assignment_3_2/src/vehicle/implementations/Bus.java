package vehicle.implementations;

import vehicle.interfaces.Vehicle;

public class Bus implements Vehicle {
    private final String type = "Bus";

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

    @Override
    public String getInfo() {
        String fuel = "Diesel";
        int capacity = 40;
        return "Vehicle Information:\nType: " + type + "\nFuel: " + fuel + "\nCapacity: " + capacity + " passengers";
    }
}
