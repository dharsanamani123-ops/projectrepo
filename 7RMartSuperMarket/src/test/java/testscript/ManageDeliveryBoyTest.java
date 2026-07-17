package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageDeliveryBoyPage;
import constant.Constant;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageDeliveryBoyTest extends Base {
	HomePage homepage;
	ManageDeliveryBoyPage deliverypage;

	@Test(retryAnalyzer = retry.Retry.class, groups = {
			"Regression" }, description = "Verify that the user is able to saves the deliveryboy details successfully when valid data is entered and the Save button is clicked")
	public void verifyWhetherUserIsAbleToAddDeliveryBoyList() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		homepage = loginpage.signIn();
		// ManageDeliveryBoyPage deliverypage = new ManageDeliveryBoyPage(driver);
		deliverypage = homepage.deliveryBoyMoreInfo();
		String names = ExcelUtility.getStringData(1, 0, "deliveryboy");
		String emails = ExcelUtility.getStringData(1, 1, "deliveryboy");
		int phones = ExcelUtility.getIntegerData(1, 2, "deliveryboy");
		String addresses = ExcelUtility.getStringData(1, 3, "deliveryboy");
		FakerUtility utility = new FakerUtility();
		String username = utility.creatARandomFirstName();
		String password = ExcelUtility.getStringData(1, 4, "deliveryboy");
		deliverypage.newButton().name(names).emails(emails).phones(phones).address(addresses).username(username)
				.password(password).save();
		boolean alertpage = deliverypage.isAlertDisplayed();
		Assert.assertTrue(alertpage,Constant.MANAGEDELIVERY);
	}
}
