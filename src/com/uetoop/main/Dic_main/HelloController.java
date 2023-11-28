package com.uetoop.main.Dic_main;

import com.quiz.QuizController;
import com.uetoop.main.DictionaryDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {


    @FXML
    private Button ButtonSound;


    @FXML
    private Button buttonQuizGame;

    @FXML
    private ImageView dic;

    @FXML
    private Button favouriteWord;

    @FXML
    private TextField inputText;

    @FXML
    private Label labelResult;

    private Parent root;
    DictionaryDatabase db = new DictionaryDatabase();

    @FXML
    void onSubmit(ActionEvent event) {
        String userInput = inputText.getText().trim();
        if (!userInput.isEmpty()) {
            String meaning = db.findDescription(userInput);

            if (!meaning.isEmpty()) {
                labelResult.setText("Meaning: " + meaning);
            } else {
                labelResult.setText("Meaning not found.");
            }
        } else {
            labelResult.setText("Please enter a word.");
        }

    }


    @FXML
    void QuizGameButton(ActionEvent event) throws  IOException{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/quiz/quiz.fxml"));
            root = fxmlLoader.load();
            QuizController quizController = fxmlLoader.getController();
            quizController.setHelloApplication(this);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}


