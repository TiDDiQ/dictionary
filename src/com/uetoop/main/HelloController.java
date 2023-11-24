package com.uetoop.main;

import com.uetoop.main.DictionaryDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {


    @FXML
    private Button ButtonSound;

    @FXML
    private Button favouriteWord;

    @FXML
    private Button Button;

    @FXML
    private TextField inputText;

    @FXML
    private Label labelResult;

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
//
//    @FXML
//    void ClickSound(ActionEvent event) {
//
//
//    }

}


