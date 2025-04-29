package Utilities;

import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {
    public static final String allureResultsDirectoryPath = "TestOutputs/allure-results";

    private AllureUtils() {
    }

    public static void attacheLogsToAllureReport() {
        try {
            File logFile = FilesUtils.getLatestFile(LogsUtils.logsDirectoryPath);
            if (!logFile.exists()) {
                LogsUtils.warn("Log file does not exist: " + LogsUtils.logsDirectoryPath);
                return;
            }
            Allure.addAttachment("Logs.log", Files.readString(Path.of(logFile.getPath())));
            LogsUtils.info("Log file attached to Allure report: " + logFile.getPath());
        } catch (Exception e) {
            LogsUtils.error("Failed to attach log file to Allure report: " + e.getMessage());
        }
    }

    public static void attacheScreenshotToAllureReport(String screenshotName, String screenshotPath) {
        try {
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotPath)));
            LogsUtils.info("Screenshot attached to Allure report: " + screenshotPath);
        } catch (Exception e) {
            LogsUtils.error("Failed to attach screenshot file to Allure report: " + e.getMessage());
        }
    }
}
