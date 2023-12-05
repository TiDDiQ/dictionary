package com.uetoop.main.Dic_main;

import com.uetoop.main.DictionaryDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteWordController {

    @FXML
    private Button CancelButton;

    @FXML
    private Button OKbutton;
    @FXML
    private TextField InputText;
    public static void setHelloApplication(HelloController helloController) {
    }

    DictionaryDatabase db1 = new DictionaryDatabase();
    private void removeDatabaseWord(String word) {

        word = InputText.getText();
        db1.removeDatabaseWord(word);

        // Display a success message using Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Word added successfully: " + word);
        alert.showAndWait();

    }



    @FXML
    private void closeWindow() {
        Stage stage = (Stage) OKbutton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void handleCancelButton(ActionEvent event) {
        // Close the Add Word window without saving
        closeWindow();
    }



    public void removeWord(ActionEvent actionEvent) {
    }
}
