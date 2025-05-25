package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
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

    public boolean verifyVisibilityOfElement(By locator) {
        LogsUtils.info("Verifying Visibility of Element:", locator.toString());
        waitUtils.waitForElementToBeVisible(locator);
        scrollToElement(locator);
        return findElement(locator).isDisplayed();
    }

    public void uploadFile(By locator, String filePath) {
        LogsUtils.info("Uploading file:", filePath, "to element:", locator.toString());
        File file = new File(filePath);
        findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void rightClickOnElement(By locator) {
        LogsUtils.info("Right clicking on element:", locator.toString());
        WebElement element = findElement(locator);
        String script = "var evt = document.createEvent('MouseEvents');" +
                "evt.initMouseEvent('contextmenu', true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 2, null);" +
                "arguments[0].dispatchEvent(evt);";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }
}
