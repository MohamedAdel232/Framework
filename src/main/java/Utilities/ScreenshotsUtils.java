package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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

}
