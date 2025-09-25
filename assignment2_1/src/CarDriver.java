
package assignment2_1;
public class CarDriver {
    public static void main(String[] args) {
        Car myCar;
        myCar = new Car("Toyota Corolla");
        myCar.fillTank();

        // Original test
        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }
        while (myCar.getSpeed() > 0) {
            myCar.decelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        System.out.println("\n--- Testing Cruise Control ---");

        // Test cruise control
        myCar.fillTank();

        // Set target speed and turn on cruise control
        myCar.setTargetSpeed(50);
        System.out.println("Target speed set to: " + myCar.getTargetSpeed() + " km/h");

        boolean cruiseOn = myCar.turnOnCruiseControl();
        if (cruiseOn) {
            System.out.println("Cruise control turned ON");
            System.out.println("Speed adjusted to: " + myCar.getSpeed() + " km/h");
        } else {
            System.out.println("Cruise control could not be turned ON");
        }

        // Test with invalid target speed
        myCar.setTargetSpeed(20); // Below minimum
        System.out.println("Trying to set target speed to 20 km/h (below minimum)");
        cruiseOn = myCar.turnOnCruiseControl();
        if (!cruiseOn) {
            System.out.println("Cruise control could not be turned ON - target speed out of range");
        }

        // Turn off cruise control
        myCar.turnOffCruiseControl();
        System.out.println("Cruise control status: " + (myCar.isCruiseControlOn() ? "ON" : "OFF"));
    }
}