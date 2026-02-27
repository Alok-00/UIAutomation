package Utilities;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
// Private method to read wait time from config file
	private static int getWait() {
		return Integer.parseInt(ConfigReader.get("explicitWait"));
	}

// Wait until element is visible on screen
	public static WebElement waitForElementVisible(WebDriver driver, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(getWait()))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

// Wait until all elements are visible (used for list of products, rows etc)
	public static List<WebElement> waitForElementsVisible(WebDriver driver, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(getWait()))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

// Wait until text changes from old text to new text. Used in checkout success message
	public static void waitForTextChange(WebDriver driver, By locator, String oldText) {
		new WebDriverWait(driver, Duration.ofSeconds(getWait()))
				.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, oldText)));
	}

// Wait until element is clickable
	public static WebElement waitForElementClickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
