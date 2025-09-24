package assignment1_3;

import java.util.Scanner;

public class QuadraticEqSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter coefficients
        System.out.print("Enter coefficient a: ");
        double a = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter coefficient b: ");
        double b = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter coefficient c: ");
        double c = Double.parseDouble(scanner.nextLine());

        // Calculate discriminant
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Two real roots:");
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("One real root:");
            System.out.println("Root: " + root);
        } else {
            System.out.println("No real roots");
        }

        scanner.close();
    }
}

