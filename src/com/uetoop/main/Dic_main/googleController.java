package com.uetoop.main.Dic_main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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
    private TextField resultText;

    @FXML
    private Button gtranslateButton;

    private Google google = new Google();

    @FXML
    void googleTranslateInit(ActionEvent event) {
        String currentWord = inputText.getText();
        try {
            resultText.setText(google.translate(currentWord));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
