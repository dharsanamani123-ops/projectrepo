package testscript;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LogOutPage;
import Pages.LoginPage;

public class LogOutTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class,groups= {"Regression"})
	public void verifyUserCanLogoutSuccessfullyFromDashBoard() {
		String usernamevalue = "admin";
		String passwordvalue = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		LogOutPage logout = new LogOutPage(driver);
		logout.clickAdminButton();
		logout.clickLogoutButton();
		boolean alert=logout.isSigninDisplayed();
		Assert.assertTrue(alert);

	}
}
