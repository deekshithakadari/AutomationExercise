package automationexercise.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import automationexercise.base.BasePage;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[@href='/products']")
    WebElement productsBtn;

    @FindBy(xpath="//h2[normalize-space()='All Products']")
    WebElement allproductsHeader;

    @FindBy(xpath="//div[@class='features_items']")
    WebElement productsList;

    @FindBy(xpath="//a[@href='/product_details/1']")
    WebElement viewProductBtn;

    @FindBy(xpath="//input[@id='search_product']")
    WebElement searchProductsTxt;

    @FindBy(xpath="//button[@id='submit_search']")
    WebElement submitSearchBtn;

    @FindBy(xpath="//h2[normalize-space()='Searched Products']")
    WebElement searchedProducts;

    @FindBy(xpath="//div[@class='productinfo text-center']//p")
    List<WebElement> searchedproductsNames;

    @FindBy(xpath="(//div[@class='features_items']//div[contains(@class,'single-products')])[1]")
    WebElement firstProduct;

    @FindBy(xpath="(//div[@class='features_items']//div[contains(@class,'single-products')])[2]")
    WebElement secondProduct;

    @FindBy(xpath="//div[@class='brands_products']")
    WebElement brands;

    @FindBy(xpath="//a[@href='/brand_products/Mast & Harbour']")
    WebElement MastandHarbourBrand;

    @FindBy(xpath="//h2[normalize-space()='Brand - Mast & Harbour Products']")
    WebElement BrandMastandHarbourProductsHeader;

    @FindBy(xpath="//a[@href='/brand_products/Biba']")
    WebElement BibaBrand;

    @FindBy(xpath="//h2[normalize-space()='Brand - Biba Products']")
    WebElement BibaBrandProductsHeader;

    // All product cards
    @FindBy(xpath="//div[@class='features_items']//div[contains(@class,'single-products')]")
    List<WebElement> productCards;

    @FindBy(xpath="//button[normalize-space()='Continue Shopping']")
    WebElement continueShoppingBtn;


    public void ClickProductsBtn() {

        productsBtn.click();
    }


    public boolean verifyAllProductsPage() {

        return allproductsHeader.isDisplayed();
    }


    public boolean verifyProductsList() {

        return productsList.isDisplayed();
    }


    public void ClickViewProduct() {

        viewProductBtn.click();
    }


    public void enterProductNameInSearchBar(String productName) {

        searchProductsTxt.sendKeys(productName);
    }


    public void ClickSubmitSearchBtn() {

        submitSearchBtn.click();
    }


    public boolean verifySearchedProducts() {

        return searchedProducts.isDisplayed();
    }


    public boolean verifySearchResults(String searchText) {

        boolean status = true;

        for (WebElement product : searchedproductsNames) {

            String productName = product.getText();

            if (!productName.toLowerCase().contains(searchText.toLowerCase())) {

                status = false;

                System.out.println(
                        "Product does not match search: " + productName
                );
            }
        }

        return status;
    }


    // Testcase-12

    public void HoverToFirstProductAndAddToCart() {

        Actions act = new Actions(driver);

        act.moveToElement(firstProduct).perform();
    }


    public void HoverToSecondProduct() {

        Actions act = new Actions(driver);

        act.moveToElement(secondProduct).perform();
    }


    public boolean VerifyBrandsVisibility() {

        return brands.isDisplayed();
    }


    public void ClickBrandMastandHarbour() {

        MastandHarbourBrand.click();
    }


    public boolean VerifyBrandMastandHarbourProductsHeader() {

        return BrandMastandHarbourProductsHeader.isDisplayed();
    }


    public void ClickBibaBrand() {

        BibaBrand.click();
    }


    public boolean VerifyBibaBrandProductsHeader() {

        return BibaBrandProductsHeader.isDisplayed();
    }


    // Testcase-20

    public int count = 0;


    public void VerifyProductsAndClickAddToCart(String searchText) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement productCard : productCards) {

            // Get product name from the current product card
            WebElement productNameElement = productCard.findElement(By.xpath(".//div[@class='productinfo text-center']//p"));

            String productName = productNameElement.getText();

            // Check whether product matches search text
            if (productName.toLowerCase().contains(searchText.toLowerCase())) {

                // Find Add to Cart button inside the SAME product card
                WebElement addToCart = productCard.findElement(By.xpath(".//a[contains(@class,'add-to-cart')]"));

                // Scroll product into the center of the screen
                js.executeScript("arguments[0].scrollIntoView({block:'center'});", productCard);

                // Click Add to Cart using JavaScript
                js.executeScript("arguments[0].click();",addToCart);

                // Click Continue Shopping
                continueShoppingBtn.click();

                // Increase count
                count++;
            }
        }
    }


    public int ReturnCount() {

        return count;
    }

}