package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.CartDetailsPage;
import automationexercise.pages.HomePage;
import automationexercise.pages.ProductDetailsPage;
import automationexercise.pages.ProductsPage;
@Listeners(TestListener.class)
public class TestCase_13 extends BaseClassMAIN{
	
	@Test
	public void VerifyProductquantityInCart() {
		
		 /*
           1. Launch browser
           2. Navigate to url 'http://automationexercise.com'
		 */
		
		 //3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
		
		//4. Click 'View Product' for any product on home page
		ProductsPage pp = new ProductsPage(driver);
		pp.ClickViewProduct();
		
       // 5. Verify product detail is opened
		ProductDetailsPage pd = new ProductDetailsPage(driver);
		Assert.assertTrue(pd.verifyProductInformation(),"Product details not opened");
		
       // 6. Increase quantity to 4
		String quantity = "4";
		pd.IncreaseQuantity(quantity);
		
       //7. Click 'Add to cart' button
		pd.ClickAddToCart();
		
       // 8. Click 'View Cart' button
		CartDetailsPage cp = new CartDetailsPage(driver);
		cp.ClickViewCart();
		
       // 9. Verify that product is displayed in cart page with exact quantity
		Assert.assertTrue(cp.VerifyCartQuantites(quantity),"The quantity in cart is not equal to the quantity mentioned");
		
		
	}
}
