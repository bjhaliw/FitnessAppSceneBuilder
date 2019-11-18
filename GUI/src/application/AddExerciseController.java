package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import model.Exercise;
import model.ExerciseList;
import model.Set;

public class AddExerciseController implements Initializable {

	private ExerciseList exerciseList;
	private Exercise exercise;
	private VBox exerciseBox;

	@FXML
	private TextField searchBar;
	@FXML
	private ListView<String> exerciseType;
	@FXML
	private ListView<String> exerciseName;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		exerciseType.getItems().addAll("Back", "Chest", "Shoulders", "Biceps", "Triceps", "Abs", "Legs", "Cardio");

	}

	public void selectExercise(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CreateRoutine.fxml"));
		Parent routineView = loader.load();

		CreateRoutineController controller = loader.getController();
		
		exercise = new Exercise("Pull Up", "Back");
		exercise.addSet(new Set(10, 100));
		exercise.addSet(new Set(9, 110));
		exercise.addSet(new Set(5, 10));
		
		exerciseBox = new VBox(10);
		
		exerciseBox.getChildren().add(new Label(exercise.getExerciseName()));
		exerciseBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		exerciseBox.setAlignment(Pos.CENTER);
		
		for (Set set : exercise.getSetList()) {
			exerciseBox.getChildren().add(new Label(set.toString()));
		}

		if (exercise != null && exerciseBox != null) {
			controller.addExercise(exercise, exerciseBox);
		}
		
		
		Scene scene = new Scene(routineView);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();

	}

	public void homeButton(ActionEvent event) throws IOException {
		
		Parent home = FXMLLoader.load(getClass().getResource("GUI.fxml"));
		Scene homeScreen = new Scene(home);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(homeScreen);
		window.show();
	}
}
