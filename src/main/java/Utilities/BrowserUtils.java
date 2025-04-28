package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

public class BrowserUtils {
    private BrowserUtils() {
    }

    @Step("Navigate to URL: {0}")
    public static void navigateToUrl(WebDriver driver, String url) {
        LogsUtils.info("Navigating to URL:", url);
        driver.get(url);
    }

    @Step("Get current URL")
    public static String getCurrentUrl(WebDriver driver) {
        LogsUtils.info("Current URL is:", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    @Step("Get page title")
    public static String getPageTitle(WebDriver driver) {
        LogsUtils.info("Page title is:", driver.getTitle());
        return driver.getTitle();
    }

    @Step("Get page source")
    public static String getPageSource(WebDriver driver) {
        LogsUtils.info("Page source is:", driver.getPageSource());
        return driver.getPageSource();
    }

    @Step("Get page source length")
    public static void quitBrowser(WebDriver driver) {
        if (driver != null) {
            LogsUtils.info("Quitting the browser");
            driver.quit();
        }
    }

    @Step("Close current window")
    public static void closeCurrentWindow(WebDriver driver) {
        if (driver != null) {
            LogsUtils.info("Closing the current window");
            driver.close();
        }
    }

    @Step("Get window handle")
    public static void refreshPage(WebDriver driver) {
        LogsUtils.info("Refreshing the page");
        driver.navigate().refresh();
    }

    @Step("Get window handles")
    public static void maximizeWindow(WebDriver driver) {
        LogsUtils.info("Maximizing the window");
        driver.manage().window().maximize();
    }

    @Step("Get window position")
    public static void minimizeWindow(WebDriver driver) {
        LogsUtils.info("Minimizing the window");
        driver.manage().window().minimize();
    }

    @Step("Get window size")
    public static void fullscreen(WebDriver driver) {
        LogsUtils.info("Setting the window to fullscreen");
        driver.manage().window().fullscreen();
    }

    @Step("Get window size")
    public static Dimension getWindowSize(WebDriver driver) {
        LogsUtils.info("Getting the window size");
        return driver.manage().window().getSize();
    }

    @Step("Set window size")
    public static void setWindowSize(WebDriver driver, int width, int height) {
        LogsUtils.info("Setting the window size to:", String.valueOf(width), "x", String.valueOf(height));
        driver.manage().window().setSize(new Dimension(width, height));
    }

    @Step("Get window position")
    public static Point getWindowPosition(WebDriver driver) {
        LogsUtils.info("Getting the window position");
        return driver.manage().window().getPosition();
    }

    @Step("Set window position")
    public static void setWindowPosition(WebDriver driver, int x, int y) {
        LogsUtils.info("Setting the window position to:", String.valueOf(x), ",", String.valueOf(y));
        driver.manage().window().setPosition(new Point(x, y));
    }

    @Step("Get window size")
    public static void navigateBack(WebDriver driver) {
        LogsUtils.info("Navigating back");
        driver.navigate().back();
    }

    @Step("Get window size")
    public static void navigateForward(WebDriver driver) {
        LogsUtils.info("Navigating forward");
        driver.navigate().forward();
    }
}
