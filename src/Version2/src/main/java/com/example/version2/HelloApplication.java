package com.example.version2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{//hàm hiển thị giao diện trong runtime
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Dictionary.fxml"));
        primaryStage.setTitle("Dictionary");
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}