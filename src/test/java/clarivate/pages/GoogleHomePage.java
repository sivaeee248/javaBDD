package clarivate.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;


public class GoogleHomePage {
	
	public WebDriver driver;
	
	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@title='Search']")
	private WebElement textbox_Search;
	
	@FindBy(xpath = "(//input[@value='Google Search'])[2]")
	private WebElement button_GoogleSearch;
	
	@FindBy(xpath = "//*[(@role='navigation') and (@id!='foot')]")
	private WebElement container_TopNavigation;
	
	@FindBy(xpath = "(//h3/ancestor::a)[1]")
	private WebElement link_FirstResult;
	
	public void setAndSearchGivenText(String strSearchString) {
		driver.getCurrentUrl();
		textbox_Search.sendKeys(strSearchString,Keys.ENTER);
	}
	
	public String getFirstResultURL() {
		return link_FirstResult.getAttribute("href");
	}
	
	public void clickOnButtonSearch() {
		button_GoogleSearch.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(container_TopNavigation));
	}

}
