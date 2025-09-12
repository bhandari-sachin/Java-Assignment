
---

## Writing Tasks (W)

- **W1:** Algorithm to generate 1000 age values based on a custom distribution (`W1_AgeDistribution.md`).
- **W2:** Explanation of why Singleton objects cannot be created with `new` (`W2_SingletonExplanation.md`).
- **W3:** Real-life examples of distributions (`W3_DistributionExamples.md`).

---

## Programming Tasks (P)

### **P1 – Age Distribution**
- `AgeDistribution.java`: Generates random ages based on a predefined distribution.
- `TestAgeDistribution.java`: Test program to print 1000 randomly generated ages.

### **P2 – Clock Singleton**
- `Clock.java`: Singleton class for tracking simulation time.
- `TestClock.java`: Test program demonstrating singleton behavior and time advancement.

### **P3 – ArrivalProcess**
- `Event.java` / `EventType.java`: Defines events and their types.
- `EventList.java`: Stores events.
- `ArrivalProcess.java`: Generates arrival events using a **random number generator**.
- `TestArrivalProcess.java`: Test program generating 10 arrival events and printing them.

### **P4 – Test Suite**
- `Customer.java`: Represents a customer and records arrival/departure times.
- `ServicePoint.java`: Manages the queue of customers.
- `TestSuite.java`: Complete test suite that:
    1. Generates 10 arrival events.
    2. Adds customers to the service point.
    3. Advances the clock.
    4. Serves customers and prints the time spent in the system.

---

