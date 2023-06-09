package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;


public class ProductPageTest extends BasePage{
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ProductPageTest(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public void login(LoginPage login, String username, String password, String isvaliduser) {
		login.typeUsername(username);
		login.typePassword(password);
		login.clickSignIn();
		Assert.assertTrue(login.verifyNewPage(isvaliduser));
	}
	
	
	public void addToCart() {
		CartPage checkoutPage = new CartPage(driver);
		ProductPage productPage = new ProductPage(driver);
		productPage.addToCart();
		productPage.clickCartSymbol();
		checkoutPage.checkProductExist();
	}
	

	@Test(priority=0) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyRemoveFromCart(String username, String password, String isvaliduser){
		LoginPage loginPage = new LoginPage(driver);
		login(loginPage, username, password, isvaliduser);
		addToCart();
		CartPage checkoutPage = new CartPage(driver);
		checkoutPage.removeFromCart();
		loginPage.logOut();
	}
	@Test(priority=1) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyContinueShopping(String username, String password, String isvaliduser){
		LoginPage loginPage = new LoginPage(driver);
		login(loginPage, username, password, isvaliduser);
		addToCart();
		CartPage checkoutPage = new CartPage(driver);
		checkoutPage.continueShopping();
		loginPage.logOut();
	}	
	
	@Test(priority=2) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyAddToCart(String username, String password, String isvaliduser){
		LoginPage loginPage = new LoginPage(driver);
		login(loginPage, username, password, isvaliduser);
		addToCart();
		loginPage.logOut();
	}
	@Test(priority=3) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyProceedToCheckout(String username, String password, String isvaliduser){
		LoginPage loginPage = new LoginPage(driver);
		login(loginPage, username, password, isvaliduser);
		addToCart();
		CartPage checkoutPage = new CartPage(driver);
		checkoutPage.clickCheckoutButton();
		//logout(loginpage);
	}

}
