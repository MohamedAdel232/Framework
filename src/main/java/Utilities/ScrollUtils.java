package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

public class ScrollUtils {
    private final ElementUtils elementUtils;
    WebDriver driver;

    public ScrollUtils(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }


    @Step("Scroll to element: {0}")
    public void scrollToElement(WebElement element) {
        LogsUtils.info("Scrolling to element:", element.toString());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                element);
    }

    @Step("Scroll to element horizontally with locator: {0}")
    public void scrollToElementHorizontally(By locator) {
        LogsUtils.info("Scrolling to element with locator:", locator.toString());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({inline: 'center', block: 'nearest'});",
                elementUtils.findElement(locator));
    }

    @Step("Scroll to element horizontally: {0}")
    public void scrollToElementHorizontally(WebElement element) {
        LogsUtils.info("Scrolling to element:", element.toString());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({inline: 'center', block: 'nearest'});",
                element);
    }

    @Step("Scroll to element vertically with locator: {0}")
    public void scrollByPixel(int x, int y) {
        LogsUtils.info("Scrolling by pixel:", String.valueOf(x), String.valueOf(y));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    @Step("Scroll to element vertically: {0}")
    public void scrollToTop() {
        LogsUtils.info("Scrolling to top of the page");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    @Step("Scroll to element vertically: {0}")
    public void scrollToBottom() {
        LogsUtils.info("Scrolling to bottom of the page");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    @Step("Scroll to element vertically with locator: {0}")
    public void smoothScrollToElement(By locator) {
        LogsUtils.info("Smooth scrolling to element with locator:", locator.toString());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });",
                elementUtils.findElement(locator)
        );
    }

    @Step("Scroll to element vertically: {0}")
    public void smoothScrollToElement(WebElement element) {
        LogsUtils.info("Smooth scrolling to element:", element.toString());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });",
                element
        );
    }

    @Step("Scroll to coordinates: {0}, {1}")
    public void scrollToCoordinates(int x, int y) {
        LogsUtils.info("Scrolling to coordinates:", String.valueOf(x), String.valueOf(y));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(arguments[0], arguments[1]);", x, y);
    }

    @Step("Scroll inside element with locator: {0}")
    public void scrollInsideElement(By locator, int x, int y) {
        LogsUtils.info("Scrolling inside element with locator:", locator.toString(), "by:", String.valueOf(x), String.valueOf(y));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollBy(arguments[1], arguments[2]);",
                elementUtils.findElement(locator), x, y
        );
    }

    @Step("Scroll inside element: {0}")
    public void scrollInsideElement(WebElement element, int x, int y) {
        LogsUtils.info("Scrolling inside element:", element.toString(), "by:", String.valueOf(x), String.valueOf(y));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollBy(arguments[1], arguments[2]);",
                element, x, y
        );
    }

    @Step("Scroll to top of element with locator: {0}")
    public void scrollToBottomOfElement(By locator) {
        LogsUtils.info("Scrolling to bottom of element with locator:", locator.toString());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop = arguments[0].scrollHeight;", elementUtils.findElement(locator)
        );
    }

    @Step("Scroll to top of element: {0}")
    public void scrollToBottomOfElement(WebElement element) {
        LogsUtils.info("Scrolling to bottom of element:", element.toString());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop = arguments[0].scrollHeight;", element
        );
    }

    @Step("Scroll to top of element with locator: {0}")
    public void scrollToElementAction(By locator) {
        LogsUtils.info("Scrolling to element with locator:", locator.toString());
        Actions actions = new Actions(driver);
        actions.scrollToElement(elementUtils.findElement(locator)).perform();
    }

    @Step("Scroll to top of element: {0}")
    public void scrollToElementAction(WebElement element) {
        LogsUtils.info("Scrolling to element:", element.toString());
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }

    @Step("Scroll by amount: {0}, {1}")
    public void scrollByAmountAction(int x, int y) {
        LogsUtils.info("Scrolling by amount:", String.valueOf(x), String.valueOf(y));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x, y).perform();
    }

    @Step("Scroll from origin of element with locator: {0}")
    public void scrollFromOriginAction(By locator, int x, int y) {
        LogsUtils.info("Scrolling from origin of element with locator:", locator.toString(), "by:", String.valueOf(x), String.valueOf(y));
        Actions actions = new Actions(driver);
        actions.scrollFromOrigin(WheelInput.ScrollOrigin.fromElement(elementUtils.findElement(locator)), x, y).perform();
    }

    @Step("Scroll from origin of element: {0}")
    public void scrollFromOriginAction(WebElement element, int x, int y) {
        LogsUtils.info("Scrolling from origin of element:", element.toString(), "by:", String.valueOf(x), String.valueOf(y));
        Actions actions = new Actions(driver);
        actions.scrollFromOrigin(WheelInput.ScrollOrigin.fromElement(element), x, y).perform();
    }
}
