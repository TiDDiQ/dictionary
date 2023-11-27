package com.uetoop.main.JavaFXListView;

import com.uetoop.main.DictionaryDatabase;
import com.uetoop.main.Google;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ListViewController implements Initializable {
    Google google = new Google();
    DictionaryDatabase db = new DictionaryDatabase();

    @FXML
    private Button ListSearchButton;

    @FXML
    private TextField listViewSearchBar;

    @FXML
    private Label listViewSearchFound;

    @FXML
    private Label listViewSearchTranslation;

    @FXML
    private ListView<String> dictionaryListView;

    ArrayList<String> words = db.showAllInArray();

    String currentWord;

    @FXML
    void searchButtonSubmit (ActionEvent event) {
        dictionaryListView.getItems().clear();
        dictionaryListView.getItems().addAll(searchList(listViewSearchBar.getText()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dictionaryListView.getItems().addAll(words);
        dictionaryListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                currentWord = dictionaryListView.getSelectionModel().getSelectedItem();
                listViewSearchFound.setText(currentWord);
                try {
                    listViewSearchTranslation.setText(google.translate(currentWord));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private List<String> searchList(String searchWord) {
        return db.showDatabaseLookalikeWordPageInArray(searchWord);
    }
}
