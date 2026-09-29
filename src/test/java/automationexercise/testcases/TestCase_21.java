package automationexercise.testcases;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBaseClass.BaseClassMAIN;
import Utilities.ConfigReader;
import automationexercise.pages.ProductDetailsPage;
import automationexercise.pages.ProductsPage;
import Listeners.TestListener;
@Listeners(TestListener.class)
public class TestCase_21 extends BaseClassMAIN{
	
	@Test
	public void AddReviewonProduct() {
	
	/*
	1. Launch browser
	2. Navigate to url 'http://automationexercise.com'   */
		
	//3. Click on 'Products' button
		ProductsPage pp = new ProductsPage(driver);
		pp.ClickProductsBtn();
		
	//4. Verify user is navigated to ALL PRODUCTS page successfully
		pp.verifyAllProductsPage();
		
	//5. Click on 'View Product' button
		 pp.ClickViewProduct();
		
	//6. Verify 'Write Your Review' is visible
		ProductDetailsPage pd = new ProductDetailsPage(driver);
		Assert.assertTrue(pd.VerifyWriteYourReview(),"Write Your Review is not visible");
		
		
	//7. Enter name, email and review
		String Name = ConfigReader.getProperty("username");
		pd.EnterName(Name);
		
		String Email = ConfigReader.getProperty("email");
		pd.EnterEmail(Email);
		
		String Review = "The product which I ordered was Good";
		pd.EnterReview(Review);
		
	//8. Click 'Submit' button
		pd.ClickSubmitButton();
		
	//9. Verify success message 'Thank you for your review.'
		Assert.assertTrue(pd.VerifySucessMessage(),"Success Message was not displayed");
		
	
	}

}
