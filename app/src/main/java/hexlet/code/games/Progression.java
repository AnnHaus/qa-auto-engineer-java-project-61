package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final String DESCRIPTION = "What number is missing in the progression?";

    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;

    private static final int MAX_START_VALUE = 20;
    private static final int MAX_STEP_VALUE = 10;

    public static void play() {
        String[][] roundsData = new String[Engine.MAX_ROUNDS][2];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int length = Utils.generateRandomNumber(MIN_LENGTH, MAX_LENGTH);
            int start = Utils.generateRandomNumber(1, MAX_START_VALUE);
            int step = Utils.generateRandomNumber(1, MAX_STEP_VALUE);

            int[] progression = makeProgression(start, step, length);

            int hiddenIndex = Utils.generateRandomNumber(0, length - 1);

            int correctAnswer = progression[hiddenIndex];

            String[] progressionStrings = new String[length];
            for (int j = 0; j < length; j++) {
                if (j == hiddenIndex) {
                    progressionStrings[j] = "..";
                } else {
                    progressionStrings[j] = String.valueOf(progression[j]);
                }
            }

            roundsData[i][0] = String.join(" ", progressionStrings);
            roundsData[i][1] = String.valueOf(correctAnswer);
        }

        Engine.run(DESCRIPTION, roundsData);
    }

    private static int[] makeProgression(int start, int step, int length) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }
        return progression;
    }
}
