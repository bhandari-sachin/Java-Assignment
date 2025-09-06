package vehicle.implementations;

import vehicle.interfaces.Vehicle;
import vehicle.abstractclasses.AbstractVehicle;

public class Motorcycle extends AbstractVehicle {
    public Motorcycle() {
        super("Motorcycle", "Gasoline", "Black", 0);
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
