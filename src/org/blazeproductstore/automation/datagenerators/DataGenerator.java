package org.blazeproductstore.automation.datagenerators;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenerator {
	
	@DataProvider(name="ExcelData")
	public static Object[][] testDataGenerator(Method met) throws IOException
	{
		FileInputStream excelFile1 = new FileInputStream("./TestData/TestData_BlazeProductStore.xlsx");
		XSSFWorkbook testDataWorkbook1 = new XSSFWorkbook(excelFile1);
		Object [][] testDataArray;
		
		switch (met.getName())
		{
		case "tc_001_validateLogin":
			XSSFSheet loginCredsSheet = testDataWorkbook1.getSheet("LoginCredentials");
			int numberOfRows_login = loginCredsSheet.getPhysicalNumberOfRows();
			testDataArray = new Object[numberOfRows_login-1][2]; 			
			for(int i=1; i<numberOfRows_login; i++)
			{
				XSSFRow dataRow = loginCredsSheet.getRow(i);
				XSSFCell userName = dataRow.getCell(0);
				XSSFCell passWord = dataRow.getCell(1);
				testDataArray[i-1][0] = userName.getStringCellValue();
				testDataArray[i-1][1] = passWord.getStringCellValue();
			}
			testDataWorkbook1.close();
			break;
			
		case "tc_002_validateSignUp":
			XSSFSheet signUpValuesSheet = testDataWorkbook1.getSheet("SignUpValues");			
			int numberOfRows_signup = signUpValuesSheet.getPhysicalNumberOfRows();
			testDataArray = new Object[numberOfRows_signup-1][2]; 			
			for(int i=1; i<numberOfRows_signup; i++)
			{
				XSSFRow dataRow = signUpValuesSheet.getRow(i);
				XSSFCell userName = dataRow.getCell(0);
				XSSFCell passWord = dataRow.getCell(1);
				testDataArray[i-1][0] = userName.getStringCellValue();
				testDataArray[i-1][1] = passWord.getStringCellValue();
			}
			testDataWorkbook1.close();
			break;
		
		default:
			testDataArray = new Object[2][2];
			break;	
		}
		return testDataArray;
	}
}
