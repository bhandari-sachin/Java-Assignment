package assignment1_4;

import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstNames = {"Sujan", "Pratik", "Anjali", "Kiran", "Mina", "Ramesh", "Sita"};
        String[] lastNames = {"Shrestha", "Gurung", "Rai", "Thapa", "Magar", "Pokharel", "Basnet"};

        System.out.print("How many random names should be generated? ");
        int count = Integer.parseInt(scanner.nextLine());

        System.out.println("\nGenerated Names:");

        for (int i = 0; i < count; i++) {
            int firstIndex = (int)(Math.random() * firstNames.length);
            int lastIndex = (int)(Math.random() * lastNames.length);

            String fullName = firstNames[firstIndex] + " " + lastNames[lastIndex];
            System.out.println(fullName);
        }

        scanner.close();
    }
}


