package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

@Listeners
public class AddToCartTest extends BaseTest {

    @Parameters({"search", "brand", "price"})
    @Test(suiteName = "AddToCartTestSuite")
    public void checkTotalPriceInCart(String searchKeyword, String brandKeyword, String totalPrice) {
        getHomePage().searchByKeyword(searchKeyword);
        getHomePage().clickSearchButton();
        getSearchResultsPage().isSearchByBrandVisible();
        getSearchResultsPage().searchByBrand(brandKeyword);
        getSearchResultsPage().isBrandButtonVisible();
        getSearchResultsPage().clickOnBrandButton();
        getSearchResultsPage().clickOnFilterButton();
        getSearchResultsPage().clickOnExpensiveFilterButton();
        getSearchResultsPage().isProductButtonVisible();
        getSearchResultsPage().clickOnProductButton();
        getProductPage().implicitWait(30);
        getProductPage().clickOnAddToCartButton();
        getProductPage().waitForPageLoadComplete(Duration.ofSeconds(30));
        getProductPage().isCartButtonVisible();
        assertFalse(getProductPage().getTotalPriceText(), totalPrice);
    }
}
