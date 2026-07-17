package testscript;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageCategoryPage;
import constant.Constant;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base {
	HomePage homepage;
	ManageCategoryPage managecategory;

	@Test(retryAnalyzer = retry.Retry.class, groups = {
			"Regression" }, description = "Verify that the user is able to upload file successfully when the Save button is clicked")
	public void verifyWhetherUserIsAbleToUploadFileOnCategoryPage() throws IOException, AWTException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		homepage = loginpage.signIn();
		// ManageCategoryPage managecategory = new ManageCategoryPage(driver);
		FakerUtility faker = new FakerUtility();
		String vegges = faker.generateCategory();
		managecategory= homepage.categoryMoreinfo();
		managecategory.newbutton().category(vegges).organic().choosefile().save();
		// String vegges = ExcelUtility.getStringData(1, 0, "category");
		/*
		 * managecategory.category(vegges); managecategory.organic();
		 * managecategory.choosefile(); managecategory.save();
		 */
		boolean alert = managecategory.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.MANAGECATEGORY);
	}
}
