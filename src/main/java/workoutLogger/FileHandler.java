package workoutLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileHandler {

  // Exercise csv format -> name, last weight, last reps, PR

  private String createFile(String fileName) {
    String filePath = fileName; //"src/main/java/workoutLogger/" + fileName + ".csv";
    try {
      File newFile = new File(filePath);
      if (newFile.createNewFile()) {
        System.out.println(newFile.getName() + " Was created");
      } else {
        System.out.println(newFile.getName() + " already exists");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return filePath;
  }

  public void save(String filename, Exercise_db database) {
    if (!(filename.isEmpty()) && !(database.getDB().isEmpty())) {
      String filePath = this.createFile(filename);
      try {
        List<String> lines = Files.readAllLines(
          Paths.get(filePath),
          StandardCharsets.UTF_8
        );
        // Copying to avoid 'java.util.ConcurrentModificationException'
        List<String> LinesToWrite = new ArrayList<>(lines);

        for (Exercise exercise : database.getDB()) {
          String toWrite =
            exercise.getName() +
            ";" +
            this.buildStringList(exercise.getReps()) +
            ";" +
            this.buildStringList(exercise.getWeight()) +
            ";" +
            this.buildStringList(exercise.getPR());
          boolean foundLine = false;
          for (int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {
            String line = lines.get(lineNumber);
            if (line.split(";")[0].equals(exercise.getName().trim())) {
              System.out.println("Found something to overwrite!");
              LinesToWrite.set(lineNumber, toWrite);
              foundLine = true;
              break; // no need to check the rest of the lines
            }
          }
          if (!foundLine) {
            LinesToWrite.add(toWrite);
          }
        }
        // Write new String[] to file:
        Files.write(Paths.get(filePath), LinesToWrite, StandardCharsets.UTF_8);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        try {} catch (Exception e) {
          // TODO: handle exception
        }
      }
    }
  }

  public Collection<Exercise> loadExercises(String filename) {
    // filename = filename + ".csv";
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
        List<Double> PR = strToListDouble(row[3]);

        // adding loaded exercises to collection:
        coll.add(new Exercise(name, reps, weight, PR));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        reader.close();
      } catch (Exception e) {
        System.out.println("cant close???");
      }
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

  private String buildStringList(List list) { // Ref generic type because can be Integer or Double
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
      if (i != list.size() - 1) {
        sb.append(",");
      }
    }
    sb.append("]");
    return sb.toString();
  }
}
