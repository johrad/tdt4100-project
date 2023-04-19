package workoutLogger;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ExerciseTest {

  @Test
  public void testConstructorWithName() {
    Exercise exercise = new Exercise("Bench Press");
    assertEquals("Bench Press", exercise.getName());
  }

  @Test
  public void testConstructorWithNameTooShort() {
    assertThrows(
      IllegalArgumentException.class,
      () -> {
        new Exercise("BP");
      }
    );
  }

  @Test
  public void testLatestRepsNoRepsLogged() {
    Exercise exercise = new Exercise("Bench Press");
    assertEquals(0, exercise.latestReps());
  }

  @Test
  public void testLatestRepsWithRepsLogged() {
    Exercise exercise = new Exercise("Bench Press");
    exercise.logSet(10, 100.0);
    assertEquals(10, exercise.latestReps());
  }

  @Test
  public void testLatestWeightNoWeightLogged() {
    Exercise exercise = new Exercise("Bench Press");
    assertEquals(0.0, exercise.latestWeight());
  }

  @Test
  public void testLatestWeightWithWeightLogged() {
    Exercise exercise = new Exercise("Bench Press");
    exercise.logSet(10, 100.0);
    assertEquals(100.0, exercise.latestWeight());
  }

  @Test
  public void testLogSet() {
    Exercise exercise = new Exercise("Bench Press");
    exercise.logSet(10, 100.0);
    assertEquals(Arrays.asList(10), exercise.getReps());
    assertEquals(Arrays.asList(100.0), exercise.getWeight());
  }

  @Test
  public void testLogSetNegativeReps() {
    Exercise exercise = new Exercise("Bench Press");
    assertThrows(
      IllegalArgumentException.class,
      () -> {
        exercise.logSet(-10, 100.0);
      }
    );
  }

  @Test
  public void testLogSetZeroWeight() {
    Exercise exercise = new Exercise("Bench Press");
    assertThrows(
      IllegalArgumentException.class,
      () -> {
        exercise.logSet(10, 0.0);
      }
    );
  }

  @Test
  public void testGetVolume() {
    Exercise exercise = new Exercise("Bench Press");
    exercise.logSet(10, 100.0);
    assertEquals(1000.0, exercise.getVolume());
  }

  @Test
  public void testToStringWithSetsLogged() {
    Exercise exercise = new Exercise("Bench Press");
    exercise.logSet(10, 100.0);
    assertEquals(
      "Bench Press (Last workout): 10 reps @ 100.0kg",
      exercise.toString()
    );
  }
}
