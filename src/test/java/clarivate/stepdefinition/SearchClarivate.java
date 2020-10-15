package clarivate.stepdefinition;

import org.junit.Assert;

import clarivate.pages.BasePage;
import clarivate.pages.GoogleHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchClarivate extends BasePage{
//    public static WebDriver driver;
	@Given("Open Browser$")
	public void open_Browser() throws Throwable {
		driver = launchDriver(properties.getProperty("browser"));
	}
	
	@When("^Navigate to Google$")
	public void Navigate_to_Google() throws Throwable {
//		driver.get(getConfigProperties("config.properties").getProperty("App_url"));
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
//    	   Assert.assertEquals("Validate First Search Result","https://clarivate.com/",url);
    	   Assert.assertEquals("Validate First Search Result",strExpectedURL,url);
    }
    
       
}
