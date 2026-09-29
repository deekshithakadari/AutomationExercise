package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import Utilities.ConfigReader;
import automationexercise.pages.ContactUs;
import automationexercise.pages.HomePage;
@Listeners(TestListener.class)
public class TestCase_6 extends BaseClassMAIN{
	
	@Test(groups= {"regression"})
	public void ContactUsForm() {
		
		/*
		1. Launch browser
		2. Navigate to url 'http://automationexercise.com'
		3. Verify that home page is visible successfully
		*/
		
		//4. Click on 'Contact Us' button
		ContactUs cu = new ContactUs(driver);
		cu.clickContactBtn();
		
		//5. Verify 'GET IN TOUCH' is visible
		Assert.assertTrue(cu.ClickgetInTouchHeader(),"GET IN TOUCH header not visible");
		
		//6. Enter name, email, subject and message
		String name = ConfigReader.getProperty("username");
		String email = ConfigReader.getProperty("email");
		String subject = ConfigReader.getProperty("subject");
		String message = ConfigReader.getProperty("message");
		
		cu.EnterDetails(name,email,subject,message);
		
		//7. Upload file
		cu.UploadFile();
		
		//8. Click 'Submit' button
		cu.ClickSubmit();
		
		//9. Click OK button
		cu.handleAlert();
		
		//10. Verify success message 'Success! Your details have been submitted successfully.' is visible
		Assert.assertTrue(cu.verifySuccessHeader(),"Unsuccessful of details submission");
		
		//11. Click 'Home' button and verify that landed to home page successfully
		cu.ClickHomeBtn();
		 
		HomePage hp = new HomePage(driver);
		hp.verifyHomePage();
		
	}
	

}
