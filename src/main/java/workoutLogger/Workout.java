package workoutLogger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Workout {

  private final String workoutName;
  private List<Exercise> exercises = new ArrayList<>();

  public Workout(String workoutName) {
    if (workoutName.length() >= 3) { // add check if workout exists in save-data
      this.workoutName = workoutName;
    } else {
      throw new IllegalArgumentException(
        "Name too short, must be at least 3 characters"
      );
    }
  }

  public void restoreExercises(Collection<Exercise> exercises) {
    if (!exercises.isEmpty()) {
      for (Exercise e : exercises) {
        this.addExercise(e);
      }
    } else {
      throw new IllegalArgumentException("Array of exercises is empty!");
    }
  }

  public Exercise getExercise(int index) {
    return this.exercises.get(index);
  }

  public void addExercise(Exercise exercise) {
    // add error checking
    this.exercises.add(exercise);
  }

  public String getName() {
    return this.workoutName;
  }

  public List<String> getExerciseNameList() {
    List<String> str = new ArrayList<>();

    for (Exercise exercise : this.exercises) {
      str.add(exercise.getName());
    }
    return str;
  }
  // public static void main(String[] args) {
  //   Exercise bench = new Exercise("Bench");
  //   Exercise bench1 = new Exercise("Bench2");
  //   Exercise bench3 = new Exercise("Bench3");

  //   Workout w = new Workout("test workout");
  //   w.addExercise(bench);
  //   w.addExercise(bench1);
  //   w.addExercise(bench3);

  //   for (String s : w.getExerciseNameList()) {
  //     System.out.println(s);
  //   }}
}
