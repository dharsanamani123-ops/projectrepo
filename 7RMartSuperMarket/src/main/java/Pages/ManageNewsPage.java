package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;
	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"))
	WebElement moreinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement news;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement save;
	@FindBy(xpath = "//h5[text()=' Alert!'] ")
	WebElement alert;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void newsMoreinfo() {
		PageUtility obj = new PageUtility();
		obj.click(moreinfo, driver);
	}

	public void newbutton() {
		WaitUtility utility = new WaitUtility();
		utility.waitForElementToBeClickable(driver, newbutton);
		newbutton.click();
	}

	public void news(String newsoffer) {
		news.sendKeys(newsoffer);
	}

	public void save() {
		save.click();
	}

	public boolean isAlertIsDisplayed() {
		return alert.isDisplayed();
	}
}
