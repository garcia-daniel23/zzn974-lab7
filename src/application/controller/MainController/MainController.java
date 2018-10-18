package application.controller.MainController;

import java.io.IOException;
import java.util.ArrayList;

import application.controller.BudgetController.BudgetController;
import application.controller.TransactionController.TransactionController;
import application.model.Budget.Budget;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * @author Daniel Garcia zzn974
 * This class handles what happens when the user clicks either button and populates the budget object
 */
public class MainController  {
	
	private static BudgetController budget = new BudgetController();
	private static Budget bud = new Budget("data.csv");
	private static TransactionController trans = new TransactionController();
	
	@FXML
	private AnchorPane rootPane;
	
	@FXML
	public void handleBudget(ActionEvent event) throws IOException
	{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Budget.fxml"));
		rootPane.getChildren().setAll(pane);
		
	}
	
	/**
	 * Handles the button for transactions switches the scene
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void handleTransactions(ActionEvent event) throws IOException
	{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Transactions.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	public static double income()
	{
		return bud.getIncome();
	}
	public static double expense()
	{
		return bud.getExpense();
	}
	public static ArrayList<String> transactions()
	{
		return bud.getTransactions();
	}
	
}
