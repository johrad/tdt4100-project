package workoutLogger;

public class testingshit {

  public static void main(String[] args) {
    Exercise_db db = new Exercise_db(
      (new FileHandler()).loadExercises(
          "src/main/java/workoutLogger/exercises.csv"
        )
    );
    Workout myWorkout = new Workout("myWorkout");
    myWorkout.restoreExercises(db.getDB());
    myWorkout.getExerciseNameList();

    for (String s : myWorkout.getExerciseNameList()) {
      System.out.println(s);
    }
  }
}
