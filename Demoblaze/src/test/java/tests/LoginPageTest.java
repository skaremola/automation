package tests;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

public class LoginPageTest extends BasePage{

	public void login(LoginPage login, String username, String password, String isvaliduser) {
		System.out.println("Entered username: "+ username);
		login.typeUsername(username);
		System.out.println("Entered password: "+ password);
		login.typePassword(password);
		login.clickSignIn();
		Assert.assertTrue(login.verifyNewPage(isvaliduser));
	}
	

	@Test(priority=0) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyLogin(String username, String password, String isvaliduser){
		LoginPage loginpage = new LoginPage(driver);
		login(loginpage, username, password, isvaliduser);
		//loginpage.logOut();
	}
}
