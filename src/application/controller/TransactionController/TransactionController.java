package application.controller.TransactionController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.controller.MainController.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
/**
 * 
 * @author Daniel Garcia zzn974
 *	This class handles when the user want to go back to the home screen as well as populates the listView with the data from the object
 */
public class TransactionController implements Initializable
{
	@FXML
	private ListView<String> list;
	
	@FXML
	private AnchorPane rootPane2;
	
	@FXML
	public void handleHome(ActionEvent event) throws IOException
	{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Main.fxml"));
		rootPane2.getChildren().setAll(pane);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		ObservableList<String> history = FXCollections.observableArrayList(
				MainController.transactions());
		list.setItems(history);
		
	}
	
	

}
