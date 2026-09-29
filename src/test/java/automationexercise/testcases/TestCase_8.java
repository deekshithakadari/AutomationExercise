package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.HomePage;
import automationexercise.pages.ProductDetailsPage;
import automationexercise.pages.ProductsPage;
@Listeners(TestListener.class)
public class TestCase_8 extends BaseClassMAIN{
	
	@Test(groups= {"smoke", "products", "regression"})
	public void VerifyAllProductsAndProductDetailPage() {
		
		/*
		 * 1. Launch browser
           2. Navigate to url 'http://automationexercise.com'*/
		
		 //3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
           
		ProductsPage pg = new ProductsPage(driver);
		
		//4. Click on 'Products' button
		pg.ClickProductsBtn();
		
        //5. Verify user is navigated to ALL PRODUCTS page successfully
		Assert.assertTrue(pg.verifyAllProductsPage(),"All products Page was not opened");
		
        //6. The products list is visible
		Assert.assertTrue(pg.verifyProductsList(),"Products list was not visible");
		
         //7. Click on 'View Product' of first product
		pg.ClickViewProduct();
		
         //8. User is landed to product detail page
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		Assert.assertTrue(pdp.verifyProductInformation(),"User not landed to product detail page");
		
         //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
		 Assert.assertTrue(pdp.verifyProductName(),"Product name is not visible");

	     Assert.assertTrue(pdp.verifyCategory(),"Category is not visible");

	     Assert.assertTrue(pdp.verifyPrice(),"Price is not visible");

	     Assert.assertTrue(pdp.verifyAvailability(),"Availability is not visible");

	     Assert.assertTrue(pdp.verifyCondition(),"Condition is not visible");

	     Assert.assertTrue(pdp.verifyBrand(),"Brand is not visible");     
		
	}
	
}
