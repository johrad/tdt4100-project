package workoutLogger;

import java.util.List;

public interface ExerciseInterface {
  String getName();

  void logSet(int reps, double weight);

  double getVolume();

  List<Double> getPR();
}
