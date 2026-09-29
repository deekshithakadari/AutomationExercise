package automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import automationexercise.base.BasePage;

public class NewRegisterPage extends BasePage {

	    public NewRegisterPage(WebDriver driver) {
	        super(driver);
	    }

	    // Signup / Login
	    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	    WebElement loginbtn;

	    // New User Signup
	    @FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
	    WebElement signUpHeader;

	    // Name
	    @FindBy(xpath = "//input[@placeholder='Name']")
	    WebElement nameTxt;

	    // Email
	    @FindBy(xpath = "//input[@data-qa='signup-email']")
	    WebElement emailAddressTxt;

	    // Signup button
	    @FindBy(xpath = "//button[normalize-space()='Signup']")
	    WebElement signupBtn;

	    // Enter Account Information
	    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
	    WebElement accountHeader;

	    // Title - Mr
	    @FindBy(xpath = "//input[@id='id_gender1']")
	    WebElement titleRdBtn;

	    // Password
	    @FindBy(xpath = "//input[@id='password']")
	    WebElement passwordTxt;

	    // Date of Birth
	    @FindBy(xpath = "//select[@id='days']")
	    WebElement daysDrop;

	    @FindBy(xpath = "//select[@id='months']")
	    WebElement monthDrop;

	    @FindBy(xpath = "//select[@id='years']")
	    WebElement yearDrop;

	    // Newsletter
	    @FindBy(xpath = "//input[@id='newsletter']")
	    WebElement newsletterChkBox;

	    // Special offers
	    @FindBy(xpath = "//input[@id='optin']")
	    WebElement offersChkBox;

	    // First name
	    @FindBy(xpath = "//input[@id='first_name']")
	    WebElement firstNameTxt;

	    // Last name
	    @FindBy(xpath = "//input[@id='last_name']")
	    WebElement lastNameTxt;

	    // Company
	    @FindBy(xpath = "//input[@id='company']")
	    WebElement companyTxt;

	    // Address
	    @FindBy(xpath = "//input[@id='address1']")
	    WebElement address1Txt;

	    // Address 2
	    @FindBy(xpath = "//input[@id='address2']")
	    WebElement address2Txt;

	    // Country
	    @FindBy(xpath = "//select[@id='country']")
	    WebElement countryDrop;

	    // State
	    @FindBy(xpath = "//input[@id='state']")
	    WebElement stateTxt;

	    // City
	    @FindBy(xpath = "//input[@id='city']")
	    WebElement cityTxt;

	    // Zipcode
	    @FindBy(xpath = "//input[@id='zipcode']")
	    WebElement zipcodeTxt;

	    // Mobile number
	    @FindBy(xpath = "//input[@id='mobile_number']")
	    WebElement mobileNoTxt;

	    // Create Account
	    @FindBy(xpath = "//button[normalize-space()='Create Account']")
	    WebElement createAccountBtn;

	    // Account Created
	    @FindBy(xpath = "//h2[@data-qa='account-created']")
	    WebElement accountCreatedHeader;

	    // Continue after account creation
	    @FindBy(xpath = "//a[normalize-space()='Continue']")
	    WebElement continueBtn;

	    // Logged in as username
	    @FindBy(xpath = "//li[contains(.,'Logged in as')]")
	    WebElement loggedInAs;

	    // Delete Account
	    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
	    WebElement deleteAccount;

	    // Account Deleted
	    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
	    WebElement accountDeletedHeader;

	    @FindBy(xpath="//p[normalize-space()='Email Address already exist!']")
	    WebElement existingEmailHeader;

	    // Step 4
	    public void clickLogin() {

	        loginbtn.click();
	    }


	    // Step 5
	    public boolean verifySignUp() {

	        return signUpHeader.isDisplayed();
	    }


	    // Steps 6 & 7
	    public void enterDetails(String name, String email) {

	        nameTxt.sendKeys(name);

	        emailAddressTxt.sendKeys(email);

	        signupBtn.click();
	    }


	    // Step 8
	    public boolean verifyAccountHeader() {

	        return accountHeader.isDisplayed();
	    }


	    // Steps 9, 10 & 11
	    public void enterAccountDetails(String password) {

	        // Title
	        titleRdBtn.click();

	        // Password
	        passwordTxt.sendKeys(password);

	        // Day
	        Select day = new Select(daysDrop);
	        day.selectByValue("1");

	        // Month
	        Select month = new Select(monthDrop);
	        month.selectByValue("6");

	        // Year
	        Select year = new Select(yearDrop);
	        year.selectByValue("2000");

	        // Newsletter
	        if (!newsletterChkBox.isSelected()) {
	            newsletterChkBox.click();
	        }

	        // Special offers
	        if (!offersChkBox.isSelected()) {
	            offersChkBox.click();
	        }
	    }


	    // Step 12 & 13
	    public void enterAddressInformation(String firstName,String lastName,String company,String address1,String address2,String state,
	    		String city,String zipcode,String mobileNo) {

	        firstNameTxt.sendKeys(firstName);

	        lastNameTxt.sendKeys(lastName);

	        companyTxt.sendKeys(company);

	        address1Txt.sendKeys(address1);

	        address2Txt.sendKeys(address2);

	        Select country = new Select(countryDrop);
	        country.selectByVisibleText("India");

	        stateTxt.sendKeys(state);

	        cityTxt.sendKeys(city);

	        zipcodeTxt.sendKeys(zipcode);

	        mobileNoTxt.sendKeys(mobileNo);

	        createAccountBtn.click();
	    }


	    // Step 14
	    public boolean verifyAccountCreated() {

	        return accountCreatedHeader.isDisplayed();
	    }


	    // Step 15
	    public void clickContinue() {

	        continueBtn.click();
	    }


	    // Step 16
	    public boolean verifyLoggedInName(String name) {

	        String actualText = loggedInAs.getText();

	        return actualText.contains(name);
	    }


	    // Step 17
	    public void clickDeleteAccount() {

	        deleteAccount.click();
	    }


	    // Step 18
	    public boolean verifyAccountDeleted() {

	        return accountDeletedHeader.isDisplayed();
	    }

	    public boolean verifyEmailExisting() {
	    	return existingEmailHeader.isDisplayed();
	    }

}
