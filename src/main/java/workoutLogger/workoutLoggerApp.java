package workoutLogger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class workoutLoggerApp extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("welcomeScene.fxml"));
    Scene scene1 = new Scene(root);

    primaryStage.setScene(scene1);

    primaryStage.setTitle("TDT4100: Workout Tracker");
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
