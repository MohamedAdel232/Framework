package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementUtils {
    private final WebDriver driver;

    private final WaitUtils waitUtils;
    private final BrowserUtils browserUtils;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.browserUtils = new BrowserUtils(driver);
    }

    public WebElement findElement(By locator) {
        LogsUtils.info("Finding element with locator:", locator.toString());
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        LogsUtils.info("Finding elements with locator:", locator.toString());
        return driver.findElements(locator);
    }

    public void clickOnElement(By locator) {
        LogsUtils.info("Clicking on element:", locator.toString());
        waitUtils.waitForElementToBeClickable(locator);
        scrollToElement(locator);
        findElement(locator).click();
    }

    public void sendDataToElement(By locator, String data) {
        LogsUtils.info("Sending", data, "to element:", locator.toString());
        waitUtils.waitForElementToBeVisible(locator);
        scrollToElement(locator);
        findElement(locator).sendKeys(data);
    }

    public String getDataFromElement(By locator) {
        LogsUtils.info("Getting data from element:", locator.toString());
        waitUtils.waitForElementToBeVisible(locator);
        scrollToElement(locator);
        return findElement(locator).getText();
    }

    public void scrollToElement(By locator) {
        LogsUtils.info("Scrolling to element with locator:", locator.toString());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                findElement(locator));
    }
}
