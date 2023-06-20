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
	
	@Test(priority=1)
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyRemoveFromCart(String username, String password, String isvaliduser){
		LoginPage loginPage = new LoginPage(driver);
		login(loginPage, username, password, isvaliduser);
		addToCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.removeFromCart();
		loginPage.logOut();
	}
	
	@Test(priority=2) 
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyContinueShopping(String username, String password, String isvaliduser){
		LoginPage loginPage = new LoginPage(driver);
		CartPage cartPage = new CartPage(driver);
		ProductPage productPage = new ProductPage(driver);
		login(loginPage, username, password, isvaliduser);
		addToCart();
		cartPage.continueShopping();
		Assert.assertEquals(productPage.checkElementsExist(), true);
		loginPage.logOut();
	}	
	
	@Test(priority=3) 
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyAddToCart(String username, String password, String isvaliduser){
		LoginPage loginPage = new LoginPage(driver);
		CartPage cartPage = new CartPage(driver);
	    login(loginPage, username, password, isvaliduser);
		addToCart();
		Assert.assertEquals(cartPage.checkElementsExist(), true);
		//loginPage.logOut();
	}
	
	@Test(priority=4) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyProceedToCheckout(String username, String password, String isvaliduser){
		LoginPage loginPage = new LoginPage(driver);
		CartPage cartPage = new CartPage(driver);
		OrderPage orderPage = new OrderPage(driver);
		login(loginPage, username, password, isvaliduser);
		addToCart();
		cartPage.clickCheckoutButton();
		Assert.assertEquals(orderPage.checkElementsExist(), true);
		//loginPage.logOut();
	}

}
