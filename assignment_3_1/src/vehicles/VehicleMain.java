package vehicles;

public class VehicleMain {
    public static void main(String[] args) {
        // === Create vehicles ===
        Car familyCar = new Car("FamilyCar", 50, 0);
        SportsCar ferrari = new SportsCar("Ferrari", 60, 0);
        Bus cityBus = new Bus("CityBus", 100, 0, 30);

        // === Test normal Car ===
        System.out.println("=== NORMAL CAR TEST ===");
        testVehicle(familyCar);

        // === Test ferrari ===
        System.out.println("\n=== SPORTS CAR TEST ===");
        testVehicle(ferrari);

        // === Test Bus ===
        System.out.println("\n=== BUS TEST ===");
        System.out.println("Initial passengers: " + cityBus.getCurrentPassengers() + "/" + cityBus.getMaxCapacity());

        cityBus.passengerEnter(15);
        System.out.println("After 15 enter: " + cityBus.getCurrentPassengers() + "/" + cityBus.getMaxCapacity());


        cityBus.passengerExit(8);
        System.out.println("After 8 exit: " + cityBus.getCurrentPassengers() + "/" + cityBus.getMaxCapacity());

    }

    private static void testVehicle(Car vehicle) {
        // Fill tank and show initial state
        vehicle.fillTank();
        System.out.println(vehicle.getTypeName() + " starts with fuel: " + vehicle.getGasolineLevel());

        // Test acceleration
        vehicle.accelerate();
        printStatus(vehicle, "after acceleration");

        // Test deceleration
        vehicle.decelerate();
        printStatus(vehicle, "after deceleration");
    }

    private static void printStatus(Car vehicle, String action) {
        System.out.println(vehicle.getTypeName() + " " + action + ": " +
                vehicle.getSpeed() + " km/h, fuel: " + vehicle.getGasolineLevel());
    }
}