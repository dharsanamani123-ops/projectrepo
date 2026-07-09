package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")
	WebElement deliveryBoyMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement address;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void deliveryBoyMoreInfo() {
		deliveryBoyMoreInfo.click();
	}

	public void newButton() {
		newbutton.click();
	}

	public void name(String names) {
		name.sendKeys(names);
	}

	public void emails(String emails) {
		email.sendKeys(emails);
	}

	public void phones(int phones) {
		phone.sendKeys(String.valueOf(phones));
	}

	public void address(String addresses) {
		address.sendKeys(addresses);
	}

	public void username(String usernames) {
		username.sendKeys(usernames);
	}

	public void password(String passwords) {
		password.sendKeys(passwords);
	}

	public void save() {
		PageUtility obj = new PageUtility();
		obj.click(save, driver);
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();

	}
}
