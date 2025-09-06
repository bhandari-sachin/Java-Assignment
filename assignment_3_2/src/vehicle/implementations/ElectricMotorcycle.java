package vehicle.implementations;

import vehicle.abstractclasses.AbstractVehicle;

public class ElectricMotorcycle extends AbstractVehicle {

    public ElectricMotorcycle() {
        super("Electric Motorcycle", "Electric", "Green", 2, 100, 3.0, "kWh/100 km");
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
