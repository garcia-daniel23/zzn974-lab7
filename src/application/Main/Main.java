package application.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * @author Daniel Garcia
 * Class that launches the initial scene
 * main method
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// Load the FXML file for the game board
			Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
			
			// Set the scene onto the stage
			primaryStage.setScene(new Scene(root,400,400));
			
			// Display the board to the user
			primaryStage.show();
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
