package org.blazeproductstore.automation.assertions;

import org.openqa.selenium.WebDriver;

public class Compare {
	
	public static boolean validatePageURL(WebDriver driver, String expURL)
	{
		boolean bool = false;
		if(driver.getCurrentUrl().equalsIgnoreCase(expURL))
		{
			bool=true;
		}
		return bool;
	}
	
	public static boolean validatePageUTitle(WebDriver driver, String expTitle)
	{
		boolean bool = false;
		if(driver.getTitle().equalsIgnoreCase(expTitle))
		{
			bool=true;
		}
		return bool;
	}
	
	public static boolean verifyAlertText(WebDriver driver, String expTxt)
	{
		boolean bool = false;
		if(driver.switchTo().alert().getText().equalsIgnoreCase(expTxt))
		{
			bool=true;
		}
		return bool;
	}

}
