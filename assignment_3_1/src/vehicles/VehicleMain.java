package vehicles;

public class VehicleMain {
    public static void main(String[] args) {
        // === Create vehicles ===
        Car familyCar = new Car("FamilyCar", 50, 0);
        SportsCar ferrari = new SportsCar("Ferrari", 60, 0);

        System.out.println("=== NORMAL CAR TEST ===");
        testVehicle(familyCar);

        System.out.println("\n=== SPORTS CAR TEST ===");
        testVehicle(ferrari);

        System.out.println("\nAdditional SportsCar accelerations:");
        ferrari.accelerate();
        ferrari.accelerate();
        printStatus(ferrari, "after 2 more accelerations");
    }

    private static void testVehicle(Car vehicle) {
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