package assignment1_3;

import java.util.Scanner;

public class BinaryToDecimal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String binary = scanner.nextLine();

        int decimal = 0;

        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(i);

            if (bit == '1') {
                decimal += 1 << (binary.length() - 1 - i);
            } else if (bit != '0') {
                System.out.println("Invalid binary number!");
                scanner.close();
                return;
            }
        }
        System.out.println("Decimal equivalent: " + decimal);

        scanner.close();
    }
}

