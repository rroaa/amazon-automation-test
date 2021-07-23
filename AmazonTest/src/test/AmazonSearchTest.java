package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AmazonHomePage;
import pages.AmazonSearchResultPage;

public class AmazonSearchTest {
	
	public static void main (String[]args){
	
		final String driverPath="driver/chromedriver.exe";
		WebDriver driver;
		AmazonHomePage hp;
		AmazonSearchResultPage rp;
		
		// Connection Setup
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://www.amazon.sa/?language=en_AE");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		// Search TC
		hp= new AmazonHomePage(driver);
		String[] searchValues= hp.JDBCSetupForAmazonDB();
		hp.search(searchValues);
		
		// Search Result TC
		rp= new AmazonSearchResultPage(driver);
		rp.getSearchResult();
		
		// Connection Termination
		driver.quit();

	  }
}
