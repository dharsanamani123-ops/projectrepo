package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.ManageLocationPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageLocationTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class,groups= {"Regression"})
	public void verifyWhetherUserIsAbleToEnterLocationInformations() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signIn();
		ManageLocationPage locationtest = new ManageLocationPage(driver);
		locationtest.locationMoreInfo();
		locationtest.newbutton();
		String countryname = ExcelUtility.getStringData(1, 0, "location");
		locationtest.country(countryname);
		String statename = ExcelUtility.getStringData(1, 1, "location");
		locationtest.state(statename);
		FakerUtility utility = new FakerUtility();
		String locationname = utility.generateAddress();
		locationtest.location(locationname);
		int chargeamount = ExcelUtility.getIntegerData(1, 3, "location");
		locationtest.charge(chargeamount);
		locationtest.save();
		boolean alertpage = locationtest.isAlertDisplayed();
		Assert.assertTrue(alertpage);
	}
}
