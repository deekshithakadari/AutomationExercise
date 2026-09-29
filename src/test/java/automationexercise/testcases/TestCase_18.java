package automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MainBaseClass.BaseClassMAIN;
import automationexercise.pages.HomePage;
import Listeners.TestListener;

@Listeners(TestListener.class)
public class TestCase_18 extends BaseClassMAIN {

    @Test
    public void ViewCategoryProducts() {

        /*
         * 1. Launch browser
         * 2. Navigate to url 'http://automationexercise.com'
         */

        // 3. Verify that categories are visible on left side bar
        HomePage hp = new HomePage(driver);

        Assert.assertTrue(hp.VerifyCategoryDisplayed(),"Category is not visible");

        // 4. Click on 'Women' category
        hp.ClickWomenCategory();

        // 5. Click on any category link under 'Women' category, for example: Tops
        hp.ClickOnTopsCategory();

        // 6. Verify that category page is displayed
        //    and confirm text 'WOMEN - TOPS PRODUCTS'
        Assert.assertTrue(hp.VerifywomenTopsProductsHeader(),"WOMEN - TOPS PRODUCTS header is not displayed");

        // 7. On left side bar, click on any sub-category link of 'Men' category
        hp.ClickmenCategory();
        hp.ClickOnTshirts();

        // 8. Verify that user is navigated to that category page
        Assert.assertTrue(hp.VerifymenTshirtsProductsHeader(),"MEN - TSHIRTS PRODUCTS header is not displayed");
        
    }
}