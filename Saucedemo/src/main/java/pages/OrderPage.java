package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
	
	By title = By.cssSelector("span.title");
	By payInfo = By.xpath("//div[text()='Payment Information']");
	By shipInfo = By.xpath("//div[text()='Shipping Information']");
	By priceTotal = By.xpath("//div[text()='Price Total']");
	By cancelButton = By.cssSelector("button#cancel");
	By finishButton = By.cssSelector("button#finish");
	By ordCompMsg = By.cssSelector("h2.complete-header");
	

	WebDriver driver;
	WebDriverWait wait;
	
	public boolean checkElementsExist() {
		if (!(driver.findElements(title).size() > 0))
			return false;
		if (!(driver.findElements(payInfo).size() > 0))
			return false;
		if (!(driver.findElements(shipInfo).size() > 0))
			return false;
		if (!(driver.findElements(priceTotal).size() > 0))
			return false;
		if (!(driver.findElements(cancelButton).size() > 0))
			return false;
		if (!(driver.findElements(finishButton).size() > 0))
			return false;
		return true;
		
	}
	
	public boolean checkOrderConfirmation() {
		if (!(driver.findElement(ordCompMsg).getText().equals("Thank you for your order!")))
			return false;
		return true;
	}
	


	public OrderPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}


	public void clickCancel() {
		driver.findElement(cancelButton).click();
	}
	
	public void clickFinsh() {
		driver.findElement(finishButton).click();
	}

	public void refresh() {
		driver.navigate().refresh();
	}


	
}
