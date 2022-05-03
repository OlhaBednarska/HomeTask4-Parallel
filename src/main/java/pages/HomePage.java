package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverFactorySingleton;

public class HomePage extends BasePage {

    By searchInput = By.xpath("//input[contains(@class,'search-form')]");
    By searchButton = By.xpath("//button[contains(@class,'submit')]");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(DriverFactorySingleton.getInstance().getDriver());
        this.driver = DriverFactorySingleton.getInstance().getDriver();
    }

    public void searchByKeyword(String keyword) {
        driver.findElement(searchInput).sendKeys(keyword);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

}