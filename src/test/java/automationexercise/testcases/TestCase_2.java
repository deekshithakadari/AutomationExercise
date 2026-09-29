package automationexercise.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBaseClass.BaseClassMAIN;
import Utilities.ConfigReader;
import automationexercise.pages.HomePage;
import automationexercise.pages.LoginPage;
import Listeners.TestListener;
@Listeners(TestListener.class)
public class TestCase_2 extends BaseClassMAIN{
	
	@Test(groups= {"smoke","login","regression"},dependsOnGroups = "registration")
    public void loginUserwithcorrectemailandpassword() throws IOException {

        // STEP 1 & 2
        // Launch browser and open URL
		//3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
        
        // Create Login Page Object
        LoginPage lp = new LoginPage(driver);
        
        // STEP 4 (does in BaseClassMAIN)
        // Click Signup / Login
        lp.clickLogin();

        // STEP 5
        // Verify New User Signup
        Assert.assertTrue(lp.verifyLoginHeader(),"Login Header is not visible");
        
        // Get email and password from config.properties
        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");

        // Step 6
        // Enter correct email and password
        lp.enterLoginDetails(email, password);
        
        // Step 7
        // Click Login
        lp.clickLoginBtn();
        
        //8. Verify that 'Logged in as username' is visible
        
        String username = ConfigReader.getProperty("username");
        lp.verifyLoggedInUser(username);
        
        //9. Click 'Delete Account' button
        //lp.ClickDeleteAccount();
        
        //10. Verify that 'ACCOUNT DELETED!' is visible
        //Assert.assertTrue(lp.VerifyAccountDeleted(),"Account is not Deleted");  
        
        // Close Browser
       
	}

}
