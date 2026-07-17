package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageLocationPage;
import constant.Constant;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageLocationTest extends Base {
	HomePage homepage;
	ManageLocationPage locationtest;

	@Test(retryAnalyzer = retry.Retry.class, groups = {
			"Regression" }, description = "Verify that the user is able to enterlocation details successfully when valid data is entered")
	public void verifyWhetherUserIsAbleToEnterLocationInformations() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		homepage = loginpage.signIn();
		// ManageLocationPage locationtest = new ManageLocationPage(driver);
		locationtest = homepage.locationMoreInfo();
		String countryname = ExcelUtility.getStringData(1, 0, "location");
		String statename = ExcelUtility.getStringData(1, 1, "location");
		FakerUtility utility = new FakerUtility();
		String locationname = utility.generateAddress();
		int chargeamount = ExcelUtility.getIntegerData(1, 3, "location");
		locationtest.newbutton().country(countryname).state(statename).location(locationname).charge(chargeamount)
				.save();
		boolean alertpage = locationtest.isAlertDisplayed();
		Assert.assertTrue(alertpage,Constant.MANAGELOCATION);
	}
}
