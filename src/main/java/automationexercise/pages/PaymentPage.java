package automationexercise.pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationexercise.base.BasePage;

public class PaymentPage extends BasePage{

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@name='name_on_card']")
	WebElement nameoncardTxt;
	
	@FindBy(xpath="//input[@name='card_number']")
	WebElement cardnumberTxt;
	
	@FindBy(xpath="//input[@placeholder='ex. 311']")
	WebElement cvcTxt;
	
	@FindBy(xpath="//input[@placeholder='MM']")
	WebElement mmTxt;
	
	@FindBy(xpath="//input[@placeholder='YYYY']")
	WebElement yyyyTxt;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement payandorderBtn;
	
	/*@FindBy(xpath="//div[@id='success_message']")
	WebElement successMessageHeader; */
	
	@FindBy(xpath="//p[normalize-space()='Congratulations! Your order has been confirmed!']")
	WebElement successMessageHeader;
	
	@FindBy(xpath="//a[normalize-space()='Download Invoice']")
	WebElement downloadInvoiceBtn;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement continueBtn;
	
	public void EnterPaymentDetails(String nameoncard,String cardnumber,String cvc,String mm,String yyyy) {
		nameoncardTxt.sendKeys(nameoncard);
		cardnumberTxt.sendKeys(cardnumber);
		cvcTxt.sendKeys(cvc);
		mmTxt.sendKeys(cvc);
		yyyyTxt.sendKeys(yyyy);
	}
	
	public void ClickpayandorderBtn() {
		payandorderBtn.click();
	}
	
	public boolean VerifysuccessMessageHeader() {
		return successMessageHeader.isDisplayed();
	}
	
	public void ClickdownloadInvoiceBtn() {
		downloadInvoiceBtn.click();
	}
	
	
	public boolean verifyInvoiceDownloaded() {

	    String downloadPath = System.getProperty("user.home") + "\\Downloads";

	    File downloadDir = new File(downloadPath);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    return wait.until(driver -> {

	        File[] files = downloadDir.listFiles();

	        if (files == null) {
	            return false;
	        }

	        for (File file : files) {

	            if (file.isFile()
	                    && file.getName().endsWith(".txt")
	                    && !file.getName().endsWith(".crdownload")) {

	                return true;
	            }
	        }

	        return false;
	    });
	}
	
	
	public void ClickcontinueBtn() {
		continueBtn.click();
	}
}
