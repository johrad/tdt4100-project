package workoutLogger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
  private Label mylabel1;

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

  @FXML
  public void buttonPress(ActionEvent e) {
    mylabel1.setText("test");
  }

  public void switchToWelcomeScene(ActionEvent event) throws IOException {
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
    Workout myWorkout = new Workout("myWorkout");
    myWorkout.restoreExercises(db.getDB());

    workoutChoiceBox.getItems().addAll(myWorkout.getExerciseNameList());

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
