// Task 1: Ticket Reservation System

class Theater {
    private int availableSeats;

    public Theater(int seats) {
        this.availableSeats = seats;
    }

    // Synchronized method to ensure thread safety
    public synchronized void reserveTickets(String customerName, int numSeats) {
        if (numSeats <= availableSeats) {
            System.out.println(customerName + " reserved " + numSeats + " tickets.");
            availableSeats -= numSeats;
        } else {
            System.out.println(customerName + " couldn't reserve " + numSeats + " tickets.");
        }
    }
}

class Customer extends Thread {
    private final Theater theater;
    private final int numSeats;

    public Customer(Theater theater, String name, int numSeats) {
        super(name);
        this.theater = theater;
        this.numSeats = numSeats;
    }

    @Override
    public void run() {
        theater.reserveTickets(getName(), numSeats);
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        Theater theater = new Theater(10); // 10 seats available

        // Multiple customers trying to reserve tickets
        Thread[] customers = {
                new Customer(theater, "Customer 1", 2),
                new Customer(theater, "Customer 2", 1),
                new Customer(theater, "Customer 3", 3),
                new Customer(theater, "Customer 4", 1),
                new Customer(theater, "Customer 5", 2),
                new Customer(theater, "Customer 6", 2),
                new Customer(theater, "Customer 7", 1),
                new Customer(theater, "Customer 8", 1),
                new Customer(theater, "Customer 9", 3),
                new Customer(theater, "Customer 10", 3),
                new Customer(theater, "Customer 11", 2),
                new Customer(theater, "Customer 12", 4),
                new Customer(theater, "Customer 13", 1),
                new Customer(theater, "Customer 14", 4),
                new Customer(theater, "Customer 15", 3)
        };

        // Start all threads
        for (Thread c : customers) {
            c.start();
        }
    }
}
