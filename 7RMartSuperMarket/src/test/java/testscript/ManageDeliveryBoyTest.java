package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;
public class ManageDeliveryBoyTest extends Base {
		@Test(retryAnalyzer = retry.Retry.class,groups= {"Regression"},description="Verify that the user is able to saves the deliveryboy details successfully when valid data is entered and the Save button is clicked")
		public void verifyWhetherUserIsAbleToAddDeliveryBoyList() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
			String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUserName(usernamevalue);
			loginpage.enterPassword(passwordvalue);
			loginpage.signIn();
			ManageDeliveryBoyPage deliverypage = new ManageDeliveryBoyPage(driver);
			deliverypage.deliveryBoyMoreInfo();
			deliverypage.newButton();
			String names = ExcelUtility.getStringData(1, 0, "deliveryboy");
			deliverypage.name(names);
			String emails = ExcelUtility.getStringData(1, 1, "deliveryboy");
			deliverypage.emails(emails);
			int phones = ExcelUtility.getIntegerData(1, 2, "deliveryboy");
			deliverypage.phones(phones);
			String addresses = ExcelUtility.getStringData(1, 3, "deliveryboy");
			deliverypage.address(addresses);
			FakerUtility utility = new FakerUtility();
			String username = utility.creatARandomFirstName();
			deliverypage.username(username);
			String password = ExcelUtility.getStringData(1, 4, "deliveryboy");
			deliverypage.password(password);
			deliverypage.save();
			boolean alertpage = deliverypage.isAlertDisplayed();
			Assert.assertTrue(alertpage);
		}
	}

