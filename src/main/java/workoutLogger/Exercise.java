package workoutLogger;

import java.util.ArrayList;
import java.util.List;

public class Exercise implements ExerciseInterface {

  private final String name;
  private List<Integer> reps = new ArrayList<>();
  private List<Double> weight = new ArrayList<>();

  public Exercise(String name) {
    if (name.length() >= 3) {
      this.name = name;
    } else {
      throw new IllegalArgumentException(
        "Name too short, must be at least 3 characters"
      );
    }
  }

  public String toString() {
    return (
      this.name +
      " (Last workout): " +
      this.prevReps() +
      " reps @ " +
      this.prevWeight()
    );
  }

  private int prevReps() {
    return this.reps.get(this.reps.size() - 1);
  }

  private double prevWeight() {
    return this.weight.get(this.weight.size() - 1);
  }

  @Override
  public String getName() {
    return this.name;
  }

  //
  // TODO:  Feilhåndtering here??
  //
  @Override
  public void logReps(int reps) {
    if (reps >= 0) {
      this.reps.add(reps);
    } else {
      throw new IllegalArgumentException("Can't do negative reps!");
    }
  }

  @Override
  public void logWeight(double weight) {
    if (weight > 0) {
      this.weight.add(weight);
    } else {
      throw new IllegalArgumentException("Can't do negative or zero weight!");
    }
  }

  @Override
  public double getVolume() {}

  @Override
  public Integer[] getPR() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPR'");
  }

  public static void main(String[] args) {
    System.out.println("compiled without errors !");
  }
}
