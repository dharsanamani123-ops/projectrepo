package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	public WebDriver driver;
	/*@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement categorymoreinfo;*/
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement category;
	@FindBy(xpath = "//li[@id='4-selectable']")
	WebElement organic;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefile;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*public void categoryMoreinfo() {
		categorymoreinfo.click();
	}*/

	public ManageCategoryPage newbutton() {
		newbutton.click();
		return this;
	}

	public ManageCategoryPage category(String vegges) {
		category.sendKeys(vegges);
		return this;
	}

	public ManageCategoryPage organic() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToBeClickable(driver, organic);
		PageUtility utility = new PageUtility();
		utility.scrollIntoElement(organic, driver);
		organic.click();
		return this;
	}

	public ManageCategoryPage choosefile() {
		FileUploadUtility fileupload = new FileUploadUtility();
		fileupload.fileUploadUsingSendKeys(Constant.APPLEIMG, choosefile);
		return this;
	}

	public ManageCategoryPage save() {
		PageUtility utility = new PageUtility();
		utility.click(save, driver);
		utility.scrollIntoElement(save, driver);
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();

	}
}


