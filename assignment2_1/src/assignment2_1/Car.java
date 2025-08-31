package assignment2_1;

public class Car {
    private double speed;
    private double gasolineLevel;
    private final String typeName;
    private double tankCapacity; // Added to store tank capacity

    public Car(String typeName) {
        speed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;   // this refers to the object itself.

    }

    /* Additional constructor with gasoline tank capacity and speed arguments */
    public Car(String typeName, double tankCapacity, double speed) {
        this.typeName = typeName;
        this.tankCapacity = tankCapacity;
        this.speed = speed;
        this.gasolineLevel = 0;     // Start with empty tank
    }

    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
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
}
