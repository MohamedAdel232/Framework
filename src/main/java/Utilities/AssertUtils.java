package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertUtils {
    private AssertUtils() {
    }

    @Step("Assert true")
    public static void assertTrue(boolean condition, String message) {
        LogsUtils.info("Asserting true");
        Assert.assertTrue(condition, message);
    }

    @Step("Assert false")
    public static void assertFalse(boolean condition, String message) {
        LogsUtils.info("Asserting false");
        Assert.assertFalse(condition, message);
    }

    @Step("Assert equals")
    public static void assertEquals(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting equals");
        Assert.assertEquals(actual, expected, message);
    }

    @Step("Assert not equals")
    public static void assertNotEquals(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting not equals");
        Assert.assertNotEquals(actual, expected, message);
    }

    @Step("Assert null")
    public static void assertNull(Object object, String message) {
        LogsUtils.info("Asserting null");
        Assert.assertNull(object, message);
    }

    @Step("Assert not null")
    public static void assertNotNull(Object object, String message) {
        LogsUtils.info("Asserting not null");
        Assert.assertNotNull(object, message);
    }

    @Step("Assert same")
    public static void assertSame(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting same");
        Assert.assertSame(actual, expected, message);
    }

    @Step("Assert not same")
    public static void assertNotSame(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting not same");
        Assert.assertNotSame(actual, expected, message);
    }

    @Step("Assert page URL")
    public static void assertPageUrl(WebDriver driver, String expectedUrl, String message) {
        String actualUrl = BrowserUtils.getCurrentUrl(driver);
        LogsUtils.info("Asserting page URL");
        LogsUtils.info("Expected URL:", expectedUrl);
        LogsUtils.info("Actual URL:", actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl, message);
    }

    @Step("Assert page title")
    public static void assertPageTitle(WebDriver driver, String expectedTitle, String message) {
        String actualTitle = BrowserUtils.getPageTitle(driver);
        LogsUtils.info("Asserting page title");
        LogsUtils.info("Expected title:", expectedTitle);
        LogsUtils.info("Actual title:", actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, message);
    }
}
