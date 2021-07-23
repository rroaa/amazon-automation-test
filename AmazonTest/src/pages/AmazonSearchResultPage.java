package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AmazonSearchResultPage {
	
	WebDriver driver;
	By resultList= By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']");
	
	
	public AmazonSearchResultPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void getSearchResult() {
		
		// Store search results in list 
		List<WebElement> getData =  driver.findElements(resultList);
		
		// Print total number of results
		System.out.println("Total No. of Product : " + getData.size());
		
		// Print search results
		for(WebElement e : getData) {
			System.out.println(e.getText());
		}
	}

}
