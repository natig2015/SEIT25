package io.cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SortableDataTableElements extends Page{

	public SortableDataTableElements(ChromeDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//h3")
	public WebElement textDataTable;
	
	@FindBy (xpath = "//table[@id='table1']//tbody/tr")
	public List<WebElement> rowsTable;
		
	public void refresh() {
		driver.navigate().refresh();
		System.out.println("Refreshed page");
	}

}
