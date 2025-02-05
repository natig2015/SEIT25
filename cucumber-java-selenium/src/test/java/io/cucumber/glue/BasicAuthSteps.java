package io.cucumber.glue;


import org.junit.jupiter.api.Assertions;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.BasicAuthPageElements;
import io.cucumber.pages.HomePageElements;

public class BasicAuthSteps extends Context{
	
	 public BasicAuthSteps(Manager manager) {
		super(manager);
	}
	 
	@When("the {string} example is opened")
	  public void the_example_is_opened(String url) {
	     
		 HomePageElements home = new HomePageElements(getDriver());		
		 home.basicAuthLink.click();	
	  }
	
	
	@When("valid credentials are supplied")
	public void valid_credentials_are_supplied() {
		
	  getDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	  
	   
	  		
	}
	  @Then("Congratulations should be displayed")
	  public void congratulations_should_be_displayed() {
	  
		  BasicAuthPageElements basicAuth = new BasicAuthPageElements(getDriver());
		  String expectedText = "Congratulations! You must have the proper credentials.";
		  String actualText = basicAuth.textMessageCongrats.getText();
		  
		   Assertions.assertEquals(expectedText, actualText);
		   
		  
	  }


	  

}
