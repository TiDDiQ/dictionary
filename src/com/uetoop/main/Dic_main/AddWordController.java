package com.uetoop.main.Dic_main;

import com.uetoop.main.DictionaryDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddWordController {

    @FXML
    private Button cancelButton;

    @FXML
    private Button okButton;

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
    }

    public void setHelloApplication(HelloController helloController) {
    }
}
