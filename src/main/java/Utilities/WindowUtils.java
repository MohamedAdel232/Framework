package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowUtils {
    private WindowUtils() {
    }

    @Step("Switch to new window")
    public static String getWindowHandle(WebDriver driver) {
        LogsUtils.info("Getting current window handle");
        return driver.getWindowHandle();
    }

    @Step("Switch to new window")
    public static Set<String> getWindowHandles(WebDriver driver) {
        LogsUtils.info("Getting all window handles");
        return driver.getWindowHandles();
    }

    @Step("Switch to new window")
    public static void switchToWindow(WebDriver driver, String windowHandle) {
        LogsUtils.info("Switching to window with handle:", windowHandle);
        driver.switchTo().window(windowHandle);
    }
}
