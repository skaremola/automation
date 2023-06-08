package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.CheckoutPage;
import tests.LoginPageTest;

public class ProductPageTest extends BasePage{
	
	public void login(LoginPage login, String username, String password, String isvaliduser) {
		login.typeUsername(username);
		login.typePassword(password);
		login.clickSignIn();
		Assert.assertTrue(login.verifyNewPage(isvaliduser));
	}
	
	public void logout(LoginPage login) {
		login.openMenu();
		login.logOut();
	}
	
	public void addToCart() {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		ProductPage productPage = new ProductPage(driver);
		productPage.addToCart();
		productPage.clickCartSymbol();
		checkoutPage.checkProductExist();
	}
	
	@Test(priority=0) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyAddToCart(String username, String password, String isvaliduser){
		LoginPage loginpage = new LoginPage(driver);
		login(loginpage, username, password, isvaliduser);
		addToCart();
		logout(loginpage);
	}
	@Test(priority=1) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyRemoveFromCart(String username, String password, String isvaliduser){
		LoginPage loginpage = new LoginPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		login(loginpage, username, password, isvaliduser);
		addToCart();
		checkoutPage.removeFromCart();
		logout(loginpage);
	}
	@Test(priority=2) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyContinueShopping(String username, String password, String isvaliduser){
		LoginPage loginpage = new LoginPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		login(loginpage, username, password, isvaliduser);
		addToCart();
		checkoutPage.continueShopping();
		logout(loginpage);
	}	

//	@Test(priority=0) //, dataProvider="accounts")
//	@Parameters({"username", "password", "isvaliduser"})
//	public void verifyAddToCart(String username, String password, String isvaliduser){
//		LoginPage loginPage = new LoginPage(driver);
//		CheckoutPage checkoutPage = new CheckoutPage(driver);
//		ProductPage productPage = new ProductPage(driver);
//		System.out.println("Entered username: "+ username);
//		loginPage.typeUsername(username);
//		System.out.println("Entered password: "+ password);
//		loginPage.typePassword(password);
//		loginPage.clickSignIn();
//		productPage.addToCart();
//		productPage.clickCartSymbol();
//		checkoutPage.checkProductExist();
//		}

}
