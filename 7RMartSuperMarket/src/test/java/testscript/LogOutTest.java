package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import constant.Constant;

public class LogOutTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, groups = {
			"Regression" }, description = "verify user is able to logout from the page, when logout button is clicked")
	public void verifyUserCanLogoutSuccessfullyFromDashBoard() {
		String usernamevalue = "admin";
		String passwordvalue = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		HomePage logout = new HomePage(driver);
		logout.clickAdminButton();
		logout.clickLogoutButton();
		boolean alert = logout.isSigninDisplayed();
		Assert.assertTrue(alert, Constant.LOGOUT);

	}
}
