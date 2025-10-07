import java.util.*;

// Class representing a person
class Person {
    String name;
    int age;
    String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return name + " (" + age + ") - " + city;
    }


}

public class Tas1Task2 {

    public static void main(String[] args) {

        // =========================
        // Task 1: Sorting and Filtering Persons
        // =========================
        System.out.println("===== Task 1: Sorting and Filtering Persons =====");

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Alice", 25, "New York"),
                new Person("Bob", 30, "Los Angeles"),
                new Person("Charlie", 22, "New York"),
                new Person("David", 28, "Chicago"),
                new Person("Eve", 35, "New York")
        ));

        // Sort by age using Comparator.comparingInt
        people.sort(Comparator.comparingInt(p -> p.age));
        System.out.println("\nSorted by age:");
        people.forEach(System.out::println);

        // Filter by city: New York
        people.removeIf(p -> !p.city.equals("New York"));
        System.out.println("\nFiltered by city (New York):");
        people.forEach(System.out::println);

        // =========================
        // Task 2: Collection Operations on Integers
        // =========================
        System.out.println("\n===== Task 2: Collection Operations on Integers =====");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 8, 20, 15, 3, 12));
        System.out.println("\nOriginal numbers: " + numbers);

        // Filter out even numbers
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After removing even numbers: " + numbers);

        // Double the remaining odd numbers
        numbers.replaceAll(n -> n * 2);
        System.out.println("After doubling odd numbers: " + numbers);

        // Sum the numbers
        final int[] sum = {0};
        numbers.forEach(n -> sum[0] += n);
        System.out.println("Sum of numbers: " + sum[0]);
    }
}
