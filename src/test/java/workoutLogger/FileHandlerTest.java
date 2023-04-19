package workoutLogger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class FileHandlerTest {

  @Test
  @DisplayName("Save a database")
  public void testSaveWithNonEmptyFilename() throws Exception {
    FileHandler fileHandler = new FileHandler();
    // create an exercise database with some data
    Exercise_db db = new Exercise_db();
    Exercise ex1 = new Exercise("ex1");
    Exercise ex2 = new Exercise("ex2");

    ex1.logSet(10, 120);
    ex2.logSet(20, 220);
    db.add(ex1);
    db.add(ex2);
    // save the database to the temporary file
    String path = "src/test/java/workoutLogger/test.csv";
    fileHandler.save(path, db);

    // load the saved exercises from the file
    Exercise_db loadedDb = new Exercise_db(
      (new FileHandler()).loadExercises(path)
    );
    Exercise ex1Loaded = loadedDb.get("ex1");
    Exercise ex2Loaded = loadedDb.get("ex2");
    assertEquals(120, ex1Loaded.latestWeight(), 0.01);
    assertEquals(20, ex2Loaded.latestReps(), 0);
  }
}
