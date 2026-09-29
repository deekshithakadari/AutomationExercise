package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import Utilities.ConfigReader;
import automationexercise.pages.HomePage;
import automationexercise.pages.LoginPage;
@Listeners(TestListener.class)
public class TestCase_4 extends BaseClassMAIN {

    @Test(groups= {"login","regression"})
    public void LogoutUser() {
    	
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

        //Step 5:Verify 'Login to your account' is visible
        Assert.assertTrue(lp.verifyLoginHeader(),"'Login to your account' is not visible");

        //Step 6:Enter correct email address and password
        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");

        lp.enterLoginDetails(email, password);

        //Step 7:Click 'login' button 
        lp.clickLoginBtn();

        //Step 8:Verify 'Logged in as username' is visible 
        String username = ConfigReader.getProperty("username");
        lp.verifyLoggedInUser(username);
                
        //Step 9:Click 'Logout' button
        lp.Clicklogout();

        //Step 10:Verify user is navigated to login page 
        Assert.assertTrue(lp.verifyLoginHeader(),"User was not successfully logged out");
    }
}
