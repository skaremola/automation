package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BasePage{

	@Test(priority=0)
	public void verifyHomePage() {
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertEquals(loginPage.getTitle(), "Swag Labs", "Title does not match");
		Assert.assertTrue(loginPage.getLogo());
		Assert.assertEquals(loginPage.checkElementsExist(), true, "Element is missing in Homepage");
	}
	
	

}
