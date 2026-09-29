package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.CartDetailsPage;
import automationexercise.pages.HomePage;
import automationexercise.pages.ProductsPage;
@Listeners(TestListener.class)
public class TestCase_12 extends BaseClassMAIN{
	
	@Test
	public void AddProductsInCart() {
		/*1. Launch browser
		  2. Navigate to url 'http://automationexercise.com' */
		
		//3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
		
		ProductsPage pp = new ProductsPage(driver);
		CartDetailsPage cd = new CartDetailsPage(driver);
		//4. Click 'Products' button
		pp.ClickProductsBtn();
		
		//5. Hover over first product and click 'Add to cart'
		pp.HoverToFirstProductAndAddToCart();
		cd.ClickfirstProductAddToCart();
		
		//6. Click 'Continue Shopping' button
		cd.ClickContinueShoppingBtn();
		
		//7. Hover over second product and click 'Add to cart'
		pp.HoverToSecondProduct();
	    cd.ClickSecondAddToCartBtn();
		
		//8. Click 'View Cart' button
		cd.ClickViewCart();
		
		//9. Verify both products are added to Cart
		Assert.assertEquals(cd.getCartProductCount(),2,"products not added to cart list");
		
		//10. Verify their prices, quantity and total price
		Assert.assertTrue(cd.verifyDetailsOfFirstProduct(),"First product total price is incorrect");

		Assert.assertTrue(cd.verifyDetailsOfSecondProduct(),"Second product total price is incorrect");
		
	}

}
