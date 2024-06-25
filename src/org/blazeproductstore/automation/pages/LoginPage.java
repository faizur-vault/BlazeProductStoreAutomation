package org.blazeproductstore.automation.pages;

import java.io.IOException;

import org.blazeproductstore.automation.webelements.LoginPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends LoginPageObjects {
	
	WebDriver driver;
	WebDriverWait wait;
	LoginPageObjects pageObjects;
	public LoginPage(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		this.pageObjects=new LoginPageObjects();
		PageFactory.initElements(driver, pageObjects);
	}
		
	public void selectLoginOption() throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.login_Option_StatusBar_ID));
		pageObjects.login_Option_StatusBar_ID.click();
	}
	
	public void enterUsername(String uname) throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.login_Username_ID));
		pageObjects.login_Username_ID.sendKeys(uname);
	}
	
	public void enterPassword(String pass) throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.login_Password_ID));
		pageObjects.login_Password_ID.sendKeys(pass);
	}
	
	public void clickLoginButton() throws IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(pageObjects.login_Button_XPATH));
		pageObjects.login_Button_XPATH.click();
	}

}
