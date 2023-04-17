package workoutLogger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

  // Exercise csv format -> name, last weight, last reps, PR

  public void save(String filename) {}

  public void loadExercises(String filename) {
    BufferedReader reader = null;
    String line;

    try {
      reader = new BufferedReader(new FileReader(filename));
      while ((line = reader.readLine()) != null) {
        String[] row = line.split(";");
        String name = row[0];
        List<Integer> reps = strToListInt(row[1]);
        List<Double> weight = strToListDouble(row[2]);
        Double pr = Double.parseDouble(row[3].trim());
        // adding loaded exercises to database:
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        reader.close();
      } catch (Exception e) {}
    }
  }

  private List<Integer> strToListInt(String str) {
    str = str.substring(1, str.length() - 1); // Remove the square brackets

    String[] strArr = str.split(",");
    List<Integer> intList = new ArrayList<>();

    for (String s : strArr) {
      intList.add(Integer.parseInt(s.trim())); // s.trim() removes any spaces.
    }
    return intList;
  }

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
    saves.loadExercises("src/main/java/workoutLogger/exercises.csv");
  }
}
