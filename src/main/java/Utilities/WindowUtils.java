package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowUtils {
    private final WebDriver driver;

    public WindowUtils(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Switch to new window")
    public String getWindowHandle() {
        LogsUtils.info("Getting current window handle");
        return driver.getWindowHandle();
    }

    @Step("Switch to new window")
    public Set<String> getWindowHandles() {
        LogsUtils.info("Getting all window handles");
        return driver.getWindowHandles();
    }

    @Step("Switch to new window")
    public void switchToWindow(String windowHandle) {
        LogsUtils.info("Switching to window with handle:", windowHandle);
        driver.switchTo().window(windowHandle);
    }
}
