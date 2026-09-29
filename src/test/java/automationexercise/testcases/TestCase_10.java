package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import Utilities.ConfigReader;
import automationexercise.pages.HomePage;
@Listeners(TestListener.class)
public class TestCase_10 extends BaseClassMAIN{
	
	@Test(groups= {"products", "regression"})
	public void VerifySubscriptioninHomePage() {
		/*
		 * 1. Launch browser
           2. Navigate to url 'http://automationexercise.com'	
		 */

		//3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
		
		//4. Scroll down to footer
		hp.scrollToFooter();
		
		//5. Verify text 'SUBSCRIPTION'
		Assert.assertTrue(hp.verifySubscriptionHeader(),"subscription header is not visible");
		
		//6. Enter email address in input and click arrow button
		String email = ConfigReader.getProperty("email");
		hp.EntersubscribeEmail(email);
		hp.ClickSubscribeBtn();
		//7. Verify success message 'You have been successfully subscribed!' is visible
		Assert.assertTrue(hp.verifySuccessHeader(),"Subscription not successfull");
		
	}
	

}
