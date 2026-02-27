package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utilities.ConfigReader;
import Utilities.LoggerUtil;
public class BaseTest {
protected WebDriver driver; // Protected driver so that child test classes can access it
// Getter method to access driver in other classes if needed
public WebDriver getDriver() {
return driver;
}
// This method runs before every TestNG test method
@BeforeMethod
public void setUp()
{
try
{
driver = new ChromeDriver(); // Launch Chrome browser
driver.manage().window().maximize(); // Maximize browser window
driver.get(ConfigReader.get("url")); // Open application URL fromconfig.properties
LoggerUtil.info("Bowser launched and URL opened"); // Log info message
}
catch(Exception e)
{
LoggerUtil.error("Setup failed", e); // Log error if setup fails
throw new RuntimeException(e); // Stop execution if browser not launched
}
}
// This method runs after every TestNG test method
@AfterMethod(alwaysRun = true)
public void tearDown()
{
if(driver!=null)
{
driver.quit();
LoggerUtil.info("Browser closed");
}
}
}