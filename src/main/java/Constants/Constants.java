package Constants;
public class Constants {
	//Path of config.properties file
	public static final String Config_Path =
	System.getProperty("user.dir")+"/resources/config.properties";
	//Path of CSV file which contains product data used for data-driven testing (multiple product add to cart)
	public static final String Csv_Path =
	System.getProperty("user.dir")+"/resources/Products.csv";
	//Screenshot folder path - All failed test screenshots will be stored here inside reports > screenshots folder
	public static final String Screenshot_Path =
	System.getProperty("user.dir")+"/reports/screenshots";
	}