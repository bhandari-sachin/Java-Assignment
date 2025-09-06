package vehicles;

public class Bus extends Car {
    private int currentPassengers;
    private final int maxCapacity;

    public Bus(String typeName, double tankCapacity, double speed, int maxCapacity) {
        super(typeName, tankCapacity, speed);
        this.maxCapacity = maxCapacity;
        this.currentPassengers = 0;
    }

    public void passengerEnter(int count) {
        if (currentPassengers + count <= maxCapacity) {
            currentPassengers += count;
        }
    }

    public void passengerExit(int count) {
        if (count <= currentPassengers) {
            currentPassengers -= count;
        }
    }

    public int getCurrentPassengers() {
        return currentPassengers;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}