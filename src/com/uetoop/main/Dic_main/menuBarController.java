package com.uetoop.main.Dic_main;

import com.quizz.QuizController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class menuBarController implements Initializable {
    @FXML
    private BorderPane mainPane;

    @FXML
    private Button GoogleButton;

    @FXML
    private Button Fbutton;

    @FXML
    private Button dicButton;

    @FXML
    private Button hangmanButton;

    @FXML
    private Button quizButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void handleButton1Action(ActionEvent event) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("MainDic.fxml"));
                mainPane.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleButton2Action(ActionEvent event) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("google.fxml"));
            mainPane.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleButton3Action(ActionEvent event) throws IOException {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("/com/quizz/quiz.fxml"));
            mainPane.setCenter(view);

            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    @FXML
    void handleButton4Action(ActionEvent event) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("/com/hangman/Hangman.fxml"));
            mainPane.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void handleButton5Action(ActionEvent event) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("FavoriteWord.fxml"));
            mainPane.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    }

