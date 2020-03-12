package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ExerciseList;
import model.Routine;
import model.RoutineTracker;
import model.Data;

/**
 * This is the main screen controller that allows the user to select from a variety of options.
 * The user can do things such as: create new exercises, view statistics, and create a new workout.
 * The main controller is responsible for initializing the different variables that will be used
 * throughout the entire program such as the exercise list, routine tracker, and the brand new
 * routine that will be used.
 * @author Brenton
 *
 */
public class Controller implements Initializable {

	private Data data;
	
	/****** FXML Instance Variables ******/
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
	
	/**
	 * If the user selects this, they will be taken to a screen which will allow them
	 * to create a brand new exercise. The exercise list will be forwarded to the
	 * screen to be manipulated by the user.
	 * @param event
	 * @throws IOException
	 */
	public void createExerciseButton(ActionEvent event) throws IOException {
		Parent newExercise = FXMLLoader.load(getClass().getResource("CreateExercise.fxml"));
		Scene newExerciseScene = new Scene(newExercise);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(newExerciseScene);
		window.show();
	}
	
	public void createRoutineButton(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CreateRoutine.fxml"));
		Parent routineView = loader.load();
		
		Scene newRoutineScene = new Scene(routineView);
		
		CreateRoutineController controller = loader.getController();
		
		controller.initData(this.data);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(newRoutineScene);
		window.show();
	}
	
	public void viewStatisticsButton(ActionEvent event) throws IOException {
		Parent viewStats = FXMLLoader.load(getClass().getResource("ViewStatistics.fxml"));
		Scene newRoutineScene = new Scene(viewStats);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(newRoutineScene);
		window.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.data = new Data();
		this.data.initalize();
		
	}
	
	
	
	
}
