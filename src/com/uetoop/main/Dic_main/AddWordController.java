package com.uetoop.main.Dic_main;

import com.uetoop.main.DictionaryDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class AddWordController {

    @FXML
    private Button Cancelbutton;

    @FXML
    private Button OKbutton;

    @FXML
    private TextField inputMeaning;

    @FXML
    private TextField inputPronunciation;

    @FXML
    private TextField inputWord;

    private DictionaryDatabase db1;

    public void setHelloController(HelloController helloController) {
    }

    @FXML
    private void initialize() {
        db1 = new DictionaryDatabase();
    }

    @FXML
    private void handleOkButton() {
        String word = inputWord.getText().trim();
        String pronun = inputPronunciation.getText().trim();
        String meaning = inputMeaning.getText().trim();

        if (!word.isEmpty() && !pronun.isEmpty() && !meaning.isEmpty()) {
            db1.addDatabaseWord(word, pronun, meaning);
        } else {
            System.out.println("Error");
        }
        //OKbutton.setOnAction();

    }

    @FXML
    public void isCancelButton(ActionEvent event){
        Cancelbutton.setCancelButton(true);
    }

    public void setHelloApplication(HelloController helloController) {
    }
}
