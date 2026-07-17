package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import constant.Constant;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	 HomePage homepage;
	@Test(retryAnalyzer = retry.Retry.class,groups= {"Regression"},description="Test case for logging in with valid credentials")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		//loginpage.enterPassword(passwordvalue);
		homepage=loginpage.signIn();
		boolean homepage = loginpage.isDashBoardDisplayed();
		Assert.assertTrue(homepage,Constant.LOGINVALIDCREDENTIALS);
	}

	 @Test(retryAnalyzer=retry.Retry.class,groups= {"Regression"},description="Test case for logging in with invalid credentials")
	public void verifyWhetherUserIsAbleToLoginUsingCorrectUsernameAndIncorrectPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		//loginpage.enterPassword(passwordvalue);
		homepage=loginpage.signIn();
		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert,Constant.LOGINWITHINVALIDPASSWORD );
	}

	 @Test(retryAnalyzer=retry.Retry.class,groups= {"Regression"},description="Test case for logging in with invalid credentials")
	public void verifyWhetherUserIsAbleToLoginUsingIncorrectUsernameAndcorrectPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(3, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(3, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		//loginpage.enterPassword(passwordvalue);
		homepage=loginpage.signIn();
		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert,Constant.LOGINWITHINVALIDUSERNAME);
	}

    @Test(retryAnalyzer=retry.Retry.class,groups= {"Regression"},description="Test case for logging in with invalid credentials")
	public void verifyWhetherUserIsAbleToLoginUsingInvalidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(4, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(4, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		//loginpage.enterPassword(passwordvalue);
		homepage=loginpage.signIn();
		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert,Constant.LOGININVALIDCREDENIALS);
	}
}

