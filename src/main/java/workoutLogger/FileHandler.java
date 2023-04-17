package workoutLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileHandler {

  // Exercise csv format -> name, last weight, last reps, PR

  public void createdb(String fileName) {
    try {
      File newFile = new File(
        "src/main/java/workoutLogger/" + fileName + ".csv"
      );

      if (newFile.createNewFile()) {
        System.out.println(newFile.getName() + " Was created");
      } else {
        System.out.println(newFile.getName() + " already exists");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void save(String filename, Exercise_db database) {
    if (!(filename.isEmpty()) && !(database.getDB().isEmpty())) {}
  }

  public Collection<Exercise> loadExercises(String filename) {
    BufferedReader reader = null;
    String line;
    Collection<Exercise> coll = new ArrayList<>();

    try {
      reader = new BufferedReader(new FileReader(filename));
      while ((line = reader.readLine()) != null) {
        String[] row = line.split(";");
        String name = row[0];
        List<Integer> reps = strToListInt(row[1]);
        List<Double> weight = strToListDouble(row[2]);
        // Double pr = Double.parseDouble(row[3].trim()); // TODO: fix PR stuff here
        // adding loaded exercises to collection:
        coll.add(new Exercise(name, reps, weight));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        reader.close();
      } catch (Exception e) {}
    }

    return coll;
  }

  // Helper function to make code cleaner. Converts a string like [12,31,4,5,1,2] into a List of Integers.
  private List<Integer> strToListInt(String str) {
    str = str.substring(1, str.length() - 1); // Remove the square brackets

    String[] strArr = str.split(",");
    List<Integer> intList = new ArrayList<>();

    for (String s : strArr) {
      intList.add(Integer.parseInt(s.trim())); // s.trim() removes any spaces.
    }
    return intList;
  }

  // Helper function to make code cleaner. Converts a string like [12.4,32.4,2.3] into a List of Doubles.
  private List<Double> strToListDouble(String str) {
    str = str.substring(1, str.length() - 1); // Remove the square brackets

    String[] strArr = str.split(",");
    List<Double> DoubleList = new ArrayList<>();

    for (String s : strArr) {
      DoubleList.add(Double.parseDouble(s.trim())); // s.trim() removes any spaces.
    }

    return DoubleList;
  }

  public static void main(String[] args) {
    System.out.println("testing file handler: ");

    FileHandler saves = new FileHandler();

    Exercise_db db = new Exercise_db(
      saves.loadExercises("src/main/java/workoutLogger/exercises.csv")
    );
    Exercise squat = db.get("squat");
    System.out.println(squat.toString());
  }
}
