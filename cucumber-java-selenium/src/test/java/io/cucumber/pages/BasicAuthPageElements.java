package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class BasicAuthPageElements extends Page{

	public BasicAuthPageElements(ChromeDriver driver) {
		super(driver);
	}
	
	
	@FindBy (xpath = "//p")
	public WebElement textMessageCongrats;
	

	public void refresh() {
		driver.navigate().refresh();
		System.out.println("Refreshed page");
	}
}
