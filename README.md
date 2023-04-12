### TDT4100: Project:

# **Workout Logger and Tracker**

This project will be a workout logger and tracker app. It will allow you to chose from a preset of movements and log the number of sets and reps for each movement. The data will then be logged and compared to previous sessions.

## **Scenes**
### Overview Scene
Contains some information about previous workout, maybe graph to see change over time for different movements.

### Workouts scene
Contains all the pre-defined workout plans with the ability to create custom plans.

### Active logging scene
Meant to be used while working out. used to log weight x reps for each movement in the workout plan. At end of workout, the data will be stored.

## Planning etc.:

The storing of data can utilize observatory technique. 
 * User clicks "end workout"
 * Sends alert to listener
 * Listener trigger saving to file functionality. 


Easiest would be to just save the workout itself. i.e. Don't care about individual movements. It can all be saved into a csv file like:
```csv
String workout_name, int reps, double weight, date (?)
```
