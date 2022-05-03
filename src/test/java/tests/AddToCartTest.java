package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import util.DriverFactorySingleton;

import java.time.Duration;

import static org.testng.Assert.*;

@Listeners
public class AddToCartTest extends BaseTest {
    WebDriver driver = DriverFactorySingleton.getInstance().getDriver();

    @Parameters({"search", "brand", "price"})
    @Test(suiteName = "AddToCartTestSuite")
    public void checkTotalPriceInCart(String searchKeyword, String brandKeyword, String totalPrice) {
        HomePage homePage = new HomePage(driver);
        homePage.searchByKeyword(searchKeyword);
        homePage.clickSearchButton();
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.isSearchByBrandVisible();
        searchResultsPage.searchByBrand(brandKeyword);
        searchResultsPage.isBrandButtonVisible();
        searchResultsPage.clickOnBrandButton();
        searchResultsPage.clickOnFilterButton();
        searchResultsPage.clickOnExpensiveFilterButton();
        searchResultsPage.isProductButtonVisible();
        searchResultsPage.clickOnProductButton();
        ProductPage productPage = new ProductPage(driver);
        productPage.implicitWait(30);
        productPage.clickOnAddToCartButton();
        productPage.waitForPageLoadComplete(Duration.ofSeconds(30));
        productPage.isPopUpVisible();
        assertFalse(productPage.getTotalPriceText(), totalPrice);
    }
}
