package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_NUMBER = 100;

    public static void play() {
        String[][] roundsData = new String[Engine.MAX_ROUNDS][2];
        Random random = new Random();

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int number = random.nextInt(MAX_NUMBER);
            String correctAnswer = (number % 2 == 0) ? "yes" : "no";

            roundsData[i][Engine.QUESTION_INDEX] = Integer.toString(number);
            roundsData[i][Engine.ANSWER_INDEX] = correctAnswer;
        }

        Engine.run(DESCRIPTION, roundsData);
    }
}
