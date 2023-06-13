package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	By usernameField = By.id("user-name");
	By passwordField = By.id("password");
	By signInButton = By.id("login-button");
	By openMenu = By.cssSelector("button#react-burger-menu-btn");
	By logOutButton = By.cssSelector("a#logout_sidebar_link");
	By sauseLogo = By.cssSelector("div.login_logo");
	By errorContainer = By.cssSelector("h3");

	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) { // create a constructor and pass the driver instance
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public void openMenu() {
		driver.findElement(openMenu).click();
	}
	
	public void logOut() {
		driver.findElement(openMenu).click();
		driver.findElement(logOutButton).click();
	}
	
	public void typeUsername(String username) { //pass a parameter so we don't hardcode values in the object class.
		driver.findElement(usernameField).clear();
		driver.findElement(usernameField).sendKeys(username);
	}

	public void typePassword(String password){
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickSignIn() {
		driver.findElement(signInButton).click();
	}
	public String getTitle() {
		return driver.getTitle();
	}

	public boolean getLogo() {
		 return driver.findElement(sauseLogo).isDisplayed();
	}

	public boolean checkElementsExist() {
		if (!(driver.findElements(usernameField).size() > 0))
			return false;
		if (!(driver.findElements(passwordField).size() > 0))
			return false;
		if (!(driver.findElements(signInButton).size() > 0))
			return false;
		return true;
	}
	
	public boolean errorContainerDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorContainer)).isDisplayed();
	}

	public boolean verifyNewPage(String isvaliduser) {
		if (isvaliduser.equals("yes"))
		{
		wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
		return driver.getTitle().contains("Swag Labs");
		}
		else
		{
		return driver.findElement(errorContainer).getText().equals("Epic sadface: Sorry, this user has been locked out.");
		}
	}

}
