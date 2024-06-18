package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {

	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String keys) {
		getElement(locator).sendKeys(keys);
	}
	
	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public String getElementText(By locator) {
		return getElement(locator).getText();
	}
	
	public String getElementAttributeValue(By locator, String attribute) {
		return getElement(locator).getAttribute(attribute);
	}
	
	public void selectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);	
	}
}
