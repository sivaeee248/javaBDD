package clarivate.stepdefinition;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import clarivate.pages.GoogleHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SearchClarivate {
    public static WebDriver driver;
    @Given("^launch googlepage$")
    public void launch_GooglePage() throws Throwable {
    	String WorkingDir = System.getProperty("user.dir");
    	WorkingDir=WorkingDir+"\\drivers";
    	System.setProperty("webdriver.chrome.driver", WorkingDir+"\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
        }
    
    
    @When("^Search given String \\\"([^\\\"]*)\\\"$")
    public void search_given_string(String SearchTerm) throws Throwable {
    	GoogleHomePage googlePage = new GoogleHomePage(driver);
    	googlePage.setAndSearchGivenText(SearchTerm);
    }
    
    @Then("^Validate search Result$")
    public void validate_search_result() throws Throwable {
    	GoogleHomePage googlePage = new GoogleHomePage(driver);
    	   String url = googlePage.getFirstResultURL();
    	   Assert.assertEquals("Validate First Search Result","https://clarivate.com/",url);
    }
    
       
}
