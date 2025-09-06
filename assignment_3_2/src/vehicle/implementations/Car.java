package vehicle.implementations;

import vehicle.interfaces.Vehicle;
import vehicle.abstractclasses.AbstractVehicle;

public class Car extends AbstractVehicle {
    public Car() {
        super("Car", "Petrol", "Red", 4, 100, 8.0, "L/100 km");
    }


    @Override
    public void start() {
        System.out.println(type + " is starting...");

    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

}