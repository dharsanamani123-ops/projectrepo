package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void dropDownVisibleText(WebElement elementname, String visibletext) {
		Select select = new Select(elementname);
		select.selectByVisibleText(visibletext);
	}

	public void dropDownIndex(WebElement elementname, int index) {
		Select select = new Select(elementname);
		select.selectByIndex(index);
	}

	public void dropDownValue(WebElement elementname, String value) {
		Select select = new Select(elementname);
		select.selectByValue(value);
	}

	public void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop) {
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();

	}

	public void mouseHover(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void rightClick(WebElement elementname, WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick(elementname).perform();
	}

	public void doubleClick(WebElement elementname, WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick(elementname).perform();
	}

	public void click(WebElement elementname, WebDriver driver) {
		Actions action = new Actions(driver);
		action.click(elementname).perform();
	}
	public void inputFieldUsingJavaScript(WebElement elementname,String value, JavascriptExecutor driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='value';",  elementname);
		elementname.sendKeys(value);
	}
	public void clickUsingJavaScript(WebElement elementname, JavascriptExecutor driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='value';",  elementname);
		elementname.click();
	}
	
	public void scrollUsingJavaScript(int x, int y, JavascriptExecutor driver, int scrollHeight) {
	    JavascriptExecutor js =(JavascriptExecutor) driver;

	    // Scroll by given x and y values
	    js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);

	    // Scroll to the bottom of the page
	    js.executeScript("window.scrollBy(0, arguments[0]);", scrollHeight);
	}

}
