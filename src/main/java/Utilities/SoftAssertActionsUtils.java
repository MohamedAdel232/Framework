package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class SoftAssertActionsUtils {
    private final WebDriver driver;
    BrowserUtils browserUtils;
    WaitUtils waitUtils;

    public SoftAssertActionsUtils(WebDriver driver) {
        this.driver = driver;
        this.browserUtils = new BrowserUtils(driver);
        this.waitUtils = new WaitUtils(driver);
    }

    @Step("Assert page URL")
    public void assertPageUrl(String expectedUrl, String message) {
        String actualUrl = browserUtils.getCurrentUrl();
        LogsUtils.info("Asserting page URL");
        LogsUtils.info("Expected URL:", expectedUrl);
        LogsUtils.info("Actual URL:", actualUrl);
        SoftAssertUtils.softAssertTrue(waitUtils.waitForPageToLoad(expectedUrl), message);
    }

    @Step("Assert page title")
    public void assertPageTitle(String expectedTitle, String message) {
        String actualTitle = browserUtils.getPageTitle();
        LogsUtils.info("Asserting page title");
        LogsUtils.info("Expected title:", expectedTitle);
        LogsUtils.info("Actual title:", actualTitle);
        SoftAssertUtils.softAssertEquals(actualTitle, expectedTitle, message);
    }
}
