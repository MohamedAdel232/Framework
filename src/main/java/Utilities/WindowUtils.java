package Utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowUtils {
    private WindowUtils() {
    }

    public static String getWindowHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public static Set<String> getWindowHandles(WebDriver driver) {
        return driver.getWindowHandles();
    }

    public static void switchToWindow(WebDriver driver, String windowHandle) {
        driver.switchTo().window(windowHandle);
    }
}
