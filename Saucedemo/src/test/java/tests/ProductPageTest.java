package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;
import pages.HomePage;

public class ProductPageTest extends BasePage{

	@Test(priority=0)
	public void navigateToForumsPage() {
		HomePage homePage = new HomePage(driver);
//		homePage.hoverOverCommunityTab();
//		logger.log(LogStatus.INFO, "Hovering over 'Community'");
//		homePage.clickOnForumsTab();
//		logger.log(LogStatus.INFO, "Clicking 'Forums'");
//		homePage.switchTabs();
//		logger.log(LogStatus.WARNING, "Opening tab in a new browser, switching to active tab");
	}


}
