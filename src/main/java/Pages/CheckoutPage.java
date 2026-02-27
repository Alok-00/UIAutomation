package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utilities.LoggerUtil;
import Utilities.WaitUtil;

public class CheckoutPage {
	private WebDriver driver; // WebDriver instance received from test class
	/* -------------------- Locators -------------------- */
	private By checkoutBtn = By.id("cart_checkout1"); // Checkout button on cart page
	private By confirmBtn = By.id("checkout_btn"); // Confirm order button
	private By orderMessage = By.cssSelector("h1.heading1 span.maintext"); // Order success message after order placement
	/* -------------------- Constants -------------------- */
	private static final String OLD_TEXT = "CHECKOUT CONFIRMATION"; // Old text before order success
	private static final String SUCCESS_TEXT = "Your Order Has Been Processed!"; // Expected success message

	/* -------------------- Constructor -------------------- */
	public CheckoutPage(WebDriver driver) // Constructor receives driver from test class
	{
		this.driver = driver;
	}

	/* -------------------- Action Methods -------------------- */
	public void placeOrder() {
		WaitUtil.waitForElementVisible(driver, checkoutBtn).click(); // Click checkout
		WaitUtil.waitForElementVisible(driver, confirmBtn).click(); // Click confirm order
		LoggerUtil.info("Order placed"); // Log action
	}

public boolean isOrderSuccess()
{
WaitUtil.waitForTextChange(driver, orderMessage, OLD_TEXT); // Wait until page text changes after order placement
String actual = WaitUtil.waitForElementVisible(driver, orderMessage).getText().trim();
// Get actual success message
return actual.equalsIgnoreCase(SUCCESS_TEXT); // Compare expected vs actual
}
}