package workoutLogger;

import java.util.ArrayList;
import java.util.List;

public class Exercise implements ExerciseInterface {

  private String name;
  private List<Integer> reps = new ArrayList<>();
  private List<Double> weight = new ArrayList<>();
  private List<Double> PR = new ArrayList<>(); // [reps, weight]

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
    List<Double> weight,
    List<Double> pR
  ) {
    this.name = name;
    this.reps = reps;
    this.weight = weight;
    this.PR = pR;
  }

  public List<Integer> getReps() {
    return new ArrayList<Integer>(this.reps);
  }

  public List<Double> getWeight() {
    return new ArrayList<Double>(this.weight);
  }

  public String toString() {
    return (this.latestReps() + " reps @ " + this.latestWeight() + "kg");
  }

  public int latestReps() {
    if (this.reps.size() < 1) {
      return 0;
    } else {
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

    if (vol > (PR.get(0) * PR.get(1))) {
      this.PR.set(0, Double.valueOf(reps));
      this.PR.set(1, weight);
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
  public List<Double> getPR() {
    return this.PR;
  }
}
