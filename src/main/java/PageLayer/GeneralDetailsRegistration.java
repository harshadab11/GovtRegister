package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.HandleDropDown;
import UtilityLayer.utilsClass;

public class GeneralDetailsRegistration extends BaseClass {
	@FindBy(name="ctl00$ContentPlaceHolder1$ddlTitle")
	private WebElement title;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$txtFName")
	private WebElement name;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$txtLName")
	private WebElement surname;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$txtAddress")
	private WebElement address1;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$txtAddress2")
	private WebElement address2;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$txtCity")
	private WebElement city;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$ddlCountry")
	private WebElement country;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$ddlState")
	private WebElement state;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$txtNationality")
	private WebElement nationality;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$txtPinCode")
	private WebElement pinCode;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$txtEmail")
	private WebElement email;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$txtPhoneNumber")
	private WebElement phone;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$txtMobileNum")
	private WebElement mobileNo;

	
	public GeneralDetailsRegistration()
	{
		PageFactory.initElements(driver,this);
	}
	
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
			String MobileNum
			)
	{
		HandleDropDown.selectByVisibleText(title,Title);
		utilsClass.sendKeys(name, FirstName);
		utilsClass.sendKeys(surname, Surname);
		utilsClass.sendKeys(address1, Address1);
		utilsClass.sendKeys(address2, Address2);
		utilsClass.sendKeys(city, City);
		HandleDropDown.selectByVisibleText(country,Country);
		HandleDropDown.selectByVisibleText(state,State);
		utilsClass.sendKeys(nationality, Nationality);
		utilsClass.sendKeys(pinCode,  PinCode);
		utilsClass.sendKeys(email, Email);
		utilsClass.sendKeys(phone, PhoneNumber);
		utilsClass.sendKeys(mobileNo, MobileNum);
		
	}

}
