package assignment1_3;

import java.util.Scanner;

public class PrimeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO PRIME NUMBERS GENERATOR!");
        System.out.print("Enter the start (positive integer): ");
        int start = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the end (positive integer greater than start): ");
        int end = Integer.parseInt(scanner.nextLine());

        if (start <= 0 || end <= 0 || start >= end) {
            System.out.println("Invalid input. Start and end must be positive and start < end.");
            scanner.close();
            return;
        }

        System.out.println("Prime numbers between " + start + " and " + end + ":");

        for (int number = start; number <= end; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }

        scanner.close();
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
