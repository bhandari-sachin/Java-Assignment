package vehicle.implementations;

import vehicle.abstractclasses.AbstractVehicle;

public class ElectricCar extends AbstractVehicle {

    public ElectricCar() {
        super("Electric Car", "Electric", "White", 0);
    }

    @Override
    public void start() {
        System.out.println(type + " is starting silently...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping silently...");
    }

    @Override
    public void charge() {
        System.out.println(type + " is charging...");
    }
}
