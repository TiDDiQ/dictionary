package com.uetoop.main.Dic_main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class FavWordConfirmController {

    @FXML
    private Button Cancelbutton;

    public void favWordConfirmController(FavWordConfirmController favWordConfirmController) {
    }

    public void setHelloApplication(HelloController helloController) {

    }

    public void handleCancelButton(ActionEvent actionEvent) {
        Stage stage = (Stage) Cancelbutton.getScene().getWindow();
        stage.close();
    }
}
