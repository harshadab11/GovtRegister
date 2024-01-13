package TestLayer;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.GeneralDetailsRegistrationPage;
import UtilityLayer.ExcelReader;

public class GeneralDetailsRegTest extends BaseClass{
	private GeneralDetailsRegistrationPage generalDetailsRegistrationPage;
	
	@BeforeMethod
	@Parameters("browsername")
	public void setUp(String browsername) throws IOException
	{
		BaseClass.initialization(browsername);
	}
	
	@Test(dataProvider="registerData")
	public void EnterGeneralDetails(String Title,
			String FirstName,
			String Surname ,
			String Address1,
			String Address2,
			String City,
			String Country,
			String State,
			String Nationality,
			String PinCode,
			String Email,
			String PhoneNumber,
			String MobileNum)
	{
		generalDetailsRegistrationPage= new GeneralDetailsRegistrationPage();
		generalDetailsRegistrationPage.EnterGeneralDetails(Title, FirstName, Surname, Address1, Address2, City, Country, State, Nationality, PinCode, Email, PhoneNumber, MobileNum);
	}
	
	@DataProvider(name="registerData")
	public Object[][] getData() throws IOException
	{
		ExcelReader excelReader= new ExcelReader(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\GovtSiteExcel.xlsx");
		Object[][] data= excelReader.getAllSheetData(0);
		return data;
		 
	}
	
	@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}

}
