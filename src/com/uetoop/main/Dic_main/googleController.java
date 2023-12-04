package com.uetoop.main.Dic_main;

import com.uetoop.main.Google;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class googleController {
    @FXML
    private TextField inputText;

    @FXML
    private AnchorPane gg;

    @FXML
    private Label resultText;

    private Google google = new Google();


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Assuming you want to trigger translation when the application starts
        String currentWord = inputText.getText();

        try {
            String meaning = setText(google.translate(currentWord));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Assuming you have a method to set the text in your resultText
    private String setText(String translation) {
        resultText.setText(translation);
        return translation;
    }
}
