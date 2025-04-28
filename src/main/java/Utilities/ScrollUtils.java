package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.logging.Logs;

public class ScrollUtils {
    private ScrollUtils() {
    }

    @Step("Scroll to element with locator: {0}")
    public static void scrollToElement(WebDriver driver, By locator) {
        LogsUtils.info("Scrolling to element with locator:", locator.toString());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                ElementUtils.findElement(driver, locator));
    }

    @Step("Scroll to element: {0}")
    public static void scrollToElement(WebDriver driver, WebElement element) {
        LogsUtils.info("Scrolling to element:", element.toString());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                element);
    }

    @Step("Scroll to element horizontally with locator: {0}")
    public static void scrollToElementHorizontally(WebDriver driver, By locator) {
        LogsUtils.info("Scrolling to element with locator:", locator.toString());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({inline: 'center', block: 'nearest'});",
                ElementUtils.findElement(driver, locator));
    }

    @Step("Scroll to element horizontally: {0}")
    public static void scrollToElementHorizontally(WebDriver driver, WebElement element) {
        LogsUtils.info("Scrolling to element:", element.toString());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({inline: 'center', block: 'nearest'});",
                element);
    }

    @Step("Scroll to element vertically with locator: {0}")
    public static void scrollByPixel(WebDriver driver, int x, int y) {
        LogsUtils.info("Scrolling by pixel:", String.valueOf(x), String.valueOf(y));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    @Step("Scroll to element vertically: {0}")
    public static void scrollToTop(WebDriver driver) {
        LogsUtils.info("Scrolling to top of the page");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    @Step("Scroll to element vertically: {0}")
    public static void scrollToBottom(WebDriver driver) {
        LogsUtils.info("Scrolling to bottom of the page");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    @Step("Scroll to element vertically with locator: {0}")
    public static void smoothScrollToElement(WebDriver driver, By locator) {
        LogsUtils.info("Smooth scrolling to element with locator:", locator.toString());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });",
                ElementUtils.findElement(driver, locator)
        );
    }

    @Step("Scroll to element vertically: {0}")
    public static void smoothScrollToElement(WebDriver driver, WebElement element) {
        LogsUtils.info("Smooth scrolling to element:", element.toString());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });",
                element
        );
    }

    @Step("Scroll to coordinates: {0}, {1}")
    public static void scrollToCoordinates(WebDriver driver, int x, int y) {
        LogsUtils.info("Scrolling to coordinates:", String.valueOf(x), String.valueOf(y));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(arguments[0], arguments[1]);", x, y);
    }

    @Step("Scroll inside element with locator: {0}")
    public static void scrollInsideElement(WebDriver driver, By locator, int x, int y) {
        LogsUtils.info("Scrolling inside element with locator:", locator.toString(), "by:", String.valueOf(x), String.valueOf(y));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollBy(arguments[1], arguments[2]);",
                ElementUtils.findElement(driver, locator), x, y
        );
    }

    @Step("Scroll inside element: {0}")
    public static void scrollInsideElement(WebDriver driver, WebElement element, int x, int y) {
        LogsUtils.info("Scrolling inside element:", element.toString(), "by:", String.valueOf(x), String.valueOf(y));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollBy(arguments[1], arguments[2]);",
                element, x, y
        );
    }

    @Step("Scroll to top of element with locator: {0}")
    public static void scrollToBottomOfElement(WebDriver driver, By locator) {
        LogsUtils.info("Scrolling to bottom of element with locator:", locator.toString());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop = arguments[0].scrollHeight;", ElementUtils.findElement(driver, locator)
        );
    }

    @Step("Scroll to top of element: {0}")
    public static void scrollToBottomOfElement(WebDriver driver, WebElement element) {
        LogsUtils.info("Scrolling to bottom of element:", element.toString());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop = arguments[0].scrollHeight;", element
        );
    }

    @Step("Scroll to top of element with locator: {0}")
    public static void scrollToElementAction(WebDriver driver, By locator) {
        LogsUtils.info("Scrolling to element with locator:", locator.toString());
        Actions actions = new Actions(driver);
        actions.scrollToElement(ElementUtils.findElement(driver, locator)).perform();
    }

    @Step("Scroll to top of element: {0}")
    public static void scrollToElementAction(WebDriver driver, WebElement element) {
        LogsUtils.info("Scrolling to element:", element.toString());
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }

    @Step("Scroll by amount: {0}, {1}")
    public static void scrollByAmountAction(WebDriver driver, int x, int y) {
        LogsUtils.info("Scrolling by amount:", String.valueOf(x), String.valueOf(y));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x, y).perform();
    }

    @Step("Scroll from origin of element with locator: {0}")
    public static void scrollFromOriginAction(WebDriver driver, By locator, int x, int y) {
        LogsUtils.info("Scrolling from origin of element with locator:", locator.toString(), "by:", String.valueOf(x), String.valueOf(y));
        Actions actions = new Actions(driver);
        actions.scrollFromOrigin(WheelInput.ScrollOrigin.fromElement(ElementUtils.findElement(driver, locator)), x, y).perform();
    }

    @Step("Scroll from origin of element: {0}")
    public static void scrollFromOriginAction(WebDriver driver, WebElement element, int x, int y) {
        LogsUtils.info("Scrolling from origin of element:", element.toString(), "by:", String.valueOf(x), String.valueOf(y));
        Actions actions = new Actions(driver);
        actions.scrollFromOrigin(WheelInput.ScrollOrigin.fromElement(element), x, y).perform();
    }
}
