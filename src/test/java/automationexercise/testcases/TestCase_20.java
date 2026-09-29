package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBaseClass.BaseClassMAIN;
import Utilities.ConfigReader;
import automationexercise.pages.CartDetailsPage;
import automationexercise.pages.HomePage;
import automationexercise.pages.LoginPage;
import automationexercise.pages.ProductsPage;
import Listeners.TestListener;
@Listeners(TestListener.class)
public class TestCase_20 extends BaseClassMAIN {

    @Test
    public void SearchProductsandVerifyCartAfterLogin() {

        /*
         * 1. Launch browser
         * 2. Navigate to url 'http://automationexercise.com'
         */

        // 3. Click on 'Products' button
        ProductsPage pp = new ProductsPage(driver);
        pp.ClickProductsBtn();

        // 4. Verify user is navigated to ALL PRODUCTS page successfully
        pp.verifyAllProductsPage();

        // 5. Enter product name in search input and click search button
        String productname = "Top";
        pp.enterProductNameInSearchBar(productname);
        pp.ClickSubmitSearchBtn();

        // 6. Verify 'SEARCHED PRODUCTS' is visible
        pp.verifySearchedProducts();

        // 7. Verify all the products related to search are visible
        /*
        Assert.assertTrue(
                pp.verifySearchResults(productname),
                "All the products related to search are not visible"
        );
        */

        // 8. Add all searched products to cart
        pp.VerifyProductsAndClickAddToCart(productname);

        // Store the number of products added to cart
        int productCount = pp.ReturnCount();

        // 9. Click 'Cart' button and verify that products are visible in cart
        HomePage hp = new HomePage(driver);
        hp.ClickCartBtn();

        CartDetailsPage cdp = new CartDetailsPage(driver);

        Assert.assertEquals(
                cdp.getCartProductCount(),
                productCount,
                "Products count is not matching before login"
        );

        // 10. Click 'Signup / Login' button and submit login details
        LoginPage lp = new LoginPage(driver);
        lp.clickLogin();

        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");

        lp.enterLoginDetails(email, password);

        // 11. Again, go to Cart page
        hp.ClickCartBtn();

        // 12. Verify that those products are visible in cart after login
        Assert.assertEquals(
                cdp.getCartProductCount(),
                productCount,
                "Products are not visible in cart after login"
        );
    }
}