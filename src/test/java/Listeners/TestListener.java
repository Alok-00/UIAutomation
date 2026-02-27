package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Base.BaseTest;
import Utilities.ExtentManager;
import Utilities.LoggerUtil;
import Utilities.ScreenshotUtil;
public class TestListener implements ITestListener{
private static ExtentReports extent = ExtentManager.getInstance(); // Get ExtentReportinstance (singleton)
// ThreadLocal used to maintain separate report entry for each test (parallel safe)
private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
// Runs when each test method starts
@Override
public void onTestStart(ITestResult result) {
// TODO Auto-generated method stub
ITestListener.super.onTestStart(result);
// Create test entry in Extent report using test method name
ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
// Store this test in ThreadLocal (so correct test logs go to correct report)
test.set(extentTest);
}
// Runs when test passes
@Override
public void onTestSuccess(ITestResult result) {
// TODO Auto-generated method stub
ITestListener.super.onTestSuccess(result);
test.get().pass("Test Passed"); // Mark test as PASS in report
}
// Runs when test fails
@Override
public void onTestFailure(ITestResult result) {
// TODO Auto-generated method stub
BaseTest baseTest = (BaseTest) result.getInstance(); // Get BaseTest object to access WebDriver
// Capture screenshot and get path
String path = ScreenshotUtil.capture(baseTest.getDriver(), result.getMethod().getMethodName());
test.get().fail(result.getThrowable()); // Add failure reason in report
test.get().addScreenCaptureFromPath(path); // Attach screenshot in report
LoggerUtil.error("Test Failed" +result.getName(), result.getThrowable()); // Log failure in log file
}
// Runs when all tests finished
@Override
public void onFinish(ITestContext context) {
// TODO Auto-generated method stub
ITestListener.super.onFinish(context);
extent.flush(); // VERY IMPORTANT → This writes everything into report file
}
}