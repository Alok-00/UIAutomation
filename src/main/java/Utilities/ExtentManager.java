package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent; // This will hold single instance of ExtentReports (Singleton pattern)

public static ExtentReports getInstance() // Method to get report instance
{
if(extent==null) // If report not created yet → create it
{
String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new
Date()); // Create timestamp to generate unique report name every time
String reportPath =System.getProperty("user.dir")+"/reports/ExtentReport_"+timestamp+".html"; // Create report file path inside project -> reports folder
ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath); //ExtentSparkReporter generates HTML report
reporter.config().setReportName("Automation test Report"); // Set report name (visible inside report)
reporter.config().setDocumentTitle("ATS Automation Results"); // Set document title (browser tab title)
extent = new ExtentReports(); // Create ExtentReports main object
extent.attachReporter(reporter); // Attach reporter to ExtentReports
// Add system/environment details in report
extent.setSystemInfo("Tester", "Alok");
extent.setSystemInfo("Environment", "QA");
// Fetch browser name from config file dynamically
extent.setSystemInfo("Browser", ConfigReader.get("browser"));
}
return extent; // Return the same report instance everywhere
}
}