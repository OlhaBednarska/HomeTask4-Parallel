package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import util.DriverFactorySingleton;

import java.time.Duration;

public class SearchResultsPage extends BasePage {
    By filterButton = By.xpath("//select[contains(@class,'select-css')]");
    By filterExpensiveButton = By.xpath("//option[contains(@value,'expensive')]");
    By productButton = By.xpath("//a[contains(@class,'tile__heading')]");
    By searchBrand = By.xpath("//div[@data-filter-name='producer']//input[contains(@class,'sidebar-search__input')]");
    By brandButton = By.xpath("//div[@data-filter-name='producer']//a[contains(@href,'producer')]");
    By productButtonVisible = By.xpath("//a[contains(@class,'tile__heading')]");
    By searchBrandVisible = By.xpath("//div[@data-filter-name='producer']//input[contains(@class,'sidebar-search__input')]");
    By brandButtonVisible = By.xpath("//ul[@class='checkbox-filter'][count(p)=1]");

    private final WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        super(DriverFactorySingleton.getInstance().getDriver());
        this.driver = DriverFactorySingleton.getInstance().getDriver();
    }

    public void searchByBrand(String brand) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(searchBrand)).perform();
        driver.findElement(searchBrand).sendKeys(brand);
    }

    public void clickOnBrandButton() {
        driver.findElement(brandButton).click();
    }

    public void clickOnFilterButton() {
        driver.findElement(filterButton).click();
    }

    public void clickOnExpensiveFilterButton() {
        driver.findElement(filterExpensiveButton).click();
    }

    public void clickOnProductButton() {
        driver.findElement(productButton).click();
    }

    public void isProductButtonVisible() {
        waitVisibilityOfElement(Duration.ofSeconds(30), productButtonVisible);
    }

    public void isSearchByBrandVisible() {
        waitVisibilityOfElement(Duration.ofSeconds(30), searchBrandVisible);
    }

    public void isBrandButtonVisible() {
        waitVisibilityOfElement(Duration.ofSeconds(30), brandButtonVisible);
    }

}
