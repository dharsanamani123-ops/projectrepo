package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;

	/*@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and  @class='small-box-footer']")
	WebElement adminmoreinfo;*/
	@FindBy(xpath = "(//a[@href='javascript:void(0)'])[1]")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertype;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement save;
	@FindBy(xpath = "//button[@class='close']")
	WebElement alertpage;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/*public void clickAdminMoreInfo() {
		adminmoreinfo.click();
	}*/
	public AdminUsersPage clickNewButton() {
		newbutton.click();
		return this;
	}
	public AdminUsersPage username(String adminusername) {
		username.sendKeys(adminusername);
		return this;
	}
	public AdminUsersPage password(String adminpassword) {
		password.sendKeys(adminpassword);
		return this;
	}
	public AdminUsersPage selectUserType(String usertypeValue) {
		PageUtility utility = new PageUtility();
		utility.dropDownVisibleText(usertype, usertypeValue);
		return this;
	}
	public AdminUsersPage save() {
		save.click();
		return this;
	}
	public boolean isAlertDisplayed() {
		return alertpage.isDisplayed();
	}
}
