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
	@Given("Open Browser$")
	public void open_Browser() throws Throwable {
		driver = launchDriver(properties.getProperty("browser"));
	}

	@When("^Navigate to Google$")
	public void Navigate_to_Google() throws Throwable {
		driver.get(properties.getProperty("App_url"));
	}

	@And("^Search given String \"([^\"]*)\"$")
	public void search_given_string(String SearchTerm) throws Throwable {
		GoogleHomePage googlePage = new GoogleHomePage(driver);
		googlePage.setAndSearchGivenText(SearchTerm);
	}

	@Then("Validate search Result \"([^\"]*)\"")
	public void validate_search_result(String strExpectedURL) throws Throwable {
		GoogleHomePage googlePage = new GoogleHomePage(driver);
		String url = googlePage.getFirstResultURL();
		Assert.assertEquals("Validate First Search Result", strExpectedURL, url);
	}

}
