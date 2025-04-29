package Listeners;

import Utilities.*;
import org.testng.*;

import java.io.File;

public class TestNGListeners implements IExecutionListener, IInvokedMethodListener, ITestListener {
    File allureResultsDirectory = new File("TestOutputs/allure-results");
    File logsDirectory = new File("TestOutputs/Logs");
    File screenshotsDirectory = new File("TestOutputs/Screenshots");

    @Override
    public void onExecutionStart() {
        LogsUtils.info("Test execution started");
        PropertiesUtils.loadProperties();
        FilesUtils.deleteFiles(allureResultsDirectory);
        FilesUtils.cleanDirectory(logsDirectory);
        FilesUtils.cleanDirectory(screenshotsDirectory);
    }

    @Override
    public void onExecutionFinish() {
        LogsUtils.info("Test execution finished");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            switch (testResult.getStatus()) {
                case ITestResult.SUCCESS -> ScreenshotsUtils.takeScreenshot("passed-" + testResult.getName());
                case ITestResult.FAILURE -> ScreenshotsUtils.takeScreenshot("failed-" + testResult.getName());
                case ITestResult.SKIP -> ScreenshotsUtils.takeScreenshot("skipped-" + testResult.getName());
            }
            AllureUtils.attacheLogsToAllureReport();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("Test " + result.getName() + " passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogsUtils.info("Test " + result.getName() + " failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("Test " + result.getName() + " skipped");
    }
}
