package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.Logs;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SoftAssertUtils extends SoftAssert {
    public static SoftAssertUtils softAssert = new SoftAssertUtils();

    public static void softAssertAll() {
        try {
            softAssert.assertAll();
        }catch (Exception e){
            System.out.println("Soft Assert failed: " + e.getMessage());
        }
    }

    public static void softAssertTrue(boolean condition, String message) {
        LogsUtils.info("Asserting true");
        softAssert.assertTrue(condition, message);
    }

    public static void softAssertFalse(boolean condition, String message) {
        LogsUtils.info("Asserting false");
        softAssert.assertFalse(condition, message);
    }

    public static void softAssertEquals(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting equals");
        softAssert.assertEquals(actual, expected, message);
    }

    public static void softAssertNotEquals(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting not equals");
        softAssert.assertNotEquals(actual, expected, message);
    }

    public static void softAssertNull(Object object, String message) {
        LogsUtils.info("Asserting null");
        softAssert.assertNull(object, message);
    }

    public static void softAssertNotNull(Object object, String message) {
        LogsUtils.info("Asserting not null");
        softAssert.assertNotNull(object, message);
    }

    public static void softAssertSame(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting same");
        softAssert.assertSame(actual, expected, message);
    }

    public static void softAssertNotSame(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting not same");
        softAssert.assertNotSame(actual, expected, message);
    }

    public static void softAssertPageUrl(WebDriver driver, String expectedUrl, String message) {
        LogsUtils.info("Asserting page URL");
        String actualUrl = BrowserUtils.getCurrentUrl(driver);
        softAssert.assertEquals(actualUrl, expectedUrl, message);
    }

    public static void softAssertPageTitle(WebDriver driver, String expectedTitle, String message) {
        LogsUtils.info("Asserting page title");
        String actualTitle = BrowserUtils.getPageTitle(driver);
        softAssert.assertEquals(actualTitle, expectedTitle, message);
    }
}

