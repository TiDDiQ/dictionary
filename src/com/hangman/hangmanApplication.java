package com.hangman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class hangmanApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(hangmanApplication.class.getResource("Hangman.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        //stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
