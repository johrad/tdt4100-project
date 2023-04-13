package workoutLogger;

import java.util.ArrayList;
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
}
/* How to save workouts to file?
 *
 * Save a normal txt file with the names of each workout
 * Once populated all previously created exercises with loops of some kind. This will however not spawn objects (?)
 * Generate a Collection<Exercise> on each boot. How find a certain exercise tho? Keeping track of index is a big no-no
 * Dictionaries?
 *
 */
