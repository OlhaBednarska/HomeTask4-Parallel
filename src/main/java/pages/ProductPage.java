package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import util.DriverFactorySingleton;

import java.time.Duration;

public class ProductPage extends BasePage {
    By addToCartButton = By.xpath("//li[contains(@class,'buttons__item ng')]");
    By cartButton = By.xpath("//rz-cart//button[@opencart]");
    By totalPrice = By.xpath("//li[contains(@class,'buttons__item ng')]");

    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        super(DriverFactorySingleton.getInstance().getDriver());
        this.driver = DriverFactorySingleton.getInstance().getDriver();
    }

    public void clickOnAddToCartButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(addToCartButton)).perform();
        driver.findElement(addToCartButton).click();
    }

    public boolean getTotalPriceText() {
        driver.findElement(totalPrice).getText();
        return false;
    }

    public void isCartButtonVisible() {
        waitVisibilityOfElement(Duration.ofSeconds(30), cartButton);
    }
}
