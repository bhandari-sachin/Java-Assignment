package vehicle.implementations;

import vehicle.abstractclasses.AbstractVehicle;


public class Bus extends AbstractVehicle {
    public Bus() {
        super("Bus", "Diesel", "Blue", 40, 100, 30.0, "L/ 100 km");    }

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

}
