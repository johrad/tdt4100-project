package workoutLogger;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class workoutLoggerController implements Initializable {

  @FXML
  private Label mylabel1;

  @FXML
  private ChoiceBox<String> workoutChoiceBox;

  public void buttonPress(ActionEvent e) {
    mylabel1.setText("test");
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Exercise_db db = new Exercise_db(
      (new FileHandler()).loadExercises(
          "src/main/java/workoutLogger/exercises.csv"
        )
    );
    Workout myWorkout = new Workout("myWorkout");
    myWorkout.restoreExercises(db.getDB());

    workoutChoiceBox.getItems().addAll(myWorkout.getExerciseNameList());
  }
}
