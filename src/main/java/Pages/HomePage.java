package Pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utilities.LoggerUtil;
import Utilities.WaitUtil;
public class HomePage {
private WebDriver driver; // WebDriver instance received from test class
/* -------------------- Locators -------------------- */
private By products = By.cssSelector(".prdocutname"); // Locator for all product names displayed on page
private By addToCart =
By.xpath("./ancestor::div[contains(@class,'col-md-3')]//a[contains(@class,'productcart')]");
// Add to cart button relative to each product Using relative xpath from product element
private By menuHome = By.cssSelector(".menu_home"); // Home menu button to navigate to product list
/* -------------------- Constructor -------------------- */
public HomePage(WebDriver driver) // Constructor receives driver from test class
{
this.driver=driver;
}
/* -------------------- Action Methods -------------------- */
public void goToHome() // Navigates to home/product listing page
{
WaitUtil.waitForElementVisible(driver, menuHome).click();
}
public void addProduct(String productName)
{
List<WebElement> list = WaitUtil.waitForElementsVisible(driver, products); // Wait and fetch all products list
for(WebElement product:list) // Loop through all products
{
if(product.getText().trim().equalsIgnoreCase(productName)) // Match product name ignoring case
{
WebElement addBtn = product.findElement(addToCart); // Find Add to cart button relative to matched product
addBtn.click();
LoggerUtil.info("Added Product: " +productName);
return; // stop loop once product added
}
}
throw new RuntimeException("Product not found..." +productName); // If product not found, fail test clearly
}
}
