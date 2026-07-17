package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageNewsPage;
import constant.Constant;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	public HomePage homepage;
	ManageNewsPage news;

	@Test(retryAnalyzer = retry.Retry.class, groups = {
			"Regression" }, description = "Verify that the system saves the news details successfully when valid data is entered and the Save button is clicked")
	public void verifyWhetherUserIsAbleToSave() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		homepage = loginpage.signIn();
		// ManageNewsPage news = new ManageNewsPage(driver);
		news = homepage.newsMoreinfo();
		String newsoffer = ExcelUtility.getStringData(1, 0, "news");
		news.newbutton().news(newsoffer).save();
		// news.news(newsoffer);
		// news.save();
		boolean alert = news.isAlertIsDisplayed();
		Assert.assertTrue(alert,Constant.MANAGENEWS);
	}
}