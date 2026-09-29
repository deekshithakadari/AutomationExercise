package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.HomePage;
import Listeners.TestListener;

@Listeners(TestListener.class)
public class TestCase_22 extends BaseClassMAIN{
	
	@Test
	public void AddToCartFromRecommendedItems() {
		
		/*1. Launch browser
		2. Navigate to url 'http://automationexercise.com'  */
		
		
		//3. Scroll to bottom of page
         HomePage hp = new HomePage(driver);
		 //hp.scrollToFooter();
         hp.scrollToRecommendedItems();
		
		//4. Verify 'RECOMMENDED ITEMS' are visible
		hp.VerifyRecommendedItems();
		
		//5. Click on 'Add To Cart' on Recommended product
		hp.ClickrecommendedItem1AddToCart();
		
		//6. Click on 'View Cart' button
		hp.ClickViewCart();
		
		//7. Verify that product is displayed in cart page 
		Assert.assertTrue(hp.VerifyItemInCart(),"The item in the cart was not matching with recommended product");
		
		
	}
	

}
