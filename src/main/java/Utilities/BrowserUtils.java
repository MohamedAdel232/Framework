package Utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

public class BrowserUtils {
    private BrowserUtils() {
    }

    public static void navigateToUrl(WebDriver driver, String url) {
        LogsUtils.info("Navigating to URL:", url);
        driver.get(url);
    }

    public static String getCurrentUrl(WebDriver driver) {
        LogsUtils.info("Current URL is:", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public static String getPageTitle(WebDriver driver) {
        LogsUtils.info("Page title is:", driver.getTitle());
        return driver.getTitle();
    }

    public static String getPageSource(WebDriver driver) {
        LogsUtils.info("Page source is:", driver.getPageSource());
        return driver.getPageSource();
    }

    public static void quitBrowser(WebDriver driver) {
        if (driver != null) {
            LogsUtils.info("Quitting the browser");
            driver.quit();
        }
    }

    public static void closeCurrentWindow(WebDriver driver) {
        if (driver != null) {
            LogsUtils.info("Closing the current window");
            driver.close();
        }
    }

    public static void refreshPage(WebDriver driver) {
        LogsUtils.info("Refreshing the page");
        driver.navigate().refresh();
    }

    public static void maximizeWindow(WebDriver driver) {
        LogsUtils.info("Maximizing the window");
        driver.manage().window().maximize();
    }

    public static void minimizeWindow(WebDriver driver) {
        LogsUtils.info("Minimizing the window");
        driver.manage().window().minimize();
    }

    public static void fullscreen(WebDriver driver) {
        LogsUtils.info("Setting the window to fullscreen");
        driver.manage().window().fullscreen();
    }

    public static Dimension getWindowSize(WebDriver driver) {
        LogsUtils.info("Getting the window size");
        return driver.manage().window().getSize();
    }

    public static void setWindowSize(WebDriver driver, int width, int height) {
        LogsUtils.info("Setting the window size to:", String.valueOf(width), "x", String.valueOf(height));
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public static Point getWindowPosition(WebDriver driver) {
        LogsUtils.info("Getting the window position");
        return driver.manage().window().getPosition();
    }

    public static void setWindowPosition(WebDriver driver, int x, int y) {
        LogsUtils.info("Setting the window position to:", String.valueOf(x), ",", String.valueOf(y));
        driver.manage().window().setPosition(new Point(x, y));
    }

    public static void navigateBack(WebDriver driver) {
        LogsUtils.info("Navigating back");
        driver.navigate().back();
    }

    public static void navigateForward(WebDriver driver) {
        LogsUtils.info("Navigating forward");
        driver.navigate().forward();
    }
}
