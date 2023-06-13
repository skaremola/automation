package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.OrderPage;

public class OrderPageTest extends BasePage{

	@Test(priority=0) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyOrderPage(String username, String password, String isvaliduser) {
		LoginPage loginPage = new LoginPage(driver);
		CartPage cartPage = new CartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		ProductPageTest.login(loginPage, username, password, isvaliduser);
		ProductPageTest.addToCart();
		cartPage.clickCheckoutButton();
		Assert.assertEquals(checkoutPage.checkElementsExist(), true);
		loginPage.logOut();
	}
	
	@Test(priority=1) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyContinueOrder(String username, String password, String isvaliduser) {
		LoginPage loginPage = new LoginPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		ProductPageTest.login(loginPage, username, password, isvaliduser);
		OrderPage orderPage = new OrderPage(driver);
		ProductPageTest.addToCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickCheckoutButton();
		checkoutPage.enterFirstName("Sridevi");
		checkoutPage.enterLastName("K");
		checkoutPage.enterPostalCode("12345");
		checkoutPage.clickContinue();
		Assert.assertEquals(orderPage.checkElementsExist(), true);
		orderPage.clickFinsh();
		Assert.assertEquals(orderPage.checkOrderConfirmation(), true);
		loginPage.logOut();
	}
	

}
