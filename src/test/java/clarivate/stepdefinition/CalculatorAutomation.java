package clarivate.stepdefinition;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import clarivate.windows.BaseWindows;
import clarivate.windows.WindowsCalculator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.CalciKeys;

public class CalculatorAutomation extends BaseWindows{
	
	 private WindowsCalculator windowsCalculator;
	 private int inputNumber;
	
	@Given("Open Windows Calculator Application")
    public void openWindowsCalculatorApplication() throws MalformedURLException {
		
		winiumDriver = launchDesktopApp("C:\\Windows\\System32\\calc.exe","http://localhost:9999");
    }

    @When("Enter given number (\\d+)")
    public void enterValue(int number) {
    	windowsCalculator = new WindowsCalculator(winiumDriver);
    	inputNumber = number;
    	windowsCalculator.inputNumber(number);
    }

    @Then("Click on square root button")
    public void clickOnSquareRootButton() {
    	windowsCalculator.pressButton(CalciKeys.SQUAREROOT);
    }

    @Then("Calculated result should be correct")
    public void verifyCalulatorResult() {
        double actual = windowsCalculator.getResult();
        double expected = Math.sqrt(inputNumber);
        assertEquals(expected,actual,0.001);
    }
    
    @And("Close Calculator Application")
    public void CloseCalculatorApplication() {
        closeDriver();
    }
}
