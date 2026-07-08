package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FileUploadUtility {
	
	public WebDriver driver;
	
	public  void fileUploadUsingSendKeys(String filepath,WebElement elementname)
	{
		elementname.sendKeys(filepath);
	}
	public void fileUploadUsingRobotClass(String filepath,WebElement elementname) throws AWTException
	{
		StringSelection obj = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
		Robot r = new Robot();
		r.delay(3000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
