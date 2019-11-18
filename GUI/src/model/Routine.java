package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * This class creates an array of exercises that will make up the routine for
 * the day that the user will track their workout with. The routine will keep
 * track of the date and time that the exercises were performed.
 * 
 * @author Brenton Haliw
 *
 */
public class Routine {

	ArrayList<Exercise> exerciseArrayList;
	LocalDateTime startTime;
	LocalDateTime endTime;

	/**
	 * Default Constructor for the Routine object. Initializes the exercise
	 * ArrayList and notes the start time of the routine.
	 */
	public Routine() {
		this.exerciseArrayList = new ArrayList<>();
		this.startTime = LocalDateTime.now();
	}

	public void addExercise(Exercise exercise) {
		this.exerciseArrayList.add(exercise);
	}

	public LocalDateTime getStartTime() {
		return this.startTime;
	}

	public LocalDateTime getEndTime() {
		return this.endTime;
	}

	public void removeExercise(Exercise exercise) {
		this.exerciseArrayList.remove(exercise);
	}

	public void endRoutine(LocalDateTime time) {
		this.endTime = time;
	}

	public Exercise getExercise(int index) {
		return exerciseArrayList.get(index);
	}

	public ArrayList<Exercise> getExerciseArrayList() {
		return this.exerciseArrayList;
	}

	/**
	 * Prints out the items in the Exercise ArrayList
	 * 
	 * @return
	 */
	public String printExerciseArrayList() {
		String output = "";
		int i = 1;

		for (Exercise exercise : this.exerciseArrayList) {
			output += i + ": " + exercise.getExerciseName() + "\n";
			i++;
		}

		return output;
	}

}
