package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	By product = By.cssSelector("a#item_4_title_link");
	By removeButton = By.xpath("//button[text()='Remove']");
	By continueShopping = By.xpath("//button[text()='Continue Shopping']");
	By checkOutButton = By.xpath("//button[text()='Checkout']");


	WebDriver driver;
	WebDriverWait wait;

	public CartPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public boolean checkElementsExist() {
		if (!(driver.findElements(removeButton).size() > 0))
			return false;
		if (!(driver.findElements(continueShopping).size() > 0))
			return false;
		if (!(driver.findElements(checkOutButton).size() > 0))
			return false;
		return true;
	}

	public boolean checkProductExist() {
		if (!(driver.findElements(product).size() > 0))
			return false;
		return true;
	}
	public void removeFromCart() {
		driver.findElement(removeButton).click();
	}
	
	public void continueShopping() {
		driver.findElement(continueShopping).click();
	}
	
	public void clickCheckoutButton() {
		driver.findElement(checkOutButton).click();
	}


}
