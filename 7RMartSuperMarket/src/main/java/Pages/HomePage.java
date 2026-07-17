package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	public WebDriver driver;
	
	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"))
	WebElement newsmoreinfo;	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location' and @class='small-box-footer']")
	WebElement locationMoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")
	WebElement deliveryBoyMoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement categorymoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and  @class='small-box-footer']")
	WebElement adminmoreinfo;
	
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logout;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signin;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageNewsPage newsMoreinfo() {
		PageUtility obj = new PageUtility();
		obj.click(newsmoreinfo, driver);
		return new ManageNewsPage(driver);
	} 
	
	public ManageLocationPage locationMoreInfo() {
		locationMoreInfo.click();
		return new ManageLocationPage(driver) ;
	}
	
	public ManageDeliveryBoyPage deliveryBoyMoreInfo() {
		deliveryBoyMoreInfo.click();
		return new ManageDeliveryBoyPage(driver);
	}

	public ManageCategoryPage categoryMoreinfo() {
		categorymoreinfo.click();
		return new ManageCategoryPage(driver);
	}
	public AdminUsersPage clickAdminMoreInfo() {
		adminmoreinfo.click();
		return new AdminUsersPage(driver);
	}
	
	
	
	public void clickAdminButton() {
		admin.click();
	}

	public void clickLogoutButton() {
		logout.click();
	}

	public boolean isSigninDisplayed() {
		return signin.isDisplayed();

	}
}
