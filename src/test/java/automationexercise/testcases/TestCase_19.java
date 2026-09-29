package automationexercise.testcases;

import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.ProductsPage;
import Listeners.TestListener;
@Listeners(TestListener.class)
public class TestCase_19 extends BaseClassMAIN{
	
	@Test
	public void ViewAndCartBrandProducts(){
		
		
		/*1. Launch browser
		2. Navigate to url 'http://automationexercise.com'  */
		
		
		//3. Click on 'Products' button
		ProductsPage pp = new ProductsPage(driver);
		pp.ClickProductsBtn();
		
		//4. Verify that Brands are visible on left side bar
		Assert.assertTrue(pp.VerifyBrandsVisibility(),"Brands are not visible");
		
		//5. Click on any brand name
		pp.ClickBrandMastandHarbour();
		
		//6. Verify that user is navigated to brand page and brand products are displayed
		Assert.assertTrue(pp.VerifyBrandMastandHarbourProductsHeader(),"User not navigated to brand page(MastandHarbour)");
		Assert.assertTrue(pp.verifyProductsList(),"MastandHarbour Brand Products are not displayed");
		
		//7. On left side bar, click on any other brand link
		pp.ClickBibaBrand();
		
		//8. Verify that user is navigated to that brand page and can see products
		Assert.assertTrue(pp.VerifyBibaBrandProductsHeader(),"User not navigated to brand page(Biba)");
		Assert.assertTrue(pp.verifyProductsList(),"Biba Brand Products are not displayed");
	}

}
