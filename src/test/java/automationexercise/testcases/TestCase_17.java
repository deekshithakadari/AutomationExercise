package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.CartDetailsPage;
import automationexercise.pages.HomePage;

@Listeners(TestListener.class)
public class TestCase_17 extends BaseClassMAIN{
	
	@Test
	public void RemoveProductsFromCart() throws InterruptedException {
		
		/*1. Launch browser
		2. Navigate to url 'http://automationexercise.com'
		*/
		
		//3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
		
		//4. Add products to cart
		CartDetailsPage cp = new CartDetailsPage(driver);
		cp.ClickfirstProductAddToCart();
		cp.ClickContinueShoppingBtn();
		cp.ClickSecondAddToCartBtn();
		cp.ClickContinueShoppingBtn();
		
		//5. Click 'Cart' button
		hp.ClickCartBtn();
		
		//6. Verify that cart page is displayed
		CartDetailsPage cdp = new CartDetailsPage(driver);
		Assert.assertTrue(cdp.VerifyshoppingCartHeader(),"Shopping Cart page is not displayed");
		
		
		//7. Click 'X' button corresponding to particular product
		cdp.ClickcartSecondQuantityDeleteBtn();  //deleting the second product
		
		//8. Verify that product is removed from the cart
		Thread.sleep(1000);
		Assert.assertEquals(cdp.getCartProductCount(),1,"The product was not removed");
		
		
		/*
		System.out.println("Cart products before delete: " + cdp.getCartProductCount());

		cdp.ClickcartSecondQuantityDeleteBtn();

		Thread.sleep(1000);

		System.out.println("Cart products after delete: " + cdp.getCartProductCount());
		*/
	}
}
