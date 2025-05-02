package Factories;

import Utilities.*;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public DriverFactory(String browser) {
        WebDriver driver = getDriver(browser).startDriver();
        setDriver(driver);
    }

    public static void removeDriver() {
        LogsUtils.info("Removing driver");
        driverThreadLocal.remove();
    }

    public static WebDriver getInstance() {
        return driverThreadLocal.get();
    }

    private void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    private AbstractDriver getDriver(String browser) {
        return switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeFactory();
            case "firefox" -> new FirefoxFactory();
            case "edge" -> new EdgeFactory();
            default -> throw new IllegalArgumentException();
        };
    }

    public WebDriver get() {
        if (driverThreadLocal.get() == null) {
            LogsUtils.error("Driver is null");
            fail("Driver is null");
            return null;
        } else {
            return driverThreadLocal.get();
        }
    }

    public ElementUtils elementUtils() {
        return new ElementUtils(get());
    }

    public BrowserUtils browserUtils() {
        return new BrowserUtils(get());
    }

    public AssertUtils assertUtils() {
        return new AssertUtils(get());
    }

    public SoftAssertActionsUtils softAssertActionsUtils() {
        return new SoftAssertActionsUtils(get());
    }

    public WindowUtils windowUtils() {
        return new WindowUtils(get());
    }

    public AlertUtils alertUtils() {
        return new AlertUtils(get());
    }
}
