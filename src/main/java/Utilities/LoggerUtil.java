package Utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoggerUtil {
// Create logger object for this class. This will be used to print logs in console/file
private static final Logger logger = LogManager.getLogger(LoggerUtil.class);
/* Private constructor. Prevents object creation of this utility class. Because all
methods here are static.*/
private LoggerUtil() {}
// Method to print normal information logs
public static void info(String msg)
{
logger.info(msg);
}
// Method to print error logs with exception stacktrace
public static void error(String msg, Throwable e)
{
logger.error(msg, e);
}
}
