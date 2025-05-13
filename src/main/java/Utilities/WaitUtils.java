package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private final WebDriver driver;
    private final int timeOut = Integer.parseInt(PropertiesUtils.getPropertyValue("explicitWait"));

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Wait for page to load with URL: {0}")
    public Boolean waitForPageToLoad(String url) {
        LogsUtils.info("Waiting for page to load with URL:", url);
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                    .until(ExpectedConditions.urlToBe(url));
        } catch (Exception e) {
            LogsUtils.error("Error while waiting for page to load:", e.getMessage());
            return false;
        }
    }

    @Step("Wait for element to be present with locator: {0}")
    public WebElement waitForElementToBePresent(By locator) {
        LogsUtils.info("Waiting for element to be present with locator:", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                .until(driver1 -> driver1.findElement(locator));
    }

    @Step("Wait for element to be visible with locator: {0}")
    public WebElement waitForElementToBeVisible(By locator) {
        LogsUtils.info("Waiting for element to be visible with locator:", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                .until(driver1 -> {
                    WebElement element = waitForElementToBePresent(locator);
                    return element.isDisplayed() ? element : null;
                });
    }

    @Step("Wait for element to be clickable with locator: {0}")
    public WebElement waitForElementToBeClickable(By locator) {
        LogsUtils.info("Waiting for element to be clickable with locator:", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                .until(driver1 -> {
                    WebElement element = waitForElementToBeVisible(locator);
                    return element.isEnabled() ? element : null;
                });
    }
}
