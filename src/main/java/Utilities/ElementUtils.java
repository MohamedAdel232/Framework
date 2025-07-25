package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    public void clickOnElementJS(By locator) {
        LogsUtils.info("Clicking on element:", locator.toString());
        scrollToElement(locator);
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


    public void sendDataToElement(By locator, String data) {
        LogsUtils.info("Sending", data, "to element:", locator.toString());
        waitUtils.waitForElementToBeVisible(locator);
        scrollToElement(locator);
        findElement(locator).sendKeys(data);
    }

    public void clearElement(By locator) {
        LogsUtils.info("Clearing element:", locator.toString());
        waitUtils.waitForElementToBeVisible(locator);
        scrollToElement(locator);
        findElement(locator).clear();
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
        try {
            LogsUtils.info("Verifying Visibility of Element:", locator.toString());
            waitUtils.waitForElementToBeVisible(locator);
            scrollToElement(locator);
            return findElement(locator).isDisplayed();
        } catch (Exception e) {
            LogsUtils.error("Element:", locator.toString(), "is not visible or not found");
            return false;
        }
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

    public void doubleClickOnElement(By locator) {
        LogsUtils.info("Double clicking on element:", locator.toString());
        Actions actions = new Actions(driver);
        actions.doubleClick(findElement(locator)).perform();
    }

    public void checkCheckbox(By locator) {
        LogsUtils.info("Checking checkbox with locator:", locator.toString());
        WebElement checkbox = findElement(locator);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void checkCheckboxJS(By locator) {
        LogsUtils.info("Checking checkbox with locator:", locator.toString());
        WebElement checkbox = findElement(locator);
        if (!checkbox.isSelected()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", checkbox);
        }
    }

    public void uncheckCheckbox(By locator) {
        LogsUtils.info("Unchecking checkbox with locator:", locator.toString());
        WebElement checkbox = findElement(locator);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheckCheckboxJS(By locator) {
        LogsUtils.info("Unchecking checkbox with locator:", locator.toString());
        WebElement checkbox = findElement(locator);
        if (checkbox.isSelected()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", checkbox);
        }
    }
}
