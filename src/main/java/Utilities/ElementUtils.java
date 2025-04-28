package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;

import java.util.List;

public class ElementUtils {
    private ElementUtils() {
    }

    public static WebElement findElement(WebDriver driver, By locator) {
        LogsUtils.info("Finding element with locator:", locator.toString());
        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(WebDriver driver, By locator) {
        LogsUtils.info("Finding elements with locator:", locator.toString());
        return driver.findElements(locator);
    }

    public static void clickOnElement(WebDriver driver, By locator) {
        LogsUtils.info("Clicking on element:", locator.toString());
        WaitUtils.waitForElementToBeClickable(driver, locator);
        ScrollUtils.scrollToElement(driver, locator);
        findElement(driver, locator).click();
    }

    public static void sendDataToElement(WebDriver driver, By locator, String data) {
        LogsUtils.info("Sending", data, "to element:", locator.toString());
        WaitUtils.waitForElementToBeVisible(driver, locator);
        ScrollUtils.scrollToElement(driver, locator);
        findElement(driver, locator).sendKeys(data);
    }

    public static String getDataFromElement(WebDriver driver, By locator) {
        LogsUtils.info("Getting data from element:", locator.toString());
        WaitUtils.waitForElementToBeVisible(driver, locator);
        ScrollUtils.scrollToElement(driver, locator);
        return findElement(driver, locator).getText();
    }
}
