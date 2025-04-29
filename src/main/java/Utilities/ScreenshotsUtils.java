package Utilities;

import Factories.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotsUtils {
    public static String screenshotsDirectoryPath = "TestOutputs/Screenshots/";

    private ScreenshotsUtils() {
    }

    public static void takeScreenshot(String screenshotName) {
        try {
            File source = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            File destination = new File(screenshotsDirectoryPath + "-" + screenshotName + "-" + TimestampUtils.getTimestamp() + ".png");
            FileUtils.copyFile(source, destination);
            LogsUtils.info("Screenshot taken: " + destination.getPath());
            AllureUtils.attacheScreenshotsToAllureReport(screenshotName, destination.getPath());
        } catch (IOException e) {
            LogsUtils.error("Failed to take screenshot: " + e.getMessage());
        }
    }

}
