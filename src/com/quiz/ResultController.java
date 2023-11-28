package com.quiz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultController {

    @FXML
    private Label marks, markstext;

    @FXML
    private void initialize() {
        marks.setText(QuizController.correct + "/10");
        int correct = QuizController.correct;

        if(correct < 2) {
            markstext.setText("Oh no! You have failed the quiz ! You need to improve your grammar");
        }
        else if(correct >= 2 && correct < 5) {
            markstext.setText("Oops! You have scored less marks. It seems like you need to improve your general knowledge");
        } else if(correct >= 5 && correct <= 7) {
            markstext.setText("Good! A bit more improvement might have you to get better result.");
        } else if(correct == 8 || correct == 9 ) {
            markstext.setText("Congratulations! This is your hardwork and dedication which help you to reach the zenith of success");
        } else if(correct == 10) {
            markstext.setText("Congratulations! You have passed the quiz with full marks!");
        }
    }
}
