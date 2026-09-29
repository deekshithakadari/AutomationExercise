package automationexercise.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationexercise.base.BasePage;

public class CartDetailsPage extends BasePage{

	public CartDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//li[@class='active' and contains(text(),'Shopping Cart')]")
	WebElement shoppingCartHeader;
  
    @FindBy(xpath="(//div[@class='productinfo text-center']//a[contains(@class,'add-to-cart')])[1]")
    WebElement firstProductAddToCart;
    
    @FindBy(xpath="//button[normalize-space()='Continue Shopping']")
    WebElement continueShoppingBtn;
    
    @FindBy(xpath="(//div[@class='productinfo text-center']//a[contains(@class,'add-to-cart')])[2]")
    WebElement secondProductAddToCart;
    
    @FindBy(xpath="//u[normalize-space()='View Cart']")
    WebElement viewCartBtn;
    
    @FindBy(xpath="//div[@id='cart_info']//tbody//tr")
    List<WebElement> cartList;
    
    
    /*
    @FindBy(xpath="//tbody/tr[1]//td[@class='cart_description']//a")
    WebElement firstCartProductName;

    @FindBy(xpath="//tbody/tr[2]//td[@class='cart_description']//a")
    WebElement secondCartProductName; 
    */
    
    
    @FindBy(xpath="//tbody/tr[1]//td[@class='cart_price']//p")
    WebElement firstCartProductPrice;

    @FindBy(xpath="//tbody/tr[2]//td[@class='cart_price']//p")
    WebElement secondCartProductPrice;
    
    @FindBy(xpath="//tbody/tr[1]//td[@class='cart_quantity']//button")
    WebElement firstCartProductQuantity;

    @FindBy(xpath="//tbody/tr[2]//td[@class='cart_quantity']//button")
    WebElement secondCartProductQuantity;
    
    @FindBy(xpath="//tbody/tr[1]//td[@class='cart_total']//p")
    WebElement firstCartProductTotal;

    @FindBy(xpath="//tbody/tr[2]//td[@class='cart_total']//p")
    WebElement secondCartProductTotal;
    
    @FindBy(xpath="//td[@class='cart_quantity']")
	WebElement cartQuantity;
    
    @FindBy(xpath="//tr[@id='product-2']//a[@class='cart_quantity_delete']")
    WebElement cartSecondQuantityDeleteBtn;
    
    @FindBy(xpath="//a[normalize-space()='Proceed To Checkout']")
    WebElement proceedToCheckoutBtn;
    
    @FindBy(xpath="//u[normalize-space()='Register / Login']")
    WebElement registerloginLink;
    
    
    
    
    
	public void ClickfirstProductAddToCart() {
		firstProductAddToCart.click();
	}
	
	public void ClickContinueShoppingBtn() {
    	continueShoppingBtn.click();
    }
	
	public void ClickSecondAddToCartBtn() {
    	secondProductAddToCart.click();
    }
    
    public void ClickViewCart() {
    	viewCartBtn.click();
    }
    
    public int getCartProductCount() {
    	return cartList.size();
    }
    
    public boolean verifyDetailsOfFirstProduct() {

        // Get price and remove "Rs. "
        String priceText = firstCartProductPrice.getText().replace("Rs. ", "");

        // Get quantity
        String quantityText = firstCartProductQuantity.getText();

        // Get actual total and remove "Rs. "
        String totalText = firstCartProductTotal.getText().replace("Rs. ", "");

        // Convert String values into numbers
        double price = Double.parseDouble(priceText);
        int quantity = Integer.parseInt(quantityText);
        double actualTotal = Double.parseDouble(totalText);

        // Calculate expected total
        double generatedTotal = price * quantity;

        // Compare actual total with calculated total
        if(actualTotal == generatedTotal) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean verifyDetailsOfSecondProduct() {

        // Get price and remove "Rs. "
        String priceText = secondCartProductPrice.getText().replace("Rs. ", "");

        // Get quantity
        String quantityText = secondCartProductQuantity.getText();

        // Get actual total and remove "Rs. "
        String totalText = secondCartProductTotal.getText().replace("Rs. ", "");

        // Convert String values into numbers
        double price = Double.parseDouble(priceText);
        int quantity = Integer.parseInt(quantityText);
        double actualTotal = Double.parseDouble(totalText);

        // Calculate expected total
        double generatedTotal = price * quantity;

        // Compare actual total with calculated total
        if(actualTotal == generatedTotal) {
            return true;
        }
        else {
            return false;
        }
    }
    
    //testcase-13
    public boolean VerifyCartQuantites(String givenQuantity) {

	    String CartQuantity = cartQuantity.getText();

	    int actgivenQuantity = Integer.parseInt(givenQuantity);
	    int actcartQuantity = Integer.parseInt(CartQuantity);

	    return actgivenQuantity == actcartQuantity;
	}
    
    public boolean VerifyshoppingCartHeader() {
    	return shoppingCartHeader.isDisplayed();
    }
    
    public void ClickproceedToCheckoutBtn()
    {
    	proceedToCheckoutBtn.click();
    }
    
    public void ClickregisterloginLink() {
    	registerloginLink.click();
    }
    
    public void ClickcartSecondQuantityDeleteBtn() {
    	cartSecondQuantityDeleteBtn.click();
    }
    
}
