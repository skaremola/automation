package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	By firstNameField = By.cssSelector("input#first-name");
	By lastNameField = By.cssSelector("input#last-name");
	By postalCodeField = By.cssSelector("input#postal-code");
	By cancelButton = By.cssSelector("button#cancel");
	By continueButton = By.cssSelector("input#continue");
	

	WebDriver driver;
	WebDriverWait wait;
	
	public boolean checkElementsExist() {
		if (!(driver.findElements(firstNameField).size() > 0))
			return false;
		if (!(driver.findElements(lastNameField).size() > 0))
			return false;
		if (!(driver.findElements(postalCodeField).size() > 0))
			return false;
		if (!(driver.findElements(cancelButton).size() > 0))
			return false;
		if (!(driver.findElements(continueButton).size() > 0))
			return false;
		return true;
		
	}


	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}

	public void enterFirstName(String firstName) {
		driver.findElement(firstNameField).clear();
		driver.findElement(firstNameField).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(lastNameField).clear();
		driver.findElement(lastNameField).sendKeys(lastName);
	}
	
	public void enterPostalCode(String postalCode) {
		driver.findElement(postalCodeField).clear();
		driver.findElement(postalCodeField).sendKeys(postalCode);
	}
	
	public void clickCancel() {
		driver.findElement(cancelButton).click();
	}
	
	public void clickContinue() {
		driver.findElement(continueButton).click();
	}

	public void refresh() {
		driver.navigate().refresh();
	}


	
}
