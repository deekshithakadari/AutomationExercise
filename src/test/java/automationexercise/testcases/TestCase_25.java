package automationexercise.testcases;

import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.TestListener;
@Listeners(TestListener.class)
public class TestCase_25 extends BaseClassMAIN {
	
	@Test
	public void VerifyScrollUpusingArrowbuttonandScrollDownfunctionality() throws InterruptedException{
		
		/*1. Launch browser
		2. Navigate to url 'http://automationexercise.com' */
		
		//3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
		
		//4. Scroll down page to bottom
		hp.scrollToFooter();
        //hp.scrollToRecommendedItems();
        logger.info("The page scrolled down successfully");
        
		//5. Verify 'SUBSCRIPTION' is visible
		//Thread.sleep(2000);
		Assert.assertTrue(hp.verifySubscriptionHeader(),"subscription header is not visible");
		logger.info("The subscription header is visible");
		
		//6. Click on arrow at bottom right side to move upward
		//Thread.sleep(2000);
		hp.ClickscrollUpArrow();
		
		//7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
		logger.info("The page was scrolled up sucessfully");
		Assert.assertTrue(hp.verifyPageScrolledUp(), "Page is not scrolled up");
		Assert.assertTrue(hp.verifyHomePageImg1Header(),"Full-Fledged practice website for Automation Engineers' text is not visible on screen");	
		logger.info("Image1 header is also visible");
		
	}
	

}
