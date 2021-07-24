package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AmazonHomePage{
	
	WebDriver driver; 
	By categoryDDL = By.xpath("//*[@id=\"searchDropdownBox\"]");
	By searchBar= By.xpath("//*[@id=\"twotabsearchtextbox\"]");
	By searchBtn= By.xpath("//*[@id=\"nav-search-submit-button\"]");
	String queryResult[]= new String[2]; 
	
	public AmazonHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String[] JDBCSetupForAmazonDB() {
		try {
			// Register the driver and connect to the database 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/AmazonProducts","root","root");
			
			// Retrieve products list from the db 
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from products");
			
			// Print and fetch query result in array
			while(rs.next()){
				System.out.println("Category: "+ rs.getString(1)+" , Product: "+ rs.getString(2));
				queryResult[0] =rs.getString(1);
				queryResult[1] = rs.getString(2);
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("Class Not Found");
			e.printStackTrace();
			
		}
		catch(SQLException e){
			System.out.println("Sql Exception");
			e.printStackTrace();
		}
		
		return queryResult;
	}
	
	public void search(String[] queryResult) {
		
		// Select product category from the drop down list
		WebElement category = driver.findElement(categoryDDL);
		Select selectOption = new Select(category);
		selectOption.selectByVisibleText(queryResult[0]);
		
		// Fetch product name in the search bar
		WebElement searchValue = driver.findElement(searchBar);
		searchValue.sendKeys(queryResult[1]);
		
		// Click on the search button
		WebElement search =driver.findElement(searchBtn);
		search.click();
		
	}
}
