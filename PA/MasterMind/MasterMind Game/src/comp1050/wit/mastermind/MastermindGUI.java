//@Jacky Chen
//@April 14 2022

package comp1050.wit.mastermind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MastermindGUI {
    private JFrame frame;
    private JButton[] colorButtons;
    private JButton submitButton;
    private JTextField[] guessFields;
    private JLabel feedbackLabel;
    private MastermindGameController gameController;

    public MastermindGUI(MastermindGameController gameController) {
        this.gameController = gameController;
    }

    public void initialize() {
        frame = new JFrame("Mastermind");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize other components, layout, and set up the frame
        JPanel panel = new JPanel(new GridLayout(4, 0));

        // Example: Create color buttons
        createColorButtons();
        panel.add(createColorButtonsPanel());

        // Example: Create submit button
        createSubmitButton();
        panel.add(createSubmitButtonPanel());

        // Example: Create guess input fields
        createGuessFields();
        panel.add(createGuessFieldsPanel());

        // Example: Create feedback label
        createFeedbackLabel();
        panel.add(feedbackLabel);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createColorButtonsPanel() {
        JPanel colorPanel = new JPanel();
        for (JButton button : colorButtons) {
            colorPanel.add(button);
        }
        return colorPanel;
    }

    private void createColorButtons() {
        colorButtons = new JButton[6];
        String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange", "Pink"};

        for (int i = 0; i < colors.length; i++) {
            JButton button = new JButton(colors[i]);
            button.addActionListener(new ColorButtonListener(colors[i]));
            colorButtons[i] = button;
        }
    }

    private JPanel createSubmitButtonPanel() {
        JPanel submitPanel = new JPanel();
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        submitPanel.add(submitButton);
        return submitPanel;
    }

    private void createSubmitButton() {
        // Additional setup for the submit button if needed
    }

    private JPanel createGuessFieldsPanel() {
        JPanel guessPanel = new JPanel();
        guessFields = new JTextField[4];

        for (int i = 0; i < guessFields.length; i++) {
            JTextField field = new JTextField(5);
            guessFields[i] = field;
            guessPanel.add(field);
        }

        return guessPanel;
    }

    private void createGuessFields() {
        // Additional setup for the guess input fields if needed
    }

    private void createFeedbackLabel() {
        feedbackLabel = new JLabel("Feedback will be displayed here");
    }

    public void updateFeedback(String feedback) {
        feedbackLabel.setText("Feedback: " + feedback);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    private class ColorButtonListener implements ActionListener {
        private String color;

        ColorButtonListener(String color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle color button click
            JButton sourceButton = (JButton) e.getSource();
            // Optionally update some visual representation
            // For simplicity, let's update the text of the corresponding guess field
            for (JTextField field : guessFields) {
                if (field.getText().isEmpty()) {
                    field.setText(color);
                    break;
                }
            }
        }
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the selected colors from the input fields
            String[] selectedColors = new String[4];
            for (int i = 0; i < guessFields.length; i++) {
                selectedColors[i] = guessFields[i].getText();
            }

            // Pass the selected colors to the controller for processing
            gameController.submitGuess(selectedColors);

            // Clear the guess input fields
            for (JTextField field : guessFields) {
                field.setText("");
            }
        }
    }
}