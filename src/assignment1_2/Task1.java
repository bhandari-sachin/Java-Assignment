package assignment1_2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();

        double celsius = (fahrenheit - 32) * 5.0 / 9.0;

        // Display the result with one decimal place
        System.out.printf("%.1f°F is equal to %.1f°C%n", fahrenheit, celsius);

        scanner.close();
    }
}