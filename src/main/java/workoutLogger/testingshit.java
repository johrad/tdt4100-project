package workoutLogger;

import java.util.ArrayList;
import java.util.Random;

public class testingshit {

  public static void main(String[] args) {
    // Exercise_db db = new Exercise_db(
    //   (new FileHandler()).loadExercises(
    //       "src/main/java/workoutLogger/exercises.csv"
    //     )
    // );
    // for (Exercise ex : db.getDB()) {
    //   String s =
    //     ex.getName() +
    //     " PR:" +
    //     ex.getPR().get(0) +
    //     "reps @ " +
    //     ex.getPR().get(1);
    //   System.out.println(s);
    // }
    // FileHandler filehandler = new FileHandler();
    // filehandler.save("src/main/java/workoutLogger/exercises.csv", db);

    // FileHandler fileHandler = new FileHandler();
    // // create an exercise database with some data
    // Exercise_db db = new Exercise_db();
    // Exercise ex1 = new Exercise("ex1");
    // Exercise ex2 = new Exercise("ex2");

    // ex1.logSet(10, 120);
    // ex2.logSet(20, 220);
    // // save the database to the temporary file
    // String path = "src/test/java/workoutLogger/test.csv";
    // fileHandler.save(path, db);

    // // load the saved exercises from the file
    // Exercise_db loadedDb = new Exercise_db(
    //   (new FileHandler()).loadExercises(path)
    // );
    // Exercise ex1Loaded = loadedDb.get("ex1");

    Exercise_db db = new Exercise_db(
      (new FileHandler()).loadExercises(
          "src/main/java/workoutLogger/exercises.csv"
        )
    );

    // Get random PR on start screen:
    Exercise ex = new ArrayList<Exercise>(db.getDB())
      .get(new Random().nextInt(db.getDB().size()));
    String s =
      ex.getName() +
      " PR: " +
      ex.getPR().get(0) +
      "reps @ " +
      ex.getPR().get(1);
    System.out.println(s);
  }
}
