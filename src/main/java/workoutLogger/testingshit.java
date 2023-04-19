package workoutLogger;

public class testingshit {

  public static void main(String[] args) {
    Exercise_db db = new Exercise_db(
      (new FileHandler()).loadExercises(
          "src/main/java/workoutLogger/exercises.csv"
        )
    );
    for (Exercise ex : db.getDB()) {
      String s =
        ex.getName() +
        " PR:" +
        ex.getPR().get(0) +
        "reps @ " +
        ex.getPR().get(1);
      System.out.println(s);
    }
    // FileHandler filehandler = new FileHandler();
    // filehandler.save("src/main/java/workoutLogger/exercises.csv", db);
  }
}
