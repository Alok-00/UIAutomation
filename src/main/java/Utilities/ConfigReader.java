package Utilities;
import java.io.FileInputStream;
import java.util.Properties;
import Constants.Constants;
public class ConfigReader {
private static Properties prop = new Properties(); // Properties object to store key-value pairs from config file
//Static block. This runs automatically when class loads. So the config file will be loaded only once at start of execution.
static
{
try(FileInputStream fis = new FileInputStream(Constants.Config_Path))
{
prop.load(fis); // Load config.properties file into Properties object
}
catch(Exception e)
{
throw new RuntimeException("Failed to load config file"); // If file not found or error occurs → stop execution
}
}
public static String get(String key)
{
return prop.getProperty(key); //get(key). Fetch value from config file using key
}
}
