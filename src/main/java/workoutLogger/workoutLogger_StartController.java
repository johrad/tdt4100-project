package workoutLogger;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class workoutLogger_StartController {

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
}
