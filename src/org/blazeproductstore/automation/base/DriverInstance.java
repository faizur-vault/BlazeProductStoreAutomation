package org.blazeproductstore.automation.base;

import java.time.Duration;

import org.blazeproductstore.automation.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance {
	
	public static WebDriver driver;
    public static WebDriverWait wait;
	
	@BeforeMethod
	public void initiateDriverInstance() throws Exception
	{
		if(Utility.fetchPropertyValue("browser_Name").toString().equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(Utility.fetchPropertyValue("browser_Name").toString().equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(Utility.fetchPropertyValue("browser_Name").toString().equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(Utility.fetchPropertyValue("application_URL").toString());
	}
	
	@AfterMethod
	public void closeDriverInstance()
	{
		driver.quit();
	}

}
