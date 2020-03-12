package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import model.Exercise;

public class AddSetController {
	
	private Exercise exercise;
	
	@FXML
	private ScrollPane scrollPane;
	@FXML
	private Label exerciseName;
	@FXML
	private Button weightIncrease;
	@FXML
	private Button weightDecrease;
	@FXML
	private Button repsIncrease;
	@FXML
	private Button repsDecrease;
	@FXML
	private Button addSet;
	@FXML
	private TextField repsField;
	@FXML
	private TextField weightField;
	
	public void initData(Exercise exercise) {
		
	}
	
	public void addSet() {
		
	}
	
}
