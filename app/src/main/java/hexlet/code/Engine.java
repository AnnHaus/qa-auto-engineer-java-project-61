package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int MAX_ROUNDS = 3;
    public static final int QUESTION_INDEX = 0;
    public static final int ANSWER_INDEX = 1;

    public static void run(String description, String[][] roundsData) {
        String userName = Cli.greetUser();

        System.out.println(description);

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < MAX_ROUNDS; i++) {
            String question = roundsData[i][QUESTION_INDEX];
            String correctAnswer = roundsData[i][ANSWER_INDEX];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next().toLowerCase();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. "
                        + "Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return; // Завершаем игру при первой же ошибке
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}


