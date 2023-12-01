package com.uetoop.main.JavaFXListView;

import com.uetoop.main.Dic_main.HelloController;
import com.uetoop.main.DictionaryDatabase;
import com.uetoop.main.Google;
import com.uetoop.main.TextSpeech;
import com.uetoop.main.Thesaurus;
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
import java.util.*;

public class ListViewController implements Initializable {


    Google google = new Google();
    DictionaryDatabase db = new DictionaryDatabase();
    TextSpeech tts = new TextSpeech();
    Thesaurus thesaurus = new Thesaurus();

    @FXML
    private Button ListSearchButton;

    @FXML
    private Button TextToSpeech;

    @FXML
    private TextField listViewSearchBar;

    @FXML
    private Label listViewSearchFound;

    @FXML
    private Label listViewSearchTranslation;

    @FXML
    private Label listViewSearchDescription;

    @FXML
    private Label listViewPronunciation;

    @FXML
    private Label listViewSynonyms;

    @FXML
    private Label listViewAntonyms;

    @FXML
    private ListView<String> dictionaryListView;

    ArrayList<String> words = db.showAllInArray();

    String currentWord = "";

    @FXML
    void searchButtonSubmit (ActionEvent event) {
        dictionaryListView.getItems().clear();
        dictionaryListView.getItems().addAll(searchList(listViewSearchBar.getText()));
    }

    @FXML
    void ttsButtonSubmit(ActionEvent event) {
        tts.textToSpeech(currentWord);
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
                listViewSearchDescription.setText(db.findDescription(currentWord));
                listViewPronunciation.setText(db.findPronounce("word", currentWord));
                listViewSynonyms.setText(thesaurus.extractSynonym(currentWord));
                listViewAntonyms.setText(thesaurus.extractAntonym(currentWord));
            }
        });
    }

    private List<String> searchList(String searchWord) {
        return db.showDatabaseLookalikeWordPageInArray(searchWord);
    }
}