package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewStatisticsController {

	@FXML
	private Button homeButton;
	
	public void homeButton(ActionEvent event) throws IOException {
		Parent newExercise = FXMLLoader.load(getClass().getResource("GUI.fxml"));
		Scene newExerciseScene = new Scene(newExercise);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(newExerciseScene);
		window.show();
	}
}
