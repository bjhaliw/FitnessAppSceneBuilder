package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws Exception {

		ExerciseList list = new ExerciseList();
		RoutineTracker tracker = new RoutineTracker();
		Routine routine = new Routine();
		int selection = 0;
		Scanner scanner = new Scanner(System.in);

		list.loadExerciseList("C:\\Users\\Brenton\\Desktop\\ExerciseList.txt");

		tracker.loadRoutineList("C:\\Users\\Brenton\\Desktop\\RoutineList.txt");

		while (selection != 9) {
			System.out.println("1. New Routine\n2. Add Exercise\n3. Add Set\n4. View Routines");
			System.out.println("5. Create Exercise\n6. Edit Routine\n7. Remove Exercise\n8. Remove Set");
			System.out.println("10. Exit");
			System.out.print("Please make your selection: ");

			selection = scanner.nextInt();

			if (selection == 1) {
				tracker.addRoutine(routine);
				System.out.println("New routine has been added!");
			} else if (selection == 2) {
				addExercise(routine, list, scanner);
			} else if (selection == 3) {
				addSet(routine, scanner);
			} else if (selection == 4) {
				viewRoutines(tracker, scanner);
			} else if (selection == 5) {
				createExercise(list, scanner);
			} else if (selection == 6) {
				editRoutine(tracker, list, scanner);
			} else if (selection == 7) {
				removeExercise(routine, scanner);
			} else if (selection == 8) {
				removeSet(routine, scanner);
			}
			
			System.out.println();
		}

		list.saveExerciseList("C:\\Users\\Brenton\\Desktop\\ExerciseList.txt");
		tracker.saveRoutineList("C:\\Users\\Brenton\\Desktop\\RoutineList.txt");

		scanner.close();
	}

	/**
	 * Used to add an exercise to a routine
	 * 
	 * @param routine
	 * @param list
	 * @param scanner
	 */
	public static void addExercise(Routine routine, ExerciseList list, Scanner scanner) {
		String add = "";
		int selection;
		ArrayList<Exercise> exerciseList = new ArrayList<>();

		System.out.println("1. Back\n2. Chest\n3. Legs\n4. Shoulders");
		System.out.println("Please select the type of exercise you wish to do:");

		selection = scanner.nextInt();
		scanner.nextLine();

		add = list.printExerciseList(selection);

		if (selection == 1) {
			exerciseList = list.backList;

		} else if (selection == 2) {
			exerciseList = list.chestList;

		} else if (selection == 3) {
			exerciseList = list.legsList;

		} else if (selection == 4) {
			exerciseList = list.shouldersList;

		}

		System.out.println("Please select an exercise :\n" + add);

		selection = scanner.nextInt();
		scanner.nextLine();

		routine.addExercise(exerciseList.get(selection - 1));

		System.out.println("Exercise has been successfully added");

	}

	/**
	 * Used to add a set to an exercise in a routine
	 * 
	 * @param routine
	 * @param scanner
	 */
	public static void addSet(Routine routine, Scanner scanner) {
		Exercise exercise;
		int selection;
		int reps = 0;
		double weight = 0;

		System.out.println(routine.printExerciseArrayList());
		System.out.print("Select the exercise you wish to add a set to:");

		selection = scanner.nextInt();

		exercise = routine.exerciseArrayList.get(selection - 1);

		System.out.print("Enter the reps done: ");
		reps = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter the weight used: ");
		weight = scanner.nextDouble();
		scanner.nextLine();

		System.out.println(reps);
		System.out.println(weight);

		exercise.addSet(new Set(reps, weight));

		System.out.println("Set has been successfully added!");

	}

	/**
	 * Allows for the retrieval of a all the exercises within a certain routine
	 * 
	 * @param tracker
	 * @param scanner
	 * @return routine
	 */
	public static Routine viewRoutines(RoutineTracker tracker, Scanner scanner) {
		Routine routine;
		int selection;
		int i = 1;
		int j = 1;

		for (Routine current : tracker.routineList) {
			System.out.println(i + ": " + current.getStartTime());
			i++;
		}
		i = 1;

		System.out.print("Please select the routine: ");

		selection = scanner.nextInt();
		scanner.nextLine();

		routine = tracker.routineList.get(selection - 1);

		for (Exercise exercise : routine.exerciseArrayList) {
			System.out.println(i + ": " + exercise);

			for (Set set : exercise.setList) {
				System.out.println("    " + j + ": " + set);
				j++;
			}
			j = 1;
			i++;
		}

		return routine;

	}

	/**
	 * Creates a new exercise to be put in the ExerciseList object
	 * 
	 * @param list
	 * @param scanner
	 */
	public static void createExercise(ExerciseList list, Scanner scanner) {
		String name, type;

		System.out.print("Please enter the name of the new exercise: ");
		name = scanner.nextLine();

		System.out.print("Please enter the type of exercise: ");
		type = scanner.nextLine();

		list.addExercise(new Exercise(name, type));

		System.out.println(name + " has been successfully created!");

	}

	/**
	 * Allows the user to edit a routine's exercise or set. Can remove or add sets
	 * 
	 * @param tracker
	 * @param list
	 * @param scanner
	 */
	public static void editRoutine(RoutineTracker tracker, ExerciseList list, Scanner scanner) {
		Routine routine;
		int selection;

		routine = viewRoutines(tracker, scanner);

		System.out.println("1. Add Exercise\n2. Remove Exercise\n3. Add Set\n4. Remove Set");
		System.out.print("Please select from one of the previous options: ");

		selection = scanner.nextInt();

		scanner.nextLine();

		if (selection == 1) {
			addExercise(routine, list, scanner);
		} else if (selection == 2) {
			removeExercise(routine, scanner);
		} else if (selection == 3) {
			addSet(routine, scanner);
		} else if (selection == 4) {
			removeSet(routine, scanner);
		}

	}

	/**
	 * Allows the user to remove an exercise entirely from a routine
	 * @param routine
	 * @param scanner
	 */
	public static void removeExercise(Routine routine, Scanner scanner) {
		int selection;

		System.out.println(routine.printExerciseArrayList());
		System.out.println("Please select the exercise that you wish to remove: ");

		selection = scanner.nextInt();

		scanner.nextLine();

		routine.removeExercise(routine.exerciseArrayList.remove(selection - 1));

		System.out.println("Item has been successfully removed");

	}

	/**
	 * Allows the user to remove a set from an exercise in a routine
	 * @param routine
	 * @param scanner
	 */
	public static void removeSet(Routine routine, Scanner scanner) {
		int selection;
		Exercise exercise;

		System.out.println(routine.printExerciseArrayList());
		System.out.print("Please select the exercise to remove the set from: ");

		selection = scanner.nextInt();

		exercise = routine.exerciseArrayList.get(selection - 1);

		System.out.println(exercise.printSetList());
		System.out.print("Please select the set that you wish to remove: ");

		selection = scanner.nextInt();

		scanner.nextLine();

		exercise.removeSet(exercise.setList.get(selection - 1));

		System.out.println("Item has been successfully removed");

	}

}
