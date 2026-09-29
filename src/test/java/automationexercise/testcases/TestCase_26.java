package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.HomePage;

import Utilities.RetryAnalyzer;

@Listeners(TestListener.class)
public class TestCase_26 extends BaseClassMAIN {
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void VerifyScrollUpwithoutArrowButtonandScrollDownFunctionality() {
		
		logger.info("========== Test Case 26 Started ==========");
		logger.info("Test Case: Verify Scroll Up without Arrow Button and Scroll Down functionality");
		
		/*
		1. Launch browser
		2. Navigate to url 'http://automationexercise.com'
		*/
		
		//3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
		
		// 4. Scroll down page to bottom
		logger.info("Scrolling the page to footer");
		hp.scrollToFooter();
		logger.info("Page scrolled down to the bottom successfully");
		
		
		// 5. Verify 'SUBSCRIPTION' is visible
		logger.info("Verifying whether subscription header is visible");
		//Assert.assertTrue(hp.verifySubscriptionHeader(),"subscription header is not visible");
		
		// INTENTIONAL FAILURE - for testing screenshot
		Assert.assertTrue(false,"Intentional failure to test automatic screenshot");
		logger.info("Subscription header is visible successfully");
		
		
		// 6. Scroll up page to top
		logger.info("Scrolling the page to top");
		hp.scrollToTop();
		logger.info("Page scrolled to top of page successfully");
		
		
		// 7. Verify that page is scrolled up and
		// 'Full-Fledged practice website for Automation Engineers'
		// text is visible on screen
		Assert.assertTrue(hp.verifyPageScrolledUp(),"Page is not scrolled up");
		hp.verifyHomePageImg1Header();
		
		logger.info("Successfully page scrolled to top and Img1_Header is visible on screen");
	}
}

