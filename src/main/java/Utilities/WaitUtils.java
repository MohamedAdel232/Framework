package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private WaitUtils() {
    }

    public static WebElement waitForElementToBePresent(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver1 -> driver1.findElement(locator));
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver1 -> {
                    WebElement element = waitForElementToBePresent(driver1, locator);
                    return element.isDisplayed() ? element : null;
                });
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver1 -> {
                    WebElement element = waitForElementToBeVisible(driver1, locator);
                    return element.isEnabled() ? element : null;
                });
    }
}
