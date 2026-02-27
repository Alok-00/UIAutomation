package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utilities.WaitUtil;

public class CartPage {
	private WebDriver driver; // WebDriver instance received from test class
	/* -------------------- Locators -------------------- */
	private By cartMenu = By.cssSelector("li[data-id='menu_cart'] > a"); // Cart menu button( top right cart icon)
	private By cartProducts = By.cssSelector("table.table tbody tr td.align_left a"); // All product names present in
																						// cart table

	/* -------------------- Constructor -------------------- */
	public CartPage(WebDriver driver) // Constructor receives driver from test class
	{
		this.driver = driver;
	}

	/* -------------------- Action Method -------------------- */
	public boolean areProductsPresent(List<String> expectedProducts) {
		WaitUtil.waitForElementVisible(driver, cartMenu).click(); // Open cart page
		List<WebElement> actualProducts = WaitUtil.waitForElementsVisible(driver, cartProducts);
// Fetch all actual products present in cart
		for (String expected : expectedProducts) // Loop through each expected product
		{
			boolean found = actualProducts.stream().anyMatch(p -> p.getText().trim().equalsIgnoreCase(expected)); // Using
																													// Java
																													// Stream
																													// API:
																													// Check
																													// if
																													// expectedproduct
																													// exists
																													// in
																													// actual
																													// cart
																													// products
			if (!found) // If any product not found → return false immediately
				return false;
		}
		return true; // If all products found → return true
	}
}
