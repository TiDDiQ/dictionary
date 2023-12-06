package com.uetoop.main.Dic_main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import com.uetoop.main.Google;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class googleController {
    @FXML
    private TextField inputText;

    @FXML
    private Text firstLang;

    @FXML
    private Text secondLang;

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
            if (firstLang.getText().equals("English")) {
                resultText.setText(google.translate(currentWord));
            } else {
                resultText.setText(google.dichTu(currentWord));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void translateSwap(ActionEvent event) {
        String tmp = firstLang.getText();
        firstLang.setText(secondLang.getText());
        secondLang.setText(tmp);
        inputText.clear();
        resultText.clear();
    }
}
