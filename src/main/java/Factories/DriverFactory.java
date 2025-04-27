package Factories;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void createDriver(String browser) {
        WebDriver driver = BrowserFactory.getBrowser(browser);
        setDriver(driver);

    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            fail("Driver is not initialized. Please set the driver before using it.");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static void removeDriver() {
        driverThreadLocal.remove();
    }
}
