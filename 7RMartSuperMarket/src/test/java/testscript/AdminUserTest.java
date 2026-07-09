package testscript;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUsersPage;
import Pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class,groups= {"Regression"})
	public void verifyWhetherUserIsAbleToSaveInformationsOnAdminUser() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		AdminUsersPage adminuserpage = new AdminUsersPage(driver);
		adminuserpage.clickAdminMoreInfo();
		adminuserpage.clickNewButton();
		FakerUtility faker = new FakerUtility();
		String adminusername = faker.creatARandomFirstName();
		// String adminusername=ExcelUtility.getStringData(1, 0, "adminuser");
		String adminPassword = ExcelUtility.getStringData(1, 1, "adminuser");
		String usertype = ExcelUtility.getStringData(1, 2, "adminuser");
		adminuserpage.username(adminusername);
		adminuserpage.password(adminPassword);
		adminuserpage.selectUserType(usertype);
		adminuserpage.save();
		boolean alertpage = adminuserpage.isAlertDisplayed();
		Assert.assertTrue(alertpage);
	}
}
