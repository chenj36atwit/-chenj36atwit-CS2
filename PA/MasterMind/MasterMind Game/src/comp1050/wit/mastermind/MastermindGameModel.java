//@Jacky Chen
//@April 14 2022

package comp1050.wit.mastermind;


import java.util.*;

public class MastermindGameModel {
    private List<String> secretCode;
    private boolean gameOver;
    private int guessCount;

    public MastermindGameModel() {
        secretCode = generateSecretCode();
        gameOver = false;
        guessCount = 0;
    }

    public String checkGuess(String[] guess) {
        guessCount++;

        int blackCount = 0; // Correct color and position
        int whiteCount = 0; // Correct color but wrong position
        int incorrectCount = 0; // Incorrect color

        // Create a copy of the secret code to avoid modifying the original list
        List<String> remainingSecretCode = new ArrayList<>(secretCode);
        List<String> remainingGuess = new ArrayList<>(Arrays.asList(guess));

        // Check for correct color and position
        for (int i = 0; i < secretCode.size(); i++) {
            if (guess[i].equalsIgnoreCase(secretCode.get(i))) {
                blackCount++;
                // Remove the matched color from the remaining secret code and guess
                remainingSecretCode.remove(guess[i]);
                remainingGuess.set(i, "");
            }
        }

        // Check for correct color but wrong position
        for (int i = 0; i < secretCode.size(); i++) {
            if (!guess[i].equalsIgnoreCase(secretCode.get(i)) && remainingSecretCode.contains(guess[i])) {
                whiteCount++;
                // Remove the matched color from the remaining secret code and guess
                remainingSecretCode.remove(guess[i]);
                remainingGuess.set(i, "");
            }
        }

        // Count incorrect colors
        for (String color : remainingGuess) {
            if (!color.isEmpty()) {
                incorrectCount++;
            }
        }

        // Add the guess count and detailed feedback to the response
        StringBuilder feedback = new StringBuilder();
        feedback.append(" (Guess ").append(guessCount).append(") - ");
        feedback.append(blackCount).append("B ").append(whiteCount).append("W ").append(incorrectCount).append("X");

        if (blackCount == secretCode.size()) {
            gameOver = true;
        }

        return feedback.toString();
    }

    public List<String> getSecretCode() {
        return secretCode;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private List<String> generateSecretCode() {
        String[] availableColors = {"Red", "Blue", "Green", "Yellow", "Orange", "Pink"};
        List<String> code = Arrays.asList(availableColors);
        Collections.shuffle(code);
        return code.subList(0, 4);
    }
}