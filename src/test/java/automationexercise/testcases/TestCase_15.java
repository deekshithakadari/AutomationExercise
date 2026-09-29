package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListener;
import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.CartDetailsPage;
import automationexercise.pages.CheckoutPage;
import automationexercise.pages.HomePage;
import automationexercise.pages.LoginPage;
import automationexercise.pages.NewRegisterPage;
import automationexercise.pages.PaymentPage;
@Listeners(TestListener.class)
public class TestCase_15 extends BaseClassMAIN{
	
	@Test
	public void PlaceOrderRegisterBeforeCheckout() {
		/*1. Launch browser
		2. Navigate to url 'http://automationexercise.com' */
		
		//3. Verify that home page is visible successfully
		 HomePage hp = new HomePage(driver);
	     logger.info("Verifying Automation Exercise Home Page");
	     hp.verifyHomePage();
	     logger.info("Automation Exercise Home Page verified successfully");
		
		//4. Click 'Signup / Login' button
		LoginPage lp = new LoginPage(driver);
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
    
        // Create Login Page Object
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
        Assert.assertTrue(Rp.verifyLoggedInName(name),"Username is not displayed correctly");
		
		
		//8. Add products to cart
        CartDetailsPage cp = new CartDetailsPage(driver);
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
		
		//12. Verify Address Details and Review Your Order
		CheckoutPage cop = new CheckoutPage(driver);
        Assert.assertTrue(cop.verifyAddressHeader(),"Address details are not displayed");
        Assert.assertEquals(cop.getfullName(),"Mr. "+ name, "Names are not same");
        Assert.assertEquals(cop.getcompanyAddress1(), company, "Companies names are not same");
        Assert.assertEquals(cop.getfirstAddress2(), address1, "Address1 is not same");
        Assert.assertEquals(cop.getsecondAddress3(),address2,"Address2 is not same");
        Assert.assertEquals(cop.getcityStatePincode(),city+" "+state+" "+zipcode, "Address3 is not same");
        Assert.assertEquals(cop.getcountry(), "India","Country does not match");
        Assert.assertEquals(cop.getphoneNo(),mobileNo,"Mobile number doesn't match");
        
        Assert.assertTrue(cop.verifyReviewYourOrder(),"Review Your Order section is not displayed");
		
		//13. Enter description in comment text area and click 'Place Order'
        String message = "Please deliver the order carefully. This is an automated test order.";
        cop.EnterMessage(message);
        cop.ClickplaceOrderBtn();
		
		//14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        PaymentPage pp = new PaymentPage(driver);
        String nameoncard = "Test User";
        String cardnumber = "4111111111111111";
        String cvc = "123";
        String mm = "12";
        String yyyy = "2030";
        pp.EnterPaymentDetails(nameoncard,cardnumber,cvc,mm,yyyy);
		
        
        // 15. Click 'Pay and Confirm Order' button
        pp.ClickpayandorderBtn();
        
        // 16. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(pp.VerifysuccessMessageHeader(),"Order success message is not displayed");
        pp.ClickcontinueBtn();
        
        //17. Click 'Delete Account' button
        Rp.clickDeleteAccount();

       // 18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(Rp.verifyAccountDeleted(), "ACCOUNT DELETED message is not visible");
        pp.ClickcontinueBtn();
		
	}

}
