package testclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtils;

public class SignupLoginPage {

	WebDriver driver;
	ElementUtils util;
	
	public SignupLoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	private By carousel = By.id("slider-carousel");
	private By loginBtn = By.xpath("//a[@href='/login']");
	private By newUserSignupText = By.xpath("//h2[contains(text(),'New User Signup!')]");
	private By nameField = By.name("name");
	private By emailField = By.name("email");
	private By signupBtn = By.xpath("//button[text()='Signup']");
	private By enterAccInfoText = By.xpath("//b[text()='Enter Account Information']");
	private By addressInfo = By.xpath("//b[text()='Address Information']");
	
	private By mrCheck = By.id("uniform-id_gender1");
	private By mrsCheck = By.id("uniform-id_gender2");
	private By passwordField = By.id("password");
	private By daysDropdown = By.id("days");
	private By monthDropdown = By.id("months");
	private By yearsDropdwon = By.id("months");
	private By newsletterCheckBox = By.id("newsletter");
	private By receiveSpecialOffersCheckBox = By.id("optin");
	
	private By firstName = By.id("first_name");
	private By lastName = By.id("last_name");
	private By companyName = By.id("company");
	private By addrLine1 = By.id("address1");
	private By countryDropdown = By.id("country");
	private By stateName = By.id("state");
	private By cityName = By.id("city");
	private By zipCode = By.id("zipcode");
	private By mobileNumber = By.id("mobile_number");
	private By createAccBtn = By.xpath("//button[text()='Create Account']");
	private By accountCreatedText = By.xpath("//b[text()='Account Created!']");
	private By continueBtn = By.linkText("Continue");
	
	public boolean isHomePageVisible() {
		return util.isElementDisplayed(carousel);
	}
	
	private void clickOnLoginBtn() {
		util.doClick(loginBtn);
	}
	
	public String isNewUserSignUpTextAvailable() {
		clickOnLoginBtn();
		return util.getElementText(newUserSignupText);
	}
	
	private void registerUser(String userName, String emailAddress) {
		clickOnLoginBtn();
		util.doSendKeys(nameField, userName);
		util.doSendKeys(emailField, emailAddress);
		util.doClick(signupBtn);
	}
	
	public boolean enterAccInfoTextAvailable(String userName, String emailAddress) {
		registerUser(userName, emailAddress);
		return util.isElementDisplayed(enterAccInfoText);
	}
	
	public boolean isAddressInfoTextAvailable(String userName, String emailAddress) {
		registerUser(userName, emailAddress);
		return util.isElementDisplayed(addressInfo);
	}
	
	private void enterDOB(String dob) {
		//dob = "11/August/2000";
		String[] date = dob.split("/");
		util.selectByValue(daysDropdown, date[0]);
		util.selectByValue(monthDropdown, date[1]);
		util.selectByValue(yearsDropdwon, date[2]);
		
	}
	
	private void checkTitleGender(String gender) {
		if(gender.equalsIgnoreCase("female")) {
			util.doClick(mrsCheck);
		}else {
			util.doClick(mrCheck);
		}
	}
	
	private void fillAccountInfo(String gender, String password, String dob, boolean newsletter, boolean optin) {
		checkTitleGender(gender);
		util.doSendKeys(passwordField, password);
		enterDOB(dob);
		if(newsletter) util.doClick(newsletterCheckBox);
		if(optin) util.doClick(receiveSpecialOffersCheckBox);
		
	}
	
	private void fillAddressInfo(String fn, String ln, String company, String addr1, String addr2, 
			String country, String state, String city, String zip, String mobile) {
		util.doSendKeys(firstName, fn);
		util.doSendKeys(lastName, ln);
		util.doSendKeys(companyName, company);
		util.doSendKeys(addrLine1, addr1);
		//util.doSendKeys(addrLine2, addr2);
		util.selectByValue(countryDropdown, country);
		util.doSendKeys(stateName, state);
		util.doSendKeys(cityName, city);
		util.doSendKeys(zipCode, zip);
		util.doSendKeys(mobileNumber, mobile);
	}
	
	public boolean createAccount(String userName, String emailAddress,
		String gender, String password, String dob, boolean newsletter, boolean optin,
		String fn, String ln, String company, String addr1, String addr2, String country, 
		String state, String city, String zip, String mobile) {
		registerUser(userName, emailAddress);
		fillAccountInfo(gender, password, dob, newsletter, optin);
		fillAddressInfo(fn, ln, company, addr1, addr2, country, state, city, zip, mobile);
		util.doClick(createAccBtn);		
		boolean accCreatedText = util.isElementDisplayed(accountCreatedText);		
		return accCreatedText;
	}
	
}
