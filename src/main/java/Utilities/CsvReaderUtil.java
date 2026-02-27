package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import Constants.Constants;

public class CsvReaderUtil {
public static List<String> getProductNames()
{
List<String> products =new ArrayList<>(); // List to store product names
//Try-with-resources used: Automatically closes file after reading
try(BufferedReader br = new BufferedReader(new FileReader(Constants.Csv_Path)))
{
String line;
br.readLine(); // Skip header row (first line of CSV)
while((line=br.readLine())!=null) //Read file line by line until file ends
{
products.add(line.trim()); // Add product name into list after trimming spaces
}
}
catch(Exception e)
{
LoggerUtil.error("CSV read failed", e); // Log error if CSV reading fails
throw new RuntimeException(e); // Stop execution if file not readable
}
return products; // Return all product names
}
}
