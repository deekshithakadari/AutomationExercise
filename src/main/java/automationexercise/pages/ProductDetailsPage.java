 package automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationexercise.base.BasePage;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='product-information']")
	WebElement productInformation;
	
	@FindBy(xpath="//div[@class='product-information']//h2")
	WebElement productName;
	
	@FindBy(xpath="//div[@class='product-information']//p[1]")
	WebElement category;
	
	@FindBy(xpath="//div[@class='product-information']//span//span")
	WebElement price;
	
	@FindBy(xpath="//div[@class='product-information']//p[2]")
	WebElement availability;
	
	@FindBy(xpath="//div[@class='product-information']//p[3]")
	WebElement condition;
	
	@FindBy(xpath="//div[@class='product-information']//p[4]")
	WebElement brand;
	
	@FindBy(xpath="//input[@id='quantity']")
	WebElement Quantity;
	
	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	WebElement addToCartButton;
	
	@FindBy(xpath="//a[normalize-space()='Write Your Review']")
	WebElement writeYourReview;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement nameTxt;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailTxt;
	
	@FindBy(xpath="//textarea[@id='review']")
	WebElement reviewTxtArea;
	
	@FindBy(xpath="//button[@id='button-review']")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@class='col-md-12 form-group']//div[@class='alert-success alert']")
	WebElement successMessage;
	
	 public boolean verifyProductInformation()
	 {
		 return productInformation.isDisplayed();
	 }
	
	 public boolean verifyProductName() 
	 {
	        return productName.isDisplayed();
	 }

	 public boolean verifyCategory() 
	 {
	        return category.isDisplayed();
	 }

	 public boolean verifyPrice() 
	 {
	        return price.isDisplayed();
	 }

	 public boolean verifyAvailability() 
	 {
	        return availability.isDisplayed();
	 }

	 public boolean verifyCondition() 
	 {
	        return condition.isDisplayed();
	 }

	 public boolean verifyBrand() 
	 {
	        return brand.isDisplayed();
	 }
	 
	 //testcase-13
	 public void IncreaseQuantity(String quantity) {
		 Quantity.clear();
		 Quantity.sendKeys(quantity);
	 }
	 
	 public void ClickAddToCart() {
		 addToCartButton.click();
	 }
	 
	 public boolean VerifyWriteYourReview() {
		 return writeYourReview.isDisplayed();
	 }
	 
	 public void EnterName(String Name) {
		 nameTxt.sendKeys(Name);
	 }
	 
	 public void EnterEmail(String Email)
	 {
		 emailTxt.sendKeys(Email);
	 }
	 
	 public void EnterReview(String Review) {
		 reviewTxtArea.sendKeys(Review);
	 }
	 
	 public void ClickSubmitButton() {
		 submitButton.click();
	 }
	 
	 public boolean VerifySucessMessage() {
		 return successMessage.isDisplayed();
	 }
	 
}
