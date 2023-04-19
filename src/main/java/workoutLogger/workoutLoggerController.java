package workoutLogger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class workoutLoggerController implements Initializable {

  @FXML
  private Label savedAlert;

  @FXML
  private TableView<Exercise> exerciseTable;

  @FXML
  private TableColumn<Exercise, String> nameColumn;

  @FXML
  private TableColumn<Exercise, String> latestSetColumn;

  @FXML
  private TableColumn<Exercise, Integer> repsColumn;

  @FXML
  private TableColumn<Exercise, Double> weightColumn;

  @FXML
  private ChoiceBox<String> workoutChoiceBox;

  private boolean hasSaved;

  @FXML
  public void saveWorkout(ActionEvent e) throws IOException {
    if (!hasSaved) {
      Exercise_db db = new Exercise_db(
        (new FileHandler()).loadExercises(
            "src/main/java/workoutLogger/exercises.csv"
          )
      );
      for (Exercise exercise : db.getDB()) {
        exercise.logSet(exercise.latestReps(), exercise.latestWeight() + 2.50);
      }
      FileHandler filehandler = new FileHandler();
      filehandler.save("src/main/java/workoutLogger/exercises.csv", db);
      savedAlert.setText("Saved!");
      this.hasSaved = true;
    }
  }

  public void switchToWelcomeScene(ActionEvent event) throws IOException {
    this.hasSaved = false;
    Stage stage;
    Parent root;
    Scene scene;
    root = FXMLLoader.load(getClass().getResource("welcomeScene.fxml"));
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

    // Populate Name column and last workout column:
    ObservableList<Exercise> data = FXCollections.observableArrayList(
      db.getDB()
    );
    exerciseTable.setItems(data);
    nameColumn.setCellValueFactory(cellData ->
      new SimpleObjectProperty<String>(cellData.getValue().getName())
    );

    latestSetColumn.setCellValueFactory(cellData -> {
      return new SimpleObjectProperty<String>(cellData.getValue().toString());
    });

    repsColumn.setCellValueFactory(cellData -> {
      return new SimpleObjectProperty<Integer>(
        cellData.getValue().latestReps()
      );
    });

    weightColumn.setCellValueFactory(cellData -> {
      return new SimpleObjectProperty<Double>(
        cellData.getValue().latestWeight() + 2.50
      );
    });
  }
}
