package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private final WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Wait for element to be present with locator: {0}")
    public WebElement waitForElementToBePresent(By locator) {
        LogsUtils.info("Waiting for element to be present with locator:", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver1 -> driver1.findElement(locator));
    }

    @Step("Wait for element to be visible with locator: {0}")
    public WebElement waitForElementToBeVisible(By locator) {
        LogsUtils.info("Waiting for element to be visible with locator:", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver1 -> {
                    WebElement element = waitForElementToBePresent(locator);
                    return element.isDisplayed() ? element : null;
                });
    }

    @Step("Wait for element to be clickable with locator: {0}")
    public WebElement waitForElementToBeClickable(By locator) {
        LogsUtils.info("Waiting for element to be clickable with locator:", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver1 -> {
                    WebElement element = waitForElementToBeVisible(locator);
                    return element.isEnabled() ? element : null;
                });
    }
}
