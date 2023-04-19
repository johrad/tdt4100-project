package workoutLogger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class workoutLoggerController {

  @FXML
  private Label mylabel1;

  public void buttonPress(ActionEvent e) {
    mylabel1.setText("cock");
  }
}
