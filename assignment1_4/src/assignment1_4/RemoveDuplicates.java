package assignment1_4;

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = Integer.parseInt(scanner.nextLine());

        int[] originalArray = new int[size];

        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            originalArray[i] = Integer.parseInt(scanner.nextLine());
        }

        int[] uniqueArray = new int[size];
        int uniqueCount = 0;

        for (int i = 0; i < size; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (originalArray[i] == uniqueArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                uniqueArray[uniqueCount] = originalArray[i];
                uniqueCount++;
            }
        }

        System.out.println("\nOriginal array:");
        for (int i = 0; i < size; i++) {
            System.out.print(originalArray[i] + " ");
        }

        System.out.println("\n\nArray after removing duplicates:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(uniqueArray[i] + " ");
        }

        System.out.println("\n\nNumber of unique elements: " + uniqueCount);

        scanner.close();
    }
}
