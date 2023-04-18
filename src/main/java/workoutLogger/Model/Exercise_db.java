package workoutLogger.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Exercise_db {

  private Collection<Exercise> exerciseCollection = new ArrayList<>();

  public Exercise_db() {
    // Empty constructor for initializing the first database
  }

  public Exercise_db(Collection<Exercise> coll) {
    if (!coll.isEmpty()) {
      this.exerciseCollection = coll;
    } else {
      throw new IllegalArgumentException(
        "The collection you are trying to load is empty."
      );
    }
  }

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
      throw new IllegalArgumentException("Workout not in database");
    } else {
      return ex;
    }
  }

  public void remove(Exercise exercise) {
    if (this.exerciseCollection.contains(exercise)) {
      this.exerciseCollection.remove(exercise);
    } else {
      throw new IllegalArgumentException("Exercise not in list, cannot remove");
    }
  }

  public Collection<Exercise> getDB() {
    return (new ArrayList<>(this.exerciseCollection)); // Returns a copy of the list. such that the user cannot mess anything up in it.
  }

  public static void main(String[] args) {
    Exercise ex1 = new Exercise("deadlift");
    Exercise ex2 = new Exercise("squat");
    Exercise ex3 = new Exercise("bench press");
    Exercise_db database = new Exercise_db();
    database.add(ex1);
    database.add(ex2);
    database.add(ex3);

    Exercise a = database.get("squat");
    System.out.println(a.toString());
  }
}
