package application.controller.BudgetController;

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
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.AnchorPane;
/**
 * 
 * @author Daniel Garcia zzn974
 *	This class handles when the user wants to go home as well as populates the pieChart with data
 */
public class BudgetController implements Initializable
{
	public double income;
	@FXML
	private AnchorPane rootPane1;
	
	@FXML
	private PieChart pie;
	
	@FXML
	public void handleHome(ActionEvent event) throws IOException
	{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Main.fxml"));
		rootPane1.getChildren().setAll(pane);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		ObservableList<Data> pieC = FXCollections.observableArrayList(
				new PieChart.Data("Income", MainController.income()),
				new PieChart.Data("Expenses", MainController.expense()),
				new PieChart.Data("Remaining", MainController.income() - MainController.expense()));
		
		// TODO Auto-generated method stub
		pie.setData(pieC);
	}


}
