package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenshotsUtils {
    public static String screenshotsDirectoryPath = "TestOutputs/Screenshots/";

    private ScreenshotsUtils() {
    }

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(screenshotsDirectoryPath + screenshotName + "-" + TimestampUtils.getTimestamp() + ".png");
            FileUtils.copyFile(source, destination);
            LogsUtils.info("Screenshot taken: " + destination.getPath());
            AllureUtils.attacheScreenshotToAllureReport(screenshotName, destination.getPath());
        } catch (IOException e) {
            LogsUtils.error("Failed to take screenshot: " + e.getMessage());
        }
    }

    public static void takeElementScreenshot(String screenshotName, WebElement element) {
        try {
            File source = element.getScreenshotAs(OutputType.FILE);
            File destination = new File(screenshotsDirectoryPath + screenshotName + "-" + TimestampUtils.getTimestamp() + ".png");
            FileUtils.copyFile(source, destination);
            LogsUtils.info("Element screenshot taken: " + destination.getPath());
            AllureUtils.attacheScreenshotToAllureReport(screenshotName, destination.getPath());
        } catch (IOException e) {
            LogsUtils.error("Failed to take element screenshot: " + e.getMessage());
        }
    }

    public static void takeElementScreenshot(WebDriver driver, String screenshotName, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            File source = element.getScreenshotAs(OutputType.FILE);
            File destination = new File(screenshotsDirectoryPath + screenshotName + "-" + TimestampUtils.getTimestamp() + ".png");
            FileUtils.copyFile(source, destination);
            LogsUtils.info("Element screenshot taken: " + destination.getPath());
            AllureUtils.attacheScreenshotToAllureReport(screenshotName, destination.getPath());
        } catch (IOException e) {
            LogsUtils.error("Failed to take element screenshot: " + e.getMessage());
        }
    }

}
