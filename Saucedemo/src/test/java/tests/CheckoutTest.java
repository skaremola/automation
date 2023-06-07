package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest extends BasePage{

	@Test(priority=0)
	public void verifyCheckoutPage() {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		//logger.log(LogStatus.INFO, "Checking title matches string");

		Assert.assertEquals(checkoutPage.checkElementsExist(), true, "Element is missing in Checkout page");
		//logger.log(LogStatus.PASS, "Title matches with title from DOM");
	}

}
