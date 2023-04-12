package workoutLogger;

public interface ExerciseInterface {
  String getName();

  void logReps(int reps);

  void logWeight(double weight);

  double getVolume();

  Integer[] getPR();
}
