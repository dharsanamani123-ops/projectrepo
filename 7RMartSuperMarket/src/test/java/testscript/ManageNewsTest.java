package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class,groups= {"Regression"},description="Verify that the system saves the news details successfully when valid data is entered and the Save button is clicked")
	public void verifyWhetherUserIsAbleToSave() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.newsMoreinfo();
		managenews.newbutton();
		String newsoffer = ExcelUtility.getStringData(1, 0, "news");
		managenews.news(newsoffer);
		managenews.save();
		boolean alert = managenews.isAlertIsDisplayed();
		Assert.assertTrue(alert);
	}
}