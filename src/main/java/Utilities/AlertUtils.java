package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AlertUtils {
    private final WebDriver driver;

    public AlertUtils(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Accept alert")
    public void acceptAlert() {
        LogsUtils.info("Accepting alert");
        driver.switchTo().alert().accept();
    }

    @Step("Dismiss alert")
    public void dismissAlert() {
        LogsUtils.info("Dismissing alert");
        driver.switchTo().alert().dismiss();
    }

    @Step("Get alert text")
    public String getAlertText() {
        LogsUtils.info("Getting alert text");
        return driver.switchTo().alert().getText();
    }

    @Step("Send keys to alert")
    public void sendKeysToAlert(String keys) {
        LogsUtils.info("Sending keys to alert:", keys);
        driver.switchTo().alert().sendKeys(keys);
    }
}
