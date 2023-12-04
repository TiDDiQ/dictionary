package com.quizz;

import com.uetoop.main.Dic_main.HelloController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class QuizController {
    @FXML
    private Button backButton; // Assume you have a "Back" button in quiz.fxml

    private HelloController helloApplication;

   @FXML
   public Label question;

   @FXML
    public Button opt1, opt2, opt3, opt4;

   int counter = 0;
   static int correct = 0;
   static int wrong = 0;
   @FXML
   private void initialize() {
        loadQuestion();

   }

   private void loadQuestion() {
       if(counter == 0) {
           question.setText("1. I am sorry that I can't ___ your invitation");
           opt1.setText("[A]. take");
           opt2.setText("[B]. except");
           opt3.setText("[C]. agree");
           opt4.setText("[D]. accept");
       }
       else if(counter == 1) {
           question.setText("2. It took us almost 4 hours to ___ to London");
           opt1.setText("[A]. reach");
           opt2.setText("[B]. arrive");
           opt3.setText("[C]. get");
           opt4.setText("[D]. approach");
       }
       else if(counter == 2) {
           question.setText("3. It’s difficult to ___ the difference between margarine and butter");
           opt1.setText("[A]. speak");
           opt2.setText("[B]. tell");
           opt3.setText("[C]. say");
           opt4.setText("[D]. look");
       }
       else if(counter == 3) {
           question.setText("4. I have never seen such a beautiful dress ___ you before");
           opt1.setText("[A]. of");
           opt2.setText("[B]. on");
           opt3.setText("[C]. for");
           opt4.setText("[D]. in");
       }
       else if(counter == 4) {
           question.setText("5. After graduating from university, I want to ____ my father's footsteps");
           opt1.setText("[A]. follow in");
           opt2.setText("[B]. succeed in");
           opt3.setText("[C]. go after");
           opt4.setText("[D]. keep up");
       }
       else if(counter == 5) {
           question.setText("6. His ___ had always been to become an architect");
           opt1.setText("[A]. ambition");
           opt2.setText("[B]. study");
           opt3.setText("[C]. imagination");
           opt4.setText("[D]. direction");
       }
       else if(counter == 6) {
           question.setText("7. Each of us must take ___ for our own actions");
           opt1.setText("[A]. probability");
           opt2.setText("[B]. ability");
           opt3.setText("[C]. possibility");
           opt4.setText("[D]. responsibility");
       }
       else if(counter == 7) {
           question.setText("8. John is ___ only child in his family so his parents love him a lot");
           opt1.setText("[A]. a");
           opt2.setText("[B]. an");
           opt3.setText("[C]. the");
           opt4.setText("[D]. no article");
       }
       else if(counter == 8) {
           question.setText("9. Peter tried his best and passed his driving test at the first ___");
           opt1.setText("[A]. try");
           opt2.setText("[B]. attempt");
           opt3.setText("[C]. doing");
           opt4.setText("[D]. aim");
       }
       else if(counter == 9) {
           question.setText("10. With greatly increased workloads, everyone is ___ pressure now");
           opt1.setText("[A]. under");
           opt2.setText("[B]. above");
           opt3.setText("[C]. upon");
           opt4.setText("[D]. out of");
       }


   }


   @FXML
   public void opt1clicked(ActionEvent event) {
        checkAnswer(opt1.getText().toString());
        if(checkAnswer(opt1.getText().toString())) {
            correct = correct + 1;
        }
        else {
            wrong = wrong + 1;
        }

        if(counter == 9) {
            try {
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.TRANSPARENT);
                scene.setFill(Color.WHITE);
                stage.show();
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestion();
        }
   }

    boolean checkAnswer(String answer) {
       if(counter == 0) {
           if(answer.equals("[A]. take")) {
               return true;
           } else {
               return false;
           }
       }
        if(counter == 1) {
            if(answer.equals("[C]. get")) {
                return true;
            } else {
                return false;
            }
        }
        if(counter == 2) {
            if(answer.equals("[B]. tell")) {
                return true;
            } else {
                return false;
            }
        }
        if(counter == 3) {
            if(answer.equals("[B]. on")) {
                return true;
            } else {
                return false;
            }
        }
        if(counter == 4) {
            if(answer.equals("[A]. follow in")) {
                return true;
            } else {
                return false;
            }
        }
        if(counter == 5) {
            if(answer.equals("[A]. ambition")) {
                return true;
            } else {
                return false;
            }
        }
        if(counter == 6) {
            if(answer.equals("[D]. responsibility")) {
                return true;
            } else {
                return false;
            }
        }
        if(counter == 7) {
            if(answer.equals("[C]. the")) {
                return true;
            } else {
                return false;
            }
        }
        if(counter == 8) {
            if(answer.equals("[B]. attempt")) {
                return true;
            } else {
                return false;
            }
        }
        if(counter == 9) {
            if(answer.equals("[A]. under")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @FXML
    public void opt2clicked(ActionEvent event) {
        checkAnswer(opt2.getText().toString());
        if(checkAnswer(opt2.getText().toString())) {
            correct = correct + 1;
        }
        else {
            wrong = wrong + 1;
        }

        if(counter == 9) {
            try {
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.TRANSPARENT);
                scene.setFill(Color.WHITE);
                stage.show();
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestion();
        }
    }
    @FXML
    public void opt3clicked(ActionEvent event) {
        checkAnswer(opt3.getText().toString());
        if(checkAnswer(opt3.getText().toString())) {
            correct = correct + 1;
        }
        else {
            wrong = wrong + 1;
        }

        if(counter == 9) {
            try {
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.TRANSPARENT);
                scene.setFill(Color.WHITE);
                stage.show();
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestion();
        }
    }
    @FXML
    public void opt4clicked(ActionEvent event) {
        checkAnswer(opt4.getText().toString());
        if(checkAnswer(opt4.getText().toString())) {
            correct = correct + 1;
        }
        else {
            wrong = wrong + 1;
        }

        if(counter == 9) {
            try {
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.TRANSPARENT);
                scene.setFill(Color.WHITE);
                stage.show();
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestion();
        }
    }



    public void setHelloApplication(HelloController helloController) {
       this.helloApplication = helloController;
    }
}


