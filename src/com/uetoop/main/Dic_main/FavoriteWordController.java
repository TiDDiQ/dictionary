package com.uetoop.main.Dic_main;

import com.uetoop.main.DictionaryDatabase;
import com.uetoop.main.TextSpeech;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FavoriteWordController implements Initializable {
    DictionaryDatabase db = new DictionaryDatabase();
    TextSpeech tts = new TextSpeech();
    String currentWord;

    @FXML
    private TextField InputText;

    @FXML
    private Label listViewPronunciation;

    @FXML
    private Label listViewSearchDescription;

    @FXML
    private Label listViewSearchFound;

    @FXML
    private Button searchButton;

    @FXML
    private TextField listViewSearchBar;

    @FXML
    private ListView<String> Listview;

    ArrayList<String> favWords = db.showAllFavouriteWordsInArray();

    public static void setHelloApplication(HelloController helloController) {
    }

    @FXML
    void searchButtonSubmit (ActionEvent event) {
        Listview.getItems().clear();
        Listview.getItems().addAll(searchList(listViewSearchBar.getText()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Listview.getItems().addAll(favWords);
        Listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                currentWord = Listview.getSelectionModel().getSelectedItem();
                listViewSearchFound.setText(currentWord);
                listViewSearchDescription.setText(db.findDescription(currentWord));
                listViewPronunciation.setText(db.findPronounce("word", currentWord));
            }
        });
    }

    public void deleteFavouriteWord(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("DeleteFavouriteWord.fxml"));
            Parent root2 = loader2.load();
            DeleteFavouriteWordController deleteWordFavouriteController = loader2.getController();
            deleteWordFavouriteController.setApplication(this);

            Stage removeStage = new Stage();
            removeStage.setTitle("DeleteWord");


            removeStage.setScene(new Scene(root2));


            removeStage.initModality(Modality.APPLICATION_MODAL);

            removeStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> searchList(String searchWord) {
        return db.showDatabaseLookalikeWordFavouriteInArray(searchWord);
    }
}
