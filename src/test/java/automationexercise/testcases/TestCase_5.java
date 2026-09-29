package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import Utilities.ConfigReader;
import automationexercise.pages.HomePage;
import automationexercise.pages.LoginPage;
import automationexercise.pages.NewRegisterPage;
@Listeners(TestListener.class)
public class TestCase_5 extends BaseClassMAIN{
	
	
	@Test(groups= {"regression"})
	public void RegisterUserwithExistingEmail() {
		
		/*1. Launch browser 
          2. Navigate to url 'http://automationexercise.com'  */
		
		 //3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
		 
	    //4. Click on 'Signup / Login' button 
		LoginPage lp = new LoginPage(driver);
	    lp.clickLogin();
	    
		NewRegisterPage Rp = new NewRegisterPage(driver);
		
		//step-5:Verify 'New User Signup!' is visible
		Assert.assertTrue(Rp.verifySignUp(),"SignUp Header not visible");
		
		String name = ConfigReader.getProperty("username");
		String email = ConfigReader.getProperty("email");
		
		//step-6 : Enter name and already registered email address
		//step-7 : Click 'Signup' button
		Rp.enterDetails(name,email);
		
		//step-8:Verify error 'Email Address already exist!' is visible
		Assert.assertTrue(Rp.verifyEmailExisting(),"This email doesn't exists previously");
		
	}

}
