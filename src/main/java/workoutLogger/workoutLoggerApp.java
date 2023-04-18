package workoutLogger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class workoutLoggerApp extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Group root = new Group();
    // Scene scene = new Scene(root, Color.AQUAMARINE);
    primaryStage.setScene(
      new Scene(FXMLLoader.load(getClass().getResource("App1.fxml")))
    );

    primaryStage.setTitle("TDT4100: Workout Tracker");
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
