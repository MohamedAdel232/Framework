package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Utilities.ElementUtils.findElement;

public class FrameUtils {
    private FrameUtils() {
    }

    public static void switchToFrame(WebDriver driver, By locator) {
        driver.switchTo().frame(findElement(driver, locator));
    }

    public static void switchToFrame(WebDriver driver, WebElement frame) {
        driver.switchTo().frame(frame);
    }

    public static void switchToFrame(WebDriver driver, String frameName) {
        driver.switchTo().frame(frameName);
    }

    public static void switchToFrame(WebDriver driver, int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public static void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }
}
