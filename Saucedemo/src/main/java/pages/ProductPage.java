package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

	By productSortContainer = By.cssSelector("select.product_sort_container");
	By products = By.xpath("//*[@class='inventory_item']");
	String addToCart = "(//button[text()='Add to cart'])[1]";
	String itemPrice = "(//div[@class='inventory_item_price'])[1]";
	String productName= "(//div[@class='inventory_item_name'])[1]";
	By cartSymbol = By.cssSelector("a.shopping_cart_link");


	WebDriver driver;
	WebDriverWait wait;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public boolean checkElementsExist() {
		if (!(driver.findElements(productSortContainer).size() > 0))
			return false;
		if (!(driver.findElements(products).size() > 0))
			return false;
		if (!(driver.findElements(cartSymbol).size() > 0))
			return false;
		return true;
	}

	public void sortProductsaz() {
		Select drpCountry = new Select(driver.findElement(productSortContainer));
		drpCountry.selectByVisibleText("Name (A to Z)");
	}
	
	public void sortProductsza() {
		Select drpCountry = new Select(driver.findElement(productSortContainer));
		drpCountry.selectByVisibleText("Name (Z to A)");
	}
	
	public void sortProductlohi() {
		Select drpCountry = new Select(driver.findElement(productSortContainer));
		drpCountry.selectByVisibleText("Price (low to high)");
	}
	
	public void sortProducthilo() {
		Select drpCountry = new Select(driver.findElement(productSortContainer));
		drpCountry.selectByVisibleText("Price (high to low)");
	}
	
	public void clickAddToCart() {
		driver.findElement(By.xpath(addToCart)).click();
	}

	public void clickCartSymbol() {
		driver.findElement(cartSymbol).click();
	}

	public void pressEnter() {
		new Actions(driver).sendKeys(Keys.ENTER).perform();
	}

}
