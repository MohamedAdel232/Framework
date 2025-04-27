package Utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class BrowserUtils {
    private BrowserUtils() {
    }

    public static void navigateToUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public static String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public static void closeBrowser(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void closeCurrentWindow(WebDriver driver) {
        if (driver != null) {
            driver.close();
        }
    }

    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void minimizeWindow(WebDriver driver) {
        driver.manage().window().minimize();
    }

    public static void fullscreen(WebDriver driver) {
        driver.manage().window().fullscreen();
    }

    public static Dimension getWindowSize(WebDriver driver) {
        return driver.manage().window().getSize();
    }

    public static void setWindowSize(WebDriver driver, int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public static Point getWindowPosition(WebDriver driver) {
        return driver.manage().window().getPosition();
    }

    public static void setWindowPosition(WebDriver driver, int x, int y) {
        driver.manage().window().setPosition(new Point(x, y));
    }

    public static void navigateBack(WebDriver driver) {
        driver.navigate().back();
    }

    public static void navigateForward(WebDriver driver) {
        driver.navigate().forward();
    }

}
