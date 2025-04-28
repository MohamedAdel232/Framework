package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertUtils {
    private AssertUtils() {
    }

    public static void assertTrue(boolean condition, String message) {
        LogsUtils.info("Asserting true");
        Assert.assertTrue(condition, message);
    }

    public static void assertFalse(boolean condition, String message) {
        LogsUtils.info("Asserting false");
        Assert.assertFalse(condition, message);
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting equals");
        Assert.assertEquals(actual, expected, message);
    }

    public static void assertNotEquals(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting not equals");
        Assert.assertNotEquals(actual, expected, message);
    }

    public static void assertNull(Object object, String message) {
        LogsUtils.info("Asserting null");
        Assert.assertNull(object, message);
    }


    public static void assertNotNull(Object object, String message) {
        LogsUtils.info("Asserting not null");
        Assert.assertNotNull(object, message);
    }

    public static void assertSame(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting same");
        Assert.assertSame(actual, expected, message);
    }

    public static void assertNotSame(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting not same");
        Assert.assertNotSame(actual, expected, message);
    }

    public static void assertPageUrl(WebDriver driver, String expectedUrl, String message) {
        String actualUrl = BrowserUtils.getCurrentUrl(driver);
        LogsUtils.info("Asserting page URL");
        LogsUtils.info("Expected URL:", expectedUrl);
        LogsUtils.info("Actual URL:", actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl, message);
    }

    public static void assertPageTitle(WebDriver driver, String expectedTitle, String message) {
        String actualTitle = BrowserUtils.getPageTitle(driver);
        LogsUtils.info("Asserting page title");
        LogsUtils.info("Expected title:", expectedTitle);
        LogsUtils.info("Actual title:", actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, message);
    }
}
