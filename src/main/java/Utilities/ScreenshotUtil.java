package Utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Constants.Constants;
public class ScreenshotUtil {
public static String capture(WebDriver driver, String testName)
{
String path= Constants.Screenshot_Path +testName +".png"; // Create screenshot path using constant folder path + test name.
try
{
File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Convert driver into TakesScreenshot interface. //This allows us to capture screenshot.
FileUtils.copyFile(src, new File(path)); /*Copy screenshot from temporary
location to project screenshot folder*/
}
catch(Exception e)
{
LoggerUtil.error("Screenshot failed", e); // If screenshot fails, log error
}
// Return screenshot path. This will be used to attach screenshot in extent report.
return path;
}
}
