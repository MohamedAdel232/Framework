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

    @Step("Assert equals")
    public static void softAssertEquals(Object actual, Object expected, String message) {
        LogsUtils.info("Asserting equals");
        softAssertion.assertEquals(actual, expected, message);
    }

}

