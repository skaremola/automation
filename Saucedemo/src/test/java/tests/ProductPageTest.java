package tests;


import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.OrderPage;


public class ProductPageTest extends BasePage{
	
	
	public static void login(LoginPage login, String username, String password, String isvaliduser) {
		login.typeUsername(username);
		login.typePassword(password);
		login.clickSignIn();
		Assert.assertTrue(login.verifyNewPage(isvaliduser));
	}
	
	
	public static void addToCart() {
		CartPage checkoutPage = new CartPage(driver);
		ProductPage productPage = new ProductPage(driver);
		productPage.clickAddToCart();
		productPage.clickCartSymbol();
		checkoutPage.checkProductExist();
	}
	
	@Test(priority=0)
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyRemoveFromCart(String username, String password, String isvaliduser){
		LoginPage loginPage = new LoginPage(driver);
		ProductPageTest.login(loginPage, username, password, isvaliduser);
		ProductPageTest.addToCart();
		CartPage checkoutPage = new CartPage(driver);
		checkoutPage.removeFromCart();
		loginPage.logOut();
	}
	
	@Test(priority=1) 
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyContinueShopping(String username, String password, String isvaliduser){
		LoginPage loginPage = new LoginPage(driver);
		CartPage checkoutPage = new CartPage(driver);
		ProductPage productPage = new ProductPage(driver);
		ProductPageTest.login(loginPage, username, password, isvaliduser);
		ProductPageTest.addToCart();
		checkoutPage.continueShopping();
		AssertJUnit.assertEquals(productPage.checkElementsExist(), true);
		loginPage.logOut();
	}	
	
	@Test(priority=2) 
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyAddToCart(String username, String password, String isvaliduser){
		LoginPage loginPage = new LoginPage(driver);
		ProductPageTest.login(loginPage, username, password, isvaliduser);
		ProductPageTest.addToCart();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		AssertJUnit.assertEquals(checkoutPage.checkElementsExist(), true);
		loginPage.logOut();
	}
	
	@Test(priority=3) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyProceedToCheckout(String username, String password, String isvaliduser){
		LoginPage loginPage = new LoginPage(driver);
		CartPage checkoutPage = new CartPage(driver);
		ProductPageTest.login(loginPage, username, password, isvaliduser);
		ProductPageTest.addToCart();
		OrderPage orderPage = new OrderPage(driver);
		checkoutPage.clickCheckoutButton();
		AssertJUnit.assertEquals(orderPage.checkElementsExist(), true);
		loginPage.logOut();
	}

}
