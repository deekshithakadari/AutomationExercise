package automationexercise.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.HomePage;
//import automationexercise.pages.LoginPage;
import automationexercise.pages.NewRegisterPage;
@Listeners(TestListener.class)
public class TestCase_1_RegisterUser extends BaseClassMAIN {

    @Test(groups= {"smoke","regression","registration"})
    public void registerUser() throws IOException {

        // STEP 1 & 2
        // Launch browser and open URL
        
        // Generate Random Test Data
        String firstName = randomString();
        String lastName = randomString();
        String name = firstName+" "+lastName;
        String email = randomString() + "@gmail.com";
        String password = randomAlphaNumeric();
        String company = randomString();
        String address1 = randomString() + ", " + randomPinCode();
        String address2 = randomString() + ", " + randomPinCode();
        String state = randomString();
        String city = randomString();
        String zipcode = randomPinCode();
        String mobileNo = randomNumeric();;
        
        
        /*System.out.println("Generated Name   : " + name);
        System.out.println("Generated Email  : " + email);
        System.out.println("Generated Mobile : " + mobileNo); */
        

        // STEP 3 
        // Verify Home Page
        //3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
             
        // Create Login Page Object
        NewRegisterPage Rp = new NewRegisterPage(driver);
        
        // STEP 4 
        // Click Signup / Login
        Rp.clickLogin();

        // STEP 5
        // Verify New User Signup
        Assert.assertTrue(Rp.verifySignUp(),"New User Signup is not visible");

        // STEP 6 & 7
        // Enter name, email and click Signup
        Rp.enterDetails(name, email);

        // STEP 8
        // Verify Enter Account Information
        Assert.assertTrue(Rp.verifyAccountHeader(),"Enter Account Information is not visible");
     
        // STEP 9, 10 & 11
        // Fill account information
        Rp.enterAccountDetails(password);
       
        // STEP 12 & 13
        // Fill address information
        // Create Account
        Rp.enterAddressInformation(firstName,lastName,company,address1,address2,state,city,zipcode,mobileNo);

        // STEP 14
        // Verify Account Created
        Assert.assertTrue(Rp.verifyAccountCreated(),"ACCOUNT CREATED message is not visible");

        // STEP 15
        // Click Continue
        Rp.clickContinue();

        // STEP 16
        // Verify Logged in as username
        Assert.assertTrue(Rp.verifyLoggedInName(name),"Username is not displayed correctly");

        // STEP 17
        // Delete Account
        //Rp.clickDeleteAccount();

        // STEP 18
        // Verify Account Deleted
        //Assert.assertTrue(Rp.verifyAccountDeleted(), "ACCOUNT DELETED message is not visible");
        
        //close browser

     
    }
}