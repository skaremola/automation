package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

	By productSortContainer = By.cssSelector("select.product_sort_container");
	By products = By.xpath("//*[@class='inventory_item']");
	String addToCart = "(//button[text()='Add to cart'])[1]";
	String itemPrice = "(//div[@class='inventory_item_price'])[1]";
	String productName= "(//div[@class='inventory_item_name'])[1]";
	By cartSymbol = By.cssSelector("a.shopping_cart_link");
//	By addtoCart2 = By.xpath("//button[text()='Add to cart']");
//	By addToCart3 = By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']");
//	By itemPrice1 = By.xpath("//div[@class='inventory_item_price']");
//	By productName1= By.xpath("//div[@class='inventory_item_name']");
//	By productHeader = By.cssSelector("iv.header_label");

	WebDriver driver;
	WebDriverWait wait;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
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
	
	public void addToCart() {
		driver.findElement(By.xpath(addToCart)).click();
	}

	public void clickCartSymbol() {
		driver.findElement(cartSymbol).click();
	}

	public void pressEnter() {
		new Actions(driver).sendKeys(Keys.ENTER).perform();
	}

}
