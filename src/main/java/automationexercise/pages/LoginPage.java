package automationexercise.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationexercise.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Signup / Login
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement loginbtn;
    
    @FindBy(xpath="//h2[normalize-space()='Login to your account']")
    WebElement loginHeader;
    
    @FindBy(xpath="//input[@data-qa='login-email']")
    WebElement loginEmail;
    
    @FindBy(xpath="//input[@placeholder='Password']")
    WebElement loginPassword;
    
    @FindBy(xpath="//button[normalize-space()='Login']")
    WebElement loginBtn;
    
    //incorrect message for wrong details(used in TestCase-3)
    @FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']")
    WebElement incorrectLoginHeader;
    
    // Logged in as username
    @FindBy(xpath = "//li[contains(.,'Logged in as')]")
    WebElement loggedInAs;
    
    @FindBy(xpath="//a[normalize-space()='Logout']")
    WebElement logoutBtn;
    
    //Click Delete account
    @FindBy(xpath="//a[normalize-space()='Delete Account']")
    WebElement deleteAccountBtn;
    
    // Account Deleted
    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    WebElement accountDeletedHeader;
   
    public void clickLogin() {
    	loginbtn.click();
    }
    
    public boolean verifyLoginHeader() {
    	return loginHeader.isDisplayed();
    }
    
    public void enterLoginDetails(String email,String password) {
    	loginEmail.sendKeys(email);
    	loginPassword.sendKeys(password);
    }
    
    public void clickLoginBtn() {
    	loginBtn.click();
    }
    
    //For TestCase-3 (incorrect credentials)
    public boolean verifyIncorrectLoginMessage() {
    	return incorrectLoginHeader.isDisplayed();
    }
    
    public boolean verifyLoggedInUser(String username) {

        String txt = loggedInAs.getText();
        
        System.out.println("ACTUAL TEXT = [" + txt + "]");
        System.out.println("EXPECTED USERNAME = [" + username + "]");   
        
        return txt.contains(username.trim());
    }
    
    public void Clicklogout() {
    	logoutBtn.click();
    }
    
    public void ClickDeleteAccount() {
    	deleteAccountBtn.click();
    }
    
    public boolean VerifyAccountDeleted() {

        return accountDeletedHeader.isDisplayed();
    }
    
    
}