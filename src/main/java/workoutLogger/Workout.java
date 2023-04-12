package workoutLogger;

public class Workout implements workoutInterface {

  private String name;
  private int previousReps;
  private double previousWeight;

  public void setName(String name) {
    if (name.length() >= 3) {
      this.name = name;
    } else {
      throw new IllegalArgumentException(
        "Name too short, must be at least 3 characters"
      );
    }
  }

  @Override
  public String getName() {
    return this.name;
  }

  public String toString() {
    return this.name + this.previousReps + "x" + this.previousWeight;
  }
}
