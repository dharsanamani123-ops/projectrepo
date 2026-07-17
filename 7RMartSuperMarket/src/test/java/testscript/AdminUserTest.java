package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUsersPage;
import Pages.HomePage;
import Pages.LoginPage;
import constant.Constant;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	HomePage homepage;
	AdminUsersPage adminuserpage;

	@Test(retryAnalyzer = retry.Retry.class, groups = {
			"Regression" }, description = "Verify that the user is able to saves the admin user details successfully when valid data is entered and the Save button is clicked")
	public void verifyWhetherUserIsAbleToSaveInformationsOnAdminUser() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		homepage = loginpage.signIn();
		// AdminUsersPage adminuserpage = new AdminUsersPage(driver);
		adminuserpage = homepage.clickAdminMoreInfo();
		adminuserpage.clickNewButton();
		FakerUtility faker = new FakerUtility();
		String adminusername = faker.creatARandomFirstName();
		// String adminusername=ExcelUtility.getStringData(1, 0, "adminuser");
		String adminPassword = ExcelUtility.getStringData(1, 1, "adminuser");
		String usertype = ExcelUtility.getStringData(1, 2, "adminuser");
		adminuserpage.clickNewButton().username(adminusername).password(adminPassword).selectUserType(usertype).save();
		boolean alertpage = adminuserpage.isAlertDisplayed();
		Assert.assertTrue(alertpage, Constant.ADMINUSER);
	}
}
