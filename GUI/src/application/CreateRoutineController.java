package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.text.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Exercise;
import model.ExerciseList;
import model.Routine;
import model.RoutineTracker;
import model.Set;

public class CreateRoutineController implements Initializable {
	
	private RoutineTracker routineTracker;
	private Routine routine;

	@FXML
	private ListView<String> exerciseTypes;
	@FXML
	private Button homeButton;
	@FXML
	private VBox exerciseVBox;
	@FXML
	private Label routineDate;

	public void homeButton(ActionEvent event) throws IOException {
		
		if(this.routine.getExerciseArrayList().size() != 0) {
			this.routineTracker.addRoutine(this.routine);
			
		}
		
		Parent home = FXMLLoader.load(getClass().getResource("GUI.fxml"));
		Scene homeScreen = new Scene(home);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(homeScreen);
		window.show();
	}
	
	public void pushAddButton(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("AddExercise.fxml"));
		Scene scene = new Scene(parent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	/**
	 * Pushes the "Add Exercise" Button
	 *
	 */
	public void addExercise(Exercise exercise, VBox exerciseBox) {
		
		routine.addExercise(exercise);
		
		exerciseVBox.getChildren().add(exerciseBox);
		
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.routine = new Routine();
		

		
		routineDate.setText(this.routine.getStartTime().toString().substring(0, 10));
		
		/*
		 * Exercise exercise = new Exercise("Pull Up", "Back"); exercise.addSet(new
		 * Set(10, 100)); exercise.addSet(new Set(9, 110)); exercise.addSet(new Set(5,
		 * 10));
		 * 
		 * VBox exerciseBox = new VBox(10);
		 * 
		 * exerciseBox.getChildren().add(new Label(exercise.getExerciseName()));
		 * exerciseBox.setBackground(new Background(new BackgroundFill(Color.WHITE,
		 * CornerRadii.EMPTY, Insets.EMPTY)));
		 * 
		 * exerciseBox.setAlignment(Pos.CENTER);
		 * 
		 * for (Set set : exercise.getSetList()) { exerciseBox.getChildren().add(new
		 * Label(set.toString())); }
		 * 
		 * exerciseVBox.getChildren().add(exerciseBox);
		 */
		
	}
	
	
	
	
	
}
