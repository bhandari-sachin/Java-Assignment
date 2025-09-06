package vehicle.implementations;

import vehicle.interfaces.Vehicle;

public class Motorcycle implements Vehicle {
    private final String type = "Motorcycle";

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
        String fuel = "Gasoline";
        String color = "Black";
        return "Vehicle Information:\nType: " + type + "\nFuel: " + fuel + "\nColor: " + color;
    }
}
