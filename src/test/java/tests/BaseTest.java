package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import util.DriverFactorySingleton;

import java.io.IOException;

public class BaseTest {

    @BeforeTest(alwaysRun = true)
    public void setUp() {
    }

    @BeforeMethod
    public void profileSetUp() throws IOException {
        DriverFactorySingleton.getInstance().setDriver();
        DriverFactorySingleton.getInstance().getDriver();
        DriverFactorySingleton.getInstance().getBrowserURL();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactorySingleton.getInstance().driverClose();
    }

    public HomePage getHomePage() {
        return new HomePage(DriverFactorySingleton.getInstance().getDriver());
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(DriverFactorySingleton.getInstance().getDriver());
    }

    public ProductPage getProductPage() {
        return new ProductPage(DriverFactorySingleton.getInstance().getDriver());
    }

}
