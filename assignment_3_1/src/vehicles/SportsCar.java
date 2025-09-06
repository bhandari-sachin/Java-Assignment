package vehicles;

public class SportsCar extends Car {
    // Class-level constants for better organization
    private static final double ACCEL_FUEL_COST = 5.0;
    private static final double BRAKE_FUEL_COST = 2.0;
    private static final double SPEED_BOOST = 20.0;
    private static final double BRAKE_POWER = 25.0;

    public SportsCar(String typeName, double tankCapacity, double speed) {
        super(typeName, tankCapacity, speed);
    }

    @Override
    public void accelerate() {
        if (getGasolineLevel() >= ACCEL_FUEL_COST) {
            double newSpeed = getSpeed() + SPEED_BOOST;
            setSpeed(newSpeed);
            consumeFuel(ACCEL_FUEL_COST);
            System.out.println(getTypeName() + " accelerates to " + newSpeed + " km/h");
        } else {
            System.out.println(getTypeName() + " cannot accelerate, not enough fuel.");
        }
    }

    @Override
    public void decelerate() {
        if (getGasolineLevel() >= BRAKE_FUEL_COST) {
            double newSpeed = Math.max(0, getSpeed() - BRAKE_POWER);
            setSpeed(newSpeed);
            consumeFuel(BRAKE_FUEL_COST);
            System.out.println(getTypeName() + " decelerates to " + newSpeed + " km/h");
        } else {
            System.out.println(getTypeName() + " stops, not enough fuel.");
        }
    }
}