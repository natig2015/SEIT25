package io.cucumber.glue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.HomePageElements;
import io.cucumber.pages.SortableDataTableElements;

public class SortableDataTableSteps extends Context {


	 HomePageElements home;
	 SortableDataTableElements sortableElemenets;

	public SortableDataTableSteps(Manager manager) {
		super(manager);
	}

	@When("the 'Sortable Data Tables'is opened")
	public void the_sortable_data_tables_is_opened() {

		home = new HomePageElements(getDriver());
		home.sortableDataTablesLink.click();
	}

	
	@Then("I validate that the Example one table displays the following results:")
	public void i_validate_that_the_example_table_displays_the_following_results(DataTable table) {
		 // Converting DataTable to a list of maps
	    List<Map<String, String>> expectedTable = table.asMaps();

	    sortableElemenets = new SortableDataTableElements(getDriver());
	    
	    // Getting the rows from the table in the webpage
	    List<WebElement> rows = sortableElemenets.rowsTable;

	    // Iterating over the table data
	    
	    for (int i = 0; i < rows.size(); i++) {
           WebElement row = rows.get(i);
           String lastName = row.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + (i+1) + "]/td[1]")).getText();
           String firstName = row.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + (i+1) + "]/td[2]")).getText();
           String email = row.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + (i+1) + "]/td[3]")).getText();
           String due = row.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + (i+1) + "]/td[4]")).getText();
           String website = row.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + (i+1) + "]/td[5]")).getText();

           // Creating a map of the actual data 
           Map<String, String> actualData = new HashMap<>();
           
              actualData.put( "Last Name", lastName);
              actualData.put( "First Name", firstName);
              actualData.put("Email", email);
              actualData.put("Due", due);
              actualData.put("Web Site", website);
           
           // Getting the expected data for comparison
           Map<String, String> expectedData = expectedTable.get(i);

           // Comparision of  the actual dataTable with the expected dataTable
           Assertions.assertEquals(expectedData.get("Last Name").trim(), actualData.get("Last Name"), 
                   "The table info does not align for the row " + (i + 1));
               Assertions.assertEquals(expectedData.get("First Name").trim(), actualData.get("First Name"), 
                   "The table info does not align for the row " + (i + 1));
               Assertions.assertEquals(expectedData.get("Email").trim(), actualData.get("Email"), 
                   "The table info does not align for the row " + (i + 1));
               Assertions.assertEquals(expectedData.get("Due").trim(), actualData.get("Due"), 
                   "The table info does not align for the row " + (i + 1));
               Assertions.assertEquals(expectedData.get("Web Site").trim(), actualData.get("Web Site"), 
                   "The table infon does not align for the row " + (i + 1));
	    
	   
	                System.out.println("Test Passed for: " + lastName + " " + firstName);
	            }
	        }
}













