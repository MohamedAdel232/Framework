package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class BrowserUtils {
    private final WebDriver driver;

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get window position")
    public void minimizeWindow() {
        LogsUtils.info("Minimizing the window");
        driver.manage().window().minimize();
    }

    @Step("Get window size")
    public void fullscreen() {
        LogsUtils.info("Setting the window to fullscreen");
        driver.manage().window().fullscreen();
    }

    @Step("Get window size")
    public Dimension getWindowSize() {
        LogsUtils.info("Getting the window size");
        return driver.manage().window().getSize();
    }

    @Step("Set window size")
    public void setWindowSize(int width, int height) {
        LogsUtils.info("Setting the window size to:", String.valueOf(width), "x", String.valueOf(height));
        driver.manage().window().setSize(new Dimension(width, height));
    }

    @Step("Get window position")
    public Point getWindowPosition() {
        LogsUtils.info("Getting the window position");
        return driver.manage().window().getPosition();
    }

    @Step("Set window position")
    public void setWindowPosition(int x, int y) {
        LogsUtils.info("Setting the window position to:", String.valueOf(x), ",", String.valueOf(y));
        driver.manage().window().setPosition(new Point(x, y));
    }

    @Step("Get window size")
    public void navigateBack() {
        LogsUtils.info("Navigating back");
        driver.navigate().back();
    }

    @Step("Get window size")
    public void navigateForward() {
        LogsUtils.info("Navigating forward");
        driver.navigate().forward();
    }

    @Step("Navigate to URL: {0}")
    public void navigateToUrl(String url) {
        LogsUtils.info("Navigating to URL:", url);
        driver.get(url);
    }

    @Step("Get current URL")
    public String getCurrentUrl() {
        LogsUtils.info("Current URL is:", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    @Step("Get page title")
    public String getPageTitle() {
        LogsUtils.info("Page title is:", driver.getTitle());
        return driver.getTitle();
    }

    @Step("Get page source")
    public String getPageSource() {
        LogsUtils.info("Page source is:", driver.getPageSource());
        return driver.getPageSource();
    }

    @Step("Get page source length")
    public void quitBrowser() {
        if (driver != null) {
            LogsUtils.info("Quitting the browser");
            driver.quit();
        }
    }

    @Step("Close current window")
    public void closeCurrentWindow() {
        if (driver != null) {
            LogsUtils.info("Closing the current window");
            driver.close();
        }
    }

    @Step("Get window handle")
    public void refreshPage() {
        LogsUtils.info("Refreshing the page");
        driver.navigate().refresh();
    }

    @Step("Get window handles")
    public void maximizeWindow() {
        LogsUtils.info("Maximizing the window");
        driver.manage().window().maximize();
    }
}
