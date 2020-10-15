package clarivate.testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
features = "C:/Users/UC209277/eclipse-workspace/Cucumber_Clarivate/src/test/java/clarivate/featurefiles",
glue= "clarivate/stepdefinition",
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
monochrome = true
)

public class TestRunner {
//	String WorkingDir = System.getProperty("user.dir");
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));
    }
	
	
	

}