package hexlet.code;

import java.util.Random;

public class Calc {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int MAX_NUMBER = 50;

    public static void runGame() {
        String[][] roundsData = new String[Engine.MAX_ROUNDS][2];
        Random random = new Random();
        String[] operators = {"+", "-", "*"};

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int num1 = random.nextInt(MAX_NUMBER);
            int num2 = random.nextInt(MAX_NUMBER);
            String operator = operators[random.nextInt(operators.length)];

            int correctAnswer = 0;
            switch (operator) {
                case "+":
                    correctAnswer = num1 + num2;
                    break;
                case "-":
                    correctAnswer = num1 - num2;
                    break;
                case "*":
                    correctAnswer = num1 * num2;
                    break;
                default:
                    break;
            }

            roundsData[i][Engine.QUESTION_INDEX] = num1 + " " + operator + " " + num2;
            roundsData[i][Engine.ANSWER_INDEX] = Integer.toString(correctAnswer);
        }

        Engine.run(DESCRIPTION, roundsData);
    }
}


