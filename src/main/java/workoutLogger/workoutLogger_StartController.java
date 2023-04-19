package workoutLogger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class workoutLogger_StartController implements Initializable {

  @FXML
  private Label prText;

  private Stage stage;
  private Parent root;
  private Scene scene;

  public void switchToWelcomeScene(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("welcomeScene.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void switchToWorkoutScene(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("workoutScene.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Exercise_db db = new Exercise_db(
      (new FileHandler()).loadExercises(
          "src/main/java/workoutLogger/exercises.csv"
        )
    );
    for (Exercise ex : db.getDB()) {
      String s =
        ex.getName() +
        " PR:" +
        ex.getPR().get(0) +
        "reps @ " +
        ex.getPR().get(1);
    }
  }
}
