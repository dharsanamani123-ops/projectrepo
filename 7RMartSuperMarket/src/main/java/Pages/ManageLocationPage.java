package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageLocationPage {
	public WebDriver driver;
	/*@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location' and @class='small-box-footer']")
	WebElement locationMoreInfo;*/
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//select[@id='country_id']")
	WebElement country;
	@FindBy(xpath = "//select[@id='st_id']")
	WebElement state;
	@FindBy(xpath = "//input[@id='location']")
	WebElement location;
	@FindBy(xpath = "//input[@id='delivery']")
	WebElement charge;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*public void locationMoreInfo() {
		locationMoreInfo.click();
	}*/

	public ManageLocationPage newbutton() {
		newbutton.click();
		return this;
	}

	public ManageLocationPage country(String countryname) {
		PageUtility utility = new PageUtility();
		utility.dropDownVisibleText(country, countryname);
		return this;
	}

	public ManageLocationPage state(String statename) {
		PageUtility utility = new PageUtility();
		utility.dropDownVisibleText(state, statename);
		return this;
	}

	public ManageLocationPage location(String locationname) {
		location.sendKeys(locationname);
		return this;
	}

	public ManageLocationPage charge(int chargeamount) {
		charge.sendKeys(String.valueOf(chargeamount));
		return this;
	}

	public ManageLocationPage save() {
		save.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}






