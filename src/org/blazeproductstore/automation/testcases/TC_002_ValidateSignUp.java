package org.blazeproductstore.automation.testcases;

import java.io.IOException;

import org.blazeproductstore.automation.base.DriverInstance;
import org.blazeproductstore.automation.datagenerators.DataGenerator;
import org.blazeproductstore.automation.pages.SignUpPage;
import org.testng.annotations.Test;

public class TC_002_ValidateSignUp extends DriverInstance {
	
	@Test(dataProvider = "ExcelData", dataProviderClass = DataGenerator.class)
	public void tc_002_validateSignUp(String uname, String pwd) throws IOException
	{
		SignUpPage signupPage = new SignUpPage(driver, wait);
		signupPage.selectSignUpOption();
		signupPage.enterUsername(uname);
		signupPage.enterPassword(pwd);
		signupPage.clickSignUpButton();
		signupPage.verifyUserCreated();
	}

}
