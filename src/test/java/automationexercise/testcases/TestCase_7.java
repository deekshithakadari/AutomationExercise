package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.HomePage;
@Listeners(TestListener.class)
public class TestCase_7 extends BaseClassMAIN{
	
	@Test(groups= {"smoke", "regression"})
	public void VerifyTestCasesPage() {
		/*
		 * 1. Launch browser
           2. Navigate to url 'http://automationexercise.com'  */
      
		//3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
	     
		//4. Click on 'Test Cases' button
		hp.Clicktestcases();
		
		//5. Verify user is navigated to test cases page successfully
		Assert.assertTrue(hp.verifyTestcasesPage(),"TestCases Page not visible");
		
	}
	

}
