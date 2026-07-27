package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Even {

    public static void runGame(String userName) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random random = new Random();
        final int maxRounds = 3;
        final int maxNumber = 100;

        for (int i = 0; i < maxRounds; i++) {

            int number = random.nextInt(maxNumber);
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");

            String answer = scanner.next().toLowerCase();

            String correctAnswer = (number % 2 == 0) ? "yes" : "no";

            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}


