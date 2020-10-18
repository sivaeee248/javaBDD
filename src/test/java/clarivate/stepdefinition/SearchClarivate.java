package clarivate.stepdefinition;

import org.junit.Assert;
import clarivate.pages.BasePage;
import clarivate.pages.GoogleHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This is a Steps definition class for Google search functionality
 *
 * @author Siva Kumar
 */


public class SearchClarivate extends BasePage {
	@Given("user Opens Browser$")
	public void open_Browser() throws Throwable {
		driver = launchDriver(properties.getProperty("browser"));
	}

	@When("^user is on \"([^\"]*)\" homepage$")
	public void Navigate_to_AppURL(String appURL) throws Throwable {
//		driver.get(properties.getProperty("App_url"));
		driver.get(appURL);
	}

	@Then("^user enters \"([^\"]*)\" in searchbox$")
	public void user_enters_in_searchbox(String SearchTerm) throws Throwable {
		GoogleHomePage googlePage = new GoogleHomePage(driver);
		googlePage.setAndSearchGivenText(SearchTerm);
	}

	@Then("The first search result should be \"([^\"]*)\"")
	public void validate_search_result(String strExpectedURL) throws Throwable {
		GoogleHomePage googlePage = new GoogleHomePage(driver);
		String url = googlePage.getFirstResultURL();
		Assert.assertEquals("validation First Search Result", strExpectedURL, url);
	}
	
	@And("Close browser")
	public void close_Borwser() throws Throwable {
		closeDriver();
	}

}
