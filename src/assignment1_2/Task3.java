package assignment1_2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the weight in grams: ");
        double weightGram = scanner.nextDouble();

        double totalLuoti = weightGram / 13.28;

        double le = Math.floor(totalLuoti / (32 * 20));

        double remainingAfterLeiviska = totalLuoti - (le * 32 * 20);

        double na = Math.floor(remainingAfterLeiviska / 32);

        double lu = remainingAfterLeiviska - (na * 32);

        System.out.printf("%.0f grams is %.0f leiviskä, %.0f naula, and %.2f luoti.",
                weightGram, le, na, lu);

        scanner.close();
    }
}