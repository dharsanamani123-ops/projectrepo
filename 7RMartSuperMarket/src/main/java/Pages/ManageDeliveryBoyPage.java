package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	/*@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")
	WebElement deliveryBoyMoreInfo;*/
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

	/*public void deliveryBoyMoreInfo() {
		deliveryBoyMoreInfo.click();
	}*/

	public  ManageDeliveryBoyPage newButton() {
		newbutton.click();
		return this;
	}

	public ManageDeliveryBoyPage name(String names) {
		name.sendKeys(names);
		return this;
	}

	public ManageDeliveryBoyPage emails(String emails) {
		email.sendKeys(emails);
		return this;
	}

	public ManageDeliveryBoyPage phones(int phones) {
		phone.sendKeys(String.valueOf(phones));
		return this;
	}

	public ManageDeliveryBoyPage address(String addresses) {
		address.sendKeys(addresses);
		return this;
	}

	public ManageDeliveryBoyPage username(String usernames) {
		username.sendKeys(usernames);
		return this;
	}

	public ManageDeliveryBoyPage password(String passwords) {
		password.sendKeys(passwords);
		return this;
	}

	public ManageDeliveryBoyPage save() {
		PageUtility obj = new PageUtility();
		obj.click(save, driver);
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();

	}
}
