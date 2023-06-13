package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.OrderPage;
public class CheckoutPageTest extends BasePage{

	@Test(priority=0) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyCheckoutPage(String username, String password, String isvaliduser) {
		LoginPage loginPage = new LoginPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		ProductPageTest.login(loginPage, username, password, isvaliduser);
		ProductPageTest.addToCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickCheckoutButton();
		AssertJUnit.assertEquals(checkoutPage.checkElementsExist(), true);
		loginPage.logOut();
	}
	
	@Test(priority=1) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyContinueCheckout(String username, String password, String isvaliduser) {
		LoginPage loginPage = new LoginPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		ProductPageTest.login(loginPage, username, password, isvaliduser);
		ProductPageTest.addToCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickCheckoutButton();
		checkoutPage.enterFirstName("Sridevi");
		checkoutPage.enterLastName("K");
		checkoutPage.enterPostalCode("12345");
		checkoutPage.clickContinue();
		AssertJUnit.assertEquals(orderPage.checkElementsExist(), true);
		loginPage.logOut();
	}
	

}
