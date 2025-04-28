package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.Logs;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SoftAssertUtils extends SoftAssert {
    public static SoftAssertUtils softAssert = new SoftAssertUtils();

    @Step("Soft assert all")
    public static void softAssertAll() {
        try {
            softAssert.assertAll();
        }catch (Exception e){
            System.out.println("Soft Assert failed: " + e.getMessage());
        }
    }

    @Step("Soft assert true")
    public static void softAssertTrue(boolean condition, String message) {
        LogsUtils.info("Asserting true");
        softAssert.assertTrue(condition, message);
    }

    @Step("Soft assert false")
    public static void softAssertFalse(boolean condition, String message) {
        LogsUtils.info("Asserting false");
        softAssert.assertFalse(condition, message);
    }

    @Step("Soft assert equals")
    public static void softAssertEquals(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting equals");
        softAssert.assertEquals(actual, expected, message);
    }

    @Step("Soft assert not equals")
    public static void softAssertNotEquals(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting not equals");
        softAssert.assertNotEquals(actual, expected, message);
    }

    @Step("Soft assert null")
    public static void softAssertNull(Object object, String message) {
        LogsUtils.info("Asserting null");
        softAssert.assertNull(object, message);
    }

    @Step("Soft assert not null")
    public static void softAssertNotNull(Object object, String message) {
        LogsUtils.info("Asserting not null");
        softAssert.assertNotNull(object, message);
    }

    @Step("Soft assert same")
    public static void softAssertSame(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting same");
        softAssert.assertSame(actual, expected, message);
    }

    @Step("Soft assert not same")
    public static void softAssertNotSame(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting not same");
        softAssert.assertNotSame(actual, expected, message);
    }

    @Step("Soft assert page URL")
    public static void softAssertPageUrl(WebDriver driver, String expectedUrl, String message) {
        LogsUtils.info("Asserting page URL");
        String actualUrl = BrowserUtils.getCurrentUrl(driver);
        softAssert.assertEquals(actualUrl, expectedUrl, message);
    }

    @Step("Soft assert page title")
    public static void softAssertPageTitle(WebDriver driver, String expectedTitle, String message) {
        LogsUtils.info("Asserting page title");
        String actualTitle = BrowserUtils.getPageTitle(driver);
        softAssert.assertEquals(actualTitle, expectedTitle, message);
    }
}

