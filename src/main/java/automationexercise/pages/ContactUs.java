package automationexercise.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationexercise.base.BasePage;

public class ContactUs extends BasePage{
	
	public ContactUs(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[normalize-space()='Contact us']")
	WebElement contactUsBtn;
	
	@FindBy(xpath="//h2[normalize-space()='Get In Touch']")
	WebElement getInTouchHeader;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement nametxt;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement emailtxt;
	
	@FindBy(xpath="//input[@placeholder='Subject']")
	WebElement subjecttxt;
	
	@FindBy(xpath="//textarea[@id='message']")
	WebElement messagetxt;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@name='upload_file']")
	WebElement uploadFileBtn;
	
	@FindBy(xpath="//div[@class='status alert alert-success']")
	WebElement successfulHeader;
	
	@FindBy(xpath="//span[normalize-space()='Home']")
	WebElement homeBtn;
	
	public void clickContactBtn() {
		contactUsBtn.click();
	}
	
	public boolean ClickgetInTouchHeader() {
		return getInTouchHeader.isDisplayed();
	}
	
	public void EnterDetails(String name,String email,String subject,String message) {
		nametxt.sendKeys(name);
		emailtxt.sendKeys(email);
		subjecttxt.sendKeys(subject);
		messagetxt.sendKeys(message);
	}
	
	public void ClickSubmit() {
		submitBtn.click();
	}
	
	public void UploadFile() {
		uploadFileBtn.sendKeys("C:\\Users\\DELL\\OneDrive\\Documents\\Excel data\\sampleTextFile.txt");
	}
	
	public void handleAlert() {

	    Alert alert = driver.switchTo().alert();

	    System.out.println("Alert message: " + alert.getText());

	    alert.accept();
	}
	
	public boolean verifySuccessHeader() {
		return successfulHeader.isDisplayed();
	}
	
	public void ClickHomeBtn() {
		homeBtn.click();
	}
}
