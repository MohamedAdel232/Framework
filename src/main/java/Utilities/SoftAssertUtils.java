package Utilities;

import io.qameta.allure.Step;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

public class SoftAssertUtils extends SoftAssert {
    public static SoftAssertUtils softAssertion = new SoftAssertUtils();

    public static void softAssertAll(ITestResult result) {
        try {
            softAssertion.assertAll("Custom Soft Assertion");
        } catch (AssertionError e) {
            LogsUtils.error("Custom Soft Assertion Failed: " + e.getMessage());
            result.setStatus(ITestResult.FAILURE);
            result.setThrowable(e);
        } finally {
            reInitializeSoftAssert();
        }
    }

    private static void reInitializeSoftAssert() {
        softAssertion = new SoftAssertUtils();
    }

    @Step("Soft Assert true")
    public static void softAssertTrue(boolean condition, String message) {
        LogsUtils.info("Asserting true");
        softAssertion.assertTrue(condition, message);
    }

    @Step("Soft Assert false")
    public static void softAssertFalse(boolean condition, String message) {
        LogsUtils.info("Asserting false");
        softAssertion.assertFalse(condition, message);
    }

    @Step("Soft Assert equals")
    public static void softAssertEquals(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting equals");
        softAssertion.assertEquals(actual, expected, message);
    }

    @Step("Soft Assert not equals")
    public static void softAssertNotEquals(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting not equals");
        softAssertion.assertNotEquals(actual, expected, message);
    }

    @Step("Soft Assert null")
    public static void softAssertNull(Object object, String message) {
        LogsUtils.info("Asserting null");
        softAssertion.assertNull(object, message);
    }

    @Step("Soft Assert not null")
    public static void softAssertNotNull(Object object, String message) {
        LogsUtils.info("Asserting not null");
        softAssertion.assertNotNull(object, message);
    }

    @Step("Soft Assert same")
    public static void softAssertSame(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting same");
        softAssertion.assertSame(actual, expected, message);
    }

    @Step("Soft Assert not same")
    public static void softAssertNotSame(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting not same");
        softAssertion.assertNotSame(actual, expected, message);
    }
}

