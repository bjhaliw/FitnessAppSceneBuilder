package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * This class allows the user to keep track of all the workouts that they have
 * completed over a length of time.
 * 
 * @author Brenton Haliw
 *
 */
public class RoutineTracker {

	ArrayList<Routine> routineList;

	/**
	 * Default constructor for the RoutineTracker class
	 */
	public RoutineTracker() {
		routineList = new ArrayList<>();
	}

	/**
	 * Returns the ArrayList containing routines
	 * 
	 * @return routineList
	 */
	public ArrayList<Routine> getRoutineList() {
		return this.routineList;
	}

	/**
	 * Adds a routine to the ArrayList containing routines
	 * 
	 * @param routine
	 * @return routineList
	 */
	public ArrayList<Routine> addRoutine(Routine routine) {
		this.routineList.add(routine);

		return this.routineList;
	}

	/**
	 * Removes the specified routine from the ArrayList containing Routines
	 * 
	 * @param routine
	 * @return routineList
	 */
	public ArrayList<Routine> removeRoutine(Routine routine) {
		this.routineList.remove(routine);

		return this.routineList;
	}

	/**
	 * This method is responsible for taking the information that is present in the
	 * ArrayList containing routines and then saving it to a document to be used for
	 * future use. This way, data that is created by the user will not be lost upon
	 * shutdown of the program.
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public void saveRoutineList(String fileName) throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter writer = new PrintWriter(fileName, "UTF-8");

		for (Routine routine : this.routineList) {
			writer.println("Start Time:" + routine.startTime);
			for (Exercise exercise : routine.exerciseArrayList) {
				writer.println(exercise);
				for (Set set : exercise.setList) {
					writer.println(set);
				}
			}

		}

		writer.close();

	}

	/**
	 * This method will attempt to open up the given file and load the information
	 * from it into the RoutineList.
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public void loadRoutineList(String fileName) throws FileNotFoundException {

		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		String current;
		int routineNum = -1;
		int exerciseNum = -1;

		// If document is empty, return back to method call
		if (!scanner.hasNextLine()) {
			scanner.close();
			return;
		}

		// Reads the text file until the end of the document
		while (scanner.hasNextLine()) {

			current = scanner.nextLine();

			// Checks to see if a new routine has been started
			if (current.contains("Start Time:")) {
				routineNum++;
				exerciseNum = -1;
				current = current.substring(11);
				this.routineList.add(new Routine());
				this.routineList.get(routineNum).startTime = LocalDateTime.parse(current);
			}

			// Checks to see if a new Exercise has been started for the routine
			if (current.contains("Exercise name: ")) {
				int name = current.indexOf("Exercise name: ");
				int type = current.indexOf("Exercise Type: ");
				exerciseNum++;

				this.routineList.get(routineNum).addExercise(new Exercise(current.substring(name + 15, type - 1),
						current.substring(type + 15, current.length())));

			}

			// Checks to see if a new Set was started for the exercise
			if (current.contains("Reps: ")) {
				int reps = current.indexOf("Reps:");
				int weight = current.indexOf("Weight:");

				this.routineList.get(routineNum).getExercise(exerciseNum)
						.addSet(new Set(Integer.parseInt(current.substring(reps + 6, weight - 1)),
								Double.parseDouble(current.substring(weight + 7, current.length()))));

			}

		}

		scanner.close();
	}
}
