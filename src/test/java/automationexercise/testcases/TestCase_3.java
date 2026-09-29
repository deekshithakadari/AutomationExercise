package automationexercise.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.HomePage;
import automationexercise.pages.LoginPage;
import utilities.DataProviders;
@Listeners(TestListener.class)
public class TestCase_3 extends BaseClassMAIN{
	@Test(groups= {"login","regression"},dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void  LoginUserwithincorrectemailandpassword(String email, String password,String expectedMessage) throws IOException {
		 

		 /*1. Launch browser
		 2. Navigate to url 'http://automationexercise.com' */
		
		 //3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
		 
	     //4. Click on 'Signup / Login' button
		 LoginPage lp = new LoginPage(driver);
		 lp.clickLogin();  
		 
		 //5. Verify 'Login to your account' is visible
		 Assert.assertTrue(lp.verifyLoginHeader());

		 //6. Enter incorrect email address and password
		 lp.enterLoginDetails(email, password);

		 //7. Click 'login' button
		 lp.clickLoginBtn();

		 //8. Verify error 'Your email or password is incorrect!' is visible
		 Assert.assertTrue(lp.verifyIncorrectLoginMessage());
		 
		}
}
