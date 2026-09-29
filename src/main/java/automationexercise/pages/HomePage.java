package automationexercise.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationexercise.base.BasePage;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {

        super(driver);
    }

    public void verifyHomePage() {

        String title = driver.getTitle();

        if (title.equals("Automation Exercise")) {

            System.out.println("Home page is visible successfully");

        } else {

            System.out.println("Home page verification failed");
        }
    }
    
    
    @FindBy(xpath="//a[contains(text(),'Test Cases')]")
    WebElement testcases;
    
    @FindBy(xpath="//span[contains(text(),'Below is the list of test Cases for you to practic')]")
    WebElement testcasesPageHeader;
    
    @FindBy(xpath="//h2[normalize-space()='Subscription']")
    WebElement subscriptionHeader;
    
    @FindBy(xpath="//input[@id='susbscribe_email']")
    WebElement subscribeEmailTxt;
    
    @FindBy(xpath="//button[@id='subscribe']")
    WebElement subscribeBtn;
    
    @FindBy(xpath="//div[@id='success-subscribe']")
    WebElement successHeader;
    
    @FindBy(xpath="//a[@href='/view_cart' and contains(text(),'Cart')]") //(or)--//div[@class='shop-menu pull-right']//a[contains(@href,'/view_cart')]
    WebElement cartBtn;
    
    @FindBy(xpath="//h2[normalize-space()='Category']")
    WebElement category;
    
    @FindBy(xpath="//a[normalize-space()='Women']")
    WebElement womenCategory;
   
    @FindBy(xpath="//a[normalize-space()='Tops']")
    WebElement tops;
    
    @FindBy(xpath="//h2[normalize-space()='Women - Tops Products']")
    WebElement womenTopsProductsHeader;
    
    @FindBy(xpath="//a[normalize-space()='Men']")
    WebElement menCategory;
    
    @FindBy(xpath="//a[normalize-space()='Tshirts']")
    WebElement tshirts;
    
    /*@FindBy(xpath="//h2[normalize-space()='Men - Tshirts Products']")
    WebElement menTshirtsProductsHeader;  */
    
     @FindBy(xpath="//h2[@class='title text-center']")
     WebElement menTshirtsProductsHeader;
     
     @FindBy(xpath="//h2[normalize-space()='recommended items']")
     WebElement recommendedItemsHeader;
     
     @FindBy(xpath="(//div[@id='recommended-item-carousel']//p)[4]")
     WebElement recommendedItem1_name;
    
     @FindBy(xpath="(//div[@id='recommended-item-carousel']//a[@class=\"btn btn-default add-to-cart\"])[4]")
     WebElement recommendedItem1_AddToCartBtn;
     
     @FindBy(xpath="//u[normalize-space()='View Cart']")
     WebElement viewCart;
     
     @FindBy(xpath="//td[@class='cart_description']//a")
     WebElement cartItem_Name;
    
     @FindBy(xpath="//a[@id='scrollUp']")
     WebElement scrollUpArrow;
     
     @FindBy(xpath="(//div[@id='slider-carousel']//div[@class='carousel-inner']//h2)[1]")
     WebElement homePage_Img1_Header;
     
    public void Clicktestcases() {
    	testcases.click();
    }
    
    public boolean verifyTestcasesPage() {
    	return testcasesPageHeader.isDisplayed();
    }
    
    //testcase-10
    
    public void scrollToFooter() {
    
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    public boolean verifySubscriptionHeader() {
    	return subscriptionHeader.isDisplayed();
    }
    
    public void EntersubscribeEmail(String email) {
    	subscribeEmailTxt.sendKeys(email);
    }
    
    public void ClickSubscribeBtn() {
    	subscribeBtn.click();
    }
    
    public boolean verifySuccessHeader() {
    	return successHeader.isDisplayed();
    }
    
    //testcase-11,14
    
    public void ClickCartBtn() {
    	cartBtn.click();
    }
    
    public boolean VerifyCategoryDisplayed() {
    	return category.isDisplayed();
    }
    
    public void ClickWomenCategory() {
    	womenCategory.click();
    }
    
    public void ClickOnTopsCategory() {
    	tops.click();
    }
    
    public boolean VerifywomenTopsProductsHeader() {
    	return womenTopsProductsHeader.isDisplayed();
    }
    
    public void ClickmenCategory() {
    	menCategory.click();
    }
    
    public void ClickOnTshirts() {
    	tshirts.click();
    }
    
    public boolean VerifymenTshirtsProductsHeader() {
    	return menTshirtsProductsHeader.isDisplayed();
    }
    
    
    String recommendedProductName;


    public void scrollToRecommendedItems() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            recommendedItemsHeader
        );
    }


    public boolean VerifyRecommendedItems() {

        return recommendedItemsHeader.isDisplayed();
    }


    public void ClickrecommendedItem1AddToCart() {

        // Store product name BEFORE leaving Home Page
        recommendedProductName = recommendedItem1_name.getText();

        recommendedItem1_AddToCartBtn.click();
    }


    public void ClickViewCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(viewCart));

        viewCart.click();
    }


    public boolean VerifyItemInCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(cartItem_Name));

        String productNameInCart = cartItem_Name.getText();

        return recommendedProductName.equals(productNameInCart);
    }
    
    public void ClickscrollUpArrow() {
    	scrollUpArrow.click();
    }
    
    public boolean verifyPageScrolledUp() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(driver -> {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            Number scrollPosition = (Number) js.executeScript("return window.pageYOffset;");

            return scrollPosition.doubleValue() == 0.0;
        });
    }
    
    /*public boolean VerifyhomePage_Img1_Header() {
    	return homePage_Img1_Header.isDisplayed();
    }  
    
    public boolean verifyHomePageImg1Header() {

        return homePage_Img1_Header.getText()
                .contains("Full-Fledged practice website for Automation Engineers");
    }
    */
    public boolean verifyHomePageImg1Header() {

        String actualText = homePage_Img1_Header.getText();
		//logger.info("Home page Image 1 header text: {}", actualText);
        return actualText.contains( "Full-Fledged practice website for Automation Engineers");
        
    }
    
    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
    
}
    
