package vehicles;

public class Car {
    private double speed;
    private double gasolineLevel;
    private final String typeName;
    private double tankCapacity; // Added to store tank capacity

    // Cruise control features
    private boolean cruiseControlOn;
    private double targetSpeed;
    private final double MIN_CRUISE_SPEED = 30;
    private final double MAX_CRUISE_SPEED = 120;

    public Car(String typeName) {
        speed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;   // this refers to the object itself.
        cruiseControlOn = false;
        targetSpeed = 0;
    }

    /* Additional constructor with gasoline tank capacity and speed arguments */
    public Car(String typeName, double tankCapacity, double speed) {
        this.typeName = typeName;
        this.tankCapacity = tankCapacity;
        this.speed = Math.abs(speed);  // Use abs instead of Math
        this.gasolineLevel = 0;     // Start with empty tank
        cruiseControlOn = false;
        targetSpeed = 0;
    }

    public void accelerate() {
        if (gasolineLevel >= 1) {
            speed += 10;
            consumeFuel(1);
        } else {
            speed = 0;
        }
    }

    void decelerate() {
        if (gasolineLevel >= 0.5) {
            speed = Math.max(0, speed - 15);
            consumeFuel(0.5);
        } else {
            speed = 0;
        }
    }

    // Cruise control methods
    void setTargetSpeed(double targetSpeed) {
        if (targetSpeed >= MIN_CRUISE_SPEED && targetSpeed <= MAX_CRUISE_SPEED) {
            this.targetSpeed = targetSpeed;
        }
    }

    double getTargetSpeed() {
        return targetSpeed;
    }

    boolean turnOnCruiseControl() {
        if (gasolineLevel > 0 && targetSpeed >= MIN_CRUISE_SPEED && targetSpeed <= MAX_CRUISE_SPEED) {
            cruiseControlOn = true;
            adjustSpeedToCruise();
            return true;
        } else {
            cruiseControlOn = false;
            return false;
        }
    }

    void turnOffCruiseControl() {
        cruiseControlOn = false;
    }

    private void adjustSpeedToCruise() {
        if (cruiseControlOn && gasolineLevel > 0) {
            // Adjust speed directly to target speed when cruise control is activated
            speed = targetSpeed;

        }
    }

    double getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = 100;
    }

    double getGasolineLevel() {
        return gasolineLevel;
    }

    double getTankCapacity() {
        return tankCapacity;
    }

    boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    protected void consumeFuel(double amount) {
        gasolineLevel = Math.max(0, gasolineLevel - amount);
    }

    protected void setSpeed(double newSpeed) {
        speed = Math.max(0, newSpeed);
    }
}