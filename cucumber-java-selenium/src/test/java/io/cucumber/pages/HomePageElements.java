package io.cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePageElements extends Page {

	public HomePageElements(ChromeDriver driver) {
		super(driver);
		System.out.println("Homepage title is : " + getTitle().getText());
	}

	@FindBy(css = "h1")
	private WebElement title;

	public WebElement getTitle() {
		return title;
	}

	@FindBy(xpath = "//ul/li")
	public List<WebElement> listOfLinks;
	
	@FindBy (linkText = "Basic Auth")
	public WebElement basicAuthLink;
	
	@FindBy (linkText = "Sortable Data Tables")
	public WebElement sortableDataTablesLink;


	public void refresh() {
		driver.navigate().refresh();
		System.out.println("Refreshed page");
	}
}
