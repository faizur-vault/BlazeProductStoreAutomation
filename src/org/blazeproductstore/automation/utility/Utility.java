package org.blazeproductstore.automation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	
	public static Object fetchPropertyValue(String key) throws IOException
	{
		FileInputStream propertyFile = new FileInputStream("./Config/config.properties");
		Properties property = new Properties();
		property.load(propertyFile);
		return property.get(key);
	}
	
	public static String fetchElementLocatorValue(String key) throws IOException
	{
		FileInputStream propertyFile = new FileInputStream("./Config/Elements.properties");
		Properties property = new Properties();
		property.load(propertyFile);
		return property.get(key).toString();
	}

}
