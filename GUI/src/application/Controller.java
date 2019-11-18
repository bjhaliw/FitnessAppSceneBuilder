package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {

	@FXML
	private Button homeButton;
	@FXML
	private Button createExerciseButton;
	@FXML
	private Button viewStatisticsButton;
	@FXML
	private VBox initialButtons;
	@FXML
	private Button newRoutineButton;
	
	
	
	public void homeButton(ActionEvent event) {
		System.out.println("Sup Dude");
	}
	
	public void createExerciseButton(ActionEvent event) throws IOException {
		Parent newExercise = FXMLLoader.load(getClass().getResource("CreateExercise.fxml"));
		Scene newExerciseScene = new Scene(newExercise);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(newExerciseScene);
		window.show();
	}
	
	public void createRoutineButton(ActionEvent event) throws IOException {
		Parent newRoutine = FXMLLoader.load(getClass().getResource("CreateRoutine.fxml"));
		Scene newRoutineScene = new Scene(newRoutine);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(newRoutineScene);
		window.show();
	}
	
	
}
