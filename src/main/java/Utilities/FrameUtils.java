package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;

import static Utilities.ElementUtils.findElement;

public class FrameUtils {
    private FrameUtils() {
    }

    @Step("Switch to frame with locator: {0}")
    public static void switchToFrame(WebDriver driver, By locator) {
        driver.switchTo().frame(findElement(driver, locator));
    }

    @Step("Switch to frame with element: {0}")
    public static void switchToFrame(WebDriver driver, WebElement frame) {
        LogsUtils.info("Switching to frame:", frame.toString());
        driver.switchTo().frame(frame);
    }

    @Step("Switch to frame with name: {0}")
    public static void switchToFrame(WebDriver driver, String frameName) {
        LogsUtils.info("Switching to frame:", frameName);
        driver.switchTo().frame(frameName);
    }

    @Step("Switch to frame with index: {0}")
    public static void switchToFrame(WebDriver driver, int frameIndex) {
        LogsUtils.info("Switching to frame with index:", String.valueOf(frameIndex));
        driver.switchTo().frame(frameIndex);
    }

    @Step("Switch to frame with ID: {0}")
    public static void switchToDefaultContent(WebDriver driver) {
        LogsUtils.info("Switching to default content");
        driver.switchTo().defaultContent();
    }

    @Step("Switch to parent frame")
    public static void switchToParentFrame(WebDriver driver) {
        LogsUtils.info("Switching to parent frame");
        driver.switchTo().parentFrame();
    }
}
