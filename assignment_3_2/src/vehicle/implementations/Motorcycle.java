package vehicle.implementations;

import vehicle.abstractclasses.AbstractVehicle;

public class Motorcycle extends AbstractVehicle {
    public Motorcycle() {
        super("Motorcycle", "Petrol", "Black", 2, 100, 4.5, "L/ 100 km");
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
