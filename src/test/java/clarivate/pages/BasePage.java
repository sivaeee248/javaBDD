package clarivate.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	
	public WebDriver driver;
	Properties properties;
	
	/**
     * This method is to load the given property file
     * @param propertyFilePath This is the path of the physical property file
     * @return Properties object after loading the property file
     */
	
	public Properties getConfigProperties(String propertyFilePath) {
		properties = new Properties();
		FileInputStream inputStream;
        try{
            inputStream = new FileInputStream(propertyFilePath);
            properties.load(inputStream);
        } catch (IOException e) { e.printStackTrace(); }
        return properties;
	}
	
	/**
     * This method is for Launch of given browser
     * @param browserName i.e., either FIREFOX or CHROME 
     * @return Webdriver object after initializing   
     */
	
	public WebDriver launchDriver(String browserName)
	{
		String WorkingDir = System.getProperty("user.dir");
    	WorkingDir=WorkingDir+"\\drivers";
		if(browserName.trim().equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", WorkingDir+"\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", WorkingDir+"\\chromedriver.exe.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(getConfigProperties("config.properties").getProperty("implicit_wait_timeout")),TimeUnit.SECONDS);
        return driver;
	}

}
