package assignment1_3;

import java.util.Scanner;

public class MultiplicationTableExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int score = 0;

            for (int i = 1; i <= 10; i++) {
                int num1 = (int) (Math.random() * 10) + 1;
                int num2 = (int) (Math.random() * 10) + 1;

                System.out.print("Problem " + i + ": " + num1 + " x " + num2 + " = ");
                int answer = Integer.parseInt(scanner.nextLine());

                if (answer == num1 * num2) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong. The correct answer is " + (num1 * num2));
                }
            }

            System.out.println("You scored " + score + " out of 10.");

            if (score == 10) {
                System.out.println("Congratulations! You have mastered the multiplication tables!");
                break;
            } else {
                System.out.println("Let's try another round!\n");
            }
        }

        scanner.close();
    }
}

