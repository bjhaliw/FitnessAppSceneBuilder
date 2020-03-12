package model;

import java.io.FileNotFoundException;

public class Data {

	private Exercise exercise;
	private Routine routine;
	private RoutineTracker routineTracker;
	private ExerciseList exerciseList;
	
	public Data() {
		this.exercise = new Exercise(null, null);
		this.routine = new Routine();
		this.routineTracker = new RoutineTracker();
		this.exerciseList = new ExerciseList();
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public Routine getRoutine() {
		return routine;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

	public RoutineTracker getRoutineTracker() {
		return routineTracker;
	}

	public void setRoutineTracker(RoutineTracker routineTracker) {
		this.routineTracker = routineTracker;
	}

	public ExerciseList getExerciseList() {
		return exerciseList;
	}

	public void setExerciseList(ExerciseList exerciseList) {
		this.exerciseList = exerciseList;
	}
	
	public void initalize() {
		try {
			this.routineTracker.loadRoutineList("C:\\Users\\Brenton\\Desktop\\RoutineList.txt");
			this.exerciseList.loadExerciseList("C:\\Users\\Brenton\\Desktop\\ExerciseList.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
