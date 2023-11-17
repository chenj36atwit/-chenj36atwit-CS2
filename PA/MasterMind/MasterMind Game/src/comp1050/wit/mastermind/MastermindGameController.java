//@Jacky Chen
//@April 14 2022

package comp1050.wit.mastermind;


public class MastermindGameController {
    private MastermindGUI gui;
    private MastermindGameModel gameModel;

    public MastermindGameController() {
        gui = new MastermindGUI(this);
        gameModel = new MastermindGameModel();
    }

    public void startGame() {
        gui.initialize();
    }

    public void submitGuess(String[] selectedColors) {
        // Check the guess and provide feedback
        String feedback = gameModel.checkGuess(selectedColors);
        gui.updateFeedback(feedback);

        // Check for game over or continue playing
        if (feedback.equals("BBBB")) {
            gui.displayMessage("Congratulations! You guessed the correct code.");
        } else if (gameModel.isGameOver()) {
            gui.displayMessage("Game over. You couldn't guess the code. The correct code was: " + gameModel.getSecretCode());
        }
    }
}