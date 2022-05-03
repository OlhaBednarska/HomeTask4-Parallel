package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactorySingleton;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.*;

public class BasePage {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = DriverFactorySingleton.getInstance().getDriver();
    }

    public void implicitWait(long timeToWait) {
        driver.manage().timeouts().implicitlyWait(timeToWait, SECONDS);
    }

    public void waitForPageLoadComplete(Duration timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public Boolean waitVisibilityOfElement(Duration timeToWait, By locator) {
        WebDriverWait wait = new WebDriverWait(DriverFactorySingleton.getInstance().getDriver(), timeToWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return null;
    }

}

