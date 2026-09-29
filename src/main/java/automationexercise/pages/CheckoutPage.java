package automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationexercise.base.BasePage;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h2[normalize-space()='Address Details']")
	WebElement addressDetailsHeader;
	
	@FindBy(xpath="//h3[normalize-space()='Your delivery address']")
	WebElement deliveryAddressHeader;
	
	@FindBy(xpath="//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']")
	WebElement fullName;
	
	@FindBy(xpath="(//ul[@id='address_delivery']//li[@class='address_address1 address_address2'])[1]")
	WebElement companyAddress1;
	
	@FindBy(xpath="(//ul[@id='address_delivery']//li[@class='address_address1 address_address2'])[2]")
	WebElement firstAddress2;
	
	@FindBy(xpath="(//ul[@id='address_delivery']//li[@class='address_address1 address_address2'])[3]")
	WebElement secondAddress3;
	
	@FindBy(xpath="//ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']")
	WebElement cityStatePincode;
	
	@FindBy(xpath="//ul[@id='address_delivery']//li[@class='address_country_name']")
	WebElement country;
	
	@FindBy(xpath="//ul[@id='address_delivery']//li[@class='address_phone']")
	WebElement phoneNo;
	
	@FindBy(xpath="//textarea[@name='message']")
	WebElement messageTxt;
	
	@FindBy(xpath="//a[normalize-space()='Place Order']")
	WebElement placeOrderBtn;
	
	@FindBy(xpath="//h2[normalize-space()='Review Your Order']")
	WebElement reviewyourorder;
	
	public boolean verifyAddressHeader() {
	    return addressDetailsHeader.isDisplayed();
	}
	
	public String getfullName() {
		return fullName.getText();
	}
	public String getcompanyAddress1() {
		return companyAddress1.getText();
	}
	public String getfirstAddress2() {
		return firstAddress2.getText();
	}
	public String getsecondAddress3() {
		return secondAddress3.getText();
	}
	public String getcityStatePincode() {
		return cityStatePincode.getText();
	}
	public String getcountry() {
		return country.getText();
	}
	public String getphoneNo() {
		return phoneNo.getText();
	}
	
	public void EnterMessage(String message) {
		messageTxt.sendKeys(message);
	}
	public void ClickplaceOrderBtn() {
		placeOrderBtn.click();
	}
	
	public boolean verifyReviewYourOrder() {
		return reviewyourorder.isDisplayed();
	}
	
	
	@FindBy(xpath="//h3[normalize-space()='Your billing address']")
	WebElement billingAddress_Header;
	
	@FindBy(xpath="//ul[@id='address_invoice']//li[@class='address_firstname address_lastname']")
	WebElement billingAddress_Name;
	
	@FindBy(xpath="(//ul[@id='address_invoice']//li[@class='address_address1 address_address2'])[1]")
	WebElement billingAddress_companyAddress1;
	
	@FindBy(xpath="(//ul[@id='address_invoice']//li[@class='address_address1 address_address2'])[2]")
	WebElement billingAddress_firstAddress2;
	
	@FindBy(xpath="(//ul[@id='address_invoice']//li[@class='address_address1 address_address2'])[3]")
	WebElement billingAddress_secondAddress3;
	
	@FindBy(xpath="//ul[@id='address_invoice']//li[@class='address_city address_state_name address_postcode']")
	WebElement billingAddress_cityStatePincode;
	
	@FindBy(xpath="//ul[@id='address_invoice']//li[@class='address_country_name']")
	WebElement billingAddress_country;
	
	@FindBy(xpath="//ul[@id='address_invoice']//li[@class='address_phone']")
	WebElement billingAddress_phoneNo;
	
	public boolean verifybillingAddressHeader() {
	    return billingAddress_Header.isDisplayed();
	}
	
	public String getbillingAddress_fullName() {
		return billingAddress_Name.getText();
	}
	public String getbillingAddress_companyAddress1() {
		return billingAddress_companyAddress1.getText();
	}
	public String getbillingAddress_firstAddress2() {
		return billingAddress_firstAddress2.getText();
	}
	public String getbillingAddress_secondAddress3() {
		return billingAddress_secondAddress3.getText();
	}
	public String getbillingAddress_cityStatePincode() {
		return billingAddress_cityStatePincode.getText();
	}
	public String getbillingAddress_country() {
		return billingAddress_country.getText();
	}
	public String getbillingAddress_phoneNo() {
		return billingAddress_phoneNo.getText();
	}
}
