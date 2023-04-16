package workoutLogger;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileHandler {

  // Exercise csv format -> name, last weight, last reps, PR

  public void save(String filename) {}

  public void load(String filename) {
    BufferedReader reader = null;
    String line;

    try {
      reader = new BufferedReader(new FileReader(filename));
      while ((line = reader.readLine()) != null) {
        String[] row = line.split(",");
        for (String s : row) {
          System.out.println(s);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        reader.close();
      } catch (Exception e) {}
    }
  }

  public static void main(String[] args) {
    System.out.println("testing file handler: ");

    FileHandler saves = new FileHandler();
    saves.load("src/main/java/workoutLogger/exercises.csv");
  }
}
