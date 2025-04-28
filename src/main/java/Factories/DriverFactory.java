package Factories;

import Utilities.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.Logs;

import static org.testng.Assert.fail;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverFactory() {
    }

    @Step("Create driver for browser: {0}")
    public static void createDriver(String browser) {
        LogsUtils.info("Creating driver for browser:", browser);
        WebDriver driver = BrowserFactory.getBrowser(browser);
        setDriver(driver);
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            LogsUtils.error("Driver is not initialized. Please set the driver before using it.");
            fail("Driver is not initialized. Please set the driver before using it.");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static void removeDriver() {
        LogsUtils.info("Removing driver");
        driverThreadLocal.remove();
    }
}
