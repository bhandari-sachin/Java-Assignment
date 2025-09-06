package vehicle.test;

import vehicle.implementations.Car;
import vehicle.implementations.Motorcycle;
import vehicle.implementations.Bus;
import vehicle.abstractclasses.AbstractVehicle;

public class VehicleMainTest {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        AbstractVehicle car = new Car();
        car.start();
        car.stop();
        System.out.println(car.getInfo() + "\n");

        AbstractVehicle motorcycle = new Motorcycle();
        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo() + "\n");

        AbstractVehicle bus = new Bus();
        bus.start();
        bus.stop();
        System.out.println(bus.getInfo() + "\n");


    }
}
