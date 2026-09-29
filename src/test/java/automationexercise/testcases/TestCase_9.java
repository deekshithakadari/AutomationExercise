package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.HomePage;
import automationexercise.pages.ProductsPage;
@Listeners(TestListener.class)
public class TestCase_9 extends BaseClassMAIN{
	
	@Test(groups= {"smoke", "products", "regression"})
	public void SearchProduct() {
		
	
	/*1. Launch browser
	2. Navigate to url 'http://automationexercise.com'  */
		
	//3. Verify that home page is visible successfully
	HomePage hp = new HomePage(driver);
	logger.info("Verifying Automation Exercise Home Page");
	hp.verifyHomePage();
	logger.info("Automation Exercise Home Page verified successfully");
	
	//4. Click on 'Products' button
	ProductsPage pg = new ProductsPage(driver);
	pg.ClickProductsBtn();
	
	//5. Verify user is navigated to ALL PRODUCTS page successfully
	pg.verifyAllProductsPage();
	
	//6. Enter product name in search input and click search button
	String productName = "top";
	pg.enterProductNameInSearchBar(productName);
	pg.ClickSubmitSearchBtn();
	
	//7. Verify 'SEARCHED PRODUCTS' is visible
	Assert.assertTrue(pg.verifySearchedProducts(),"SEARCHED PRODUCTS is not displayed");

    // Step 8 - Verify all products related to search are visible
    Assert.assertTrue(pg.verifySearchResults(productName),"Search results contain unrelated products");
	
	}

}
