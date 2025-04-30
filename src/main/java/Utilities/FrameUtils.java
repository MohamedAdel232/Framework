package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameUtils {
    private final ElementUtils elementUtils;
    WebDriver driver;

    public FrameUtils(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }

    @Step("Switch to frame with locator: {0}")
    public void switchToFrame(By locator) {
        driver.switchTo().frame(elementUtils.findElement(locator));
    }

    @Step("Switch to frame with element: {0}")
    public void switchToFrame(WebElement frame) {
        LogsUtils.info("Switching to frame:", frame.toString());
        driver.switchTo().frame(frame);
    }

    @Step("Switch to frame with name: {0}")
    public void switchToFrame(String frameName) {
        LogsUtils.info("Switching to frame:", frameName);
        driver.switchTo().frame(frameName);
    }

    @Step("Switch to frame with index: {0}")
    public void switchToFrame(int frameIndex) {
        LogsUtils.info("Switching to frame with index:", String.valueOf(frameIndex));
        driver.switchTo().frame(frameIndex);
    }

    @Step("Switch to frame with ID: {0}")
    public void switchToDefaultContent() {
        LogsUtils.info("Switching to default content");
        driver.switchTo().defaultContent();
    }

    @Step("Switch to parent frame")
    public void switchToParentFrame() {
        LogsUtils.info("Switching to parent frame");
        driver.switchTo().parentFrame();
    }
}
