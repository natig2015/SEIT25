package io.cucumber.glue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.pages.HomePageElements;

public class HomeSteps extends Context {

	public HomeSteps(Manager manager) {
		super(manager);
	}

	@Given("an example Home Page step")
	public void exampleHomePageStep() {
		System.out.println("printing shared stash :" + getTestStash().toString());
	}

	@Then("the list of links should contain the following examples:")
	public void the_list_of_links_should_contain_the_following_examples(DataTable dataTable) {
		
		List<String> expectedLists  = dataTable.asList(); // name of link names comes from steps

		// Adding link texts to the actual list.
		List<String> actualLists = new ArrayList<>();   

		HomePageElements home = new HomePageElements(getDriver());

		for (WebElement el : home.listOfLinks) {

			actualLists.add(el.getText().trim()); // getting each text of links and adding in actualLists.
		}

		// Verify that expected and actual list of links are matching
		Assertions.assertEquals(expectedLists, actualLists);
		
		
	}

}