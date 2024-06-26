package org.blazeproductstore.automation.testcases;

import java.io.IOException;

import org.blazeproductstore.automation.base.DriverInstance;
import org.blazeproductstore.automation.datagenerators.DataGenerator;
import org.blazeproductstore.automation.pages.LoginPage;
import org.testng.annotations.Test;

public class TC_001_ValidateLogin extends DriverInstance {
	
	@Test(dataProvider = "ExcelData", dataProviderClass = DataGenerator.class)
	public void tc_001_validateLogin(String uname, String pwd) throws IOException
	{
		LoginPage login = new LoginPage(driver, wait);
		login.selectLoginOption();
		login.enterUsername(uname);
		login.enterPassword(pwd);
		login.clickLoginButton();
		login.verifyLoggedIn();
	}

}
