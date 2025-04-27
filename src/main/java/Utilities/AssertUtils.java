package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertUtils {
    private AssertUtils() {
    }

    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public static void assertNotEquals(Object actual, Object expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    public static void assertNull(Object object, String message) {
        Assert.assertNull(object, message);
    }

    public static void assertNotNull(Object object, String message) {
        Assert.assertNotNull(object, message);
    }

    public static void assertSame(Object actual, Object expected, String message) {
        Assert.assertSame(actual, expected, message);
    }

    public static void assertNotSame(Object actual, Object expected, String message) {
        Assert.assertNotSame(actual, expected, message);
    }

    public static void assertPageUrl(WebDriver driver, String expectedUrl, String message) {
        String actualUrl = BrowserUtils.getCurrentUrl(driver);
        Assert.assertEquals(actualUrl, expectedUrl, message);
    }

    public static void assertPageTitle(WebDriver driver, String expectedTitle, String message) {
        String actualTitle = BrowserUtils.getPageTitle(driver);
        Assert.assertEquals(actualTitle, expectedTitle, message);
    }
}
