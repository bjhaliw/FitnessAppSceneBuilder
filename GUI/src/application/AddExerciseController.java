package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Data;
import model.Exercise;
import model.ExerciseList;
import model.Routine;
import model.RoutineTracker;
import model.Set;

public class AddExerciseController {

	private Data data;

	@FXML
	private TextField searchBar;
	@FXML
	private ListView<String> exerciseType;
	@FXML
	private ListView<String> exerciseName;


	
	public void initData(Data data) {
		this.exerciseType.getItems().addAll("Back", "Chest", "Shoulders", "Biceps", "Triceps", "Abs", "Legs", "Cardio");
		this.data = data;
	}

	public void selectExercise(ActionEvent event) throws IOException {
		
		if (this.exerciseName.getSelectionModel().getSelectedItem() != null) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("CreateRoutine.fxml"));
			Parent routineView = loader.load();

			CreateRoutineController controller = loader.getController();
			
			this.data.setExercise(new Exercise(this.exerciseName.getSelectionModel().getSelectedItem(), this.exerciseType.getSelectionModel().getSelectedItem())); 
						
			controller.initData(data);
			controller.addExercise(this.data.getExercise());
			
			Scene scene = new Scene(routineView);

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(scene);
			window.show();
		}
	}

	public void loadExercises() {
		if (this.exerciseName.getItems().size() != 0) {
			this.exerciseName.getItems().remove(0, this.exerciseName.getItems().size());
		}

		if (this.exerciseType.getSelectionModel().getSelectedItem().equals("Back")) {
			for (int i = 0; i < this.data.getExerciseList().getBackExercises().size(); i++) {
				this.exerciseName.getItems().add(this.data.getExerciseList().getBackExercises().get(i).getExerciseName());
			}
		} else if (this.exerciseType.getSelectionModel().getSelectedItem().equals("Chest")) {

			for (int i = 0; i < this.data.getExerciseList().getChestExercises().size(); i++) {
				this.exerciseName.getItems().add(this.data.getExerciseList().getChestExercises().get(i).getExerciseName());
			}
		} else if (this.exerciseType.getSelectionModel().getSelectedItem().equals("Legs")) {

			for (int i = 0; i < this.data.getExerciseList().getLegsExercises().size(); i++) {
				this.exerciseName.getItems().add(this.data.getExerciseList().getLegsExercises().get(i).getExerciseName());
			}
		} else if (this.exerciseType.getSelectionModel().getSelectedItem().equals("Shoulders")) {

			for (int i = 0; i < this.data.getExerciseList().getShouldersExercises().size(); i++) {
				this.exerciseName.getItems().add(this.data.getExerciseList().getShouldersExercises().get(i).getExerciseName());
			}
		}
	}
	
	public void addSet() {
		if (this.exerciseName.getSelectionModel().getSelectedItem() != null) {
			
		}
	}

	public void homeButton(ActionEvent event) throws IOException {

		Parent home = FXMLLoader.load(getClass().getResource("GUI.fxml"));
		Scene homeScreen = new Scene(home);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(homeScreen);
		window.show();
	}
}
