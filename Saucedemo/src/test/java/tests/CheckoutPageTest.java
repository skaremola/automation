package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;
import pages.CheckoutPage;
import pages.LoginPage;
import tests.ProductPageTest;

public class CheckoutPageTest extends BasePage{

	@Test(priority=0) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyCheckoutPage(String username, String password, String isvaliduser) {
		ProductPageTest prodPageTest = new ProductPageTest(driver);
		LoginPage loginPage = new LoginPage(driver);
		prodPageTest.verifyProceedToCheckout(username, password, isvaliduser);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		Assert.assertEquals(checkoutPage.checkElementsExist(), true, "Element is missing in Checkout page");
		loginPage.logOut();
	}
	
	@Test(priority=1) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyContinueCheckout(String username, String password, String isvaliduser){
		ProductPageTest prodPageTest = new ProductPageTest(driver);
		LoginPage loginPage = new LoginPage(driver);
		prodPageTest.verifyProceedToCheckout(username, password, isvaliduser);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.enterFirstName("Sridevi");
		checkoutPage.enterLastName("K");
		checkoutPage.enterPostalCode("12345");
		checkoutPage.clickContinue();
		loginPage.logOut();
	}
	

}
