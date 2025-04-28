package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private WaitUtils() {
    }

    @Step("Wait for element to be present with locator: {0}")
    public static WebElement waitForElementToBePresent(WebDriver driver, By locator) {
        LogsUtils.info("Waiting for element to be present with locator:", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver1 -> ElementUtils.findElement(driver1, locator));
    }

    @Step("Wait for element to be visible with locator: {0}")
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        LogsUtils.info("Waiting for element to be visible with locator:", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver1 -> {
                    WebElement element = waitForElementToBePresent(driver1, locator);
                    return element.isDisplayed() ? element : null;
                });
    }

    @Step("Wait for element to be clickable with locator: {0}")
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        LogsUtils.info("Waiting for element to be clickable with locator:", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver1 -> {
                    WebElement element = waitForElementToBeVisible(driver1, locator);
                    return element.isEnabled() ? element : null;
                });
    }
}
