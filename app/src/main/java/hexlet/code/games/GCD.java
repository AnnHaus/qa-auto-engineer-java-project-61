package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void play() {
        String[][] roundsData = new String[Engine.MAX_ROUNDS][2];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int num1 = Utils.generateRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int num2 = Utils.generateRandomNumber(MIN_NUMBER, MAX_NUMBER);

            roundsData[i][0] = num1 + " " + num2;
            roundsData[i][1] = String.valueOf(gcd(num1, num2));
        }

        Engine.run(DESCRIPTION, roundsData);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
