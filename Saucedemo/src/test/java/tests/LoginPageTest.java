package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends BasePage{


	public void navigateToLoginPage() {
		HomePage homePage = new HomePage(driver);
		//homePage.clickLogInLink();
		//logger.log(LogStatus.INFO, "Clicking 'Log In or Sign Up' button");
//		homePage.clickSigninLink();
//		logger.log(LogStatus.INFO, "Clicking the 'Sign in' link");
	}

	//* Test invalid login attempts using data from DataProvider
	@DataProvider(name="accounts")
	public Object[][] getData(){
		return new Object[][] {
			{"standard_user", "secret_sauce"},  // Valid user
			{"locked_out_user", "secret_sauce"}, // Invalid user
			{"problem_user", "secret_sauce"},	 // Valid user
			{"performance_glitch_user","secret_sauce"} // Valid user

		};
	}

//	@Test(priority=-1, dataProvider="accounts")
//	public void verifyInvalidLoginCredentials(String testUsername, String testPassword) throws InterruptedException {
//		LoginPage login = new LoginPage(driver);
//		login.typeUsername(testUsername);
//		logger.log(LogStatus.INFO, "Entering invalid username");
//		Thread.sleep(5000);
//		login.typePassword(testPassword);
//		logger.log(LogStatus.INFO, "Entering invalid password");
//		login.clickSignIn();
//		logger.log(LogStatus.INFO, "Clicking Sign in button");
//		Assert.assertTrue(login.errorContainerDisplayed());
//		logger.log(LogStatus.PASS, "Log in with invalid crendentials failed");
//	}

	@Test(priority=0) //, dataProvider="accounts")
	@Parameters({"username", "password", "isvaliduser"})
	public void verifyLogin(String username, String password, String isvaliduser){
		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		System.out.println("Entered username: "+ username);
		login.typeUsername(username);
		//logger.log(LogStatus.INFO, "Entering valid username");
		System.out.println("Entered password: "+ password);
		login.typePassword(password);
		//logger.log(LogStatus.INFO, "Entering valid password");
		login.clickSignIn();
		//logger.log(LogStatus.INFO, "Clicking Sign in button");
		Assert.assertTrue(login.verifyNewPage(isvaliduser));
	}
}
