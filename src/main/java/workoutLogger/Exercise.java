package workoutLogger;

import java.util.ArrayList;
import java.util.List;

public class Exercise implements ExerciseInterface {

  private String name;
  private List<Integer> reps = new ArrayList<>();
  private List<Double> weight = new ArrayList<>();

  public List<Integer> getReps() {
    return new ArrayList<Integer>(this.reps);
  }

  public List<Double> getWeight() {
    return new ArrayList<Double>(this.weight);
  }

  private int[] PR = new int[2]; // [reps, weight]

  // TODO: Decide if PR is going to be an array of two numbers, or a single number for the weight.

  // Constructor for creating the workout
  public Exercise(String name) {
    if (name.length() >= 3) { // add check if exercise exists in save-data
      this.name = name;
    } else {
      throw new IllegalArgumentException(
        "Name too short, must be at least 3 characters"
      );
    }
  }

  // Constructor for restoring data from file. No error checking here, as we assume the user cannot go in and fuck with the files
  public Exercise(
    String name,
    List<Integer> reps,
    List<Double> weight
    // int[] pR  TODO: uncomment when done
  ) {
    this.name = name;
    this.reps = reps;
    this.weight = weight;
    // PR = pR; TODO: uncomment when done
  }

  public String toString() {
    return (
      this.name +
      " (Last workout): " +
      this.latestReps() +
      " reps @ " +
      this.latestWeight() +
      "kg"
    );
  }

  public int latestReps() {
    if (this.reps.size() < 1) {
      return 0;
    } else { // TODO: Handle if reps is zero
      return this.reps.get(this.reps.size() - 1);
    }
  }

  public double latestWeight() {
    if (this.weight.size() < 1) {
      return 0;
    } else {
      return this.weight.get(this.weight.size() - 1);
    }
  }

  @Override
  public void logSet(int reps, double weight) {
    this.logReps(reps);
    this.logWeight(weight);

    double vol = reps * weight;

    if (vol > (PR[0] * PR[1])) {
      this.PR[0] = reps;
      this.PR[1] = (int) weight; // TODO: FIX THIS !!
    }
  }

  @Override
  public String getName() {
    return this.name;
  }

  private void logReps(int reps) {
    if (reps >= 0) {
      this.reps.add(reps);
    } else {
      throw new IllegalArgumentException("Can't do negative reps!");
    }
  }

  private void logWeight(double weight) {
    if (weight > 0) {
      this.weight.add(weight);
    } else {
      throw new IllegalArgumentException("Can't do negative or zero weight!");
    }
  }

  @Override
  public double getVolume() {
    return this.latestWeight() * this.latestReps();
  }

  @Override
  public int[] getPR() {
    return this.PR;
  }
  //   public static void main(String[] args) {
  //     // Exercise bench = new Exercise("Bench Press");
  //     // // bench.logSet(10, 100000);
  //     // // bench.logSet(10, 53.5);
  //     // // System.out.println(bench.toString());
  //     // // System.out.println(bench.getPR()[1]);
  //     // int i = 0;
  //     // List<Exercise> exerciseList = new ArrayList<>();
  //     // while (i < 5) {
  //     //   String name = "exercise_" + i;
  //     //   exerciseList.add(new Exercise(name));
  //     //   i++;
  //     // }

  //     // System.out.println(exerciseList.get(2).getName());
  //   }
}
