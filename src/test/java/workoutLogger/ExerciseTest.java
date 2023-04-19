package workoutLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExerciseTest {

  @Test
  void testConstructor() {
    Exercise exercise = new Exercise("Bench Press");
    Assertions.assertEquals("Bench Press", exercise.getName());
  }

  @Test
  void testConstructorThrowsException() {
    Assertions.assertThrows(
      IllegalArgumentException.class,
      () -> {
        Exercise exercise = new Exercise("BP"); // too short name
      }
    );
  }

  @Test
  void testLogSet() {
    Exercise exercise = new Exercise("Bench Press");
    exercise.logSet(10, 100);
    Assertions.assertEquals(10, exercise.latestReps());
    Assertions.assertEquals(100.0, exercise.latestWeight());
  }

  @Test
  void testGetVolume() {
    Exercise exercise = new Exercise("Bench Press");
    exercise.logSet(10, 100);
    Assertions.assertEquals(1000.0, exercise.getVolume());
  }

  @Test
  void testGetPR() {
    Exercise exercise = new Exercise("Bench Press");
    exercise.logSet(10, 100);
    exercise.logSet(12, 110);
    List<Double> expectedPR = new ArrayList<>(Arrays.asList(12.0, 110.0));
    Assertions.assertEquals(expectedPR, exercise.getPR());
  }
}
