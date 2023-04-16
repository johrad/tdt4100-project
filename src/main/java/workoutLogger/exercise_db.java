package workoutLogger;

import java.util.ArrayList;
import java.util.Collection;

public class exercise_db {

  private Collection<Exercise> exerciseCollection = new ArrayList<>();

  public void add(Exercise exercise) {
    this.exerciseCollection.add(exercise);
  }

  public Exercise get(String name) {
    Exercise ex = null;
    for (Exercise e : this.exerciseCollection) {
        if (e.getName().equalsIgnoreCase(name)) {
            ex = e;
        }
    }
    if (ex == null) {
        throw new IllegalAccessError("Workout not in database")
    } else {
        return ex;
    }
  }

  public static void main(String[] args) {
    Exercise ex1 = new Exercise("deadlift");
    Exercise ex2 = new Exercise("squat");
    Exercise ex3 = new Exercise("bench press");
    exercise_db database = new exercise_db();
    database.add(ex1);
    database.add(ex2);
    database.add(ex3);

    Exercise a = database.get("squat");
    System.out.println(a.toString());
  }
}
