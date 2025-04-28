package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;

import static Utilities.ElementUtils.findElement;

public class FrameUtils {
    private FrameUtils() {
    }

    public static void switchToFrame(WebDriver driver, By locator) {
        driver.switchTo().frame(findElement(driver, locator));
    }

    public static void switchToFrame(WebDriver driver, WebElement frame) {
        LogsUtils.info("Switching to frame:", frame.toString());
        driver.switchTo().frame(frame);
    }

    public static void switchToFrame(WebDriver driver, String frameName) {
        LogsUtils.info("Switching to frame:", frameName);
        driver.switchTo().frame(frameName);
    }

    public static void switchToFrame(WebDriver driver, int frameIndex) {
        LogsUtils.info("Switching to frame with index:", String.valueOf(frameIndex));
        driver.switchTo().frame(frameIndex);
    }

    public static void switchToDefaultContent(WebDriver driver) {
        LogsUtils.info("Switching to default content");
        driver.switchTo().defaultContent();
    }

    public static void switchToParentFrame(WebDriver driver) {
        LogsUtils.info("Switching to parent frame");
        driver.switchTo().parentFrame();
    }
}
