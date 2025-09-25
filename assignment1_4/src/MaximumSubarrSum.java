package assignment1_4;
import java.util.Scanner;

public class MaximumSubarrSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers in the array: ");
        int n = Integer.parseInt(scanner.nextLine());

        int[] arr = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }

        int maxSum = arr[0];
        int currentSum = arr[0];
        int startIndex = 0;
        int tempStart = 0;
        int endIndex = 0;

        for (int i = 1; i < n; i++) {
            if (currentSum < 0) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIndex = tempStart;
                endIndex = i;
            }
        }

        System.out.println("\nMaximum subarray sum: " + maxSum);
        System.out.println("Subarray starts at index: " + (startIndex + 1));
        System.out.println("Subarray ends at index: " + (endIndex + 1));

        System.out.print("Subarray elements: ");
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}
