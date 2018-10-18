package application.model.Budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
/**
 * 
 * @author Daniel Garcia zzn974
 *	This class reads in a file and populates the informations such as income, expenses, and remaining balance
 */
public class Budget 
{
	static ArrayList<String> transactions = new ArrayList<String>();
	public static double expense;
	public static double income;
	public static double remaining;
	
	public Budget(String fileName)
	{
	
		File file = new File(fileName);
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNextLine())
			{
			String data = inputStream.nextLine();
			String[] info = data.split(",");
			if(info[1].toLowerCase().equals("paycheck"))
			{
				income += Double.parseDouble(info[2]);
			}
			else
			{
				expense += Double.parseDouble(info[2]);
			}
			remaining = income - expense;
			transactions.add(data);
			}
			Collections.sort(transactions);
			Collections.reverse(transactions);
			
			DateFormat f1 = new SimpleDateFormat("MM-dd-yyyy");
			DateFormat f2 = new SimpleDateFormat("MMMMM dd, yyyy");
			
			for(int i = 0; i< transactions.size();i++)
			{
				String[] tranParts = transactions.get(i).split(",");
				Date d = null;
				try {
					d = f1.parse(tranParts[0]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String dString = f2.format(d);
				double v1 = Double.parseDouble(tranParts[2]);
				String l = String.format("%-30s %-30s $%.2f", dString, tranParts[1], v1);
				transactions.set(i, l);
			}
			
			inputStream.close();
		}
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public double getRemaining() {
		return remaining;
	}
	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public static ArrayList<String> getTransactions() {
		return transactions;
	}
	public static void setTransactions(ArrayList<String> transactions) {
		Budget.transactions = transactions;
	}
	
}
