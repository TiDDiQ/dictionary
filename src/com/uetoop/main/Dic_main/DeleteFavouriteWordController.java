package com.uetoop.main.Dic_main;

import com.uetoop.main.DictionaryDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteFavouriteWordController {
    @FXML
    private Button CancelButton;

    @FXML
    private Button OKbutton;

    @FXML
    private TextField InputText;

    private DictionaryDatabase db1 = new DictionaryDatabase();

    public static void setApplication(FavoriteWordController favoriteWordController) {
    }

    @FXML
    private void handleOkbutton() {
        String word = InputText.getText();
        if (!word.isEmpty()) {
            RemoveDatabaseWord(word);
        }
    }

    private void RemoveDatabaseWord(String word) {
        db1.removeFavouriteWord(word);

        // Display a success message using Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Word removed successfully: " + word);
        alert.showAndWait();
    }

    @FXML
    private void closeWindow() {
        Stage stage = (Stage) OKbutton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        // Close the Delete Word window without saving
        closeWindow();
    }
}
