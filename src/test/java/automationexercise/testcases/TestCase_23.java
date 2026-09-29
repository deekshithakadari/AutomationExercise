package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.CartDetailsPage;
import automationexercise.pages.CheckoutPage;
import automationexercise.pages.HomePage;
import automationexercise.pages.LoginPage;
import automationexercise.pages.NewRegisterPage;
import automationexercise.pages.PaymentPage;
import Listeners.TestListener;
@Listeners(TestListener.class)
public class TestCase_23 extends BaseClassMAIN{
	
	@Test
	public void  Verifyaddressdetailsincheckoutpage() throws InterruptedException {
		/*
		1. Launch browser
		2. Navigate to url 'http://automationexercise.com' */
		
		//3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
		
		//4. Click 'Signup / Login' button
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(1000);
		lp.clickLogin();
		
		//5. Fill all details in Signup and create account
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
        String mobileNo = randomNumeric();
        
        NewRegisterPage Rp = new NewRegisterPage(driver);
        // Enter name, email and click Signup
        Rp.enterDetails(name, email);
        Rp.enterAccountDetails(password);
        // Fill address information
        // Create Account
        Rp.enterAddressInformation(firstName,lastName,company,address1,address2,state,
        		city,zipcode,mobileNo); 

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(Rp.verifyAccountCreated(),"ACCOUNT CREATED message is not visible");
        Rp.clickContinue();

        //7. Verify ' Logged in as username' at top
        Thread.sleep(1000);
        Assert.assertTrue(Rp.verifyLoggedInName(name),"Username is not displayed correctly");
		
		//8. Add products to cart
        CartDetailsPage cp = new CartDetailsPage(driver);
        Thread.sleep(1000);
		cp.ClickfirstProductAddToCart();
		cp.ClickContinueShoppingBtn();
		cp.ClickSecondAddToCartBtn();
		cp.ClickContinueShoppingBtn();
		
		//9. Click 'Cart' button
		
		hp.ClickCartBtn();
		
		//10. Verify that cart page is displayed
		CartDetailsPage cdp = new CartDetailsPage(driver);
		Assert.assertTrue(cdp.VerifyshoppingCartHeader(),"Shopping Cart page is not displayed");
		
		//11. Click Proceed To Checkout
		cdp.ClickproceedToCheckoutBtn();
		
		//12. Verify that the delivery address is same address filled at the time registration of account
		CheckoutPage cop = new CheckoutPage(driver);
        Assert.assertTrue(cop.verifyAddressHeader(),"Address details are not displayed");
        Assert.assertEquals(cop.getfullName(),"Mr. "+ name, "Names are not same");
        Assert.assertEquals(cop.getcompanyAddress1(), company, "Companies names are not same");
        Assert.assertEquals(cop.getfirstAddress2(), address1, "Address1 is not same");
        Assert.assertEquals(cop.getsecondAddress3(),address2,"Address2 is not same");
        Assert.assertEquals(cop.getcityStatePincode(),city+" "+state+" "+zipcode, "Address3 is not same");
        Assert.assertEquals(cop.getcountry(), "India","Country does not match");
        Assert.assertEquals(cop.getphoneNo(),mobileNo,"Mobile number doesn't match");
		
		//13. Verify that the billing address is same address filled at the time registration of account
        Assert.assertTrue(cop.verifybillingAddressHeader(),"Address details are not displayed");
        Assert.assertEquals(cop.getbillingAddress_fullName(),"Mr. "+ name, "Names are not same");
        Assert.assertEquals(cop.getbillingAddress_companyAddress1(), company, "Companies names are not same");
        Assert.assertEquals(cop.getbillingAddress_firstAddress2(), address1, "Address1 is not same");
        Assert.assertEquals(cop.getbillingAddress_secondAddress3(),address2,"Address2 is not same");
        Assert.assertEquals(cop.getbillingAddress_cityStatePincode(),city+" "+state+" "+zipcode, "Address3 is not same");
        Assert.assertEquals(cop.getbillingAddress_country(), "India","Country does not match");
        Assert.assertEquals(cop.getbillingAddress_phoneNo(),mobileNo,"Mobile number doesn't match");
		
		//14. Click 'Delete Account' button
		Rp.clickDeleteAccount();
	       
		//15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
	    Assert.assertTrue(Rp.verifyAccountDeleted(), "ACCOUNT DELETED message is not visible");
	    PaymentPage pp = new PaymentPage(driver);
	    pp.ClickcontinueBtn();
		
	}


}
