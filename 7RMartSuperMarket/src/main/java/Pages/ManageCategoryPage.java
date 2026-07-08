package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {
	public WebDriver driver;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement moreinfo;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")WebElement newbutton;
@FindBy(xpath="//input[@id='category']")WebElement category;
@FindBy(xpath="//li[@id='4-selectable']")WebElement organic;
@FindBy(xpath="//input[@id='main_img']")WebElement choosefile;
@FindBy(xpath="//button[text()='Save']")WebElement save;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;

public ManageCategoryPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void categoryMoreinfo() {
	moreinfo.click();
}
public void newbutton() {
	newbutton.click();
}
public void category(String vegges) {
	category.sendKeys(vegges);
}
public void organic() {
	organic.click();
}
public void choosefile() {
	FileUploadUtility fileupload=new FileUploadUtility();
fileupload.fileUploadUsingSendKeys(Constant.APPLEIMG, choosefile);
}
public void save() {
	PageUtility obj = new PageUtility();
	obj.click(save, driver);
}
public boolean isAlertDisplayed() {
	return alert.isDisplayed();
	
}
}


