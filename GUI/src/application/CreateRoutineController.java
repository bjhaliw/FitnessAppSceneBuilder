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
import model.Data;
import model.Exercise;
import model.ExerciseList;
import model.Routine;
import model.RoutineTracker;
import model.Set;

public class CreateRoutineController {
	
	private Data data;

	@FXML
	private ListView<String> exerciseTypes;
	@FXML
	private Button homeButton;
	@FXML
	private VBox exerciseVBox;
	@FXML
	private Label routineDate;

	public void initData(Data data) {
		this.data = data;
		this.routineDate.setText(this.data.getRoutine().getStartTime().toString().substring(0, 10));
	}
	
	public void homeButton(ActionEvent event) throws IOException {
		
		if(this.data.getRoutine().getExerciseArrayList().size() != 0) {
			this.data.getRoutineTracker().addRoutine(this.data.getRoutine());			
		}
		
		Parent home = FXMLLoader.load(getClass().getResource("GUI.fxml"));
		Scene homeScreen = new Scene(home);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(homeScreen);
		window.show();
	}
	
	public void pushAddButton(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("AddExercise.fxml"));
		Parent routineView = loader.load();
		
		Scene newRoutineScene = new Scene(routineView);
		
		AddExerciseController controller = loader.getController();
		
		controller.initData(this.data);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(newRoutineScene);
		window.show();
	}
	
	/**
	 * Pushes the "Add Exercise" Button
	 *
	 */
	public void addExercise(Exercise exercise) {
		
		this.data.getRoutine().addExercise(exercise);
		
		for(Exercise current : this.data.getRoutine().getExerciseArrayList()) {
			VBox exerciseBox = new VBox(10);
			exerciseBox.getChildren().add(new Label(current.getExerciseName()));
			exerciseBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
			exerciseBox.setAlignment(Pos.CENTER);
			
			for (Set set : current.getSetList()) {
				VBox setBox = new VBox(10);
				setBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
				setBox.setAlignment(Pos.CENTER);
				setBox.getChildren().add(new Label(set.toString()));
				exerciseBox.getChildren().add(setBox);
			}
			
			this.exerciseVBox.getChildren().add(exerciseBox);
		}
		
	}	
}
