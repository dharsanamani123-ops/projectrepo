package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		boolean homepage = loginpage.isDashBoardDisplayed();
		Assert.assertTrue(homepage);

	}

	 @Test(retryAnalyzer=retry.Retry.class)
	public void verifyWhetherUserIsAbleToLoginUsingCorrectUsernameAndIncorrectPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert);
	}

	 @Test(retryAnalyzer=retry.Retry.class)
	public void verifyWhetherUserIsAbleToLoginUsingIncorrectUsernameAndcorrectPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(3, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(3, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert);
	}

    @Test(retryAnalyzer=retry.Retry.class)
	public void verifyWhetherUserIsAbleToLoginUsingInvalidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(4, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(4, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		boolean alert = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert);
	}
}

