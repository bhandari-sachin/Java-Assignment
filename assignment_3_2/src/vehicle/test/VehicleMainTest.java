package vehicle.test;

import vehicle.abstractclasses.AbstractVehicle;
import vehicle.implementations.*;

public class VehicleMainTest {
    public static void main(String[] args) {
        AbstractVehicle[] vehicles = {
                new Car(),
                new Motorcycle(),
                new Bus(),
                new ElectricCar(),
                new ElectricMotorcycle()
        };

        for (AbstractVehicle v : vehicles) {
            v.start();
            v.stop();
            System.out.println(v.getInfo());
            v.charge();
            System.out.println();
        }
    }
}
