package com.uetoop.main.Dic_main;

import com.uetoop.main.DictionaryDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    private DictionaryDatabase db1; // Declare the object here

    public void setHelloController(HelloController helloController) {
    }

    @FXML
    private void initialize() {
        db1 = new DictionaryDatabase(); // Initialize the object here
    }

    @FXML
    private void handleOkButton() {
        String word = inputWord.getText().trim();
        String pronun = inputPronunciation.getText().trim();
        String meaning = inputMeaning.getText().trim();

        if (!word.isEmpty() && !pronun.isEmpty() && !meaning.isEmpty()) {
            addDatabaseWord(word, pronun, meaning);


        } else {
            System.out.println("Error");
        }

    }

    private void closeWindow() {
        Stage stage = (Stage) Cancelbutton.getScene().getWindow();
        stage.close();
    }

    private void addDatabaseWord(String word, String pronunciation, String meaning) {
        db1.addDatabaseWord(word, pronunciation, meaning);

        // Display a success message using Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Word added successfully: " + word);
        alert.showAndWait();

    }



    @FXML
    private void closeWindow1() {
        Stage stage = (Stage) OKbutton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void handleCancelButton(ActionEvent event) {
        // Close the Add Word window without saving
        closeWindow();
    }

    public void setHelloApplication(HelloController helloController) {
    }
}
