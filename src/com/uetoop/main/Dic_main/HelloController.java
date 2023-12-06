    package com.uetoop.main.Dic_main;

    import com.quizz.QuizController;
    import com.uetoop.main.DictionaryDatabase;
    import com.uetoop.main.Google;
    import com.uetoop.main.TextSpeech;
    import com.uetoop.main.Thesaurus;
    import javafx.beans.value.ChangeListener;
    import javafx.beans.value.ObservableValue;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.*;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.Node;
    import javafx.stage.Modality;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.net.URL;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.ResourceBundle;


    public class HelloController implements Initializable {

        @FXML
        private Button Addword;

        @FXML
        private Button ButtonSound;


        @FXML
        private Button buttonQuizGame;

        @FXML
        private ImageView AddImage;

        @FXML
        private ImageView dic;


        @FXML
        private TextField inputText;

        @FXML
        private Label labelResult;

        private Parent root;
        private Parent root1;
        DictionaryDatabase db = new DictionaryDatabase();


        @FXML
        void onSubmit(ActionEvent event) {
            String userInput = inputText.getText().trim();
            if (!userInput.isEmpty()) {
                String meaning = db.findDescription(userInput);

                if (!meaning.isEmpty()) {
                    labelResult.setText("Meaning: " + meaning);
                } else {
                    labelResult.setText("Meaning not found.");
                }
            } else {
                labelResult.setText("Please enter a word.");
            }

        }



        @FXML
        void QuizGameButton(ActionEvent event) throws IOException {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("src/com/quizz/quiz.fxml"));
                root = fxmlLoader.load();
                QuizController quizController = fxmlLoader.getController();
                quizController.setHelloApplication(this);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Google google = new Google();

        TextSpeech tts = new TextSpeech();
        Thesaurus thesaurus = new Thesaurus();


        @FXML
        private Button TextToSpeech;


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
        private Button FavouriteWord;

        @FXML
        private ListView<String> dictionaryListView;

        ArrayList<String> words = db.showAllInArray();

        String currentWord = "";

        @FXML
        void searchButtonSubmit(ActionEvent event) {
            dictionaryListView.getItems().clear();
            dictionaryListView.getItems().addAll(searchList(inputText.getText()));
        }

        @FXML
        void ttsButtonSubmit(ActionEvent event) {
            tts.textToSpeech(currentWord);
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            /**
             *  Image i = new Image("com/uetoop/main/Dic_main/add2.png");
             *             ImageView iw = new ImageView(i);
             *             Addword.setGraphic(iw);
             *             iw.setFitHeight(40);
             *             iw.setFitWidth(40);
             */

            dictionaryListView.getItems().addAll(words);
            dictionaryListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                    currentWord = dictionaryListView.getSelectionModel().getSelectedItem();
                    listViewSearchFound.setText(currentWord);
               /*   try {
                        listViewSearchTranslation.setText(google.translate(currentWord));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                 */
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

        private Parent root2;


        public void AddWord(ActionEvent event) throws IOException {
            try {
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("AddWord.fxml"));
                root2 = loader1.load();
                AddWordController addWordController = loader1.getController();
                addWordController.setHelloApplication(this);

                Stage addWordStage = new Stage();
                addWordStage.setTitle("Add Word");


                addWordStage.setScene(new Scene(root2));


                addWordStage.initModality(Modality.APPLICATION_MODAL);

                addWordStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public void DeleteWord(ActionEvent event) throws IOException {
            try {
                FXMLLoader loader2 = new FXMLLoader(getClass().getResource("DeleteWord.fxml"));
                root2 = loader2.load();
                DeleteWordController deleteWordController = loader2.getController();
                DeleteWordController.setHelloApplication(this);

                Stage removeStage = new Stage();
                removeStage.setTitle("DeleteWord");


                removeStage.setScene(new Scene(root2));


                removeStage.initModality(Modality.APPLICATION_MODAL);

                removeStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    @FXML
    private Button favoriteButton;

        public void favoriteWord(ActionEvent event) throws IOException {
            String word = currentWord.trim();
            if(!word.isEmpty()){
                db.addFavouriteWord(word);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Word added successfully: " + word);
                alert.showAndWait();
            } else {
                System.out.println("Error");
            }
        }


    }














