package workoutLogger.Model;

public interface ExerciseInterface {
  String getName();

  void logSet(int reps, double weight);

  double getVolume();

  int[] getPR();
}
