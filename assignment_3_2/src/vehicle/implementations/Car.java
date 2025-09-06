package vehicle.implementations;

import vehicle.interfaces.Vehicle;

public class Car implements Vehicle {
    private final String type = "Car";


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
        String color = "Red";
        String fuel = "Petrol";
        return "Vehicle Information:\nType: " + type + "\nFuel: " + fuel + "\nColor: " + color;
    }
}